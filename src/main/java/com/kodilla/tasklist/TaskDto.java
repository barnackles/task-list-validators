package com.kodilla.tasklist;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
@Value
public class TaskDto {
    @NotNull
    @DateMin("2021-01-01")
    LocalDate when;
    @NotNull
    String title;
    @IntRange(min = 1, max = 5)
    int priority;
}
