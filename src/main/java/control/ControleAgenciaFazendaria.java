/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import SGBD.SGBDAgenciaFazendaria;
import java.util.ArrayList;
import model.ModeloAgenciaFazendaria;

/**
 *
 * @author Scorsatto
 */
public class ControleAgenciaFazendaria {
    
    public int incluirAgenciaFazendaria(ModeloAgenciaFazendaria objAgenciaFazendaria) {
        SGBDAgenciaFazendaria sgbd = new SGBDAgenciaFazendaria();
        int idAgencia = sgbd.incluirAgenciaFazendaria(objAgenciaFazendaria);
        return idAgencia;
    }
    
    public ArrayList<ModeloAgenciaFazendaria> pesquisaAgenciaFazendaria(String nome, String campo) {
        SGBDAgenciaFazendaria sgbd = new SGBDAgenciaFazendaria();
        ArrayList<ModeloAgenciaFazendaria> lstAgenciaFazendaria = sgbd.pesquisaAgenciaFazendaria(nome, campo);
        return lstAgenciaFazendaria;
    }
    
    public boolean alterarAgenciaFazendaria(ModeloAgenciaFazendaria objAgenciaFazendaria) {
        SGBDAgenciaFazendaria sgbd = new SGBDAgenciaFazendaria();
        boolean registroAlterado = sgbd.alterarAgenciaFazendaria(objAgenciaFazendaria);
        return registroAlterado;
    }
    
    public boolean excluirAgenciaFazendaria(ModeloAgenciaFazendaria objAgenciaFazendaria) {
        SGBDAgenciaFazendaria sgbd = new SGBDAgenciaFazendaria();
        boolean registroExcluido = sgbd.excluirUsuario(objAgenciaFazendaria);
        return registroExcluido;
    }
    
}
