package com.company.dla.trainings.topic4.annotation;

import java.util.ArrayList;
import java.util.List;

public abstract class Box {
    protected List<Object> values = new ArrayList<>();

    protected void addToBox(Object value){
        this.values.add(value);
    }
}
