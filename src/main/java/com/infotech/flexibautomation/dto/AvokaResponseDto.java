package com.infotech.flexibautomation.dto;

import java.util.List;

import com.infotech.flexibautomation.entity.AvokaResults;

public class AvokaResponseDto {

	private Integer currentPage;
	private Integer totalpages;
	private Integer totalRecords;
	private List<AvokaResults> data;
	private Boolean last;
	private Boolean first;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(Integer totalpages) {
		this.totalpages = totalpages;
	}
	public Integer getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<AvokaResults> getData() {
		return data;
	}
	public void setData(List<AvokaResults> data) {
		this.data = data;
	}
	public Boolean getLast() {
		return last;
	}
	public void setLast(Boolean last) {
		this.last = last;
	}
	public Boolean getFirst() {
		return first;
	}
	public void setFirst(Boolean first) {
		this.first = first;
	}
	public AvokaResponseDto(Integer currentPage, Integer totalpages, Integer totalRecords, List<AvokaResults> data,
			Boolean last, Boolean first) {
		super();
		this.currentPage = currentPage;
		this.totalpages = totalpages;
		this.totalRecords = totalRecords;
		this.data = data;
		this.last = last;
		this.first = first;
	}
	public AvokaResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AvokaResponseDto [currentPage=" + currentPage + ", totalpages=" + totalpages + ", totalRecords="
				+ totalRecords + ", data=" + data + ", last=" + last + ", first=" + first + "]";
	}
	
}
