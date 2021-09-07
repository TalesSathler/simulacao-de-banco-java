/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.banco;

import br.com.pessoa.Pessoa;
import br.com.pessoa.PessoaClienteFisica;
import br.com.pessoa.PessoaClienteJuridica;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static solucao.de.banco.Menu.jRBCorrente;
import static solucao.de.banco.Menu.jRBFisica;
import static solucao.de.banco.Menu.jRBJuridica;
import static solucao.de.banco.Menu.jRBPoupanca;
import static solucao.de.banco.Menu.txtConta;
import static solucao.de.banco.Menu.txtSenha;
import solucao.de.banco.TelaPrincipal;

/**
 *
 * @author tales
 */
public class GerenciadorDeClientes {
    
    public  static ArrayList<PessoaClienteFisica> listaClienteFi;
    public  static ArrayList<PessoaClienteJuridica> listaClienteJu;
    
    
    
    public GerenciadorDeClientes(){
        this.listaClienteFi = new ArrayList<>();
        this.listaClienteJu = new ArrayList<>();
    }
    
    /*1-juridica 2-fisica*/
    public boolean adicionar(String tipo, String nome, String endereco, String cpf, Date dataDeNasc, String sexo, String cnpj, 
            Date dataDeAbertura, String nomeFantasia){
        if(tipo.equals("fisica") || tipo.equals("Fisica")){
            this.listaClienteFi.add(new PessoaClienteFisica(nome, endereco, cpf, dataDeNasc, sexo, new Date()));
            return true;
        }
        else if(tipo.equals("Juridica") || tipo.equals("juridica")){
            this.listaClienteJu.add(new PessoaClienteJuridica(nome, endereco, cnpj, dataDeAbertura, nomeFantasia));
            return true;
        }
        return false;
    }
    
    public void remover(Pessoa cliente, String tipo){
        int i = 0;
        //de acordo com o tipo ele busca o index e remove
        if(tipo.equals("fisica") || tipo.equals("Fisica")){
            while(!this.listaClienteFi.get(i).getNome().equals(cliente.getNome()))
                i++;
            this.listaClienteFi.remove(i);
        }
        else if(tipo.equals("juridica") || tipo.equals("Juridica")){
            while(!this.listaClienteJu.get(i).getNome().equals(cliente.getNome()))
                i++;
            this.listaClienteJu.remove(i);
        }
    }
    
    public ArrayList<PessoaClienteFisica> getListaClienteFisica(){
        return this.listaClienteFi;
    }
    
    public ArrayList<PessoaClienteJuridica> getListaClienteJuridica(){
        return this.listaClienteJu;
    }
    
