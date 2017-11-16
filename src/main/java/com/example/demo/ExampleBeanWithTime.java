package com.example.demo;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;


/**
 * Created by Piotr Dziubecki (piotr.dziubecki@keymile.com) on 16/11/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExampleBeanWithTime {

    String label;

    OffsetDateTime time;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ExampleBeanWithTime{" + "label='" + label + '\'' + ", time=" + time + '}';
    }
}
