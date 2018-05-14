/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.visao.CadastroAdm;

import br.ifmg.edu.trabalho_java_avancado.modelo.Adm;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vitor
 */
public class AdmTableModel extends AbstractTableModel{

    private List<Adm> adms;
    private String[] cols ={"ID", "Nome", "Idade", "Login"};

    public AdmTableModel(List<Adm> adms) {
        this.adms = adms;
    }
    
    public AdmTableModel(List<Adm> adms, String[] colunas) {
        this.adms = adms;
        this.cols = colunas;
    }
    
    @Override
    public int getRowCount() {
        return adms.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return adms.get(rowIndex).getID();
            case 1 : return adms.get(rowIndex).getNome();
            case 2 : return adms.get(rowIndex).getIdade();
            case 3 : return adms.get(rowIndex).getLogin();         
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue == null) 
            return;
        
        switch (columnIndex){
            case 0 : adms.get(rowIndex).setId((Integer)aValue);break;
            case 1 : adms.get(rowIndex).setNome((String)aValue);break;
            case 2 : adms.get(rowIndex).setIdade((Integer)aValue);break;
            case 4 : adms.get(rowIndex).setLogin((String) aValue);break;                     
        }      
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(Adm a){
        adms.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(Integer linha){
        adms.remove(linha);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return  cols[column]; 
    }
}
