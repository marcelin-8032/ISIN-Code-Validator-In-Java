package fr.isin.code.validator;

public interface IIsinValidation {

    String covertAnyLettersToNumber(String str);

    String multiplicationOfOddDigitByTwoAndThenSum(String number);

    String addingOfDigitsAtEvenPlace(String number);

    String sumOfDigits(String number);

    String subtractTheSumNearGreaterRound(String number);

    long getDigit(long number);


}
