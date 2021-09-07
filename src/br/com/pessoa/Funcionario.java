/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa;

import java.util.Date;

/**
 *
 * @author tales
 */
public abstract class Funcionario {
    protected double salario;
    protected Date dataAdmissao;
    
    public Funcionario(double salario, Date dataAdmissao){
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }
    
    public abstract double getSalario();
    
    public Date getDataAdmissao(){
        return this.dataAdmissao;
    }
            
}
