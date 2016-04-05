package be.powerdale;

import org.camunda.bpm.application.ProcessApplicationInfo;
import org.camunda.bpm.application.ProcessApplicationInterface;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ProcessArchiveServletContextListener implements ServletContextListener {

    @EJB
    private ProcessApplicationInterface defaultEjbProcessApplication;

    public ProcessArchiveServletContextListener() {
    }

    public void contextInitialized(ServletContextEvent contextEvent) {
        String contextPath = contextEvent.getServletContext().getContextPath();
        this.defaultEjbProcessApplication.getProperties().put(ProcessApplicationInfo.PROP_SERVLET_CONTEXT_PATH , contextPath);
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    }
}
