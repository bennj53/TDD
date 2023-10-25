package org.example.FizzBuzz;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    public String fizzBuzz(int number){
        String fizzBuzz = "";

        if(number%3 == 0) {
            fizzBuzz = FIZZ;
        }

        if(number%5 == 0) {
            fizzBuzz += BUZZ;
        }

        return fizzBuzz == ""? ""+number : fizzBuzz;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
