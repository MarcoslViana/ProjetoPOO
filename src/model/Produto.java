package model;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {
    private String nome;
    private  String marca;
    private String codigoBarras;
    private double preco;
    private int quantidade;

    public Produto(String nome, String codigoBarras, double preco, int quantidade,String marca) {
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.preco = preco;
        this.quantidade = quantidade;
        this.marca=marca;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigoBarras, produto.codigoBarras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoBarras);
    }
}
