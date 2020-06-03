package com.dhruba619.thymeleaf.thymeleafspringboot.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class NewArticle {
    private String title;
    private int author;
    private String content;
}
