package com.dhruba619.thymeleaf_blog;

import java.io.StringWriter;
import java.util.Locale;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class StandaloneThymeleaf {
	
	public static void main(String[] args) {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setTemplateMode("HTML");
		templateResolver.setSuffix(".html");

		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		
		StringWriter writer = new StringWriter();
		Context context = new Context(Locale.GERMAN);
		context.setVariable("message", "Welcome to thymeleaf article");
		templateEngine.process("myTemplate", context, writer);
		System.out.println(writer.toString());
	}

}
