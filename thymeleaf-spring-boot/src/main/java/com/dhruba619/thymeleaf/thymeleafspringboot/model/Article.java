package com.dhruba619.thymeleaf.thymeleafspringboot.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article {

    @NotNull
    @Size(min=2, max=30)
    private String title;
    private String author;
    @NotNull
    @Size(min=2, max=1000)
    private String content;
    private String category;
    private String technology;
    private String area;
}
