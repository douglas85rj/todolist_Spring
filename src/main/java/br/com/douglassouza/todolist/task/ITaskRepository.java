package br.com.douglassouza.todolist.task;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {

    @Override
    public <S extends TaskModel> S save(S taskModel);
    
}
