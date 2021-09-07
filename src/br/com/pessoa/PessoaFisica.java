/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa;

import java.util.Date;

/**
 *feito
 * @author tales
 */
public class PessoaFisica extends Pessoa{
    protected String cpf;
    protected Date dataDeNasc;
    protected String sexo;

    public PessoaFisica(String nome, String endereco, String cpf, Date dataDeNasc, String sexo) {
        super(nome, endereco);
        this.cpf = cpf;
        this.dataDeNasc = dataDeNasc;
        this.sexo = sexo;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public Date getDataDeNasc(){
        return this.dataDeNasc;
    }
    
    public String getSexo(){
        return this.sexo;
    }
    
    
    
}
