package fr.isin.code.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsinValidationTest {


    private IsinValidation isin;

    @BeforeEach
    void setUp() {
        isin = new IsinValidation();
    }

    @Test
    public void testconvertAnyLetterstoNumbers() {
        String num = "DE12";
        assertEquals("131412", isin.covertAnyLettersToNumber(num));
        String num1 = "ABCDE";
        assertEquals("1011121314", isin.covertAnyLettersToNumber(num1));
    }


    @Test
    public void testFromRightmostDigitMultiPlyBy2AtOddplaceThenSumThem() {
        assertEquals("8", isin.multiplicationOfOddDigitByTwoAndThenSum("123"));
        assertEquals("12", isin.multiplicationOfOddDigitByTwoAndThenSum("1234"));
        assertEquals("18", isin.multiplicationOfOddDigitByTwoAndThenSum("12345"));
        assertEquals("24", isin.multiplicationOfOddDigitByTwoAndThenSum("123456"));
        assertEquals("32", isin.multiplicationOfOddDigitByTwoAndThenSum("1234567"));
        assertEquals("40", isin.multiplicationOfOddDigitByTwoAndThenSum("12345678"));
        assertEquals("32", isin.multiplicationOfOddDigitByTwoAndThenSum("125698"));
        assertEquals("50", isin.multiplicationOfOddDigitByTwoAndThenSum("123456789"));
        assertEquals("54", isin.multiplicationOfOddDigitByTwoAndThenSum("1314123456789"));
    }

    @Test
    public void testFromRightMostSumDigitsAtEvenPlaces() {
        assertEquals("2", isin.addingOfDigitsAtEvenPlace("123"));
        assertEquals("4", isin.addingOfDigitsAtEvenPlace("1234"));
        assertEquals("9", isin.addingOfDigitsAtEvenPlace("123456"));
        assertEquals("12", isin.addingOfDigitsAtEvenPlace("1234567"));
        assertEquals("4", isin.addingOfDigitsAtEvenPlace("1234"));
        assertEquals("15", isin.addingOfDigitsAtEvenPlace("125698"));
        assertEquals("9", isin.addingOfDigitsAtEvenPlace("151879"));
        assertEquals("27", isin.addingOfDigitsAtEvenPlace("1314123456789"));
    }

    @Test
    public void testSumOfAllDigits() {
        assertEquals("10", isin.sumOfDigits("123"));
        assertEquals("16", isin.sumOfDigits("1234"));
        assertEquals("33", isin.sumOfDigits("123456"));
        assertEquals("44", isin.sumOfDigits("1234567"));
    }


    @Test
    public void testSubtractSumoDigitMinusNearestEqual() {
        assertEquals("0", isin.subtractTheSumNearGreaterRound("123"));
        assertEquals("4", isin.subtractTheSumNearGreaterRound("1234"));
        assertEquals("6", isin.subtractTheSumNearGreaterRound("12345"));
        assertEquals("7", isin.subtractTheSumNearGreaterRound("123456"));
        assertEquals("6", isin.subtractTheSumNearGreaterRound("1234567"));
    }


    @Test
    public void testIfDigitsAreBiggerThan9ThenReturnSumOfTheirDigits() {
        assertEquals(9, isin.getDigit(9));
        assertEquals(6, isin.getDigit(15));
        assertEquals(10, isin.getDigit(19));
    }


}