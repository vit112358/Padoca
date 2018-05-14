/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.visao.CadastroFornecedor;

import br.ifmg.edu.trabalho_java_avancado.modelo.Fornecedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vitor
 */
public class FornecedorTableModel extends AbstractTableModel{
    
    private List<Fornecedor> fornecedores;
    
    private String[] colunas = {"ID", "Razao Soc.","Nome Fant.","Endereço","CNPJ","Telefone"};

    public FornecedorTableModel(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public FornecedorTableModel(List<Fornecedor> fornecedores, String[] colunas) {
        this.fornecedores = fornecedores;
        this.colunas = colunas;
    }

    
    @Override
    public int getRowCount() {
        return fornecedores.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return fornecedores.get(rowIndex).getID();
            case 1 : return fornecedores.get(rowIndex).getRazaoSocial();
            case 2 : return fornecedores.get(rowIndex).getNomeFantasia();
            case 3 : return fornecedores.get(rowIndex).getEndereco();
            case 4 : return fornecedores.get(rowIndex).getCNPJ();
            case 5 : return fornecedores.get(rowIndex).getTelefone();            
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue == null) 
            return;
        
        switch (columnIndex){
            case 0 : fornecedores.get(rowIndex).setID((Integer)aValue);break;
            case 1 : fornecedores.get(rowIndex).setRazaoSocial((String)aValue);break;
            case 2 : fornecedores.get(rowIndex).setNomeFantasia((String)aValue);break;
            case 3 : fornecedores.get(rowIndex).setEndereco((String)aValue);break;
            case 4 : fornecedores.get(rowIndex).setCNPJ((String) aValue);break;
            case 5 : fornecedores.get(rowIndex).setTelefone((String)aValue);break;                        
        }      
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(Fornecedor a){
        fornecedores.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(Integer linha){
        fornecedores.remove(linha);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return  colunas[column]; 
    }
    
}
