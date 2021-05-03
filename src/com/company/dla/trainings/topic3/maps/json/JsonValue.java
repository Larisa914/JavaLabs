package com.company.dla.trainings.topic3.maps.json;

class JsonValue extends Json {
    private String value;

    JsonValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String get() {
        return value;
    }

    @Override
    public String toString() {
        return "\"" + value + "\"";
    }

    @Override
    public String getType() {
        return "value";
    }
}
