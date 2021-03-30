package fr.isin.code.call;

import fr.isin.code.validator.IIsinValidation;
import fr.isin.code.validator.IsinValidation;

import java.util.concurrent.Callable;

public class IsinCall implements Callable<String> {

    private String isinValidationicateUpdate;


    public IsinCall(String isinValidationicateUpdate) {
        this.isinValidationicateUpdate = isinValidationicateUpdate;
    }

    private IIsinValidation isinValidation = new IsinValidation();

    @Override
    public String call() throws Exception {

        return
                isinValidation.covertAnyLettersToNumber(isinValidationicateUpdate) + "," +
                        isinValidation.multiplicationOfOddDigitByTwoAndThenSum(isinValidationicateUpdate) + "," +
                        isinValidation.addingOfDigitsAtEvenPlace(isinValidationicateUpdate) + "," +
                        isinValidation.sumOfDigits(isinValidationicateUpdate) + "," +
                        isinValidation.subtractTheSumNearGreaterRound(isinValidationicateUpdate);
    }


}



