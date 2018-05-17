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
public class Itens implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name = "codProduto")
    private ProdutoProduzido produto;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name = "codMateria")
    private Materia_Prima mp;
    
    @Column(nullable = false)
    private Integer qtde;

    public Itens() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public ProdutoProduzido getProduto() {
        return produto;
    }

    public void setProduto(ProdutoProduzido produto) {
        this.produto = produto;
    }

    public Materia_Prima getMp() {
        return mp;
    }

    public void setMp(Materia_Prima mp) {
        this.mp = mp;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.ID);
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

    @Override
    public String toString() {
        return "Itens{" + "ID=" + ID + ", produto=" + produto + ", mp=" + mp + ", qtde=" + qtde + '}';
    }

}
