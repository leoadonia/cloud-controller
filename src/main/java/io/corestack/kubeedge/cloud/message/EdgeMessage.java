package io.corestack.kubeedge.cloud.message;

import java.util.LinkedHashMap;

public class EdgeMessage {

    private String source;

    private LinkedHashMap data;

    private Object resource;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LinkedHashMap getData() {
        return data;
    }

    public void setData(LinkedHashMap data) {
        this.data = data;
    }

    public Object getResource() {
        return resource;
    }

    public void setResource(Object resource) {
        this.resource = resource;
    }
}
