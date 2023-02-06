package HomeWork7;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class CalculatorTestListener extends RunListener {

    @Override
    public void testFinished(Description description) throws Exception {

        System.out.println(description.getMethodName() + " успешно ? выполнен ");
    }
}
