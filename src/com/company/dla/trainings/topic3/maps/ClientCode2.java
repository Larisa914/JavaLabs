package com.company.dla.trainings.topic3.maps;

import com.company.dla.trainings.topic3.maps.json.Json;

import java.util.Map;

import static com.company.dla.trainings.topic3.maps.json.JsonFactory.json;

public class ClientCode2 {
    public static void main(String[] args) {
        Json json = json("name", json("Bill"));
        Map<String, Json> map = json.get();
        map.put("age", json("13"));
        map.put("address", json("Street 10, flat 2"));
        Json[] jsons = {
                json("name", json("Bill")),
                json("name", json("Matt")),
                json("name", json("Sancho")),
                json("name", json("Bill"))
        };
        map.put("bytes", json("sldkvnlwsdkvn#$*(&)_(*&OJIjoi987huyi8yu".getBytes()));
        map.put("friends", json(jsons));

        System.out.println(json.toString());
        Json[] friends = map.get("friends").get();
        Json friend = friends[2];

        Map<String, Json> friendDetails = friend.get();
        System.out.println(friendDetails.get("name"));

    }
}
