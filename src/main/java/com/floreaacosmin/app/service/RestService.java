package com.floreaacosmin.app.service;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.floreaacosmin.app.repository.Notification;
import com.floreaacosmin.app.repository.NotificationRepository;

@Service
@Transactional
public class RestService {

	// private static final Logger logger = LoggerFactory.getLogger(RestService.class);
	
	private NotificationRepository notificationRepository;
	
	@Autowired
	public RestService(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	public String getUptime() {
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		long uptimeValue = runtimeMXBean.getUptime();
		String uptime = "Uptime: "; 
		
		String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(uptimeValue),
			    TimeUnit.MILLISECONDS.toMinutes(uptimeValue) % TimeUnit.HOURS.toMinutes(1),
			    TimeUnit.MILLISECONDS.toSeconds(uptimeValue) % TimeUnit.MINUTES.toSeconds(1));
		
		return uptime + hms; 
	}
	
	public List<String> findAllDistinctAuthors() {
		return notificationRepository.findAllDistinctAuthors();
	}
	
	public List<Notification> findAllNotifications() {
		return notificationRepository.findAll();
	}

	public List<Notification> findByNameContains(String term) {
		return notificationRepository.findByNameContains(term);
	}

	
	public Notification findNotification(Long id) {
		return notificationRepository.findOne(id);
	}
	
	public void saveNotification(Notification newNotification) {
		notificationRepository.save(newNotification);
	}
	
	public void deleteNotification(Long id) {
		notificationRepository.delete(id);
	}
	
	public void updateNotification(Notification updatedNotification) {
		// TODO : implement function
		// Notification tempNotification = notificationRepository.getOne(updatedNotification.getId());
		// tempNotification.setFirstName(updatedNotification.getFirstName());
	}

	@PostConstruct
	public void initData() {
		if (notificationRepository.count() == 0) {
			
			// ArrayList<Notification> notifList = (ArrayList<Notification>) processInputFile.processInputFile("static/notifications.csv");
			
			// logger.debug("parsing...");
			// logger.debug(notifList.toString());
			
			//notificationRepository.save(notifList);
			
			
			// String veryLongText = "shfklejfklesjfsek<br />ljfklsjflskj<br />fseljfekls<br />hfklejfklesjfse<br />kljfklsjflskjfse<br />ljfeklshfklejfklesjfsekljfklsjflskjfseljfekl";
			
			notificationRepository.save(new Notification("salary payment", "december salary! ... will enter in january ;)", "today", "HR", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("new positions", "we are hiring 100 new austronauts!", "yesterday", "HR", "http://www.pngmart.com/files/1/Banana-Icon-PNG.png"));
			notificationRepository.save(new Notification("LetterBex", "Luigi has a new movie! :p", "today", "Luigi", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("christmas party", "It was a great party, you will find the pictures on your phone! :D", "yesterday", "comms", "http://www.pngmart.com/files/1/Banana-Icon-PNG.png"));
			notificationRepository.save(new Notification("compliance stuff", "some stuff here", "today", "compliance", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("M-essage", "message from Mike", "yesterday", "M", "http://www.pngmart.com/files/1/Banana-Icon-PNG.png"));
			notificationRepository.save(new Notification("Building alarm test", "you are asked to evacuate the building", "today", "facility", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("nobody", ".................", "in the future", "secret", "http://www.pngmart.com/files/1/Banana-Icon-PNG.png"));
			notificationRepository.save(new Notification("test8", "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh", "today", "CXO", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("test9", "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", "yesterday", "?", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("test10", "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu", "yesterday", "M", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("test11", "rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr", "today", "Facility", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("test12", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", "today", "...", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("test13", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "yesterday", "X", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("test14", "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", "today", "HR", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("x1", "aaaaaa", "today", "X1", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("x2", "aaaaaa", "today", "X2", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("x3", "aaaaaa", "today", "X3", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("x4", "aaaaaa", "today", "X4", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("x5", "aaaaaa", "today", "X5", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("x6", "aaaaaa", "today", "X6", "http://www.hotnews.ro/images/new/logo.gif"));
			notificationRepository.save(new Notification("x7", "zzzzzz", "today", "X7", "http://www.hotnews.ro/images/new/logo.gif"));
			
			
			
			/*Stream.of("Gigi Masinuta", "Ana CuMere", "Robin Hood", "Ogre Forest").map(name -> name.split(" "))
					.map(v -> new Customer(v[0], v[1], addressRepository
						.getOne(ThreadLocalRandom.current().nextLong(1L, addressRepository.count()))))
						.forEach(c -> notificationRepository.save(c));*/
		}
	}
}
