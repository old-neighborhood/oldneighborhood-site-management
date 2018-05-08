package com.oldneighborhood.demo.entity;

import java.io.Serializable;

import lombok.Data;

/**
* @ClassName: Page  
* @Description: 分頁輔助類
* @author user005  
* @date 2018年3月27日  
 */
@Data
public class Page implements Serializable{
	private static final long serialVersionUID = -365011931848788096L;
	
	private int total_rows;
	private int current_page;
	private int page_size;
	
	private int total_pages;
	private int offset_row;
	private boolean hasPre;
	private boolean hasNext;
	
	
	public Page(int total_rows, int current_pages, int page_size) {
		super();
		this.total_rows = total_rows;
		this.current_page = current_pages;
		this.page_size = page_size;
		
		this.total_pages = (this.total_rows - 1) / this.page_size + 1;
		this.offset_row = (this.current_page - 1) * this.page_size;
		this.hasPre = this.current_page == 1 ? false : true;
		this.hasNext = this.current_page == this.total_pages ? false : true;
	}

}
