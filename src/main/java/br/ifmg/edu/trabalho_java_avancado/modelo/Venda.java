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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Venda_Id")
    private Integer ID;
    
    @OneToMany(mappedBy = "venda",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<VendaProduto> itens = new LinkedList<VendaProduto>();
    
    @ManyToOne
    @JoinColumn(name = "codVendedor")
    private Vendedor vendedor;
    
    @Temporal(TemporalType.DATE)
    private Date DataVenda;
    private Float PrecoVenda;
    
    public Venda() {
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Date getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(Date DataVenda) {
        this.DataVenda = DataVenda;
    }

    public Float getPrecoVenda() {
        return PrecoVenda;
    }

    public void setPrecoVenda(Float PrecoVenda) {
        this.PrecoVenda = PrecoVenda;
    }

    public List<VendaProduto> getItens() {
        return itens;
    }

    public void setItens(List<VendaProduto> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Venda{" + "ID=" + ID + ", itens=" + itens + ", vendedor=" + vendedor + ", DataVenda=" + DataVenda + ", PrecoVenda=" + PrecoVenda + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.ID);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }
}
