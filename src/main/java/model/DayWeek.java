package model;

public enum DayWeek {

    MONDAY("Пн"),

    TUESDAY("Вт"),

    WEDNESDAY("Ср"),

    THURSDAY("Чт"),

    FRIDAY("Пт"),

    SATURDAY("Сб"),

    SUNDAY("Нд");

    public final String label;

    private DayWeek(String label) {
        this.label = label;
    }

}
