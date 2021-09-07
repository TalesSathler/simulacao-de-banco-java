/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pessoa;

import br.com.banco.ContaCorrente;
import br.com.banco.ContaPoupanca;
import java.util.ArrayList;
import java.util.Date;
import solucao.de.banco.TelaPrincipal;

/**
 *
 * @author tales
 */
public class PessoaClienteFisica extends PessoaFisica{
    private Date dataCadastro;
    public ArrayList<ContaCorrente> listaCC;
    public ArrayList<ContaPoupanca> listaCP;

    public PessoaClienteFisica(String nome, String endereco, String cpf, Date dataDeNasc, String sexo, Date dataCadastro) {
        super(nome, endereco, cpf, dataDeNasc, sexo);
        this.dataCadastro = dataCadastro;
        this.listaCC = new ArrayList<>();
        this.listaCP = new ArrayList<>();
    }
    
    public void cadastrarCCorrente(int numeroConta, double saldo, double limite, String senha){
        this.listaCC.add(new ContaCorrente(numeroConta, saldo, limite, senha));
    }
    
    public void cadastrarCPoupanca(int numeroConta, double saldo, String senha){
        this.listaCP.add(new ContaPoupanca(numeroConta, saldo, senha));
    }
    
    public void atualizaCC(int numeroConta, double saldo, double limite){
        for(int i=0; i<this.listaCC.size(); i++)
            if(this.listaCC.get(i).getNumeroConta() == numeroConta){
                this.listaCC.get(i).atualizar(numeroConta, saldo, limite);
                return;
        }
    }
    
    public void atualizaCP(int numeroConta, double saldo){
        for(int i=0; i<this.listaCP.size(); i++)
            if(this.listaCP.get(i).getNumeroConta() == numeroConta){
                this.listaCP.get(i).atualizar(numeroConta, saldo);
                return;
        }
    }
    
    public void removerCCorrente(int numeroConta){
        for(int i=0; i<this.listaCC.size(); i++)
            if(this.listaCC.get(i).getNumeroConta() == numeroConta){
                this.listaCC.remove(i);
                return;
            }
    }
    
    public void removerCPoupanca(int numeroConta){
        for(int i=0; i<this.listaCP.size(); i++)
            if(this.listaCP.get(i).getNumeroConta() == numeroConta){
                this.listaCP.remove(i);
                return;
            }
    }
    
    public Date getDataCadastro(){
        return this.dataCadastro;
    }
    
    public ArrayList<ContaCorrente> getListaCC(){
        return this.listaCC;
    }
    
    public ArrayList<ContaPoupanca> getListaCP(){
        return this.listaCP;
    }
    
    public void tipoEnumero(String tipo, int posconta, int posCliente){
        TelaPrincipal.pConta = posconta;
        TelaPrincipal.tipoConta = tipo;
        TelaPrincipal.pCliente = posCliente;
    }
    
    public boolean buscaCC(int conta, String senha){
        System.out.println("entrou buscacc");
        for(int i=0; i<this.listaCC.size(); i++){
            if(this.listaCC.get(i).getNumeroConta() == conta && this.listaCC.get(i).verificaSenha(senha)){
                TelaPrincipal.pConta = i;
                TelaPrincipal.tipoConta= "Conta Corrente";
                return true;
            }
        }
        return false;
    }
    
    public boolean buscaCP(int conta, String senha){
        System.out.println("entrou buscacp");
        for(int i=0; i<this.listaCP.size(); i++){
            if(this.listaCP.get(i).getNumeroConta() == conta && this.listaCP.get(i).verificaSenha(senha)){
                TelaPrincipal.pConta = i;
                TelaPrincipal.tipoConta = "Conta Poupança";
                return true;
            }
        }
        return false;
    }
 
}
