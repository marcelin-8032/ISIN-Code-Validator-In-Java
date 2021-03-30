package fr.isin.code.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Country {
    USA("US"), FRANCE("FR"), IRAN("IR"), GERMANY("DE"), UNITED_KINGDOM("GB"),
    ITALY("IT"), RUSSIA("RU");

    private String code;

    Country(String code) {
        this.code = code;
    }


}
