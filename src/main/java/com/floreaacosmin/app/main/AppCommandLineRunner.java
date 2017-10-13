package com.floreaacosmin.app.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.floreaacosmin.app.utils.StaticUtils;

@Component
public class AppCommandLineRunner implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(AppCommandLineRunner.class);

	@Override
	public void run(String... strings) throws Exception {

		logger.info(StaticUtils.APP_STARTED);
	}
}
