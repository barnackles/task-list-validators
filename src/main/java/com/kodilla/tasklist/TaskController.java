package com.kodilla.tasklist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @GetMapping("/{priority}")
    public ResponseEntity<List<TaskDto>> getFiltered(@PathVariable int priority) {
        List<TaskDto> dtos = TaskRepository.getRepository()
                .stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}