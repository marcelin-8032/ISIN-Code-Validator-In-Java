package fr.isin.code.validator;


public interface IIsinValidation {

    boolean isValidIsin(String number) throws Exception;

    long covertAnyLettersToNumber(String str);

    long multiplicationOfOddDigitByTwoAndThenSum(String number);

    long addingOfDigitsAtEvenPlace(String number);

    long sumOfDigits(String number);

    boolean checkDigit(String number);

    long sumToSingleDigit(long number);





}
