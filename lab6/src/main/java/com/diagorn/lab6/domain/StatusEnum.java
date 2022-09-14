package com.diagorn.lab6.domain;

/**
 * Enum representing user's availability
 *
 * @author Diagorn
 */
public enum StatusEnum {
    /**
     * User is available
     */
    ACTIVE("active"),
    /**
     * User is not available
     */
    INACTIVE("inactive");

    private final String name;

    StatusEnum(String name) {
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
    public static StatusEnum ofString(String value) {
        for (StatusEnum status: StatusEnum.values()) {
            if (status.name.equals(value)) {
                return status;
            }
        }

        throw new IllegalArgumentException("Unknown status - " + value);
    }
}
