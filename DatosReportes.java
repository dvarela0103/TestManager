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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DatosReportes {
     private String dbDriver;
    private String dbURL;
   
    
    public DatosReportes(String dbHost,int dbPort){
        dbDriver="com.mysql.jdbc.Driver";
        dbURL="jdbc:mysql://"+dbHost +":" + dbPort+ "/tmdb";
    }
    
  
    public String getDbURL (){
        return this.dbURL;
    }
    //Los metodos encontrados aqui hacen referencia a los storeprocedures de la bd
    
    //Llamado a AllUsersFullList para llenar tabla con usuarios
    public List ReporteUsuarios (String dbUser, String dbPass, JTable t1){
        
        String sql="call AllUsersFullList";
        List usrList  = new ArrayList();
               
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                ResultSetMetaData rm=resultSet.getMetaData();
                int columnas=rm.getColumnCount();
                DefaultTableModel mod=new DefaultTableModel();
                t1.setModel(mod);
                
                for(int i=1;i<=columnas;i++){
                mod.addColumn(rm.getColumnLabel(i));}
                while(resultSet.next()){
                Object [] Filas=new Object[columnas];
                for(int z=0;z<columnas;z++)
                {
                    Filas[z]=resultSet.getObject(z+1);
                }
                mod.addRow(Filas);
                }
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return usrList; //retornando arraylist con los usuarios.      
    }
    
    //Llamado AllTipos para llenar tabla tipos
    public List ReporteTipos (String dbUser, String dbPass, JTable t1){
        
        String sql="call AllTipos";
        List usrList  = new ArrayList();
               
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                ResultSetMetaData rm=resultSet.getMetaData();
                int columnas=rm.getColumnCount();
                DefaultTableModel mod=new DefaultTableModel();
                t1.setModel(mod);
                
                for(int i=1;i<=columnas;i++){
                mod.addColumn(rm.getColumnLabel(i));}
                while(resultSet.next()){
                Object [] Filas=new Object[columnas];
                for(int z=0;z<columnas;z++)
                {
                    Filas[z]=resultSet.getObject(z+1);
                }
                mod.addRow(Filas);
                }
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return usrList; //retornando arraylist con los usuarios.      
    }
    
    //Llamado a AllTests para llenar tabla
     public List ReporteTests (String dbUser, String dbPass, JTable t1){
        
        String sql="call AllTests";
        List usrList  = new ArrayList();
               
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                ResultSetMetaData rm=resultSet.getMetaData();
                int columnas=rm.getColumnCount();
                DefaultTableModel mod=new DefaultTableModel();
                t1.setModel(mod);
                
                for(int i=1;i<=columnas;i++){
                mod.addColumn(rm.getColumnLabel(i));}
                while(resultSet.next()){
                Object [] Filas=new Object[columnas];
                for(int z=0;z<columnas;z++)
                {
                    Filas[z]=resultSet.getObject(z+1);
                }
                mod.addRow(Filas);
                }
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return usrList; //retornando arraylist con los usuarios.      
    }
     //Metodos para buscar usuarios, tipos y test
 public void ReportePorID ( JTable t1,Integer id){
        
        
               
        try { 
            int fil, col;
        //Limpia selección de la tabla
        t1.clearSelection();

        for(fil = 0; fil <= t1.getRowCount();fil++)
        {
            for(col = 0; col < t1.getColumnCount(); col++)
            {              
                 //Obtiene dato contenido en una celda de la tabla
                Integer value = (Integer)t1.getValueAt(fil, col);
                 Integer value1=id;
                  if(value.equals(value1))
                 {     
                       //Selecciona celda si el texto es encontrado     
                       t1.changeSelection(fil, col, false, false);
                 }
             }
        }
                
            
        }catch (Exception e){
            //System.out.println(e.getMessage());
        }
         //retornando arraylist con los usuarios.      
    }
 
 
 ///aqui los reportes por id
 
 
  public boolean ReporteIdUsuario (String dbUser, String dbPass, JTable t1, int id){
        boolean invali=false;
        String sql="call AllUsersFullList";
        
               
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                int idu=0;
                
                    
                ResultSetMetaData rm=resultSet.getMetaData();
                int columnas=rm.getColumnCount();
                DefaultTableModel mod=new DefaultTableModel();
                t1.setModel(mod);
                
                for(int i=1;i<=columnas;i++){
                mod.addColumn(rm.getColumnLabel(i));}
                while(resultSet.next()){
                     idu=resultSet.getInt("idusers");//sacando datos la columna user de la tabla resultado generada por el SQL
                
                if (idu==id){
                    invali= true;
                    
                
                Object [] Filas=new Object[columnas];
                for(int z=0;z<columnas;z++)
                {
                    Filas[z]=resultSet.getObject(z+1);
                    
                }
                mod.addRow(Filas);
                }}
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return invali; //retornando arraylist con los usuarios.      
    }
  
  //consultar id tipo
  public boolean ReporteIdTipo (String dbUser, String dbPass, JTable t1, Integer id){
        boolean invali=false;
        String sql="call SearchByIDtipo('"+id+"');";
        
               
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                int idt=0;
                
                    
                ResultSetMetaData rm=resultSet.getMetaData();
                int columnas=rm.getColumnCount();
                DefaultTableModel mod=new DefaultTableModel();
                t1.setModel(mod);
                
                for(int i=1;i<=columnas;i++){
                mod.addColumn(rm.getColumnLabel(i));}
                while(resultSet.next()){
                     idt=resultSet.getInt("idtipos");//sacando datos la columna user de la tabla resultado generada por el SQL
                
                if (idt==id){
                    invali= true;}
                Object [] Filas=new Object[columnas];
                for(int z=0;z<columnas;z++)
                {
                    Filas[z]=resultSet.getObject(z+1);
                }
                mod.addRow(Filas);
                }
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return invali; //retornando arraylist con los usuarios.      
    }
//consulta test
  
  public boolean ReporteIdTest (String dbUser, String dbPass, JTable t1, Integer id){
        boolean invali=false;
        String sql="call SearchByIdtests('"+id+"');";
        
               
        try (Connection connection = DriverManager.getConnection(this.dbURL, dbUser, dbPass)
                ;Statement statement = connection.createStatement()){ //conexion con la BD
            try (ResultSet resultSet = statement.executeQuery(sql)) { //ejecucion del comando SQL
                int idt=0;
                
                    
                ResultSetMetaData rm=resultSet.getMetaData();
                int columnas=rm.getColumnCount();
                DefaultTableModel mod=new DefaultTableModel();
                t1.setModel(mod);
                
                for(int i=1;i<=columnas;i++){
                mod.addColumn(rm.getColumnLabel(i));}
                while(resultSet.next()){
                     idt=resultSet.getInt("idtests");//sacando datos la columna user de la tabla resultado generada por el SQL
                
                if(id==id){
                    
                    invali= true;}
                Object [] Filas=new Object[columnas];
                for(int z=0;z<columnas;z++)
                {
                    Filas[z]=resultSet.getObject(z+1);
                }
                mod.addRow(Filas);
                }
                
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return invali; //retornando arraylist con los usuarios.      
    }
}
