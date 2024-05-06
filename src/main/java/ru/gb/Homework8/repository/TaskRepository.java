package ru.gb.Homework8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.Homework8.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
