package com.kodilla.tasklist;

import jakarta.validation.Payload;

public @interface DateMin {

    String message() default "Earlier date then expected";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String value() default "2020-01-01";

}
