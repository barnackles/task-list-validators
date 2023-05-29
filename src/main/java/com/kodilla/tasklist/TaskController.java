package com.kodilla.tasklist;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @GetMapping("/{priority}")
    public ResponseEntity<List<TaskDto>> getFiltered(@PathVariable @Min(1) @Max(5) int priority) {
        List<TaskDto> dtos = TaskRepository.getRepository()
                .stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleException(ConstraintViolationException exc) {
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.BAD_REQUEST);
    }
}