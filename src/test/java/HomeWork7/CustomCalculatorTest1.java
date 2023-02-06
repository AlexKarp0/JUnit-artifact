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

public class CustomCalculatorTest1 {


    @Parameters(name = "{index}: sumOf({0}+{1})={2}")

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0, 0 },
                { 1, 1, 2 },
                { 2, 1, 3 },
                { 3, 2, 5 },
                { 4, 3, 7  }});
    }

    private final CustomCalculator calculator;
    private final double first;
    private final double second;
    private final double expectedSum;

    public CustomCalculatorTest1(double first,
                                 double second,
                                 double expectedSum) {

        this.calculator = new CustomCalculator();
        this.first = first;
        this.second = second;
        this.expectedSum = expectedSum;
    }

    @Test
    public void shouldReturnCorrectSum() {

        Assert.assertEquals(expectedSum,calculator.sum(first,second),0.0001);
    }
}