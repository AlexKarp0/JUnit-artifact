package by.academy.jUnit.Listener;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;

public class TestRunner extends BlockJUnit4ClassRunner {
    private  CustomListener customListener;

    public TestRunner (Class<CustomListener> clz) throws InitializationError{
        super(clz);
        customListener = new CustomListener();
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(customListener);
        super.run(notifier);
    }
}
