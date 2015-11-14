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
import com.tm.db.DatosTest;
public class LogicaTest {
   LogicaApp log;
    
    
    public LogicaTest (){
        
     log=new LogicaApp();
    }
    //Los metodos encontrados aqui hacen referencio a las clases datos 
    //que contienen los llamados de los metodos de la bd
    //storeProcedures
    //Metodo Add llamado 
     public void RAgregar(Integer id, String fecha,String nom, Integer  idtipo,Integer idusua,String estado){
        DatosTest test = new DatosTest(log.getDbHost(),log.getPort());
        test.Agregar(log.getDbUser(), log.getDbPass(),id,fecha, nom, idtipo,idusua,estado); 
    }
     //Metodo Delete llamado
    public void REliminar(Integer id){
        DatosTest test = new DatosTest(log.getDbHost(),log.getPort());
        test.Eliminar(log.getDbUser(), log.getDbPass(),id); 
    }
    
    //Metodo update llamado
    public void RModificar(Integer id, String fecha,String nom, Integer  idtipo,Integer idusua,String estado){
        DatosTest test = new DatosTest(log.getDbHost(),log.getPort());
        test.Modificar(log.getDbUser(), log.getDbPass(),id,fecha, nom, idtipo,idusua,estado); 
    }
   //Metodo para que el ID test no se repita en la bd 
    public Boolean ValidarIdtest(int idt){
        boolean val=false;
        DatosTest tipos = new DatosTest(log.getDbHost(),log.getPort());
        val=tipos.ValidarIdtest(log.getDbUser(), log.getDbPass(), idt);
        return val;
    }
}
