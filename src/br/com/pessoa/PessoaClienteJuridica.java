/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa;

import br.com.banco.ContaCorrente;
import java.util.ArrayList;
import java.util.Date;
import solucao.de.banco.TelaPrincipal;

/**
 *
 * @author tales
 */
public class PessoaClienteJuridica extends PessoaJuridica{
    private Date dataCadastro;
    public ArrayList<ContaCorrente> listaCC;
    
    public PessoaClienteJuridica(String nome, String endereco, String cnpj, Date dataAbertura, String nomeFantasia) {
        super(nome, endereco, cnpj, dataAbertura, nomeFantasia);
        this.listaCC = new ArrayList<>();
    }
    
    public void cadastrarCCorrente(int numeroConta, double saldo, double limite, String senha){
        this.listaCC.add(new ContaCorrente(numeroConta, saldo, limite, senha));
    }
    
    public Date getDataCadastro(){
        return this.dataCadastro;
    }
    
    public ArrayList<ContaCorrente> getListaCC(){
        return this.listaCC;
    }
    
    public void removerCCorrente(int numeroConta){
        for(int i=0; i<this.listaCC.size(); i++)
            if(this.listaCC.get(i).getNumeroConta() == numeroConta){
                this.listaCC.remove(i);
                return;
            }
    }
    
    public boolean buscaCC(int conta, String senha){
        for(int i=0; i<this.listaCC.size(); i++)
            if(this.listaCC.get(i).getNumeroConta() == conta && this.listaCC.get(i).verificaSenha(senha)){
                TelaPrincipal.pConta = i;
                TelaPrincipal.tipoConta= "Conta Corrente";
                return true;
        }
        return false;
    }
    
}
