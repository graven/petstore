package org.springframework.samples.jpetstore.web.spring;

import org.springframework.samples.jpetstore.dao.InstanceDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author apanasenko
 */
public class InstancesController implements Controller {
    private InstanceDao instanceDao;

    public void setInstanceDao(InstanceDao instanceDao) {
        this.instanceDao = instanceDao;
    }

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String, Integer> model = new HashMap<String, Integer>();
        model.put("count", instanceDao.getCountInstances());
        return new ModelAndView("Status", model);
    }
}
