package com.bamboo.ioc.inject;

import com.bamboo.ioc.annotation.Autowired;
import com.bamboo.ioc.annotation.Component;
import com.bamboo.ioc.exception.IocException;
import com.bamboo.ioc.factory.BeanFactory;
import java.lang.reflect.Field;
import java.util.Set;
import org.reflections.Reflections;

/**
 * @url
 * @desc
 * @example
 */
public class AnnotationBeanInjector implements BeanInjector {

  private String basePackage;

  public AnnotationBeanInjector(String basePackage) {
    this.basePackage = basePackage;
  }

  public void inject() throws IocException {
    Reflections reflections = new Reflections(basePackage);
    Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Component.class);

    try {
      for (Class clazz : classes) {
        Field[] fields = clazz.getDeclaredFields();
        Object bean = BeanFactory.getBeanByClassName(clazz.getName()).get();
        for (Field field : fields) {
          if (field.isAnnotationPresent(Autowired.class)) {
            field.setAccessible(true);
            field.set(bean, BeanFactory.getBeanByClassName(field.getType().getName()).get());
          }
        }
      }
    } catch (Exception e) {
      throw new IocException(e);
    }

  }

}
