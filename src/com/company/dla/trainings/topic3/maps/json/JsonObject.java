package com.company.dla.trainings.topic3.maps.json;

import java.util.HashMap;
import java.util.Map;

class JsonObject extends Json {
    private Map<String, Json> map = new HashMap<>();

    JsonObject(String name, Json json) {
        map.put(name, json);
    }

    public Map<String, Json> getMap() {
        return map;
    }

    @Override
    public Map<String, Json> get() {
        return map;
    }

    @Override
    public String toString() {
        String result = "{";
        for (String name : map.keySet()) {
            result += "\"" + name + "\"";
            result += " : " + map.get(name).toString();
            result += " , ";
        }
        //remove ,
        return result + "}";
    }

    @Override
    public String getType() {
        return "object";
    }
}
