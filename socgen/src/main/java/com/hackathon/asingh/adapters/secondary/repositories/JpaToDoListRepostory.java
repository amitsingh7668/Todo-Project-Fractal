package com.hackathon.asingh.adapters.secondary.repositories;

import com.hackathon.asingh.corelogic.gateways.repositories.toDoListRepository;
import com.hackathon.asingh.corelogic.models.ToDo;

import java.util.List;

import javax.transaction.Transactional;

@Transactional
public class JpaToDoListRepostory implements toDoListRepository {

	private SpringDataJpaToDoLiStRepository jpaToDoRepository;

	public JpaToDoListRepostory(SpringDataJpaToDoLiStRepository jpaToDoRepository) {
		this.jpaToDoRepository = jpaToDoRepository;
	}

	@Override
	public void save(ToDo newTask) {
		JpaToDoListEntity jp = new JpaToDoListEntity(newTask.getId(), newTask.getTask(), newTask.getStatus(),
				newTask.getCategory());
		jpaToDoRepository.save(jp);

	}

	@Override
	public String byId(String Employeeid, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JpaToDoListEntity> allTasks() {

		return jpaToDoRepository.findAll();
	}

	@Override
	public void removeFromTaskList(int id) {
		jpaToDoRepository.deleteById(id);

	}

	@Override
	public String userNameAvaibilityCheck(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
