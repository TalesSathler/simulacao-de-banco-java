/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.banco;

/**
 *
 * @author Bruna
 */
interface Transacoes {
    
    public void transferir(int conta, double valor);
    public void sacar(double valor);
    public void depositar(double valor);
}
