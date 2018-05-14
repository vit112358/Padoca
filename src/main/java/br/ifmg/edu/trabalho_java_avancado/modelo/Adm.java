/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Vitor
 */

@Entity
@DiscriminatorValue("Adm")
public class Adm extends Funcionario{

    public Adm() {
    }

    public Adm(Integer Id, String Nome, Integer Idade, String login, String senha) {
        super(Id, Nome, Idade, login, senha);
    }

    @Override
    public String toString() {
        return super.getNome();
    }
   
}
