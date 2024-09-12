/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurante.sabor.gourmet;

/**
 *
 * @author Amanda
 */
public class Pedido {
    private ItemMenu[] itens;
    private Cliente cliente;
    private double total;
    private String status;
    private int numItens;
    
    // Construtor
    public Pedido(Cliente cliente, int capacidade) {
        this.itens = new ItemMenu[capacidade];
        this.cliente = cliente;
        this.total = 0.0;
        this.status = "Em preparação";
        this.numItens = 0;
    }

    // Adiciona um item ao pedido e atualiza o total
    public void adicionarItem(ItemMenu item) {
        if (numItens < itens.length) {
            itens[numItens] = item;
            total += item.getPreco();
            numItens++;
            calcularTotal(); // Atualiza o total sempre que um item é adicionado
        } else {
            System.out.println("Não é possível adicionar mais itens. Capacidade máxima alcançada.");
        }
    }

    // Calcula o total do pedido com base nos preços dos itens
    private void calcularTotal() {
        total = 0.0;
        for (int i = 0; i < numItens; i++) {
            total += itens[i].getPreco();
        }
    }

    // Atualiza o status do pedido se for válido
    public void atualizarStatus(String status) {
        if (status.equalsIgnoreCase("Em preparação") || 
            status.equalsIgnoreCase("Pronto para entrega") || 
            status.equalsIgnoreCase("Entregue")) {
            this.status = status;
        } else {
            System.out.println("Status inválido. Utilize 'Em preparação', 'Pronto para entrega' ou 'Entregue'.");
        }
    }

    // Retorna a lista de itens do pedido
    public ItemMenu[] getItens() {
        return itens;
    }

    // Retorna o total do pedido
    public double getTotal() {
        return total;
    }

    // Retorna o status do pedido
    public String getStatus() {
        return status;
    }

    // Retorna os detalhes do pedido
    public String getDetalhesPedido() {
        String detalhes = "Status: " + status + "\n";
        detalhes += "Itens:\n";
        for (int i = 0; i < numItens; i++) {
            detalhes += itens[i].getDetalhesItem() + "\n";
        }
        detalhes += "Total: R$ " + total;
        return detalhes;
    }
}
