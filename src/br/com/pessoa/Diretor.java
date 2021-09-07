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
public class Diretor extends Funcionario{

    public Diretor(double salario, Date dataAdmissao) {
        super(salario, dataAdmissao);
    }

    @Override
    public double getSalario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
