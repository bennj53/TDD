package org.example.FizzBuzz;

import junit.framework.TestCase;
import org.example.FizzBuzz.App;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void test_multiple_de_3() {
        App app = new App();
        String result = app.fizzBuzz(3);
        assertEquals("Fizz", result);
    }

    public void test_multiple_de_5() {
        App app = new App();
        String result = app.fizzBuzz(5);
        assertEquals("Buzz", result);
    }

    public void test_multiple_de_15() {
        App app = new App();
        String result = app.fizzBuzz(15);
        assertEquals("FizzBuzz", result);
    }

    public void test_non_multiple_3_5_15(){
        App app = new App();
        String result = app.fizzBuzz(8);
        assertEquals("8", result);
    }
}
