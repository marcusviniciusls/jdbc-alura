package br.com.alura.model;

import java.util.List;
import java.util.ArrayList;

public class Categoria {
    private Integer id;
    private String nome;
    private List<Product> listaProdutos = new ArrayList<>();

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public void adicionarProduto(Product produto){
        this.listaProdutos.add(produto);
    }

    public List<Product> getListaProdutos(){
        return this.listaProdutos;
    }
}
