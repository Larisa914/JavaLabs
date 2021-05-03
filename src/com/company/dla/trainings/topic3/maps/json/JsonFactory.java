package com.company.dla.trainings.topic3.maps.json;

public class JsonFactory {
    private JsonFactory() {
    }

    public static Json json(String value) {
        return new JsonValue(value);
    }
    public static Json json(Json[] arr) {
        return new JsonArray(arr);
    }
    public static Json json(String name, Json json) {
        return new JsonObject(name, json);
    }
    public static Json json(byte[] byteArray) {
        return new JsonBinaryData(byteArray);
    }
}
