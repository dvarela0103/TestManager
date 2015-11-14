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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatosTest {
      private String dbDriver;
    private String dbURL;

    public DatosTest(String dbHost,int dbPort) {
        dbDriver="com.mysql.jdbc.Driver";
        dbURL="jdbc:mysql://"+dbHost +":" + dbPort+ "/tmdb";
    }
    public String getDbURL (){
        return this.dbURL;
    }
    
   //Los metodos encontrados aqui hacen referencia a los storeprocedures de la bd
     
    
    //llamado a AddTest
     public void Agregar (String dbUser, String dbPass,Integer id, String fecha,String nom, Integer  idtipo,Integer idusua,String estado){
        
        
        String sql="call AddTest('"+id+"','"+fecha+"','"+nom+"','"+idtipo+"','"+idusua+"','"+estado+"');";

        try (Connection connection = DriverManager.getConnection(this.dbURL,dbUser,dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }        
        
    }
     //llamado a DeleteTest
     public void Eliminar (String dbUser, String dbPass,Integer id){
        String sql="call DeleteTest('"+id+"');";
        try (Connection connection = DriverManager.getConnection(this.dbURL,dbUser,dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL  
        }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }        
    }
     //Llamado a UpdateTest
     public void Modificar (String dbUser, String dbPass,Integer id, String fecha,String nom, Integer  idtipo,Integer idusua,String estado){
        
        
        String sql="call UpdateTest('"+id+"','"+fecha+"','"+nom+"','"+idtipo+"','"+idusua+"','"+estado+"');";

        try (Connection connection = DriverManager.getConnection(this.dbURL,dbUser,dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }        
        
    }
     //llamado a SearchByIdtests para validar que no se repitan id test
        public boolean ValidarIdtest (String dbUser, String dbPass, int id){
        boolean invali=false;
        String sql="call SearchByIdtests('"+id+"');";
        
               
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                int idt=0;
                
                
                while(resultSet.next()){
                     idt=resultSet.getInt("idtests");//sacando datos la columna user de la tabla resultado generada por el SQL
                if(idt!=0)
                   invali=true;
                }
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return invali; //retornando arraylist con los usuarios.      
    }
     
   
}
