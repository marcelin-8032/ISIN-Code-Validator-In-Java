package fr.isin.code.validator;

import fr.isin.code.model.Country;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.isin.code.exception.InapproriateISINException;

public class IsinValidation implements IIsinValidation {

    public static final Pattern ISIN_LETTER_DIGITS_PATTERN = Pattern.compile("([A-Z]{2})([A-Z0-9]{9})([0-9]{1})");


    public boolean isValidIsin(String number) throws Exception {

        if (number.length() < 2) {
            throw new InapproriateISINException("Your ISIN Number is less than two character! It should be 12 characters");
        }

        boolean countryCodes = Arrays.stream(Country.values()).map(Country::getCode).anyMatch(number::contains);

        if (!countryCodes) {
            throw new InapproriateISINException("The country code is wrong");
        }

        Matcher matcher = ISIN_LETTER_DIGITS_PATTERN.matcher(number);

        if (!matcher.matches()) {
            throw new InapproriateISINException("Error ISIN number formation is Not valid");
        }

        return (countryCodes && matcher.matches());
    }

    public long covertAnyLettersToNumber(String str) {
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

        return Long.parseLong(result);
    }


    public long multiplicationOfOddDigitByTwoAndThenSum(String number) {
        number = String.valueOf(covertAnyLettersToNumber(number));
        long sumOdd = 0;
        for (int i = number.length() - 1; i >= 0; i -= 2) {
            sumOdd += sumToSingleDigit(Long.parseLong(Character.getNumericValue(number.charAt(i)) + "")) * 2;

        }
        return sumOdd;

    }

    public long addingOfDigitsAtEvenPlace(String number) {
        number = String.valueOf(covertAnyLettersToNumber(number));
        long sumEven = 0;
        for (int i = number.length() - 2; i >= 0; i -= 2) {
            sumEven += sumToSingleDigit(Long.parseLong(Character.getNumericValue(number.charAt(i)) + ""));
        }
        return sumEven;

    }

    public long sumOfDigits(String number) {
        return multiplicationOfOddDigitByTwoAndThenSum(number) + addingOfDigitsAtEvenPlace(number);
    }

    public boolean checkDigit(String number) {
        long cl = sumOfDigits(number);
        long sNear = 10 + (cl / 10) * 10;
        long digit;

        if (cl % 10 == 0) {
            return true;
        } else if (sNear >= cl) {
            digit = sNear - cl;
            return true;
        } else {
            return false;
        }
    }

    public long sumToSingleDigit(long number) {
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }

}
