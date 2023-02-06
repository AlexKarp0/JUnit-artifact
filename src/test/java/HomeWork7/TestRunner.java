package HomeWork7;

import by.academy.jUnit.Listener.CustomListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;

public class TestRunner extends BlockJUnit4ClassRunner {
    private CalculatorTestListener customListener;

    public TestRunner (Class<CustomListener> clz) throws InitializationError{
        super(clz);
        customListener = new CalculatorTestListener();
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(customListener);
        super.run(notifier);
    }
}

