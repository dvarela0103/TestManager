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
import com.tm.db.DatosReportes;
import javax.swing.JTable;
public class LogicaReportes {
    LogicaApp log; 
     
    
    
    public LogicaReportes (){
        
     log=new LogicaApp();
     
    }
    //Los metodos encontrados aqui hacen referencio a las clases datos 
    //que contienen los llamados de los metodos de la bd
    //storeProcedures
    //Cargar usuarios a la tabla
     public void ReporteUsuarios(JTable t1){
      
        DatosReportes repo = new DatosReportes(log.getDbHost(),log.getPort());
        repo.ReporteUsuarios(log.getDbUser(), log.getDbPass(),t1); 
    }
     //Cargar tipos a la tabla
     public void ReporteTipos(JTable t1){
        DatosReportes repo = new DatosReportes(log.getDbHost(),log.getPort());
        repo.ReporteTipos(log.getDbUser(), log.getDbPass(),t1); 
    }
     //Cargar test a la tabla
     public void ReporteTests(JTable t1){
        DatosReportes repo = new DatosReportes(log.getDbHost(),log.getPort());
        repo.ReporteTests(log.getDbUser(), log.getDbPass(),t1); 
    }
     //Cargar tabla
      public void ReportePorID(JTable t1,Integer id){
        DatosReportes repo = new DatosReportes(log.getDbHost(),log.getPort());
        repo.ReportePorID(t1,id); 
    }
      //reportes por id
      //Metodo para asociarse a un idusuario
       public boolean ReporteIdUsuario(JTable t1,Integer id){
           boolean idus=false;
        DatosReportes repo = new DatosReportes(log.getDbHost(),log.getPort());
        idus=repo.ReporteIdUsuario(log.getDbUser(), log.getDbPass(),t1,id); 
        return idus;
    }
       //idtipos
       //Metodo para asociarse a un idtipo
       public boolean ReporteIdTipo(JTable t1,Integer id){
           boolean idti=false;
        DatosReportes repo = new DatosReportes(log.getDbHost(),log.getPort());
        idti=repo.ReporteIdTipo(log.getDbUser(), log.getDbPass(),t1,id); 
        return idti;
    }
       //idtests
       //Metodo para que el IDtest no se repita en la bd
       public boolean ReporteIdTest(JTable t1,Integer id){
           boolean idte=false;
        DatosReportes repo = new DatosReportes(log.getDbHost(),log.getPort());
        idte=repo.ReporteIdTest(log.getDbUser(), log.getDbPass(),t1,id); 
        return idte;
    }
    
    
}
