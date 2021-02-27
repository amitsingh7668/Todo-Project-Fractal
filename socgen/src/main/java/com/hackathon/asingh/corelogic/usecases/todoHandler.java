package com.hackathon.asingh.corelogic.usecases;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.hackathon.asingh.corelogic.models.ToDo;
import com.hackathon.asingh.adapters.secondary.repositories.JpaToDoListEntity;
import com.hackathon.asingh.corelogic.gateways.repositories.*;

@Component
public class todoHandler {

	public toDoListRepository toDolist;

	public todoHandler(toDoListRepository toDolist) {
		this.toDolist = toDolist;
	}

	public List<JpaToDoListEntity> handleTasks() {
		List<JpaToDoListEntity> jpList = toDolist.allTasks();
		Collections.sort(jpList);
		return jpList;

	}

	public List<JpaToDoListEntity> handleAddTasks(String task) {
		try {
			List AllTasks = toDolist.allTasks().stream().map(m -> m.getTask()).collect(Collectors.toList());
			List taskId = toDolist.allTasks().stream().map(m -> m.getId()).collect(Collectors.toList());
			int maxId = (int) Collections.max(taskId);
			if (!AllTasks.contains(task)) {
				toDolist.save(new ToDo(maxId + 1, task, "NOT COMPLETED", "TODO"));
			}
		} catch (Exception e) {
			toDolist.save(new ToDo(1, task, "NOT COMPLETED", "TODO"));
		}

		List<JpaToDoListEntity> jpList = toDolist.allTasks();
		Collections.sort(jpList);
		return jpList;

	}

	public List<JpaToDoListEntity> deleteTaskHandler(int id) {
		toDolist.removeFromTaskList(id);
		List<JpaToDoListEntity> jpList = toDolist.allTasks();
		Collections.sort(jpList);
		return jpList;

	}

	public List<JpaToDoListEntity> UpdateTask(int id) {
		Optional<JpaToDoListEntity> jp = toDolist.allTasks().stream().filter(f -> f.getId() == id).findFirst();
		if (jp.get().getStatus().equals("COMPLETED")) {
			jp.get().setStatus("NOT COMPLETED");
		} else {
			jp.get().setStatus("COMPLETED");
		}
		toDolist.save(new ToDo(jp.get().getId(), jp.get().getTask(), jp.get().getStatus(), jp.get().getCategory()));
		List<JpaToDoListEntity> jpList = toDolist.allTasks();
		Collections.sort(jpList);
		return jpList;

	}

	public List<JpaToDoListEntity> UpdateTaskHandler(int id, String categeory) {
		Optional<JpaToDoListEntity> jp = toDolist.allTasks().stream().filter(f -> f.getId() == id).findFirst();
		jp.get().setCategory(categeory);
		toDolist.save(new ToDo(jp.get().getId(), jp.get().getTask(), jp.get().getStatus(), jp.get().getCategory()));
		List<JpaToDoListEntity> jpList = toDolist.allTasks();
		Collections.sort(jpList);
		return jpList;
	}

}
