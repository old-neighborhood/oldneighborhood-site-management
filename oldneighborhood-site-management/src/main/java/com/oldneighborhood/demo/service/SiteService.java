package com.oldneighborhood.demo.service;

import java.util.List;

import com.oldneighborhood.demo.entity.Site;

public interface SiteService {
	//添加景点
	public Site addSite(Site site);
	//返回所有景点
	public List<Site> listSite();
	
	//查找findByID
	public Site find(String siteID);
	//模糊查找findByName
	public List<String> findByNameLike(String sitename);
	//精确查找
	public Site findByName(String sitename);
	//更新信息
	public boolean updateSite(Site site);
	//设置景点关闭
	public boolean closeSite(String siteID);
	//改变景点类型
	public boolean changeType(String siteID, String site_type);
	//删除景点
	public boolean deleteSite(String siteID);

}
