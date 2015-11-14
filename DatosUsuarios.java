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
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DatosUsuarios {
   // private String dbDriver;
   private String dbDriver;
    private String dbURL;

    public DatosUsuarios(String dbHost,int dbPort) {
        dbDriver="com.mysql.jdbc.Driver";
        dbURL="jdbc:mysql://"+dbHost +":" + dbPort+ "/tmdb";
    }
    public String getDbURL (){
        return this.dbURL;
    }
    
    
  //Los metodos que se encuentran aqui hacen referencia a los storeprocedures   
     
     //llamado AddUser
     public void Agregar (String dbUser, String dbPass,Integer id, String usu,String pass, String  nom){
        
        
        String sql="call AddUser('"+id+"','"+usu+"','"+pass+"','"+nom+"');";

        try (Connection connection = DriverManager.getConnection(this.dbURL,dbUser,dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }        
        
    }
     //llamado DeleteUser por medio de iduser
     public void Eliminar (String dbUser, String dbPass,Integer id){
        String sql="call DeleteUser('"+id+"');";
        try (Connection connection = DriverManager.getConnection(this.dbURL,dbUser,dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL  
        }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }        
    }
     //llamado UpdateUser 
     public void Modificar (String dbUser, String dbPass,Integer id, String usu,String pass, String  nom){
        
        
        String sql="call UpdateUser('"+id+"','"+usu+"','"+pass+"','"+nom+"');";

        try (Connection connection = DriverManager.getConnection(this.dbURL,dbUser,dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }        
        
    }
     //Validacion para nombre de usuario llamado SearchByUserName 
     public boolean ValidarNoUsuario (String dbUser, String dbPass, String nom){
        boolean invali=false;
        String sql="call SearchByUserName('"+nom+"');";
        
               
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                String obtusuario="";
                
                
                while(resultSet.next()){
                     obtusuario=resultSet.getString("user");//sacando datos la columna user de la tabla resultado generada por el SQL
                if(obtusuario.equals(nom))
                   invali=true;
                }
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return invali; //retornando arraylist con los usuarios.      
    }
     
     // llamado a AllUsersFullList para llenar un combobox
   public void ComboUsu (String dbUser, String dbPass, JComboBox combousu){
        combousu.removeAllItems();
        String sql="call AllUsersFullList";
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                while(resultSet.next()){ 
                    combousu.addItem(resultSet.getInt("idusers"));//sacando datos la columna user de la tabla resultado generada por el SQL
                }    
                combousu.setSelectedIndex(-1);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
             
    } 
    
   // llamado a AllUsersFullList para que no se repitan ids
   public boolean ValidarIdUser (String dbUser, String dbPass, int id){
        boolean invali=false;
        String sql="call AllUsersFullList";
        
               
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                int idt=0;
                
                
                while(resultSet.next()){
                     idt=resultSet.getInt("idusers");//sacando datos la columna user de la tabla resultado generada por el SQL
                if(idt==id)
                   invali=true;
                }
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return invali; //retornando arraylist con los usuarios.      
    }
   
   //llamado a SearchByUserName para validar el eliminar que no se elimine un usuario activo
   public boolean ValidarUsuarioActivo (String dbUser, String dbPass, String nom,Integer id){
        boolean invali=false;
        String sql="call SearchByUserName('"+nom+"');";
        
               
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                int obtusuario=0;
                
                
                while(resultSet.next()){
                     obtusuario=resultSet.getInt("idusers");//sacando datos la columna user de la tabla resultado generada por el SQL
                if(obtusuario==id){
                   invali=true;}
                }
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return invali; //retornando arraylist con los usuarios.      
    }
}
