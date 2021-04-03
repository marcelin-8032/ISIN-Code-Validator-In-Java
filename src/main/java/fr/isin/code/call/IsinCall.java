package fr.isin.code.call;

import fr.isin.code.model.Isin;
import fr.isin.code.validator.IIsinValidation;
import fr.isin.code.validator.IsinValidation;

import java.util.concurrent.Callable;

public class IsinCall implements Callable<String> {

    private String isinNumber;

    public IsinCall(String isinNumber) {
        this.isinNumber = isinNumber;
    }

    @Override
    public String call() throws Exception {
        IsinValidation isinValidation = new IsinValidation();

        boolean isValidNumber = isinValidation.isValidIsin(isinNumber);

        boolean isDigitValid = isinValidation.checkDigit(isinNumber);

        String validation = "";

        if (isValidNumber && isDigitValid) {
            validation = "is Valid";
        } else {
            validation = "is Not Valid";
        }
        return validation;
    }

}