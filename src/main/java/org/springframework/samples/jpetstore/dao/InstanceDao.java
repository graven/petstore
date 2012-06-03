package org.springframework.samples.jpetstore.dao;

import org.springframework.samples.jpetstore.domain.Instance;

/**
 * @author apanasenko
 */
public interface InstanceDao {
    int getCountInstances();
    void insertInstance(Instance instance);
    void deleteInstance(Instance instance);
    String searchInstance(Instance instance);
}
