/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante.sabor.gourmet;

/**
 *
 * @author Agatha
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;

    public Cliente(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    // Getters para os atributos
    public String getNome() {
        return nome;
    }

    public String endereco(){
        return endereco;
    }

    public String telefone(){
        return telefone;
    }
    // Método para registrar o cliente em uma lista fornecida
    public void registrarCliente(List<Cliente> listaClientes) {
        listaClientes.add(this);
        System.out.println("Cliente registrado com sucesso.");
    }

    public void visualizarCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
    }
}
