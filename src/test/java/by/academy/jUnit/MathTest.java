package by.academy.jUnit;

import by.academy.jUnit.Listener.TestRunner;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(TestRunner.class)
public class MathTest extends Assert {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Before
    public void before() {
        System.out.println("Before each test");
    }
    @After public void after(){
        System.out.println("After each test");
    }

    @Test
    public void assertEquals() {
        System.out.println("@test 2+2=4");
        assertEquals(3, Math.min(3, 68));
        assertTrue(2 == 1 << 1);
    }


    @Test(timeout = 100, expected = ArithmeticException.class)
    public void timeoutTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println("TEST ");
        }
        int x = 1 / 0;
    }

}
