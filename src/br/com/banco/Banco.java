/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.banco;

import java.util.Objects;

/**
 *
 * @author tales
 */
public class Banco {
    private String nome;
    private String endereco;
    public GerenciadorDeClientes clientes;
    public GerenciadorDeContas contas;
    
    public Banco(String nome, String endereco, GerenciadorDeClientes clientes, GerenciadorDeContas contas){
        this.nome = nome;
        this.endereco = endereco;
        this.clientes = clientes;
        this.contas = contas;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getEndereco(){
        return this.endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Banco other = (Banco) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    
}
