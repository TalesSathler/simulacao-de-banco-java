/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.banco;

import static br.com.banco.GerenciadorDeClientes.listaClienteFi;
import static br.com.banco.GerenciadorDeClientes.listaClienteJu;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruna
 */
public class ContaCorrente extends Conta implements Transacoes { 
    private double limite;

   public ContaCorrente(int numeroConta, double saldo, double limite, String senha){
       super(numeroConta, saldo, senha);
       this.limite = limite;
       this.senha = senha;
   };
    
    public double getLimite() {
        return this.limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    @Override
    public int getNumeroConta(){
        return super.getNumeroConta();
    }
    
    
    public void atualizar(int numeroConta, double saldo, double limite) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.limite = limite;
    }
    
    public boolean transferirPFCC(int conta, double valor){
        if(valor <= this.saldo){
            for(int i=0; i<listaClienteFi.size(); i++){
                for(int j=0; j<listaClienteFi.get(i).listaCC.size(); j++){
                    if(listaClienteFi.get(i).listaCC.get(j).getNumeroConta() == conta){
                        listaClienteFi.get(i).listaCC.get(j).depositar(valor);
                        this.saldo-= valor;
                        return true;
                    }
                }
            }
            return false;
        }
        else
            return false;
    }
    
    public boolean transferirPJCC(int conta, double valor){
        if(valor <= this.saldo){
            for(int i=0; i<listaClienteJu.size(); i++){
                for(int j=0; j<listaClienteJu.get(i).listaCC.size(); j++){
                    if(listaClienteJu.get(i).listaCC.get(j).getNumeroConta() == conta){
                        listaClienteJu.get(i).listaCC.get(j).depositar(valor);
                        this.saldo-= valor;
                        return true;
                    }
                }
            }
            return false;
        }
        else
            return false;
    }
    
    
    
    public boolean saca(double valor){
        if((this.saldo+this.limite) - valor >= 0){
            this.saldo-=valor;
            return true;
        }
        else
            return false;
    }
    
    @Override
    public void depositar(double valor){
        this.saldo += valor;
    }

    @Override
    void atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean verificaSenha(String senha){
        return this.senha.equals(senha);
    }
    
    @Override
    public double getSaldo(){
        return this.saldo;
    }
    
    public double getSaldoLimite(){
        return this.saldo+this.limite;
    }

    @Override
    public void transferir(int conta, double valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sacar(double valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}
