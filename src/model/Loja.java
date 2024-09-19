package model;
import model.Cliente;
import model.Funcionario;
import model.Produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Loja implements Serializable {
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;
    private List<Produto> produtos;

    public Loja() {
        this.clientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    // Métodos para Clientes
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    // Métodos para Funcionários
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    // Métodos para Produtos
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
