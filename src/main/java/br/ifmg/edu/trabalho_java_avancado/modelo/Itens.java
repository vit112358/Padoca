/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.modelo;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Vitor
 */
public class Itens {
    private Integer ID;
    private Materia_Prima materiais;
    private Float Qtde;

    public Itens() {
    }

    public Itens(Integer ID, Materia_Prima materiais, Float Qtde) {
        this.ID = ID;
        this.materiais = materiais;
        this.Qtde = Qtde;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Materia_Prima getMateriais() {
        return materiais;
    }

    public void setMateriais(Materia_Prima materiais) {
        this.materiais = materiais;
    }

    public Float getQtde() {
        return Qtde;
    }

    public void setQtde(Float Qtde) {
        this.Qtde = Qtde;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.ID);
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
        final Itens other = (Itens) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

}
