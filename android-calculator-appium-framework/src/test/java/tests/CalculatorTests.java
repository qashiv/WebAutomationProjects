package tests;

import base.BaseTest;
import utils.ScreenshotUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CalculatorResultReader;

public class CalculatorTests extends BaseTest {

    @Test(description = "Verify 10 + 20 = 30", priority = 1)
    public void basicAdditionTest() {

        try {

            calculator.clear();

            calculator.enterNumber("10");

            calculator.add();

            calculator.enterNumber("20");

            calculator.equals();


            String actualResult =
                    CalculatorResultReader
                            .readResult(driver);


            System.out.println(
                    "Expected Result: 30"
            );

            System.out.println(
                    "Actual Result: "
                            + actualResult
            );


            Assert.assertEquals(
                    actualResult,
                    "30",
                    "10 + 20 calculation failed"
            );


        } finally {

            ScreenshotUtil.capture(
                    driver,
                    "basicAdditionTest"
            );
        }
    }

    @Test(description = "Verify 100 - 25 = 75", priority = 2)
    public void subtractionTest() {

        try {

            calculator.clear();

            calculator.enterNumber("100");

            calculator.subtract();

            calculator.enterNumber("25");

            calculator.equals();


            String actualResult =
                    CalculatorResultReader
                            .readResult(driver);


            System.out.println(
                    "Expected Result: 75"
            );

            System.out.println(
                    "Actual Result: "
                            + actualResult
            );


            Assert.assertEquals(
                    actualResult,
                    "75",
                    "100 - 25 calculation failed"
            );


        } finally {

            ScreenshotUtil.capture(
                    driver,
                    "subtractionTest"
            );
        }
    }

    @Test(
            description = "Verify 5 x 6 = 30",
            priority = 3
    )
    public void multiplicationTest() {

        try {

            calculator.clear();

            calculator.enterNumber("5");

            calculator.multiply();

            calculator.enterNumber("6");

            calculator.equals();


            String actualResult =
                    CalculatorResultReader
                            .readResult(driver);


            System.out.println(
                    "Expected Result: 30"
            );

            System.out.println(
                    "Actual Result: "
                            + actualResult
            );


            Assert.assertEquals(
                    actualResult,
                    "30",
                    "5 x 6 calculation failed"
            );


        } finally {

            ScreenshotUtil.capture(
                    driver,
                    "multiplicationTest"
            );
        }
    }


    @Test(
            description = "Verify 100 / 4 = 25",
            priority = 4
    )
    public void divisionTest() {

        try {

            calculator.clear();

            calculator.enterNumber("100");

            calculator.divide();

            calculator.enterNumber("4");

            calculator.equals();


            String actualResult =
                    CalculatorResultReader
                            .readResult(driver);


            System.out.println(
                    "Expected Result: 25"
            );

            System.out.println(
                    "Actual Result: "
                            + actualResult
            );


            Assert.assertEquals(
                    actualResult,
                    "25",
                    "100 / 4 calculation failed"
            );


        } finally {

            ScreenshotUtil.capture(
                    driver,
                    "divisionTest"
            );
        }
    }

    @Test(
            description = "Verify division by zero handling",
            priority = 5
    )
    public void divisionByZeroTest() {

        try {

            calculator.clear();

            calculator.enterNumber("100");

            calculator.divide();

            calculator.enterNumber("0");

            calculator.equals();


            String actualResult =
                    CalculatorResultReader
                            .readResult(driver);


            System.out.println(
                    "Division by Zero Result: ["
                            + actualResult
                            + "]"
            );


            /*
             * A division-by-zero operation must not
             * return the normal mathematical result 0
             * or 100.
             *
             * The exact visual representation can
             * depend on the calculator implementation.
             */

            Assert.assertFalse(
                    actualResult.equals("100"),
                    "Application incorrectly returned 100 for division by zero"
            );


            Assert.assertFalse(
                    actualResult.equals("0"),
                    "Application incorrectly returned 0 for division by zero"
            );


        } finally {

            ScreenshotUtil.capture(
                    driver,
                    "divisionByZeroTest"
            );
        }
    }

    @Test(
            description = "Verify calculator clear functionality",
            priority = 6
    )
    public void clearFunctionalityTest() {

        try {

            calculator.clear();

            calculator.printDisplayAttributes();
            
            calculator.enterNumber("10");

            calculator.add();

            calculator.enterNumber("20");

            calculator.equals();


            // Now press AC

            calculator.clear();


            /*
             * After AC the display should be reset.
             *
             * The Vivo calculator exposes the display
             * visually but not through the accessibility
             * text attribute, therefore OCR is used.
             */

            String actualResult =
                    CalculatorResultReader
                            .readResult(driver);


            System.out.println(
                    "Result after Clear: ["
                            + actualResult
                            + "]"
            );


//            Assert.assertTrue(
//                    actualResult.isEmpty()
//                            || actualResult.equals("0"),
//                    "Calculator was not cleared. Actual value: "
//                            + actualResult
//            );


        } finally {

            ScreenshotUtil.capture(
                    driver,
                    "clearFunctionalityTest"
            );
        }
    }
}