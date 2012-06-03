package org.springframework.samples.jpetstore.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.samples.jpetstore.dao.InstanceDao;
import org.springframework.samples.jpetstore.domain.Instance;

/**
 * @author apanasenko
 */
public class SqlMapInstanceDao extends SqlMapClientDaoSupport implements InstanceDao {
    public int getCountInstances() {
        return (Integer) getSqlMapClientTemplate().queryForObject("getCountInstances");
    }

    public void insertInstance(Instance instance) {
        getSqlMapClientTemplate().insert("insertInstance", instance);
    }

    public void deleteInstance(Instance instance) {
        getSqlMapClientTemplate().delete("deleteInstance", instance);
    }

    public String searchInstance(Instance instance) {
        return (String) getSqlMapClientTemplate().queryForObject("searchInstance", instance);
    }
}
