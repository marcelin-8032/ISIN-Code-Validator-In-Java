package fr.isin.code.validator;

import fr.isin.code.model.Country;

import java.util.Arrays;

public interface IIsinValidation {

    String covertAnyLettersToNumber(String str);

    long multiplicationOfOddDigitByTwoAndThenSum(String number);

    long addingOfDigitsAtEvenPlace(String number);

    long sumOfDigits(String number);

    long checkDigit(String number);

    long sumToSingleDigit(long number);

    boolean checkFirstTwoLetter(String number) throws Exception;

    boolean isValidIsin(String number) throws Exception;


}
