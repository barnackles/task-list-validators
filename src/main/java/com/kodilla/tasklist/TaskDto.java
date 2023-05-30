package com.kodilla.tasklist;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
@Value
public class TaskDto {
    @NotNull
    LocalDate when;
    @NotNull
    String title;
    @Min(1)
    @Max(5)
    int priority;
}
