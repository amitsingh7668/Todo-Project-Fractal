package com.hackathon.asingh.adapters.primary;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.hackathon.asingh.adapters.secondary.repositories.JpaToDoListRepostory;
import com.hackathon.asingh.adapters.secondary.repositories.SpringDataJpaToDoLiStRepository;
import com.hackathon.asingh.corelogic.gateways.repositories.toDoListRepository;
import com.hackathon.asingh.corelogic.usecases.todoHandler;

@Configuration
@EntityScan(basePackages = { "com.hackathon.asingh.adapters.secondary" })
@EnableJpaRepositories(basePackages = { "com.hackathon.asingh.adapters.secondary.repositories" })
public class BeanConfiguration {

	@Bean
	public toDoListRepository toDoRepo(SpringDataJpaToDoLiStRepository jpatoDoRepository) {
		return new JpaToDoListRepostory(jpatoDoRepository);
	}

	@Bean
	public todoHandler todoHandle(toDoListRepository toDoiIst) {
		return new todoHandler(toDoiIst);

	}
}
