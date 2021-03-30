package fr.isin.code.model;

import lombok.Getter;

@Getter
public enum Country {
    USA("US"), FRANCE("FR"), IRAN("IR"), GERMANY("DE"), UNITED_KINGDOM("GB"),
    ITALY("IT");

    private String code;

    Country(String code) {
        this.code = code;
    }
}
