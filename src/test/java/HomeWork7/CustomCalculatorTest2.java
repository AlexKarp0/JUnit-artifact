package HomeWork7;

import JUnit_group.HomeWork7.Task3.CustomCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;

@RunWith(Parameterized.class)

public class CustomCalculatorTest2 {


    @Parameters(name = "{index}: sqrValue of ({0}={2}")

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 },
                { 1, 1 },
                { 2, 4 },
                { 10,100.000000000000001 },// точность указывается в тесте
                { 11, 121 }});
    }

    private final CustomCalculator calculator;
    private final double value;
    private final double sqrValue;

    public CustomCalculatorTest2(double value,
                                 double sqrValue){
        this.calculator = new CustomCalculator();
        this.value = value;
        this.sqrValue = sqrValue;
    }

    @Test
    public void testSqr() {

        Assert.assertEquals(sqrValue,calculator.sqr(value),0.0001);
    }
}