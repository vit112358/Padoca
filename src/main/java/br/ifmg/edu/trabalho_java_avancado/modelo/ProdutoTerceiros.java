/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.modelo;

import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Vitor
 */

@Entity
@DiscriminatorValue("Produtos_Terceiros")
public class ProdutoTerceiros extends Produto{
    
    private Float precoCusto;
    private Float precoVenda;
    
    private Integer Estoque;
    private Integer EstoqueMin;
    
    //Verificar colocar Estoque
    
    @ManyToOne
    @JoinColumn(name = "Fornecedor_Id")
    private Fornecedor fornecedor_prod;

    public ProdutoTerceiros() {
    }

    public ProdutoTerceiros(Float precoCusto, Float precoVenda, Integer Id, String Nome, Integer estoque, Integer estoqueMin) {
        super(Id, Nome);
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.Estoque = estoque;
        this.EstoqueMin = estoqueMin;
    }

    public Float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getEstoque() {
        return Estoque;
    }

    public void setEstoque(Integer Estoque) {
        this.Estoque = Estoque;
    }

    public Integer getEstoqueMin() {
        return EstoqueMin;
    }

    public void setEstoqueMin(Integer EstoqueMin) {
        this.EstoqueMin = EstoqueMin;
    }

    
    public Fornecedor getFornecedor() {
        return fornecedor_prod;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor_prod = fornecedor;
    }
    
       
    @Override
    public String toString() {
        return "Produtos_Terceiros{" +"ID: "+ super.getID()+ " precoCusto=" + precoCusto + ", precoVenda=" + precoVenda + '}';
    }

}
