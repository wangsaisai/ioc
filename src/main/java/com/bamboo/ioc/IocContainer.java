package com.bamboo.ioc;

import com.bamboo.ioc.bean.AnnotationBeanDefinitionReader;
import com.bamboo.ioc.bean.BeanDefinitionReader;
import com.bamboo.ioc.factory.BeanFactory;
import com.bamboo.ioc.inject.AnnotationBeanInjector;
import com.bamboo.ioc.inject.BeanInjector;

/**
 * @url
 * @desc
 * @example
 */
public class IocContainer {

  public static void initialize(String basePackage) {
    BeanDefinitionReader beanDefinitionReader = new AnnotationBeanDefinitionReader(basePackage);
    beanDefinitionReader.getBeanDefinitions().forEach(BeanFactory::registerBean);
    BeanInjector beanInjector = new AnnotationBeanInjector(basePackage);
    beanInjector.inject();
  }

}
