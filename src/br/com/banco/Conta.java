/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.banco;

import java.util.Date;

/**
 *
 * @author Bruna
 */
abstract class  Conta {
    protected int numeroConta;
    protected double saldo;
    protected Date dataAbertura;
    protected String senha;
    
    public Conta(int numeroConta, double saldo, String senha){
        this.numeroConta= numeroConta;
        this.saldo= saldo;
        this.dataAbertura = new Date();
        this.senha = senha;
    }
    
    abstract void atualizar();

    protected int getNumeroConta() {
        return numeroConta;
    }

    protected double getSaldo() {
        return saldo;
    }

    protected Date getDataAbertura() {
        return dataAbertura;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.numeroConta;
        return hash;
    }
    
    //Utilizado para comparar dois objetos do tipo conta 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conta other = (Conta) obj;
        if (this.numeroConta != other.numeroConta) {
            return false;
        }
        return true;
    }
    
    
    
    
}
