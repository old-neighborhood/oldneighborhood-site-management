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
	//?
	public SiteState state;
	
	@Column(columnDefinition="timestamp not null default now()" , updatable=false)
	private Timestamp site_date;

}
