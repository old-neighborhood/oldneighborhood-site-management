package com.oldneighborhood.demo.service;

import java.util.List;

import com.oldneighborhood.demo.entity.Site;

public interface SiteService {
	
	public Site addSite(Site site);
	
	public List<Site> listSite();
	
	//查找，实现方法有findByID/findByName...
	public Site find(String siteID);
	
	public Site findByname(String sitename);
	
	public boolean updateSite(Site site);
	
	public boolean closeSite(String siteID);
	
	public void deleteSite(String siteID);

}
