package com.clinbrain.datac.common.support;

import com.clinbrain.datac.common.domain.BaseObject;

import java.util.Map;
import java.util.Set;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

/**
 * Created by Liaopan on 2019/7/3.
 */
public class DynamicalBean {

  private Object object = null;
  private BeanMap beanMap = null;

  public DynamicalBean() {
    super();
  }

  public DynamicalBean(Map propertyMap) {
    this.object = generateBean(propertyMap);
    this.beanMap = BeanMap.create(this.object);
  }

  /**
   * 给bean属性赋值
   *
   * @param property 属性名
   * @param value 值
   */
  public void setValue(Object property, Object value) {
    beanMap.put(property, value);
  }

  /**
   * 通过属性名得到属性值
   *
   * @param property 属性名
   * @return 值
   */
  public Object getValue(String property) {
    return beanMap.get(property);
  }

  public Object getObject () {
    return this.object;
  }

  private Object generateBean(Map propertyMap) {
    BeanGenerator generator = new BeanGenerator();
    Set keySet = propertyMap.keySet();
    for (Object o : keySet) {
      String key = (String) o;
      generator.addProperty(key, (Class) propertyMap.get(key));
    }
    generator.setSuperclass(BaseObject.class);
    return generator.create();
  }
}
