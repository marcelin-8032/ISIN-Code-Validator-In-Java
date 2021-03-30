package fr.isin.code.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsinCallTest {

    @Test
    public void testCallMethod() throws Exception {
        String number="NW97233490";
        IsinCall myCall=new IsinCall(number);
        assertEquals("233297233490,38,28,66,4",myCall.call());
    }

}