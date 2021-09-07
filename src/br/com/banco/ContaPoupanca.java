/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.banco;

import static br.com.banco.GerenciadorDeClientes.listaClienteFi;

/**
 *
 * @author tales
 */
public class ContaPoupanca extends Conta implements Transacoes{
    private double porcentagemDeRendimento;

    public ContaPoupanca(int numeroConta, double saldo, String senha) {
        super(numeroConta, saldo, senha);
    }
    
    @Override
    public void atualizar(){
        
    }
    
    public void atualizar(int numeroConta, double saldo) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
    }
    
    @Override
    public int getNumeroConta(){
        return super.getNumeroConta();
    }
    
    @Override
    public void transferir(int conta, double valor){
        
    }
    
    public boolean saca(double valor){
        if((this.saldo) - valor >= 0){
            this.saldo-=valor;
            return true;
        }
        else
            return false;
    }
    
    @Override
    public void sacar(double valor){
        if((this.saldo-valor) >= 0 )
            this.saldo -= valor;
        else
            System.out.println("Saldo insuficiente!");
    }
    
    @Override
    public void depositar(double valor){
        this.saldo += valor;
    }
    
    public boolean verificaSenha(String senha){
        return this.senha.equals(senha);
    }
    
    @Override
    public double getSaldo(){
        return this.saldo;
    }
    
    public boolean transferirPFCP(int conta, double valor){
        if(valor <= this.saldo){
            for(int i=0; i<listaClienteFi.size(); i++){
                for(int j=0; j<listaClienteFi.get(i).listaCP.size(); j++){
                    if(listaClienteFi.get(i).listaCP.get(j).getNumeroConta() == conta){
                        listaClienteFi.get(i).listaCP.get(j).depositar(valor);
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
}
