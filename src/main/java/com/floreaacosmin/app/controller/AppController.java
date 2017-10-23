package com.floreaacosmin.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.floreaacosmin.app.repository.Notification;
import com.floreaacosmin.app.service.RestService;
import com.floreaacosmin.app.utils.StaticUtils;

@CrossOrigin
@RestController
public class AppController {

	private RestService restService;

	public AppController(RestService restService) {
		this.restService = restService;
	}

	@RequestMapping("**")
	public ResponseEntity<String> getAnythingElse() {
		return new ResponseEntity<String>(StaticUtils.NOT_MAPPED, HttpStatus.OK);
	}

	@RequestMapping("/")
	public ResponseEntity<String> defaultResponse() {
		return new ResponseEntity<String>(StaticUtils.NOTHING, HttpStatus.OK);
	}

	@RequestMapping(value = "/notifications/all", method = RequestMethod.GET)
	public List<Notification> findAllNotifications() {
		return restService.findAllNotifications();
	}

	@RequestMapping(value = "/notifications/{id}", method = RequestMethod.GET)
	public Notification findNotification(@PathVariable Long id) {
		return restService.findNotification(id);
	}

	@RequestMapping(value = "/addnotification", method = RequestMethod.POST)
	public ResponseEntity<Notification> addNotification(@RequestBody Notification newNotification) {
		restService.saveNotification(newNotification);
		return new ResponseEntity<Notification>(newNotification, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/sendnotification", method = RequestMethod.POST)
	public ResponseEntity<Notification> sendNotification(@RequestBody Notification newNotification) {
		
		// Pushraven.setKey("AAAAp-h0nj4:APA91bG5RIeKkU8ggERJ9LHIKqx1s9ZNgqd8mb0hM1sT3Zl7bdBeNS077W9BXvooLE1XIvnAps7Np4oCU49nNZy5tIIVm9sJ2ebxlupiq87R4JOE-VJS4M-txl0xyo-Jp0abZw0iPMRJ");
		

		
		restService.saveNotification(newNotification);
		return new ResponseEntity<Notification>(newNotification, HttpStatus.OK);
	}

	@RequestMapping(value = "/notifications/{id}", method = RequestMethod.PUT)
	public String updateNotification(@RequestBody Notification updatedNotification) {
		restService.updateNotification(updatedNotification);
		return (StaticUtils.UPDATED + updatedNotification.getId());
	}
	
	@RequestMapping(value = "/notifications/{id}", method = RequestMethod.DELETE)
	public String deleteNotification(@PathVariable Long id) {
		restService.deleteNotification(id);
		return (StaticUtils.DELETED + id);
	}
}
