package com.gl.dispatcher;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.gl.springconfig.SpringConfig;

public class DispatcherConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[0];
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		return new Class[] { SpringConfig.class };
	}

	@Override
	protected String[] getServletMappings() 
	{
		return new String[] { "/" };
	}
}



