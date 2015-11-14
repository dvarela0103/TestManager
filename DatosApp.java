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

package com.tm.db;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class DatosApp {
    private String dbDriver;
    private String dbURL;
    public DatosApp(){
        
    }
    
    public DatosApp(String dbHost,int dbPort){
        dbDriver="com.mysql.jdbc.Driver";
        dbURL="jdbc:mysql://"+dbHost +":" + dbPort+ "/tmdb";
    }
    
  
    public String getDbURL (){
        return this.dbURL;
    }
    //Los metodos encontrados aqui hacen referencia a los storeprocedures de la bd
    
    public List getUsers (String dbUser, String dbPass){
        
        String sql="call AllUsers";
        List usrList  = new ArrayList();
               
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                String user="";
                
                while (resultSet.next()){
                   user=resultSet.getString("user"); //sacando datos la columna user de la tabla resultado generada por el SQL
                   
                   usrList.add(user);            
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return usrList; //retornando arraylist con los usuarios.      
    }
    
    public boolean checkAccess (String dbUser, String dbPass){
        
        //verificando conexion a la bd
        
        boolean dbOn=false;
        
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)){
            dbOn=true;
        
        }catch (SQLException e){
            dbOn=false;
        }
    
        return dbOn;
    }
    
    public boolean checkPassAccess (String dbUser, String dbPass,String qaUser, String  qaPass){
        
        boolean isValid=false;
        String sql="call SearchForAccess(" +  "'" + qaUser + "'" +");";

        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                String qaPassTemp="";
                if (resultSet.next())
                    qaPassTemp=resultSet.getString("pass");//sacando datos la columna user de la tabla resultado generada por el SQL
                
                if (qaPassTemp.equals(qaPass))
                    isValid=true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }        
        return isValid;
    }
    
    
}
