package com.sclw.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.sclw.enums.Perfil;

public class TokenDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String username;
	private String authorization;
	private String authorities;
	private Integer userId;
	
	public TokenDTO(String username, String authorization, String authorities, Integer userId) {
		super();
		this.username = username;
		this.authorization = authorization;
		this.authorities = authorities;
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "TokenDTO [username=" + username + ", authorization=" + authorization + ", authorities=" + authorities
				+ ", userId=" + userId + "]";
	}
}
