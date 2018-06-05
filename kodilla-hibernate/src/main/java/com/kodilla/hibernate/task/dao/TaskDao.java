package com.kodilla.hibernate.task.dao;

import org.springframework.data.repository.CrudRepository;
import com.kodilla.hibernate.task.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TaskDao extends CrudRepository<Task, Integer> {

    List<Task> findByDuration(int duration);

}
