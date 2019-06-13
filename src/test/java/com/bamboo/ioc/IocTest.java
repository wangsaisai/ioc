package com.bamboo.ioc;

import com.bamboo.ioc.bean.test.AutowiredBean;
import com.bamboo.ioc.bean.test.ComponentBean;
import com.bamboo.ioc.factory.BeanFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @url
 * @desc
 * @example
 */
public class IocTest {

  @Test
  public void getBean() throws Exception {
    try {
      IocContainer.initialize("com.bamboo.ioc.bean.test");

      ComponentBean componentBean = (ComponentBean) BeanFactory
          .getBeanByClassName(ComponentBean.class.getName()).get();

      AutowiredBean autowiredBean = (AutowiredBean) BeanFactory
          .getBeanByClassName(AutowiredBean.class.getName()).get();

      Assert.assertEquals(autowiredBean.getComponentBean(), componentBean);
    } catch (Exception e) {
      Assert.fail();
    }
  }

}
