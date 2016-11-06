package org.jdbc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 要先在META_INF/persistence.xml做下配置
@Entity
@Table
public class User {

	@Id
	private String uid;

	private String uname;

	private String password;

	public User() {
	}

	public User(String uid, String uname, String password) {
		this.uid = uid;
		this.uname = uname;
		this.password = password;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + "]";
	}
	
}
