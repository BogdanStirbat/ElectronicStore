package com.bstirbat.sample.electronicstore;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Main {

    private static final int DEFAULT_JETTY_PORT = 8080;

    public static void main(String[] args) throws Exception {
        Server server = new Server(DEFAULT_JETTY_PORT);

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
        webAppContext.setConfigLocation("com.bstirbat.sample.electronicstore");
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppContext);
        ServletHolder springServletHolder = new ServletHolder("mvc-dispatcher", dispatcherServlet);
        contextHandler.addServlet(springServletHolder, "/");
        contextHandler.addEventListener(new ContextLoaderListener(webAppContext));

        server.setHandler(contextHandler);
        server.start();
        server.join();
    }
}