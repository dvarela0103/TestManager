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
public class Test {
    private int     id;
    private String  fecha;
    private String  nombre;
    private int     tipo;
    private int     qaUser;
    private String  estado;
    
    public void setId (int id){
        this.id=id;
    }
    public void setFecha (String fecha){
        this.fecha=fecha;
    }
    public void setNombre (String nombre){
        this.nombre=nombre;
    }
    public void setTipo (int tipo) {
        this.tipo=tipo;
    }
    public void setQAuser (int qaUser){
        this.qaUser=qaUser;
    }
    public void setEstado (String estado){
        this.estado=estado;
    }
    public int getId (){
        return id;
    }
    public String getFecha (){
        return fecha;
    }
    public String getNombre (){
        return nombre;
    }
    public int getTipo(){
        return tipo;
    }
    public int getQAuser (){
        return qaUser;
    }
    public String getEstado (){
        return estado;
    }
    
}
