package com.bamboo.ioc.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @url
 * @desc
 * @example
 */
public class BeanDefinition {

//  private String name;

  private String className;

//  private Map<String, Object> fieldValues = new HashMap<>();

  public BeanDefinition(String className) {
    this.className = className;
  }

//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

//  public Map<String, Object> getFieldValues() {
//    return fieldValues;
//  }
//
//  public void setFieldValues(Map<String, Object> fieldValues) {
//    this.fieldValues = fieldValues;
//  }
}
