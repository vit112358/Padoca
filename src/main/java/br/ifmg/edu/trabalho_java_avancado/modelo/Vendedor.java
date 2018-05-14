/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.modelo;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Vitor
 */

@Entity
@DiscriminatorValue("Vendedor")
public class Vendedor extends Funcionario{
    
    
    
    @Temporal(TemporalType.DATE)
    private Date dataAdmissão;

    public Vendedor() {
    }

    public Vendedor(Date dataAdmissão, Integer Id, String Nome, Integer Idade, String login, String senha) {
        super(Id, Nome, Idade, login, senha);
        this.dataAdmissão = dataAdmissão;
    }

    public Date getDataAdmissão() {
        return dataAdmissão;
    }

    public void setDataAdmissão(Date dataAdmissão) {
        this.dataAdmissão = dataAdmissão;
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
    
    
}
