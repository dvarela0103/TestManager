/**************************************************************
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 *************************************************************/

package com.tm.items;
public class QAuser {
    
    private int   id;
    private String user;
    private String pass;
    private String fullName;
    
    public void setId (int id){
        this.id=id;
    }    
    public void setUser (String user){
        this.user=user;
    }
    
    public void setPass (String pass){
        this.pass=pass;
    }
    
    public void setFullName (String fullName){
        this.fullName=fullName;
    }
    public int getId(){
        return id;
    }
    
    public String getUser(){
        return user;
    }
    
    public String getPass (){
        return pass;
    }
    
    public String getFullName(){
        return fullName;
    }    
}
