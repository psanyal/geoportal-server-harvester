/*
 * Copyright 2016 Esri, Inc.
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
package com.esri.geoportal.harvester.api;

import com.esri.geoportal.harvester.api.ex.DataInputException;
import com.esri.geoportal.harvester.api.ex.DataOutputException;
import com.esri.geoportal.harvester.api.specs.InputBroker;
import com.esri.geoportal.harvester.api.specs.OutputBroker;
import java.util.List;

/**
 * Processor.
 * @param <D> data type
 */
public interface Processor<D> {

  /**
   * Initialize processor.
   * @param source data source
   * @param destinations data destination
   * @param l events listener
   * @return 
   */
  Handler initialize(InputBroker<D> source, List<OutputBroker<D>> destinations, Listener l);
  
  /**
   * Process handler.
   */
  interface Handler {
    /**
     * Begins process.
     */
    void begin();
    
    /**
     * Aborts process.
     */
    void abort();
    
    /**
     * Checks if process is active.
     * @return <code>true</code> if process is active
     */
    boolean isActive();
  }
  
  /**
   * Process listener.
   */
  interface Listener<D> {
    /**
     * Called when process is onStarted
     */
    void onStarted();
    
    /**
     * Called when process is onCompleted
     */
    void onCompleted();
    
    /**
     * Called when data reference has been processed
     * @param dataReference data reference
     */
    void onSuccess(DataReference<D> dataReference);
    
    /**
     * Called for output onError.
     * @param ex onError
     */
    public void onError(DataOutputException ex);
    
    /**
     * Called for input onError.
     * @param ex onError
     */
    public void onError(DataInputException ex);
  }
  
}
