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
			
			notificationRepository.save(new Notification("salary payment", "december salary! ... will enter in january ;)", "today", "HR", "http://www.pvhc.net/img64/eaibpkgpggjvqxriuved.png"));
			notificationRepository.save(new Notification("new positions", "we are hiring 100 new austronauts!", "yesterday", "HR", "http://www.pvhc.net/img64/eaibpkgpggjvqxriuved.png"));
			notificationRepository.save(new Notification("Movies", "Luigi has a new movie! :p", "today", "LetterBex", "https://marketplace.canva.com/MAB4reUgRxg/1/thumbnail/canva-video-camera-icon.-movie-design.-vector-graphic--MAB4reUgRxg.png"));
			notificationRepository.save(new Notification("christmas party", "It was a great party, you will find the pictures on your phone! :D", "yesterday", "comms", "http://www.racialequityresourceguide.org/images/dmImage/ThumbnailImage/icon-lg-media.png"));
			notificationRepository.save(new Notification("compliance stuff", "some stuff here", "today", "compliance", "http://www.appliedsensortech.com/images_2016/form_image.png"));
			notificationRepository.save(new Notification("M-essage", "message from Mike", "yesterday", "M", "https://icon-icons.com/icons2/278/PNG/512/Mou_30215.png"));
			notificationRepository.save(new Notification("Building alarm test", "you are asked to evacuate the building", "today", "facility", "http://solostep.com/wp-content/uploads/2015/02/icon-facility-lg.png"));
			notificationRepository.save(new Notification("nobody", ".................", "in the future", "secret", "http://www.pngmart.com/files/1/Banana-Icon-PNG.png"));
			
			notificationRepository.save(new Notification("test8", "testing testing x8 testing testing x8 testing testing x8 testing testing x8 testing testing x8 testing testing x8", "today", "TEST", "http://www.iconarchive.com/download/i88896/icons8/ios7/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("test9", "testing testing x9", "yesterday", "TEST", "http://www.iconarchive.com/download/i88896/icons8/ios7/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("test10", "testing testing x10", "yesterday", "TEST", "http://www.iconarchive.com/download/i88896/icons8/ios7/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("test11", "testing testing x11", "today", "TEST", "http://www.iconarchive.com/download/i88896/icons8/ios7/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("test12", "testing testing x12", "today", "TEST", "http://www.iconarchive.com/download/i88896/icons8/ios7/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("test13", "testing testing x13", "yesterday", "TEST", "http://www.iconarchive.com/download/i88896/icons8/ios7/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("test14", "testing testing x14", "today", "TEST", "http://www.iconarchive.com/download/i88896/icons8/ios7/Science-Test-Tube.ico"));
			
			notificationRepository.save(new Notification("x1", "aaaaaabbbbbbcccccc", "today", "mr.X", "http://www.iconarchive.com/download/i91613/icons8/windows-8/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("x2", "aaaaaabbbbbbcccccc", "today", "mr.X", "http://www.iconarchive.com/download/i91613/icons8/windows-8/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("x3", "aaaaaabbbbbbcccccc", "today", "mr.X", "http://www.iconarchive.com/download/i91613/icons8/windows-8/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("x4", "aaaaaabbbbbbcccccc", "today", "mr.X", "http://www.iconarchive.com/download/i91613/icons8/windows-8/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("x5", "aaaaaabbbbbbcccccc", "today", "mr.X", "http://www.iconarchive.com/download/i91613/icons8/windows-8/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("x6", "aaaaaabbbbbbcccccc", "today", "mr.X", "http://www.iconarchive.com/download/i91613/icons8/windows-8/Science-Test-Tube.ico"));
			notificationRepository.save(new Notification("x7", "aaaaaabbbbbbcccccc", "today", "mr.X", "http://www.iconarchive.com/download/i91613/icons8/windows-8/Science-Test-Tube.ico"));
			
			
			
			/*Stream.of("Gigi Masinuta", "Ana CuMere", "Robin Hood", "Ogre Forest").map(name -> name.split(" "))
					.map(v -> new Customer(v[0], v[1], addressRepository
						.getOne(ThreadLocalRandom.current().nextLong(1L, addressRepository.count()))))
						.forEach(c -> notificationRepository.save(c));*/
		}
	}
}
