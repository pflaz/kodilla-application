package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TaskRepository extends CrudRepository<Task, Integer> {
    @Override
    List<Task> findAll();

    @Override
    Task save(Task task);

    Optional<Task> findById(Long id);

    void deleteById(Long id);
}
