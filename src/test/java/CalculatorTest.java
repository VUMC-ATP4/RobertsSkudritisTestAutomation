import mavenTestNGHomework.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {

    //vajag uztaisit include folderim clasroomSix
Calculator calculator;
    @BeforeTest
    public void pirmsTests(){
        System.out.println("Sakas tests");
        calculator = new Calculator();
    }

    @Test
    public void testSum(){
        System.out.println("Sis ir pirmais tests");
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(13,25);
        int expectedResult = 38;
        Assert.assertEquals(actualResult,expectedResult);

    }



}
