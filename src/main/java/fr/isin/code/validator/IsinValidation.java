package fr.isin.code.validator;

import fr.isin.code.model.Country;

import java.util.Arrays;

import static fr.isin.code.model.Country.values;

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


    public String multiplicationOfOddDigitByTwoAndThenSum(String number) {
        long sum = 0;
        for (int i = number.length() - 1; i >= 0; i -= 2) {
            sum += getDigit(Long.parseLong(Character.getNumericValue(number.charAt(i)) + "")) * 2;

        }
        return String.valueOf(sum);

    }

    public String addingOfDigitsAtEvenPlace(String number) {
        long sum = 0;
        for (int i = number.length() - 2; i >= 0; i -= 2) {
            sum += getDigit(Long.parseLong(Character.getNumericValue(number.charAt(i)) + ""));
        }
        return String.valueOf(sum);

    }


    public String sumOfDigits(String number) {
        long sum = Long.parseLong(multiplicationOfOddDigitByTwoAndThenSum(number)) + Long.parseLong(addingOfDigitsAtEvenPlace(number));
        return String.valueOf(sum);
    }

    public boolean checkDigit(String number) {
        long cl = Long.parseLong(multiplicationOfOddDigitByTwoAndThenSum(number)) + Long.parseLong(addingOfDigitsAtEvenPlace(number));

        long sNear = 10 + (cl / 10) * 10;

        if (cl % 10 == 0) {
            return true;
        } else if (sNear >= cl) {
            long a = sNear - cl;
            System.out.println("digit= " + a);
            return true;
        } else {
            return false;
        }
    }

    public long getDigit(long number) {
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

        return true;
    }

    public boolean isValidIsin(String number) throws Exception {
        return true;
    }

}
