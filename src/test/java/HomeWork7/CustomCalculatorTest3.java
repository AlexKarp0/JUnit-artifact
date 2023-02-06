package HomeWork7;

import JUnit_group.HomeWork7.Task3.CustomCalculator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.sql.Time;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

@RunWith(Parameterized.class)

public class CustomCalculatorTest3 {
    @Rule
    public final TestRule timeout = Timeout.millis(100);

    @Parameters(name = "{index}: Sinus of {0} degrees  ={2}")

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 },
                { 90, 1 },
                { 30, 0.5 },
                { 60, Math.sqrt(3)/2 }
                });
    }

    private final CustomCalculator calculator;
    private final double angle;
    private final double sinusValue;

    public CustomCalculatorTest3(double value,
                                 double sqrValue){
        this.calculator = new CustomCalculator();
        this.angle = value;
        this.sinusValue = sqrValue;
    }

    @Test
    public void testSqr() {

        Assert.assertEquals(sinusValue,calculator.sinus(angle),0.0001);
    }
}