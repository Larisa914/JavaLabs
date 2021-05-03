package com.company.dla.trainings.topic3.maps;

import com.company.dla.trainings.topic3.maps.json.Json;

import static com.company.dla.trainings.topic3.maps.json.JsonFactory.json;

public class ClientCode {
    public static void main(String[] args) {
        Json json = json("name", json("Bill"));
        json.getMap().put("age", json("13"));
        json.getMap().put("address", json("Street 10, flat 2"));
        Json[] jsons = {
                json("name", json("Bill")),
                json("name", json("Matt")),
                json("name", json("Sancho")),
                json("name", json("Bill"))
        };
//        json.getMap().put("bytes", json("sldkvnlwsdkvn#$*(&)_(*&OJIjoi987huyi8yu".getBytes()));
        json.getMap().put("friends", json(jsons));

        System.out.println(json.toString());

        System.out.println(json.getMap().get("friends")
                .getArr()[2].getMap().get("name"));
        System.out.println(json.getMap().get("friends")
                .getArr()[2]);
    }
}