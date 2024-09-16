# Sabor Gourmet - Sistema de Pedidos Online

## Descrição

O "Sabor Gourmet" é um restaurante que está expandindo seus serviços para pedidos online. Este projeto visa desenvolver um sistema que permitirá gerenciar pedidos feitos pelos clientes, incluindo cadastro, visualização de menu, realização de pedidos e acompanhamento do status dos pedidos.

## Requisitos Funcionais

### Cadastro de Clientes

- Permitir que o cliente forneça seu nome, endereço e telefone.
- Armazenar os dados dos clientes em um array.

### Visualização do Menu

- Exibir o menu do restaurante com itens disponíveis.
- Cada item deve conter nome, preço e categoria.
- Armazenar os itens do menu em um array.

### Realização de Pedido

- O cliente deve poder escolher itens do menu e adicionar ao pedido.
- Um pedido deve conter múltiplos itens e ser registrado no sistema.
- O sistema deve calcular o total do pedido com base nos preços dos itens.

### Acompanhamento de Pedidos

- O cliente pode verificar o status do pedido, que pode ser "Em preparação", "Pronto para entrega", ou "Entregue".

## Modelo de Dados

### Entidades

1. **Cliente**
   - Nome
   - Endereço
   - Telefone

2. **ItemMenu**
   - Nome
   - Categoria
   - Preço

3. **Pedido**
   - Cliente
   - Itens escolhidos
   - Total do pedido
   - Status

### Diagrama ER

Utilize um software de modelagem, como MySQL Workbench ou DBDesigner, para criar o diagrama ER do banco de dados. Estruture as tabelas para armazenar as informações de clientes, itens do menu e pedidos.

## Implementação em Java

### Classes

1. **Cliente**

   ```java
   public class Cliente {
       private String nome;
       private String endereco;
       private String telefone;

           public void registrarCliente (List<Cliente> listaClientes) {
        listaClientes.add(this);
        System.out.println("Cliente registrado com sucesso.");
    }

       public String visualizarCliente() {
           return "Nome: " + nome + ", Endereço: " + endereco + ", Telefone: " + telefone;
       }
   }
   ```

2. **ItemMenu**

   ```java
   public class ItemMenu {
       private String nome;
       private String categoria;
       private double preco;

       public ItemMenu(String nome, String categoria, double preco) {
           this.nome = nome;
           this.categoria = categoria;
           this.preco = preco;
       }

       public String getDetalhesItem() {
           return "Nome: " + nome + ", Categoria: " + categoria + ", Preço: " + preco;
       }

       public double calcularPreco() {
           return preco;
       }
   }
   ```

3. **Pedido**

   ```java
   public class Pedido {
       private ItemMenu[] itens;
       private Cliente cliente;
       private double total;
       private String status;

       public Pedido() {
           itens = new ItemMenu[10]; // Exemplo com tamanho fixo
           total = 0.0;
           status = "Em preparação";
       }

       public void adicionarItem(ItemMenu item) {
           // Adiciona o item ao array de itens
           // Atualiza o total e o status
           for (int i = 0; i < itens.length; i++) {
               if (itens[i] == null) {
                   itens[i] = item;
                   total += item.calcularPreco();
                   status = "Preparando";
                   break;
               }
           }
       }

       private void calcularTotal() {
           total = 0.0;
           for (ItemMenu item : itens) {
               if (item != null) {
                   total += item.calcularPreco();
               }
           }
       }

       public void atualizarStatus(String status) {
           if (status.equals("Em preparação") || status.equals("Pronto para entrega") || status.equals("Entregue")) {
               this.status = status;
           }
       }

       public double getTotal() {
           return total;
       }

       public String getStatus() {
           return status;
       }

       public String getDetalhesPedido() {
           StringBuilder detalhes = new StringBuilder("Cliente: " + cliente.visualizarCliente() + "\nItens:\n");
           for (ItemMenu item : itens) {
               if (item != null) {
                   detalhes.append(item.getDetalhesItem()).append("\n");
               }
           }
           detalhes.append("Total: ").append(total).append("\nStatus: ").append(status);
           return detalhes.toString();
       }
   }
   ```

4. **Principal**

   ```java
   public class Principal {
       private Cliente[] clientes;
       private ItemMenu[] menu;
       private Pedido[] pedidos;

       public Principal() {
           clientes = new Cliente[10]; // Exemplo com tamanho fixo
           menu = new ItemMenu[10]; // Exemplo com tamanho fixo
           pedidos = new Pedido[10]; // Exemplo com tamanho fixo
       }

       // Métodos para interagir com o sistema: cadastrar cliente, visualizar menu, adicionar itens ao pedido, etc.
   }
   ```

## Executando o Sistema

- Compile as classes Java.
- Execute a classe `Principal` para iniciar o menu interativo.
- Utilize as opções disponíveis para cadastrar clientes, visualizar o menu, adicionar itens ao pedido e acompanhar o status dos pedidos.

## Notas

- O sistema usa arrays simples para armazenamento de dados. Em uma aplicação real, considere usar um banco de dados para persistência.
- Adapte o tamanho dos arrays conforme necessário para suportar mais clientes, itens e pedidos.
