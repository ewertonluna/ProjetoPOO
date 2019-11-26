package model;

import exception.InsumoException;;

public class Insumo extends Alimento {
    private double precoIndividual;
    private int quantidade;

    public Insumo(String nome, double calorias, double precoIndividual, int quantidade) {
        super(nome, calorias);
        if (quantidade < 0) {
            throw new IllegalArgumentException("Argumento não válido");
        }
        this.precoIndividual = precoIndividual;
        this.quantidade = quantidade;
    }

    public double getPrecoIndividual() {
        return precoIndividual;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoTotal() {
        return quantidade * precoIndividual;
    }

    public void aumentarQuantidade(int quantidade) throws InsumoException{
        if (quantidade < 0) {
            throw new InsumoException("Quantidade negativa não é válida");
        }
        this.quantidade += quantidade;
    }

    public void diminuirQuantidade(int quantidade) throws InsumoException{
        if (quantidade < 0) {
            throw new InsumoException("Quantidade negativa não é válida");
        }
        if (this.quantidade - quantidade < 0) {
            throw new InsumoException("Estoque mínimo não pode ser menor do que zero");
        }
        this.quantidade -= quantidade;        
    }

    @Override
    public String toString() {
        return "Insumo [nome=" + nome + ", calorias=" + calorias + ", preco=" + precoIndividual + ", quantidade=" + quantidade + "]";
    }

}