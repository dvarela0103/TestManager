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

import com.tm.db.DatosTipos;
import javax.swing.JComboBox;

public class LogicaTipos {
    LogicaApp log;
    
    
    public LogicaTipos (){
        
     log=new LogicaApp();
    }
    //Los metodos encontrados aqui hacen referencio a las clases datos 
    //que contienen los llamados de los metodos de la bd
    //storeProcedures
    //Metodo Add llamado 
     public void RAgregar(Integer id, String nom,String des){
        DatosTipos tipos = new DatosTipos(log.getDbHost(),log.getPort());
        tipos.Agregar(log.getDbUser(), log.getDbPass(), id,nom,des); 
    }
     //Metodo Delete llamado
    public void REliminar(Integer id){
        DatosTipos tipos = new DatosTipos(log.getDbHost(),log.getPort());
        tipos.Eliminar(log.getDbUser(), log.getDbPass(),id); 
    }
    
    //Metodo update llamado
    public void RModificar(Integer id, String nom,String des){
        DatosTipos tipos = new DatosTipos(log.getDbHost(),log.getPort());
        tipos.Modificar(log.getDbUser(), log.getDbPass(), id,nom,des); 
    }
   //Metodo para validar que no se repita un id tipo 
    public Boolean ValidarIdtipo(int idt){
        boolean val=false;
        DatosTipos tipos = new DatosTipos(log.getDbHost(),log.getPort());
        val=tipos.ValidarIdtipo(log.getDbUser(), log.getDbPass(), idt);
        return val;
    }
    //Metodo para no eliminar tipo que este asociado a test
     public Boolean NoEliminartipo (int idt){
        boolean val=false;
        DatosTipos tipos = new DatosTipos(log.getDbHost(),log.getPort());
        val=tipos.NoEliminartipo(log.getDbUser(), log.getDbPass(), idt);
        return val;
    }
     
     //Metodo para cargar id tipos en Combobox
     public void ComboTipo (JComboBox combotipo){
        
        DatosTipos tipos = new DatosTipos(log.getDbHost(),log.getPort());
        tipos.Combotipo(log.getDbUser(), log.getDbPass(),combotipo);
        
    }
}