    /**
     * procura se o conta que deseja entrar exite
     * @return boolean
     */
    public boolean validaCliente(){
        int i = 0;
        
            
        int conta = Integer.valueOf(txtConta.getText());
        String senha = txtSenha.getText();
        
        
        for(i=0; i<this.listaClienteFi.size(); i++){
            if(jRBFisica.isSelected() && !this.listaClienteFi.isEmpty()){
                if(this.listaClienteFi.get(i).buscaCC(conta, senha) == true && jRBCorrente.isSelected()){
                    TelaPrincipal.pCliente = i;
                    TelaPrincipal.tipoCliente = "Fisica";
                    return true;
                }
                else if(this.listaClienteFi.get(i).buscaCP(conta, senha) == true && jRBPoupanca.isSelected()){
                    TelaPrincipal.pCliente = i;
                    TelaPrincipal.tipoCliente = "Fisica";
                    return true;
                }
            }
        }
        
        for(i=0; i<this.listaClienteJu.size(); i++){
            if(jRBJuridica.isSelected() && !this.listaClienteJu.isEmpty() && jRBCorrente.isSelected()){
                if(this.listaClienteJu.get(i).buscaCC(conta, senha) == true){
                    TelaPrincipal.pCliente = i;
                    TelaPrincipal.tipoCliente = "Juridica";
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public void depositarCliF(String tipo, double valor){
        int j=0;
        int i=0;
        if(tipo.equals("Conta Corrente")){
            this.listaClienteFi.get(TelaPrincipal.pCliente).listaCC.get(TelaPrincipal.pConta).depositar(valor);
        }
        else if(tipo.equals("Conta Poupança")){
            this.listaClienteFi.get(TelaPrincipal.pCliente).listaCP.get(TelaPrincipal.pConta).depositar(valor);
        }
    }
    
    public void depositarCliJ(String tipo, double valor){
        int j=0;
        int i=0;
        if(tipo.equals("Conta Corrente")){
            this.listaClienteJu.get(TelaPrincipal.pCliente).listaCC.get(TelaPrincipal.pConta).depositar(valor);
        }
    }
    
    public boolean sacarCliF(String tipo, double valor){
        int j=0;
        int i=0;
        if(tipo.equals("Conta Corrente")){
            if(this.listaClienteFi.get(TelaPrincipal.pCliente).listaCC.get(TelaPrincipal.pConta).saca(valor))
                return true;
        }
        else if(tipo.equals("Conta Poupança")){
            if(this.listaClienteFi.get(TelaPrincipal.pCliente).listaCP.get(TelaPrincipal.pConta).saca(valor))
                return true;
        }
        
        return false;
        
    }
    
    public boolean sacarCliJ(String tipo, double valor){
        int j=0;
        int i=0;
        if(tipo.equals("Conta Corrente")){
            if(this.listaClienteJu.get(TelaPrincipal.pCliente).listaCC.get(TelaPrincipal.pConta).saca(valor))
                return true;
        }
        return false;
    }
    
    public void transCliF(String tipo, int numeroConta, double valor){
        int j=0;
        int i=0;
        
        if(tipo.equals("Conta Corrente") && TelaPrincipal.tipoCliente.equals("Fisica")){
            if(this.listaClienteFi.get(TelaPrincipal.pCliente).listaCC.get(TelaPrincipal.pConta).transferirPFCC(numeroConta, valor))
                JOptionPane.showMessageDialog(null, "Valor Transferido com sucesso!");
                //this.listaClienteFi.get(numeroConta).listaCC.get(numeroConta).depositar(valor);
            else
                JOptionPane.showMessageDialog(null, "Algo deu errado, verifique seu saldo e a conta inserida!");
        }
        else if(tipo.equals("Conta Corrente") && TelaPrincipal.tipoCliente.equals("Juridica")){
            if(this.listaClienteJu.get(TelaPrincipal.pCliente).listaCC.get(TelaPrincipal.pConta).transferirPFCC(numeroConta, valor))
                JOptionPane.showMessageDialog(null, "Valor Transferido com sucesso!");
                //this.listaClienteFi.get(numeroConta).listaCC.get(numeroConta).depositar(valor);
            else
                JOptionPane.showMessageDialog(null, "Algo deu errado, verifique seu saldo e a conta inserida!");
        }
        else if (tipo.equals("Conta Poupança") && TelaPrincipal.tipoCliente.equals("Fisica")){
            if(this.listaClienteFi.get(TelaPrincipal.pCliente).listaCP.get(TelaPrincipal.pConta).transferirPFCP(numeroConta, valor))
                JOptionPane.showMessageDialog(null, "Valor Transferido com sucesso!");
        }
    }
    
    public void transCliJ(String tipo, int numeroConta, double valor){
        int j=0;
        int i=0;
        
        if(tipo.equals("Conta Corrente") && TelaPrincipal.tipoCliente.equals("Juridica")){
            JOptionPane.showMessageDialog(null, "de conta juridica");
            if(this.listaClienteJu.get(TelaPrincipal.pCliente).listaCC.get(TelaPrincipal.pConta).transferirPJCC(numeroConta, valor))
                JOptionPane.showMessageDialog(null, "Valor Transferido com sucesso!");
                //this.listaClienteFi.get(numeroConta).listaCC.get(numeroConta).depositar(valor);
            else
                JOptionPane.showMessageDialog(null, "Algo deu errado, verifique seu saldo e a conta inserida!");
        }
        else if(tipo.equals("Conta Poupança") && TelaPrincipal.tipoCliente.equals("Juridica")){
            if(this.listaClienteJu.get(TelaPrincipal.pCliente).listaCC.get(TelaPrincipal.pConta).transferirPJCC(numeroConta, valor))
                JOptionPane.showMessageDialog(null, "Valor Transferido com sucesso!");
                //this.listaClienteFi.get(numeroConta).listaCC.get(numeroConta).depositar(valor);
            else
                JOptionPane.showMessageDialog(null, "Algo deu errado, verifique seu saldo e a conta inserida!");
        }
        else if(tipo.equals("Conta Corrente") && TelaPrincipal.tipoCliente.equals("Fisica")){
            if(this.listaClienteFi.get(TelaPrincipal.pCliente).listaCC.get(TelaPrincipal.pConta).transferirPJCC(numeroConta, valor))
                JOptionPane.showMessageDialog(null, "Valor Transferido com sucesso!");
                //this.listaClienteFi.get(numeroConta).listaCC.get(numeroConta).depositar(valor);
            else
                JOptionPane.showMessageDialog(null, "Algo deu errado, verifique seu saldo e a conta inserida!");
        }
        else if(tipo.equals("Conta Poupança") && TelaPrincipal.tipoCliente.equals("Fisica")){
            if(this.listaClienteFi.get(TelaPrincipal.pCliente).listaCC.get(TelaPrincipal.pConta).transferirPJCC(numeroConta, valor))
                JOptionPane.showMessageDialog(null, "Valor Transferido com sucesso!");
                //this.listaClienteFi.get(numeroConta).listaCC.get(numeroConta).depositar(valor);
            else
                JOptionPane.showMessageDialog(null, "Algo deu errado, verifique seu saldo e a conta inserida!");
        }
    }
    
}
