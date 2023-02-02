package by.academy.jUnit.Listener;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class CustomListener extends RunListener {
    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("успешно выполнено " + (result.getRunCount() - result.getFailureCount()) );
    }

    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println(description.getMethodName() + " как-то выполнен ");
    }
}
