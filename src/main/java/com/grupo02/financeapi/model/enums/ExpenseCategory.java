package com.grupo02.financeapi.model.enums;

public enum ExpenseCategory {

    FOOD(1, "food"),
    HEALTH(2, "health"),
    HOME(3, "home"),
    TRANSPORT(4, "transport"),
    EDUCATION(5, "education"),
    LEISURE(6, "leisure"),
    UNEXPECTED(7, "unexpected"),
    OTHERS(8, "others");

    private int cod;
    private String description;

    ExpenseCategory(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static ExpenseCategory toEnum(Integer cod) {
        if(cod == null) {
            return ExpenseCategory.OTHERS;
        }

        for (ExpenseCategory e:ExpenseCategory.values()) {
            if(cod.equals(e.getCod())) {
                return e;
            }
        }

        throw  new IllegalArgumentException("Invalid ID " + cod);
    }
}
