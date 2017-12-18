package com.floreaacosmin.app.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.floreaacosmin.app.repository.Notification;

public class ProcessInputFile {

	public List<Notification> processInputFile(String inputFilePath) {
	    List<Notification> inputList = new ArrayList<Notification>();
	    
	    try{
	      File inputFile = new File(inputFilePath);
	      InputStream inputFileStream = new FileInputStream(inputFile);
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputFileStream));
	      // skip the header of the csv
	      inputList = bufferedReader.lines().skip(1).map(mapToNotification).collect(Collectors.toList());
	      bufferedReader.close();
	    } catch (IOException e) {
	    }

	    return inputList;
	}
	
	private Function<String, Notification> mapToNotification = (line) -> {
		String COMMA = ";";
		
		// A CSV has comma separated lines  
		String[] p = line.split(COMMA);
		Notification notification = new Notification();
		
		
		// String name, String content, String date, String author, String imageUrl
		notification.setName(p[0]);
		notification.setContent(p[1]);
		notification.setDate(p[2]);
		notification.setAuthor(p[3]);
		notification.setImageUrl(p[4]);
		
		return notification;
	};
	
}
