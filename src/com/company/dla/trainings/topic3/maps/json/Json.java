package com.company.dla.trainings.topic3.maps.json;

import java.util.Map;

public abstract class Json {
    protected Json() {
    }

    public abstract String getType();

    public Map<String, Json> getMap() {
        throw new UnsupportedOperationException();
    }

    public Json[] getArr() {
        throw new UnsupportedOperationException();
    }

    public String getValue() {
        throw new UnsupportedOperationException();
    }

    public byte[] getBytesArray() {
        throw new UnsupportedOperationException();
    }

    public abstract <T> T get();

}
