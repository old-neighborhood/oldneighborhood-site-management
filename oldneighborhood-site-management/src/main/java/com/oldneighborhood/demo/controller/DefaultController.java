package com.oldneighborhood.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: DefaultController
 * @Description: 景点管理默认页面
 * @author user005
 * @date 2018年3月26日
 */
@Controller
public class DefaultController {
	@RequestMapping(path= {"/site"})
	public String siteManage() {
		return "/site";
	}

}
