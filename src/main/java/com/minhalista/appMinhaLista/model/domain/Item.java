package com.minhalista.appMinhaLista.model.domain;

public class Item {

    private Integer quantidade;
    private Double valorTotal;
    private Produto produto;

    public Item(Integer quantidade, Double valorTotal, Produto produto) {
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return String.format("produto (%s) - quantidade (%d) - valorTotal (%.2f)",
                produto.getNome(), quantidade, valorTotal);
    }
}
