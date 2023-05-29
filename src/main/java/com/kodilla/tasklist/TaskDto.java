package com.kodilla.tasklist;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
@Value
public class TaskDto {
    @NotNull
    LocalDate when;
    @NotNull
    String title;
    int priority;
}
