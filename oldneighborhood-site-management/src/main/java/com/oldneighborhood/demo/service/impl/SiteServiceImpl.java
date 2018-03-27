package com.oldneighborhood.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oldneighborhood.demo.dao.SiteDao;
import com.oldneighborhood.demo.entity.Site;
import com.oldneighborhood.demo.service.SiteService;

@Service
public class SiteServiceImpl implements SiteService{
	
	@Autowired
	private SiteDao siteDao;

	@Override
	@Transactional
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
	
	//list all sites here
	@Override
	public List<Site> listSite() {
		List<Site> sitelist = null;
		try {
			sitelist = siteDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sitelist;
	}

	@Override
	public Site find(Integer siteID) {
		Site site = null;
		try {
			site = siteDao.findOne(siteID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return site;
	}
	
	//模糊查询，仅返回名称列表
	@Override
	public List<String> findByNameLike(String sitename) {
		List<String> sitelist = null;
		try {
			String namelike = "%"+sitename+"%";
			sitelist = siteDao.findByNameLike(namelike);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sitelist;
	}
	//按照景点名称精确查找
	public Site findByName(String sitename) {
		Site site = null;
		try {
			site = siteDao.findByName(sitename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return site;
	}
	
	//更新景点信息 site_ID/site_date/ad_ID/site_state(在closeSite中改变)不可变更
	@Override
	public boolean updateSite(Site site) {
		boolean flag = false;
		try {
			siteDao.updateSiteInfo(
					site.getSite_name(), site.getSite_address(), site.getSite_image(), 
					site.getSite_intro(), site.getSite_tele(), site.getSite_web(), site.getSite_email(), 
					site.getSite_ticket(), site.getSite_time(), site.getSite_ID());
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean closeSite(Integer siteID) {
		boolean flag = false;
		try {
			siteDao.closeSite(siteID);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//关闭某景点，site_state设置为CLOSED
	@Override
	public boolean deleteSite(Integer siteID) {
		boolean flag = false;
		try {
			Site site = this.find(siteID);
			siteDao.delete(site);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//该变景点类型 site/pub 景点/卫生间/停车场...
	@Override
	public boolean changeType(Integer site_ID, String site_type) {
		boolean flag = false;
		try {
			siteDao.changeType(site_type, site_ID);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
