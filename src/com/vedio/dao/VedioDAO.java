package com.vedio.dao;

import java.math.BigDecimal;

public class VedioDAO {
	private int id;
	private String url;
	private String url_host;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrl_host() {
		return url_host;
	}
	public void setUrl_host(String url_host) {
		this.url_host = url_host;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
