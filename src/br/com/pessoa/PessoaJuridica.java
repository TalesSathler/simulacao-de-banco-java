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
public class PessoaJuridica extends Pessoa{
    protected String cnpj;
    protected Date dataAbertura;
    protected String nomeFantasia;

    public PessoaJuridica(String nome, String endereco, String cnpj, Date dataAbertura, String nomeFantasia) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.dataAbertura = dataAbertura;
        this.nomeFantasia = nomeFantasia;
    }
    
    public String getCnpj(){
        return this.cnpj;
    }
    
    public Date getDataAbertura(){
        return this.getDataAbertura();
    }
    
    public String getNomeFantasia(){
        return this.nomeFantasia;
    }
    
    public void setNomeFantasia(String nomeFantasia){
        this.nomeFantasia = nomeFantasia;
    }
    
}
