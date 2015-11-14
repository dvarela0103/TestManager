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

package com.tm.logica;

import com.tm.db.*;
import javax.swing.JComboBox;

public class LogicaUsuarios {
     LogicaApp log;
    
    public LogicaUsuarios (){
        
     log=new LogicaApp();
    }
    
    //Los metodos encontrados aqui hacen referencio a las clases datos 
    //que contienen los llamados de los metodos de la bd
    //storeProcedures
    
    //Metodo Add llamado
     public void RAgregar(Integer id, String usu,String pass, String  nom){
        DatosUsuarios usua = new DatosUsuarios(log.getDbHost(),log.getPort());
        usua.Agregar(log.getDbUser(), log.getDbPass(), id,usu,pass, nom); 
    }
    //Metodo de DELETE llamado 
    public void REliminar(Integer id){
        DatosUsuarios usua = new DatosUsuarios(log.getDbHost(),log.getPort());
        usua.Eliminar(log.getDbUser(), log.getDbPass(),id); 
    }
    
    //Metodo update llamado
    public void RModificar(Integer id, String usu,String pass, String  nom){
        DatosUsuarios usua = new DatosUsuarios(log.getDbHost(),log.getPort());
        usua.Modificar(log.getDbUser(), log.getDbPass(), id,usu,pass, nom); 
    }
   //Validacion para que no se repita un nombre de usuario en la bd
    public Boolean ValidarNoUsuario(String usuario){
        boolean val=false;
        DatosUsuarios usua = new DatosUsuarios(log.getDbHost(),log.getPort());
        val=usua.ValidarNoUsuario(log.getDbUser(), log.getDbPass(),usuario); 
        return val;
    }
    
   //Cargar los id de usuarios en un combobox
    public void ComboUsu (JComboBox combousu){
        
        DatosUsuarios usu = new DatosUsuarios(log.getDbHost(),log.getPort());
        usu.ComboUsu(log.getDbUser(), log.getDbPass(),combousu);
        
    }//Validacion para que no se repita un ID en usuario
    public Boolean ValidarIdUser(int id){
    boolean val=false;
        DatosUsuarios usua = new DatosUsuarios(log.getDbHost(),log.getPort());
        val=usua.ValidarIdUser(log.getDbUser(), log.getDbPass(),id); 
        return val;
    }
    //Metodo para que no se pueda eliminar usuario activo osea el que ingreso al sistema
     public Boolean ValidarUsuarioActivo(String usuario,int id){
        boolean val=false;
        DatosUsuarios usua = new DatosUsuarios(log.getDbHost(),log.getPort());
        val=usua.ValidarUsuarioActivo(log.getDbUser(), log.getDbPass(),usuario,id); 
        return val;
    }
    
}
