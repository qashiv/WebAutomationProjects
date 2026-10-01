package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class CalculatorPage {

    private AndroidDriver driver;

    // ============================================
    // DIGITS
    // ============================================

    private static final int[] ZERO =
            {416, 2178};

    private static final int[] ONE =
            {168, 1967};

    private static final int[] TWO =
            {416, 1967};

    private static final int[] THREE =
            {664, 1967};

    private static final int[] FOUR =
            {168, 1756};

    private static final int[] FIVE =
            {416, 1756};

    private static final int[] SIX =
            {664, 1756};

    private static final int[] SEVEN =
            {168, 1544};

    private static final int[] EIGHT =
            {416, 1544};

    private static final int[] NINE =
            {664, 1544};


    // ============================================
    // OPERATORS
    // ============================================

    private static final int[] ADD =
            {912, 1967};

    private static final int[] SUBTRACT =
            {912, 1756};

    private static final int[] MULTIPLY =
            {912, 1544};

    private static final int[] DIVIDE =
            {912, 1333};

    private static final int[] EQUALS =
            {912, 2178};

    private static final int[] CLEAR =
            {168, 1333};


    public CalculatorPage(
            AndroidDriver driver) {

        this.driver = driver;
    }


    // ============================================
    // DIGIT METHODS
    // ============================================

    public void pressDigit(String digit) {

        switch (digit) {

            case "0":
                tap(ZERO);
                break;

            case "1":
                tap(ONE);
                break;

            case "2":
                tap(TWO);
                break;

            case "3":
                tap(THREE);
                break;

            case "4":
                tap(FOUR);
                break;

            case "5":
                tap(FIVE);
                break;

            case "6":
                tap(SIX);
                break;

            case "7":
                tap(SEVEN);
                break;

            case "8":
                tap(EIGHT);
                break;

            case "9":
                tap(NINE);
                break;

            default:
                throw new IllegalArgumentException(
                        "Invalid digit: " + digit
                );
        }
    }


    public void enterNumber(String number) {

        for (char digit : number.toCharArray()) {

            pressDigit(
                    String.valueOf(digit)
            );
        }
    }


    // ============================================
    // OPERATIONS
    // ============================================

    public void add() {
        tap(ADD);
    }

    public void subtract() {
        tap(SUBTRACT);
    }

    public void multiply() {
        tap(MULTIPLY);
    }

    public void divide() {
        tap(DIVIDE);
    }

    public void equals() {
        tap(EQUALS);
    }

    public void clear() {
        tap(CLEAR);
    }


    // ============================================
    // GENERIC TAP
    // ============================================

    private void tap(int[] coordinate) {

        int x = coordinate[0];

        int y = coordinate[1];

        driver.executeScript(
                "mobile: clickGesture",
                Map.of(
                        "x", x,
                        "y", y
                )
        );
    }
    
    public void printDisplayAttributes() {

        WebElement formula =
                driver.findElement(
                        By.id(
                            "com.vivo.calculator:id/formula"
                        )
                );

        WebElement result =
                driver.findElement(
                        By.id(
                            "com.vivo.calculator:id/result"
                        )
                );

        System.out.println(
                "FORMULA text: ["
                        + formula.getAttribute("text")
                        + "]"
        );

        System.out.println(
                "FORMULA content-desc: ["
                        + formula.getAttribute("contentDescription")
                        + "]"
        );

        System.out.println(
                "RESULT text: ["
                        + result.getAttribute("text")
                        + "]"
        );

        System.out.println(
                "RESULT content-desc: ["
                        + result.getAttribute("contentDescription")
                        + "]"
        );
    }
}