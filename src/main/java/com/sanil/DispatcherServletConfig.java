package com.sanil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class DispatcherServletConfig implements WebApplicationInitializer {

    Logger logger = LoggerFactory.getLogger(DispatcherServletConfig.class);

    @Override
    public void onStartup(ServletContext servletContext) {

        logger.info("Initializing dispatcher servlet-->");

/*        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(DispatcherConfig.class);

        //Adding the listener for the rootContext
        servletContext.addListener(new ContextLoaderListener(rootContext));

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");*/

        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(Test.class);

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext =
                new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(Test.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
