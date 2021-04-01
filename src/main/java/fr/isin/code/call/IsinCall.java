package fr.isin.code.call;

import fr.isin.code.model.Isin;
import fr.isin.code.validator.IIsinValidation;
import fr.isin.code.validator.IsinValidation;

import java.util.concurrent.Callable;

public class IsinCall implements Callable<Boolean> {

    private String isinNumber;

    private final IsinValidation isinValidation = new IsinValidation();

    public IsinCall(String isinNumber) {
        this.isinNumber = isinNumber;
    }

    @Override
    public Boolean call() throws Exception {
        if (isinValidation.isValidIsin(isinNumber))
            return true;
        return false;
    }

}