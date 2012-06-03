package org.springframework.samples.jpetstore.service;

import org.springframework.samples.jpetstore.dao.InstanceDao;
import org.springframework.samples.jpetstore.domain.Instance;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author apanasenko
 */
public class Initialization {
    private InstanceDao instanceDao;

    public void setInstanceDao(InstanceDao instanceDao) {
        this.instanceDao = instanceDao;
    }

    public void init() throws UnknownHostException {
        Instance instance = new Instance(InetAddress.getLocalHost().getHostName());
        if (instanceDao.searchInstance(instance) == null) {
            instanceDao.insertInstance(instance);
        }
    }

    public void destroy() throws UnknownHostException {
        instanceDao.deleteInstance(new Instance(InetAddress.getLocalHost().getHostName()));
    }
}
