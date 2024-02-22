package com.gl.springconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration 
@EnableWebMvc 
@ComponentScan("com.gl.controller")
public class SpringConfig 
{
	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public SpringResourceTemplateResolver templateResolver() 
	{
		//this is the object which finds the front end files - locate
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		//folder
		resolver.setPrefix("/WEB-INF/views/");
		//extension
		resolver.setSuffix(".html");
		//which container
		resolver.setApplicationContext(applicationContext);
		//type of file
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() 
	{
		//load the file found by the Resolver
		SpringTemplateEngine engine = new SpringTemplateEngine();
		//mapping the engine to the resolver
		engine.setTemplateResolver(templateResolver());
		//for accepting the Expression Language eg: ${temo.name} ${message}
		engine.setEnableSpringELCompiler(true);
		return engine;
	}

	@Bean
	public ThymeleafViewResolver viewResolver() 
	{
		//thyme leaf object
		ThymeleafViewResolver vr = new ThymeleafViewResolver();
		//loader - engine
		vr.setTemplateEngine(templateEngine());
		return vr;
	}
}