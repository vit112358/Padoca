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
public class ItemProducao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name = "Cod_producao")
    private Producao producao;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name = "codProduto")
    private ProdutoProduzido item;
    
    @Column(nullable = false)
    private Integer Qtde;

    public ItemProducao() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    public ProdutoProduzido getProd() {
        return item;
    }

    public void setProd(ProdutoProduzido prod) {
        this.item = prod;
    }

    public Integer getQtde() {
        return Qtde;
    }

    public void setQtde(Integer Qtde) {
        this.Qtde = Qtde;
    }

    @Override
    public String toString() {
        return "ItemProducao{" + "ID=" + ID + ", producao=" + producao + ", prod=" + item + ", Qtde=" + Qtde + '}';
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
        final ItemProducao other = (ItemProducao) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }
    
    
}
