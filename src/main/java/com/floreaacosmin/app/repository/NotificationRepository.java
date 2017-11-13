package com.floreaacosmin.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{
	
	@Query("SELECT DISTINCT n.author FROM Notification n")
	List<String> findAllDistinctAuthors();
	
	// Auto-generated Spring repository interface implementation
	List<Notification> findByNameContains(String term);
}

