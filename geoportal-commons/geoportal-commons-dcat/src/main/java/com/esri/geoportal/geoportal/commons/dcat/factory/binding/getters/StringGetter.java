/*
 * Copyright 2017 Esri, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.esri.geoportal.geoportal.commons.dcat.factory.binding.getters;

import com.esri.geoportal.commons.meta.Attribute;
import com.esri.geoportal.commons.meta.MapAttribute;
import com.esri.geoportal.geoportal.commons.dcat.factory.binding.Getter;

/**
 * String getter.
 */
public class StringGetter implements Getter<String>{
  private final String attrName;

  public StringGetter(String attrName) {
    this.attrName = attrName;
  }

  @Override
  public String get(MapAttribute attributes) {
    Attribute attr = attributes.getNamedAttributes().get(attrName);
    return attr!=null? attr.getValue(): null;
  }
}
