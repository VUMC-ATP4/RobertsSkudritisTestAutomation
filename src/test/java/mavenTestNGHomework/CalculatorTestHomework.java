package mavenTestNGHomework;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTestHomework {

//    Calculator calculator;

    @BeforeTest
    public void pirmsTests(){
        System.out.println("Sakas tests, pirms testa info");
        Calculator calculator = new Calculator();
    }

    @BeforeMethod
            public void pirmsMetodes(){
        System.out.println("Sakas tests, pirms metodes info");
    }

    @Test
    public void testAdd(){
        System.out.println("Sis ir add tests");
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(2,3);
        int expectedResult = 5;
        Assert.assertEquals(actualResult,expectedResult);

    }


    @Test
    public void testMultiply(){
        System.out.println("Sis ir multiply tests");
        Calculator calculator = new Calculator();
//        int actualResult = calculator.multiply(5,5);
//        int expectedResult = 25;
        Assert.assertEquals(calculator.multiply(5,5),25);
    }

    @Test
    public void testSubstract(){
        System.out.println("Sis ir substract tests");
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.substract(10,5),5);
    }

    @Test
    public void testDivide(){
        System.out.println("Sis ir divide tests");
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(5,5),0);
    }




}
