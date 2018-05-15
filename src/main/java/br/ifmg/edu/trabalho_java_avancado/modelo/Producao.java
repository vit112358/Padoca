package br.ifmg.edu.trabalho_java_avancado.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vitor
 */

@Entity
public class Producao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Producao_Id")
    private Integer codigo;
    
    @Temporal(TemporalType.DATE)
    private Date DataProducao;
    
    @OneToMany(mappedBy = "producao",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<ItemProducao> itens = new LinkedList<ItemProducao>();

    public Producao() {
    }

    public Integer getId() {
        return codigo;
    }

    public void setId(Integer id) {
        this.codigo = id;
    }

    public Date getDataProducao() {
        return DataProducao;
    }

    public void setDataProducao(Date DataProducao) {
        this.DataProducao = DataProducao;
    }

    public List<ItemProducao> getProdutos_feitos() {
        return itens;
    }

    public void setProdutos_feitos(List<ItemProducao> produtos_feitos) {
        this.itens = produtos_feitos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codigo);
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
        final Producao other = (Producao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producao{" + "id=" + codigo + ", DataProducao=" + DataProducao + ", produtos_feitos=" + itens + '}';
    }
    
    
}
