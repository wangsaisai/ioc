package com.bamboo.ioc.bean;

import com.bamboo.ioc.annotation.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.reflections.Reflections;

/**
 * @url
 * @desc
 * @example
 */
public class AnnotationBeanDefinitionReader implements BeanDefinitionReader {

  private String basePackage;

  public AnnotationBeanDefinitionReader(String basePackage) {
    this.basePackage = basePackage;
  }

  @Override
  public List<BeanDefinition> getBeanDefinitions() {
    Reflections reflections = new Reflections(basePackage);
    Set<Class<?>> beanClasses = reflections.getTypesAnnotatedWith(Component.class);

    return beanClasses.stream().map(beanClass -> {
      String className = beanClass.getName();
      BeanDefinition beanDefinition = new BeanDefinition(className);
      return beanDefinition;
    }).collect(Collectors.toList());
  }
}
