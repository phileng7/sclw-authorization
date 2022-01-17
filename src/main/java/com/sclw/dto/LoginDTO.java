package com.sclw.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String username;
	private String senha;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", senha=" + senha + "]";
	}
}
