package fr.isin.code.model;

import lombok.Getter;
import lombok.ToString;

@ToString
public enum Country {
    USA("US"), FRANCE("FR"), IRAN("IR"), GERMANY("DE"), UNITED_KINGDOM("GB"),
    ITALY("IT"), RUSSIA("RU"), SWITZERLAND("CH");

    private String code;

    Country(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
