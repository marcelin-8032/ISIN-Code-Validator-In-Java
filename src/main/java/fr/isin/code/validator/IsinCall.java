package fr.isin.code.validator;

import java.util.concurrent.Callable;

public class IsinCall implements Callable<String> {

    private String isinValidationicateUpdate;

    private IsinValidation isinValidation=new IsinValidation();

    public IsinCall(String isinValidationicateUpdate) {
        this.isinValidationicateUpdate = isinValidationicateUpdate;
    }

    @Override
    public String call() throws Exception {
        return isinValidation.covertAlphabetNumberToNumber(isinValidationicateUpdate) + "," +
                isinValidation.multiplicationOfDigitsByTwoAtOddPlace(isinValidationicateUpdate) + "," +
                isinValidation.addingOfDigitsAtEvenPlace(isinValidationicateUpdate) + "," +
                isinValidation.sumOfDigits(isinValidationicateUpdate) + "," +
                isinValidation.subtractTheSumNearGreaterRound(isinValidationicateUpdate);
    }




}
