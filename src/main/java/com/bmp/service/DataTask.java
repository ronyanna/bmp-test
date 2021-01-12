package com.bmp.service;

import java.util.*;

public class DataTask {

    private Map<String, Object> data = new HashMap<>();

    public DataTask() {
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataTask{" +
                "data=" + data +
                '}';
    }
}
