package fr.isin.code.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Isin {

    String number;
    Country country;
    String checkDigit;

    public Isin(String number, Country country, String checkDigit) {
        this.number = number;
        this.country = country;
        this.checkDigit = checkDigit;
    }
}
