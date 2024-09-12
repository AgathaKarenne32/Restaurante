/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restaurante.sabor.gourmet;

/**
 *
 * @author Amanda
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RestauranteSaborGourmet {
    private static List<Cliente> clientes = new ArrayList<>();
    private static ItemMenu[] menu = new ItemMenu[9];  // Array de menu
    private static Pedido[] pedidos = new Pedido[100];  // Array de pedidos com capacidade inicial de 100
    private static int numPedidos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        exibirMenu();

        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Cadastro de Cliente");
            System.out.println("2. Visualizar Menu");
            System.out.println("3. Adicionar itens ao pedido");
            System.out.println("4. Finalizar pedido");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;

                case 2:
                    visualizarMenu();
                    break;

                case 3:
                    adicionarPedido(scanner);
                    break;

                case 4:
                    finalizarPedido(scanner);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void exibirMenu() {
        menu[0] = new ItemMenu("Costela Bovina", "Prato Principal", 50.00);
        menu[1] = new ItemMenu("Cordeiro", "Prato Principal", 35.00);
        menu[2] = new ItemMenu("Camarão", "Prato Principal", 25.00);
        menu[3] = new ItemMenu("Vinho Suave", "Bebidas", 60.00);
        menu[4] = new ItemMenu("Drink de Morango", "Bebidas", 45.00);
        menu[5] = new ItemMenu("Suco de Laranja", "Bebidas", 20.00);
        menu[6] = new ItemMenu("Mousse de Chocolate", "Sobremesa", 35.00);
        menu[7] = new ItemMenu("Brownie", "Sobremesa", 45.00);
        menu[8] = new ItemMenu("Sorvete Artesanal", "Sobremesa", 35.00);
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.println("\n=== CADASTRO DE CLIENTE ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        Cliente novoCliente = new Cliente(nome, endereco, telefone);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private static void visualizarMenu() {
        System.out.println("\n=== MENU ===");
        for (ItemMenu item : menu) {
            System.out.println(item.getDetalhesItem());
        }
    }

    private static void adicionarPedido(Scanner scanner) {
        System.out.println("\n=== ADICIONAR ITENS AO PEDIDO ===");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Cadastre um cliente primeiro.");
            return;
        }

        System.out.println("Escolha o número do cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
        int opcaoCliente = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        if (opcaoCliente < 1 || opcaoCliente > clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }
        Cliente clienteEscolhido = clientes.get(opcaoCliente - 1);
        
        
        // Inicializa o array de itens para o novo pedido
        Pedido pedido = new Pedido(clienteEscolhido, 10);
        
        System.out.println("Adicione itens ao pedido (digite o número do item ou '0' para finalizar):");
        while (true) {
            // Exibe o menu com números
        System.out.println("\n=== MENU ===");
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                System.out.println((i + 1) + ". " + menu[i].getDetalhesItem());
            }
        }

        // Captura a escolha do usuário
        System.out.print("Número do item: ");
        int numeroItem = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (numeroItem == 0) {
            break;  // Sai do loop se o usuário digitar 0
        }

        if (numeroItem < 1 || numeroItem > menu.length || menu[numeroItem - 1] == null) {
            System.out.println("Número do item inválido.");
        } else {
            ItemMenu itemEscolhido = menu[numeroItem - 1];
            pedido.adicionarItem(itemEscolhido);
            System.out.println("Item adicionado: " + itemEscolhido.getDetalhesItem());
        }
    }
    
    if (numPedidos >= pedidos.length) {
            System.out.println("Número máximo de pedidos atingido.");
            return;
        }
    pedidos[numPedidos] = pedido;  // Adiciona o pedido ao array
        numPedidos++;
    System.out.println("Pedido adicionado com sucesso.");
}

    private static void finalizarPedido(Scanner scanner) {
        System.out.println("\n=== FINALIZAR PEDIDO ===");
        if (numPedidos > 0) {
            System.out.println("Escolha o número do pedido para finalizar:");
            for (int i = 0; i < numPedidos; i++) {
                System.out.println((i + 1) + ". Pedido " + (i + 1));
            }
            int opcaoPedido = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            if (opcaoPedido >= 1 && opcaoPedido <= numPedidos) {
                Pedido pedidoParaFinalizar = pedidos[opcaoPedido - 1];
                System.out.println("Pedido finalizado com sucesso.");
                System.out.println("Detalhes do pedido:");
                System.out.println(pedidoParaFinalizar.getDetalhesPedido());
                for (int i = opcaoPedido - 1; i < numPedidos - 1; i++) {
                    pedidos[i] = pedidos[i + 1];
                }
                pedidos[numPedidos - 1] = null;
                numPedidos--;
            } else {
                System.out.println("Número do pedido inválido.");
            }
        } else {
            System.out.println("Nenhum pedido para finalizar.");
        }
    }
}
