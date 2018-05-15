package br.ifmg.edu.trabalho_java_avancado.modelo;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Vitor
 */

@Entity
public class Fornecedor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Fornecedor_Id")
    private Integer ID;
    
    @NotNull
    private String razaoSocial;
    private String nomeFantasia;
    private String endereco;
    
    @NotNull
    private String CNPJ;
    private String Telefone;
    
    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
    private List<Materia_Prima> materias;
    
    @OneToMany(mappedBy = "fornecedor_prod", fetch = FetchType.LAZY)
    private List<ProdutoTerceiros> produtos;

    public Fornecedor() {
    }

    public Fornecedor(Integer ID, String razaoSocial, String nomeFantasia, String endereco, String CNPJ, String Telefone) {
        this.ID = ID;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
        this.CNPJ = CNPJ;
        this.Telefone = Telefone;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
    
    public List<Materia_Prima> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia_Prima> materias) {
        this.materias = materias;
    }

    /*
    public List<ProdutosTerceiros> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutosTerceiros> produtos) {
        this.produtos = produtos;
    }
    */
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.ID);
        hash = 29 * hash + Objects.hashCode(this.razaoSocial);
        hash = 29 * hash + Objects.hashCode(this.nomeFantasia);
        hash = 29 * hash + Objects.hashCode(this.endereco);
        hash = 29 * hash + Objects.hashCode(this.CNPJ);
        hash = 29 * hash + Objects.hashCode(this.Telefone);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return razaoSocial;
    }
}
