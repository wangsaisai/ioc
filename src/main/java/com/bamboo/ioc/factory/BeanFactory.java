package com.bamboo.ioc.factory;

import com.bamboo.ioc.bean.BeanDefinition;
import com.bamboo.ioc.exception.BeanDefinitionException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @url
 * @desc
 * @example
 */
public class BeanFactory {

  private static ConcurrentHashMap<String, Object> beans = new ConcurrentHashMap<>();

  public static Optional<Object> getBeanByName(String name) {
    // todo
    throw new UnsupportedOperationException();
  }

  public static Optional<Object> getBeanByClassName(String className) {
    return Optional.ofNullable(beans.get(className));
  }

  public static void registerBean(BeanDefinition beanDefinition) throws BeanDefinitionException {
    try {
      String className = beanDefinition.getClassName();

      Class beanClass = Class.forName(className);
      Object bean = beanClass.newInstance();
      beans.put(className, bean);
    } catch (Exception e) {
      throw new BeanDefinitionException(e);
    }

  }
}
