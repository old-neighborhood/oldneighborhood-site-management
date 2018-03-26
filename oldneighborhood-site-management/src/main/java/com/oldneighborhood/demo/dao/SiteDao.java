package com.oldneighborhood.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oldneighborhood.demo.entity.Site;

public interface SiteDao extends JpaRepository<Site, String>{
	

}
