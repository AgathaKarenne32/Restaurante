/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante.sabor.gourmet;

/**
 *
 * @author Agatha
 */

public class ItemMenu {
    private String nome;
    private String categoria;
    private double preco;

    public ItemMenu(String nome, String categoria, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }
    
    // Getters para os atributos
    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }
    public String getDetalhesItem() {
        return "Nome: " + nome + ", Categoria: " + categoria + ", Preço: " + preco;
    }

    public double calcularPreco() {
        return preco;
    }
}
