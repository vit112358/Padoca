package br.ifmg.edu.trabalho_java_avancado.modelo;

import java.util.List;
import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Vitor
 */
@Entity
@DiscriminatorValue("Produto_Produzido")
public class ProdutoProduzido extends Produto{
    
    private Float precoCusto;
    private Float precoVenda;
    
    private Integer Estoque;
    private Integer EstoqueMin;
    
    @ManyToMany
    private List<Materia_Prima> materiaisUsados;
    
    public ProdutoProduzido() {
    }

    public ProdutoProduzido(Float precoCusto, Float precoVenda, List<Materia_Prima> materiaisUsados, Integer Id, String Nome, Integer estoque, Integer estoqueMin) {
        super(Id, Nome);
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.materiaisUsados = materiaisUsados;
        this.Estoque = estoque;
        this.EstoqueMin = estoqueMin;
    }

    @Override
    public String toString() {
        return "Produtos_Produzidos{" + "precoCusto=" + precoCusto + ", precoVenda=" + precoVenda + ", materiaisUsados=" + materiaisUsados + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.precoCusto);
        hash = 37 * hash + Objects.hashCode(this.precoVenda);
        hash = 37 * hash + Objects.hashCode(this.materiaisUsados);
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
        final ProdutoProduzido other = (ProdutoProduzido) obj;
        return true;
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

    public List<Materia_Prima> getMateriaisUsados() {
        return materiaisUsados;
    }

    public void setMateriaisUsados(List<Materia_Prima> materiaisUsados) {
        this.materiaisUsados = materiaisUsados;
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
}
