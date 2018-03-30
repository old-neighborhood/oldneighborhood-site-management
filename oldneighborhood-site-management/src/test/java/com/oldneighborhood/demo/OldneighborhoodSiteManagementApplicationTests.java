package com.oldneighborhood.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OldneighborhoodSiteManagementApplication.class)
//@WebAppConfiguration
public class OldneighborhoodSiteManagementApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("---------------Junit TEST>>>>>>>>>>>");
	}
	
	
	//模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
	private MockMvc mockMvc;
	@Autowired
	// 注入WebApplicationContext
	private WebApplicationContext wac;
//	   @Autowired    
//	    private MockHttpSession session;// 注入模拟的http session    
//	        
//	    @Autowired    
//	    private MockHttpServletRequest request;// 注入模拟的http request
	@Before//测试之前的初始化
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void add() throws Exception{
//		new Map<K,V>();
//		无法实例化类型Map<String,Boolean>
//		看了一下Map的定义，public abstract interface java.util.Map
//		原来是抽象接口，不能直接实例化，需要使用它的实现类；
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("site_name", "北大楼");
		map.put("site_address", "汉口路22号");
		map.put("site_ticket", "0.00");
		map.put("site_time", "10:00-19:00");
		map.put("site_type", "大学");
		map.put("ad_ID", "00000000000000000000000000000001");
		System.out.println("flag---------------------------"+JSONObject.fromObject(map).toString());
		MvcResult result = mockMvc.perform(post("/oldneighborhood/site/add").content(JSONObject.fromObject(map).toString()))
				.andExpect(status().isOk())// 模拟向testRest发送get请求 
				// 预期返回值的媒体类型text/plain;charset=UTF-8
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andReturn();// 返回执行请求的结果   
		System.out.println(result.getResponse().getContentAsString());
	}

}
