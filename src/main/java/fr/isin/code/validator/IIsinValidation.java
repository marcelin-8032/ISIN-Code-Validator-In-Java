package fr.isin.code.validator;

import fr.isin.code.model.Country;

import java.util.Arrays;

public interface IIsinValidation {

    String covertAnyLettersToNumber(String str);

    String multiplicationOfOddDigitByTwoAndThenSum(String number);

    String addingOfDigitsAtEvenPlace(String number);

    String sumOfDigits(String number);

    boolean checkDigit(String number);

    long getDigit(long number);

    boolean checkFirstTwoLetter(String number) throws Exception;

    boolean isValidIsin(String number) throws Exception;


}
