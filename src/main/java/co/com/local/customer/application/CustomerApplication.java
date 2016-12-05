package co.com.local.customer.application;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import co.com.local.customer.service.CustomerService;

//import co.com.local.customer.service.CustomerService;

public class CustomerApplication {
	public static void main(String[] args) throws Exception {
		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8071);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                CustomerService.class.getCanonicalName());
        
	/*	ResourceConfig config = new ResourceConfig();
		 config.packages("JavaGetCustomerRest");
		 ServletHolder servlet = new ServletHolder(new ServletContainer(config));


		Server server = new Server(2222);
		 ServletContextHandler context = new ServletContextHandler(server, "/*");
		 context.addServlet(servlet, "/*");
*/

		 
        /*ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8070);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
             org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter(
           "jersey.config.server.provider.classnames",
           CustomerService.class.getCanonicalName());
        jerseyServlet.setInitParameter(
                "co.com.local.customer.dto.CustomerDTO",
                "true");
*/
        try {
        	jettyServer.start();
        	jettyServer.join();
        } finally {
        	jettyServer.destroy();
        }
    }
}
