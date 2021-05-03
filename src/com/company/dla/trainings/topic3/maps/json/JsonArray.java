package com.company.dla.trainings.topic3.maps.json;

import java.util.Arrays;

class JsonArray extends Json {
    private Json arr[];

    JsonArray(Json[] arr) {
        this.arr = arr;
    }

    public Json[] getArr() {
        return arr;
    }

    @Override
    public Json[] get() {
        return arr;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(arr);
    }

    @Override
    public String getType() {
        return "array";
    }
}
