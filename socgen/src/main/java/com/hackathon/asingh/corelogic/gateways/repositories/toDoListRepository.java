package com.hackathon.asingh.corelogic.gateways.repositories;

import java.util.List;

import com.hackathon.asingh.adapters.secondary.repositories.JpaToDoListEntity;
import com.hackathon.asingh.corelogic.models.ToDo;

public interface toDoListRepository {

	void save(ToDo newTask);

	String byId(String Employeeid, String Password);

	List<JpaToDoListEntity> allTasks();

	void removeFromTaskList(int id);

	String userNameAvaibilityCheck(String userId);

}
