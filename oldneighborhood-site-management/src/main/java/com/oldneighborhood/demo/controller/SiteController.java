package com.oldneighborhood.demo.controller;

import java.util.List;
import java.util.Map;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oldneighborhood.demo.entity.Page;
import com.oldneighborhood.demo.entity.Site;
import com.oldneighborhood.demo.service.SiteService;


@RestController
//@RequestMapping(path= {"/site"})
public class SiteController {
	
	@Autowired
	private SiteService siteService;
	
	@RequestMapping(path= {"/add"},method= {RequestMethod.POST})
	public String addSite(@RequestBody Map<String, Object> reqMap) {
		System.out.println("addController>>>>>>>>>>>");
		System.out.println(reqMap);
		Site site = new Site(
				reqMap.get("site_name").toString(), 
				reqMap.get("site_address").toString(),
				Double.parseDouble(reqMap.get("site_ticket").toString()),
				reqMap.get("site_time").toString(),
				reqMap.get("ad_ID").toString(),
				reqMap.get("site_type").toString());
		Site newsite = siteService.addSite(site);
		
		if (newsite!=null) {
			return "{\"result\":\"success\"}";
		}else {
			return "{\"result\":\"error\"}";
		}
	}
	
	@RequestMapping("/list")
	public String list(@RequestBody Map<String, Object> reqMap) {
		int total_rows = siteService.listcount();
		int current_pages = Integer.parseInt(reqMap.get("current_page").toString());
		int page_size = Integer.parseInt(reqMap.get("page_size").toString());
		Page page = new Page(total_rows, current_pages, page_size);
		List<Site> sitelist = siteService.list(page);
		JSONArray json = JSONArray.fromObject(sitelist);
		return json.toString();
	}
	
	//返回景点列表-全部
	@RequestMapping(path= {"/listall"})
	public String listSite() {
		List<Site> sitelist = null;
		sitelist = siteService.listSite();
		JSONArray json = JSONArray.fromObject(sitelist);
		System.out.println(json);
		return json.toString();
	}
	
	@RequestMapping(path= {"/update"})
	public String updateSite(@RequestBody Map<String, Object> reqMap) {
		Site site = new Site(
				Integer.parseInt(reqMap.get("site_ID").toString()),
				reqMap.get("site_name").toString(), 
				reqMap.get("site_address").toString(), 
				Double.parseDouble(reqMap.get("site_ticket").toString()), 
				reqMap.get("site_time").toString(), 
				reqMap.get("site_image").toString(), 
				reqMap.get("site_intro").toString(), 
				reqMap.get("site_tele").toString(), 
				reqMap.get("site_web").toString(), 
				reqMap.get("site_email").toString());
		return siteService.updateSite(site) ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}" ;
	}
	
	@RequestMapping(path= {"/findID"})
	public String findSiteByID(@RequestBody Map<String, Object> reqMap) {
		Site site = siteService.find(
				Integer.parseInt(reqMap.get("site_ID").toString()));
		JSONObject json = JSONObject.fromObject(site);
		System.out.println(json);
		return json.toString();
	}
	
//	@RequestMapping(path= {"/find"})
//	public String findSite(@RequestBody Map<String, Object> reqMap) {
//		Site site = siteService.findByName(reqMap.get("site_name").toString());
//		JSONObject json = JSONObject.fromObject(site);
//		System.out.println(json);
//		return json.toString();
//	}
	
	@RequestMapping(path= {"/search"})
	public String searchSite(@RequestBody Map<String, Object> reqMap) {
		List<Site> sitenames = siteService.findByNameLike(reqMap.get("sitename").toString());
		JSONArray json = JSONArray.fromObject(sitenames);
//		System.out.println(json);
		return json.toString();
	}
	
	@RequestMapping(path= {"/close"})
	public String closeSite(@RequestBody Map<String, Object> reqMap) {
		boolean flag = siteService.closeSite(Integer.parseInt(reqMap.get("site_ID").toString()));
		return flag ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}" ;
	}
	
	@RequestMapping(path= {"/change"})
	public String changeSite(@RequestBody Map<String, Object> reqMap) {
		boolean flag = siteService.changeType(
				Integer.parseInt(reqMap.get("site_ID").toString()), 
				reqMap.get("site_type").toString());
		return flag ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}" ;
	}
	
	@RequestMapping(path= {"/delete"})
	public String deleteSite(@RequestBody Map<String, Object> reqMap) {
		boolean flag = siteService.deleteSite(Integer.parseInt(reqMap.get("site_ID").toString()));
		return flag ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}" ;
	}

}
