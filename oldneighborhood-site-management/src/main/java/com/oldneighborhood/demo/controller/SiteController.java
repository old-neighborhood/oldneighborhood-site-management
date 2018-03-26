package com.oldneighborhood.demo.controller;

import java.util.Map;

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
		Site site = new Site();
		siteService.addSite(site);
		return "";
	}
	@RequestMapping(path= {"/list"})
	public String listSite(@RequestBody Map<String, Object> reqMap) {
		
		siteService.listSite();
		return "";
	}
	@RequestMapping(path= {"/update"})
	public String updateSite(@RequestBody Map<String, Object> reqMap) {
		return "";
	}
	@RequestMapping(path= {"/find"})
	public String findSite(@RequestBody Map<String, Object> reqMap) {
		return "";
	}
	@RequestMapping(path= {"/close"})
	public String closeSite(@RequestBody Map<String, Object> reqMap) {
		return "";
	}
	@RequestMapping(path= {"/delete"})
	public String deleteSite(@RequestBody Map<String, Object> reqMap) {
		return "";
	}
	

}
