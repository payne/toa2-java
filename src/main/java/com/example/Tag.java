package com.example;

public class Tag {
	public Tag(int id, String tag) {
		super();
		this.id = id;
		this.tag = tag;
	}
	int id;
	String tag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

}
