package com.bstirbat.sample.electronicstore;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final int DEFAULT_JETTY_PORT = 8080;

    public static void main(String[] args) throws Exception {

        int port = DEFAULT_JETTY_PORT;

        for(String arg: args) {
            int index = arg.indexOf(':');
            if (index > 0) {
                String namePart = arg.substring(0, index);
                String valuePart = arg.substring(index + 1);
                if ("port".equals(namePart)) {
                    try {
                        port = Integer.parseInt(valuePart);
                    } catch (Exception e) {
                        logger.warn("Could not parse given port value {}, using {}", namePart, port);
                    }
                }
            }
        }

        Server server = new Server(port);

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