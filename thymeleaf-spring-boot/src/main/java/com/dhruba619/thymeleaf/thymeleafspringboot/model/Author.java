package com.dhruba619.thymeleaf.thymeleafspringboot.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Author {
    private int id;
    private String name;
}
