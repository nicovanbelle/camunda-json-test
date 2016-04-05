package be.powerdale.listener;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.variable.VariableMap;

import javax.ejb.Stateless;
import javax.inject.Named;

@Stateless
@Named
public class OnAssign implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        VariableMap typedMap = delegateTask.getVariablesTyped(true);
    }

}
