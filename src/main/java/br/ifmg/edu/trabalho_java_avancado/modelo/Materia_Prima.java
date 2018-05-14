/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.modelo;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Vitor
 */

@Entity
public class Materia_Prima implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Materia_Id")
    private Integer ID;
    
    @NotNull
    private String nome;//Descriçao
    private Float preco;
    private Float estoque;
    private Float estoque_min;
    
    @ManyToOne
    @JoinColumn(name = "codFornecedor")
    private Fornecedor fornecedor;

    public Materia_Prima() {
    }

    public Materia_Prima(Integer ID, String Nome, Float preco, Float estoque, Float estoque_min) {
        this.ID = ID;
        this.nome = Nome;
        this.preco = preco;
        this.estoque = estoque;
        this.estoque_min = estoque_min;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getEstoque() {
        return estoque;
    }

    public void setEstoque(Float estoque) {
        this.estoque = estoque;
    }

    public Float getEstoque_min() {
        return estoque_min;
    }

    public void setEstoque_min(Float estoque_min) {
        this.estoque_min = estoque_min;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.ID);
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.preco);
        hash = 17 * hash + Objects.hashCode(this.estoque);
        hash = 17 * hash + Objects.hashCode(this.estoque_min);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia_Prima other = (Materia_Prima) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }    
}
