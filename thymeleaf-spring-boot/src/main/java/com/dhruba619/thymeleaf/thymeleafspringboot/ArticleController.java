package com.dhruba619.thymeleaf.thymeleafspringboot;

import com.dhruba619.thymeleaf.thymeleafspringboot.model.Article;
import com.dhruba619.thymeleaf.thymeleafspringboot.model.Author;
import com.dhruba619.thymeleaf.thymeleafspringboot.model.NewArticle;
import com.dhruba619.thymeleaf.thymeleafspringboot.service.ArticleService;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/")
    public ModelAndView getArticle(ModelAndView modelAndView) {
        Article article = new Article();
        article.setAuthor(getName());
        article.setContent(getArticleContent());
        article.setTitle(getTitle());
        modelAndView.addObject("article", article);
        modelAndView.setViewName("article");
        return modelAndView;
    }


    @GetMapping("/articles")
    public ModelAndView getArticles(ModelAndView modelAndView) {
        modelAndView.addObject("articles", getArticles());
        modelAndView.addObject("authors", getAuthors());
        modelAndView.setViewName("articles");
        return modelAndView;
    }

    @GetMapping("/form")
    public ModelAndView getArticleForm(ModelAndView modelAndView, Article article) {
        modelAndView.addObject("categories", Arrays.asList("SERVER", "UNIX", "CLOUD"));
        modelAndView.addObject("technologies", Arrays.asList("JAVA", "GO", "NODEJS"));
        modelAndView.addObject("areas", Arrays.asList("Spring", "Struts", "DJengo"));
        modelAndView.setViewName("articleForm");
        return modelAndView;
    }

    @PostMapping("/article")
    public String saveArticle(@ModelAttribute @Valid Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "articleForm";
        }
        articleService.saveArticle(article);
        return "redirect:articles";
    }


    private Map<Integer, Author> getAuthors() {
        Map<Integer, Author> authorMap = new HashMap<>();
        IntStream.range(0, 5).forEach(number -> {
            authorMap.put(number, Author.builder().id(number).name(Faker.instance().name().fullName()).build());
        });
        return authorMap;
    }

    private List<NewArticle> getArticles() {
        List<NewArticle> articles = new ArrayList<>();
        IntStream.range(0, 5).forEach(number -> {
            articles.add(NewArticle.builder().author(number).content(getArticleContent()).title(getTitle()).build());
        });
        return articles;
    }

    private String getTitle() {
        return Faker.instance().lorem().sentence();
    }

    private String getName() {
        return Faker.instance().name().fullName();
    }

    private String getArticleContent() {
        return Faker.instance().lorem().paragraph(10);
    }

    public static void main(String[] args) {
        System.out.println(Faker.instance().name().fullName());
    }

}
