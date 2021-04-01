package fr.isin.code.validator;

import fr.isin.code.model.Country;

import java.util.Arrays;


public class IsinValidation implements IIsinValidation {


    public String covertAnyLettersToNumber(String str) {
        String result = "";
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                result = result + ch;
            }

            if (Character.isLetter(ch)) {
                result = result + (ch - 55);
            }
        }
        return result;
    }


    public long multiplicationOfOddDigitByTwoAndThenSum(String number) {
        long sumOdd = 0;
        for (int i = number.length() - 1; i >= 0; i -= 2) {
            sumOdd += sumToSingleDigit(Long.parseLong(Character.getNumericValue(number.charAt(i)) + "")) * 2;

        }
        return sumOdd;

    }

    public long addingOfDigitsAtEvenPlace(String number) {
        long sumEven = 0;
        for (int i = number.length() - 2; i >= 0; i -= 2) {
            sumEven += sumToSingleDigit(Long.parseLong(Character.getNumericValue(number.charAt(i)) + ""));
        }
        return sumEven;

    }


    public long sumOfDigits(String number) {
        long sumAll = multiplicationOfOddDigitByTwoAndThenSum(number) + addingOfDigitsAtEvenPlace(number);
        return sumAll;
    }

    public long checkDigit(String number) {
        long cl = sumOfDigits(number);
        long sNear = 10 + (cl / 10) * 10;
        long digit;
        if (cl % 10 == 0) {
            return 10;
        } else if (sNear >= cl) {

            digit = sNear - cl;
            return digit;
        } else {
            return 0;
        }
    }

    public long sumToSingleDigit(long number) {
        if (number < 9)
            return number;
        return number / 10 + number % 10;

    }

    public long getSizeISIN(String number) {
        return number.length();
    }

    public boolean checkFirstTwoLetter(String number) throws Exception {
        if (number.length() < 2) {
            throw new Exception("Your Number is less than two character!");
        }
        return Arrays.stream(Country.values())
                .map(Country::getCode).anyMatch(number::contains);
    }

    public boolean isValidIsin(String number) throws Exception {
        return (getSizeISIN(number) == 12) && checkFirstTwoLetter(number) && (covertAnyLettersToNumber(number).length() == 14)
                && (10 - (sumOfDigits(covertAnyLettersToNumber(number)) % 10) == checkDigit(covertAnyLettersToNumber(number)));

    }


    public static void main(String[] args) throws Exception {
        IsinValidation isinValidation = new IsinValidation();
        System.out.println(isinValidation.isValidIsin("US9311421039"));
    }


}
