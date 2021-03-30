package fr.isin.code.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Isin {

    long number;
    Country country;
    long checkDigit;

    public Isin(long number, Country country, long checkDigit) {
        this.number = number;
        this.country = country;
        this.checkDigit = checkDigit;
    }


}
