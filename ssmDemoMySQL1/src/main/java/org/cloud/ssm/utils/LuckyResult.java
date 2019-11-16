package org.cloud.ssm.utils;

import java.util.List;

import org.cloud.ssm.entity.Person;

public class LuckyResult {
	private int res;
	private List<Person> data;
	
	public LuckyResult() {
		super();
	}
	public LuckyResult(int res, List<Person> data) {
		super();
		this.res = res;
		this.data = data;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public List<Person> getData() {
		return data;
	}
	public void setData(List<Person> data) {
		this.data = data;
	}
}
