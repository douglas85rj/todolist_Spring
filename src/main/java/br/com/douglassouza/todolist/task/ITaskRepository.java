package br.com.douglassouza.todolist.task;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;




public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {

 List<TaskModel> findByIdUser(UUID idUser);

    @Override
    public <S extends TaskModel> S save(S taskModel);

  
    
}
