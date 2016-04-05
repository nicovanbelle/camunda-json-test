package be.powerdale.listener;

import be.powerdale.domain.FunctionalLocation;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.variable.VariableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Named;

@Stateless
@Named
public class PrintVariables implements TaskListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintVariables.class);

    public void notify(DelegateTask delegateTask) {
        LOGGER.debug("fetching variables");
        VariableMap typedMap = delegateTask.getVariablesTyped(true);
        FunctionalLocation newAddressData = typedMap.getValue("newAddressData", FunctionalLocation.class);
    }
}
