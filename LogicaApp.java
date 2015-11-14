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

import com.tm.db.DatosApp;
import java.util.ArrayList;
import java.util.List;

public class LogicaApp {
    private static String dbHost;
    private static int dbPort;
    private static String dbUser;
    private static String dbPass;
    
    public LogicaApp (){
        
        //Valores iniciales con los que la app intenta conectar
        dbHost="localhost";
        dbPort=3306;
        dbUser="root";
        dbPass="root";
    }
    ////Set y Gets
    public void setDbHost (String dbHost){
        LogicaApp.dbHost=dbHost;
    }
    public void setDbPort (int dbPort){
        LogicaApp.dbPort=dbPort;
    }
    public void setDbUser (String dbUser){
        LogicaApp.dbUser=dbUser;
    }
    public void setDbPass (String dbPass){
        LogicaApp.dbPass=dbPass;
    }    
    public String getDbHost (){
        return LogicaApp.dbHost;
    }    
    public int getPort (){
        return LogicaApp.dbPort;
    }
    public String getDbUser (){
        return LogicaApp.dbUser;
    }
    public String getDbPass (){
        return LogicaApp.dbPass;
    }
    ///////Logica de Negocios
    public boolean verificarConexion(){
        
        DatosApp datosApp = new DatosApp (dbHost,dbPort);
        
        boolean vc = datosApp.checkAccess(dbUser, dbPass);
        
        return vc;
    }
    public boolean configurarConexion(){
        
        DatosApp datosApp = new DatosApp (getDbHost(),getPort());
                
        boolean vc = datosApp.checkAccess(getDbUser(), getDbPass());
        return vc;
    
    }
    //Cargar usuaros
    public List cargarUsuarios (){
        List usuarios = new ArrayList ();
        DatosApp datosApp = new DatosApp (dbHost,dbPort);
        
        usuarios=datosApp.getUsers(dbUser, dbPass);
        
        return usuarios;
    }
    //Metodo para acceder al sistema validacion de usuario y contraseña
    public boolean revisarAcceso (String qaUser, String  qaPass){
        boolean acceso=false;
        DatosApp datosApp = new DatosApp (dbHost,dbPort);
        
        acceso=datosApp.checkPassAccess(dbUser, dbPass, qaUser, qaPass);
        
        return acceso;
        
    }
    
     
    
    
    
}
