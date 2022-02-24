package co.com.sofka.katafullStack.services;


import co.com.sofka.katafullStack.models.Todo;
import co.com.sofka.katafullStack.models.TodoTask;
import co.com.sofka.katafullStack.repositories.TodoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoTaskServices {

    @Autowired
    private TodoTaskRepository todoTaskRespository;

    // listar todas las tareas
    public List<TodoTask> listTodo(){
        return todoTaskRespository.findAll();
    }

    // buscar tarea por id
    public Optional<TodoTask> findById(Long id){
        return todoTaskRespository.findById(id);
    }

    // buscar task por todoId

    // Crear nueva tarea
    public TodoTask save(TodoTask todotask){
        return todoTaskRespository.save(todotask);
    }

    // Actualizar tarea
    public TodoTask updateTodo(TodoTask todotask) {
        Optional<TodoTask> TodoTaskData = todoTaskRespository.findById(todotask.getId());

        if(TodoTaskData.isEmpty()){
            throw new IllegalArgumentException("La tarea no se encuentra en la base de datos");
        }

        return todoTaskRespository.save(todotask);
    }

    // borrar tarea
    public void deleteById(Long id){
        todoTaskRespository.deleteById(id);
    }
}

