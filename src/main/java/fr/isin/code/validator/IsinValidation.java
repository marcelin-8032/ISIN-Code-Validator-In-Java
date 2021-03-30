package fr.isin.code.validator;

public class IsinValidation implements IIsinValidation{

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

    public String subtractTheSumNearGreaterRound(String number) {
        long cl = Long.parseLong(multiplicationOfOddDigitByTwoAndThenSum(number))
                + Long.parseLong(addingOfDigitsAtEvenPlace(number));

        long sNear = 10 + (cl / 10) * 10;
        long subst = 0;

        if (cl % 10 == 0) {
            return String.valueOf(10);
        } else if (sNear >= cl) {
            subst = sNear - cl;
        }
        return String.valueOf(subst);
    }

    public long getDigit(long number) {
        if (number < 9)
            return number;
        return number / 10 + number % 10;

    }

}
