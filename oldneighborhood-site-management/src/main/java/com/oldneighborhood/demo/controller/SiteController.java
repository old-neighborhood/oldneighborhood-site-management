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
import org.springframework.web.bind.annotation.RestController;

import com.oldneighborhood.demo.entity.Site;
import com.oldneighborhood.demo.service.SiteService;


@RestController
@RequestMapping(path= {"/site"})
public class SiteController {
	
	@Autowired
	private SiteService siteService;
	
	@RequestMapping(path= {"/add"})
	public String addSite(@RequestBody Map<String, Object> reqMap) {
		Site site = new Site(
				reqMap.get("site_name").toString(), 
				reqMap.get("site_address").toString(),
				Double.parseDouble(reqMap.get("site_ticket").toString()),
				reqMap.get("site_time").toString(),
				reqMap.get("site_type").toString());
		Site newsite = siteService.addSite(site);
		
		if (newsite!=null) {
			return "\"result\":\"success\"";
		}else {
			return "\"result\":\"error\"";
		}
	}
	//返回景点列表
	@RequestMapping(path= {"/list"})
	public String listSite() {
		List<Site> sitelist = null;
		sitelist = siteService.listSite();
		JSONArray json = JSONArray.fromObject(sitelist);
		System.out.println(json);
		return json.toString();
//		for (Site site : sitelist) {
//			JSONObject jo = new JSONObject();
//			try {
//				jo.put("site_ID", site.getSite_ID());
//				jo.put("site_name", site.getSite_name());
//				jo.put("site_address", site.getSite_address());
//				jo.put("site_image", site.getSite_image());
//				jo.put("site_intro", site.getSite_intro());
//				jo.put("site_tele", site.getSite_tele());
//				jo.put("site_web", site.getSite_web());
//				jo.put("site_email", site.getSite_email());
//				jo.put("site_ticket", site.getSite_ticket());
//				jo.put("site_time", site.getSite_time());
//				
//				jo.put("site_state", site.getState());
//				jo.put("site_type", site.getSite_type());
//				json.put(jo);
//			} catch (JSONException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	@RequestMapping(path= {"/update"})
	public String updateSite(@RequestBody Map<String, Object> reqMap) {
		Site site = new Site(reqMap.get("site_name").toString(), 
				reqMap.get("site_address").toString(), 
				Double.parseDouble(reqMap.get("site_ticket").toString()), 
				reqMap.get("site_time").toString(), 
				reqMap.get("site_image").toString(), 
				reqMap.get("site_intro").toString(), 
				reqMap.get("site_tele").toString(), 
				reqMap.get("site_web").toString(), 
				reqMap.get("site_email").toString());
		return siteService.updateSite(site) ? "\"result\":\"success\"" : "\"result\":\"error\"" ;
	}
	
	@RequestMapping(path= {"/find"})
	public String findSite(@RequestBody Map<String, Object> reqMap) {
		Site site = siteService.findByName(reqMap.get("sitename").toString());
		JSONObject json = JSONObject.fromObject(site);
		System.out.println(json);
		return json.toString();
	}
	
	@RequestMapping(path= {"/search"})
	public String searchSite(@RequestBody Map<String, Object> reqMap) {
		List<String> sitenames = siteService.findByNameLike(reqMap.get("sitename").toString());
		JSONObject json = JSONObject.fromObject(sitenames);
		System.out.println(json);
		return json.toString();
	}
	
	@RequestMapping(path= {"/close"})
	public String closeSite(@RequestBody Map<String, Object> reqMap) {
		boolean flag = siteService.closeSite(Integer.parseInt(reqMap.get("site_ID").toString()));
		return flag ? "\"result\":\"success\"" : "\"result\":\"error\"" ;
	}
	
	@RequestMapping(path= {"/change"})
	public String changeSite(@RequestBody Map<String, Object> reqMap) {
		boolean flag = siteService.changeType(
				Integer.parseInt(reqMap.get("site_ID").toString()), 
				reqMap.get("new_site_type").toString());
		return flag ? "\"result\":\"success\"" : "\"result\":\"error\"" ;
	}
	
	@RequestMapping(path= {"/delete"})
	public String deleteSite(@RequestBody Map<String, Object> reqMap) {
		boolean flag = siteService.deleteSite(Integer.parseInt(reqMap.get("site_ID").toString()));
		return flag ? "\"result\":\"success\"" : "\"result\":\"error\"" ;
	}

}
