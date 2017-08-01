package com.lenovo.springboot.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public class PageParam {
	private Integer page;
	private Integer size;
	private String orderByColumn;
	private String direct;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getOrderByColumn() {
		return orderByColumn;
	}
	public void setOrderByColumn(String orderByColumn) {
		this.orderByColumn = orderByColumn;
	}
	public String getDirect() {
		return direct;
	}
	public void setDirect(String direct) {
		this.direct = direct;
	}
	public  Pageable getPageable(){
		if(orderByColumn==null||orderByColumn.length()==0){
			return new PageRequest(this.page, this.size);
		}
		Sort sort=new Sort(new Order(Direction.fromStringOrNull(this.direct),orderByColumn));
		return new PageRequest(this.page, this.size, sort);
	}
}
