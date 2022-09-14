package com.diagorn.lab6.domain;

/**
 * Enum representing human genders
 *
 * @author Diagorn
 */
public enum GenderEnum {
    /**
     * Man
     */
    MALE("male"),
    /**
     * Woman
     */
    FEMALE("female");

    private final String name;

    GenderEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Parsing string to get a enum value
     * @param value - string to parse
     * @return - enum string representation
     */
    public static GenderEnum ofString(String value) {
        for (GenderEnum gender: GenderEnum.values()) {
            if (gender.name.equals(value)) {
                return gender;
            }
        }

        throw new IllegalArgumentException("We support only binary genders");
    }
}
