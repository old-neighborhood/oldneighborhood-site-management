package com.oldneighborhood.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oldneighborhood.demo.dao.SiteDao;
import com.oldneighborhood.demo.entity.Site;
import com.oldneighborhood.demo.service.SiteService;

@Service
public class SiteServiceImpl implements SiteService{
	
	@Autowired
	private SiteDao siteDao;

	@Override
	public Site addSite(Site site) {
		Site newsite = null;
		try {
			newsite = siteDao.saveAndFlush(site);
			System.out.println(newsite);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsite;
	}
	
	@Override
	public List<Site> listSite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Site find(String siteID) {
		Site site = siteDao.findOne(siteID);
		return site;
	}
	
	@Override
	public Site findByname(String sitename) {
		//自行实现
		return null;
	}

	@Override
	public boolean updateSite(Site site) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeSite(String siteID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteSite(String siteID) {
		try {
			Site site = this.find(siteID);
			siteDao.delete(site);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
