/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.banco;

import javax.swing.JOptionPane;

/**
 *
 * @author tales
 */
public class GerenciadorDeContas {
    
    public GerenciadorDeClientes clientes;
    
    public GerenciadorDeContas(GerenciadorDeClientes clientes){
        this.clientes = clientes;
    }
    
    public void atualizarContas(String tipo, String nomeCliente, int numDaConta){
        int i = 0;
        int z = 0;
        if(tipo.equals("Fisica") || tipo.equals("fisica")){
            while(!this.clientes.getListaClienteFisica().get(i).equals(nomeCliente))
                i++;
            for(int x=0; x<this.clientes.getListaClienteFisica().get(i).getListaCC().size(); x++){
                while(z < this.clientes.getListaClienteFisica().get(x).getListaCC().size()){
                        this.clientes.getListaClienteFisica().get(x).removerCCorrente(numDaConta);
                    z++;
                }
            }
        }
        else if(tipo.equals("Juridica") || tipo.equals("juridica")){
            while(!this.clientes.getListaClienteFisica().get(i).equals(nomeCliente))
                i++;
            for(int x=0; x<this.clientes.getListaClienteJuridica().get(i).getListaCC().size(); x++){
                while(z < this.clientes.getListaClienteJuridica().get(x).getListaCC().size()){
                    this.clientes.getListaClienteJuridica().get(x).removerCCorrente(numDaConta);

                    z++;
                }
            }
        }
    }
    
    public boolean adicionarCorrente(String tipo, String nomeCliente, int numeroConta, double saldo, double limite, String senha){
        //int i = 0;
        if(tipo.equals("Fisica") || tipo.equals("fisica")){
            for(int i=0; i<this.clientes.getListaClienteFisica().size(); i++){
                
                if(this.clientes.listaClienteFi.get(i).getNome().equals(nomeCliente)){
                    this.clientes.listaClienteFi.get(i).cadastrarCCorrente(numeroConta, saldo, limite, senha);
                    return true;
                }
            }
        }
        else if(tipo.equals("Juridica") || tipo.equals("juridica")){
            
            for(int i=0; i<this.clientes.getListaClienteJuridica().size(); i++){
                
                if(this.clientes.listaClienteJu.get(i).getNome().equals(nomeCliente)){
                    this.clientes.listaClienteJu.get(i).cadastrarCCorrente(numeroConta, saldo, limite, senha);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean adicionarPoupanca(String tipo, String nomeCliente, int numeroConta, double saldo, String senha){
       
        for(int i=0; i<this.clientes.getListaClienteFisica().size(); i++){
                
                System.out.println(this.clientes.getListaClienteFisica().size());
                if(this.clientes.listaClienteFi.get(i).getNome().equals(nomeCliente)){
                    this.clientes.listaClienteFi.get(i).cadastrarCPoupanca(numeroConta, saldo, senha);
                    return true;
                }
            }
        return false;
    }
    
    public void removerContaCorrente(String tipo, String nomeCliente, int numDaConta){
        int i = 0;
        int z = 0;
        if(tipo.equals("Fisica") || tipo.equals("fisica")){
            while(!this.clientes.getListaClienteFisica().get(i).equals(nomeCliente))
                i++;
            for(int x=0; x<this.clientes.getListaClienteFisica().get(i).getListaCC().size(); x++){
                while(z < this.clientes.getListaClienteFisica().get(x).getListaCC().size()){
                        this.clientes.getListaClienteFisica().get(x).removerCCorrente(numDaConta);
                    z++;
                }
            }
        }
        else if(tipo.equals("Juridica") || tipo.equals("juridica")){
            while(!this.clientes.getListaClienteFisica().get(i).equals(nomeCliente))
                i++;
            for(int x=0; x<this.clientes.getListaClienteJuridica().get(i).getListaCC().size(); x++){
                while(z < this.clientes.getListaClienteJuridica().get(x).getListaCC().size()){
                    this.clientes.getListaClienteJuridica().get(x).removerCCorrente(numDaConta);

                    z++;
                }
            }
        }
    }
    
    public void removerContaPoupanca(String tipo, String nomeCliente, int numDaConta){
        int i = 0;
        int z = 0;
        if(tipo.equals("Fisica") || tipo.equals("fisica")){
            while(!this.clientes.getListaClienteFisica().get(i).equals(nomeCliente))
                i++;
            for(int x=0; x<this.clientes.getListaClienteFisica().get(i).getListaCC().size(); x++){
                while(z < this.clientes.getListaClienteFisica().get(z).getListaCC().size()){
                    if(this.clientes.getListaClienteFisica().get(z).getListaCC().get(z).getNumeroConta() == numDaConta){
                        this.clientes.getListaClienteFisica().get(z).getListaCC().remove(z);
                        return;
                    }
                        
                    z++;
                }
            }
        }
    }
    
}
