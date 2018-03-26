package com.oldneighborhood.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="site")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder

public class Site implements Serializable{
	
	private static final long serialVersionUID = 2331222388069345367L;
	@Id
	private String site_ID;
	@NonNull
	private String site_name;
	@NonNull
	private String site_address;
	@NonNull
	private Double site_ticket;
	@NonNull
	private String site_time;
	private String site_image;
	private String site_intro;
	private String site_tele;
	private String site_web;
	private String site_email;
	//外键管理员ID
	private String ad_ID;
	//OPEN/CLOSED
	private String state;
	//site/pub
	@NonNull
	private String site_type;
	
	@Column(columnDefinition="timestamp not null default now()" , updatable=false)
	private Timestamp site_date;

	public Site(String site_name, String site_address, Double site_ticket, String site_time, String site_image,
			String site_intro, String site_tele, String site_web, String site_email) {
		super();
		this.site_name = site_name;
		this.site_address = site_address;
		this.site_ticket = site_ticket;
		this.site_time = site_time;
		this.site_image = site_image;
		this.site_intro = site_intro;
		this.site_tele = site_tele;
		this.site_web = site_web;
		this.site_email = site_email;
	}
	
}
