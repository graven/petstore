package org.springframework.samples.jpetstore.domain;

/**
 * @author apanasenko
 */
public class Instance {
    private String ip;

    public Instance() {
    }

    public Instance(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
