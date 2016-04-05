package be.powerdale;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.ProcessApplicationInterface;
import org.camunda.bpm.application.impl.EjbProcessApplication;
import org.camunda.bpm.engine.cdi.impl.event.CdiEventListener;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.TaskListener;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import java.util.HashMap;
import java.util.Map;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@ProcessApplication("Test Application")
@Local({ProcessApplicationInterface.class})
public class AthlonEjbProcessApplication extends EjbProcessApplication {
    private CdiEventListener cdiEventListener = new CdiEventListener();

    private Map<String, String> properties = new HashMap<>();

    public AthlonEjbProcessApplication() {
    }

    @PostConstruct
    public void start() {
        this.deploy();
    }

    @PreDestroy
    public void stop() {
        this.undeploy();
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public ExecutionListener getExecutionListener() {
        return cdiEventListener;
    }

    public TaskListener getTaskListener() {
        return cdiEventListener;
    }

}