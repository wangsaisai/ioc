package com.bamboo.ioc.bean.test;

import com.bamboo.ioc.annotation.Autowired;
import com.bamboo.ioc.annotation.Component;

/**
 * @url
 * @desc
 * @example
 */
@Component
public class AutowiredBean {

  @Autowired
  private ComponentBean componentBean;

  public ComponentBean getComponentBean() {
    return componentBean;
  }

  public void setComponentBean(ComponentBean componentBean) {
    this.componentBean = componentBean;
  }
}
