package ru.gb.Homework8.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.Homework8.aspect.TrackUserAction;
import ru.gb.Homework8.model.Task;
import ru.gb.Homework8.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    // Добавление задачи
    @TrackUserAction

    public Task add(Task task) {
        return repository.save(task);
    }

    // Просмотр всех задач
    @TrackUserAction

    public List<Task> getAll() {
        return repository.findAll();
    }

    // Просмотр задач по статусу
    @TrackUserAction
    public List<Task> getByStatus(Task.TaskStatus status) {
        return repository.findAll().stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    // Изменение статуса задачи
    @TrackUserAction
    public Task update(Long id, Task task) {
        Optional<Task> optionalTask = repository.findById(id);

        if (optionalTask.isPresent()) {
            Task updatedTask = optionalTask.get();

            updatedTask.setDescription(task.getDescription());
            updatedTask.setStatus(task.getStatus());
            updatedTask.setCreationDate(task.getCreationDate());

            return updatedTask;
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    // Удаление задачи
    @TrackUserAction
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
