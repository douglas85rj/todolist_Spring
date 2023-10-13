package br.com.douglassouza.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/task")
public class TaskController {
    
    @Autowired
    private ITaskRepository taskRepository;
    
    @PostMapping("/")
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel taskModel, HttpServletRequest request){
    
        var idUser = (UUID) request.getAttribute("idUser");
        taskModel.setIdUser(idUser);

        var currentDate = LocalDateTime.now();
       if(currentDate.isAfter(taskModel.getEndAt())){
           return ResponseEntity.badRequest().build();
         }
    
        this.taskRepository.save(taskModel);
        return ResponseEntity.ok(taskModel);
    }
}

