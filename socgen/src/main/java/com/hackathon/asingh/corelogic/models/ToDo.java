package com.hackathon.asingh.corelogic.models;

import javax.persistence.Id;

public class ToDo {

	int id;
	String task;
	String status;
	String category;

	public ToDo(int id, String task, String status, String category) {
		super();
		this.id = id;
		this.task = task;
		this.status = status;
		this.category = category;
	}

	public ToDo(String task, String status, String category) {
		super();
		this.task = task;
		this.status = status;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
