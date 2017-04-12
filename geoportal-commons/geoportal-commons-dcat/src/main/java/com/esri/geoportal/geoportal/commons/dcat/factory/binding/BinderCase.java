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
package com.esri.geoportal.geoportal.commons.dcat.factory.binding;

import com.esri.geoportal.commons.meta.MapAttribute;
import com.esri.geoportal.geoportal.commons.dcat.api.Dataset;

/**
 * BinderCase.
 */
public class BinderCase<T> {
  private final Setter<T> setter;
  private final Getter<T> getter;

  public BinderCase(Setter<T> setter, Getter<T> getter) {
    this.setter = setter;
    this.getter = getter;
  }
  
  public void bind(Dataset dataset, MapAttribute attributes) {
    T value = getter.get(attributes);
    setter.set(dataset, value);
  }
}
