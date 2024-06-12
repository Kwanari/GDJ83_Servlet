package com.kwan.home;

public class Action {

	private boolean flag; // controller의 if문
	private String path; // student, weather uri 변수

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
