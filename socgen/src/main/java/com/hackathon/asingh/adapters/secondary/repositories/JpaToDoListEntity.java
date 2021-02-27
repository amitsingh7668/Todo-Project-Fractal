package com.hackathon.asingh.adapters.secondary.repositories;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo", schema = "public")
public class JpaToDoListEntity implements Serializable, Comparable<JpaToDoListEntity> {

	@Id
	Integer id;
	String task;
	String status;
	String category;

	public JpaToDoListEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JpaToDoListEntity(Integer id, String task, String status, String category) {
		super();
		this.id = id;
		this.task = task;
		this.status = status;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	@Override
	public int compareTo(JpaToDoListEntity o) {

		return id.compareTo(o.getId());
	}

}
