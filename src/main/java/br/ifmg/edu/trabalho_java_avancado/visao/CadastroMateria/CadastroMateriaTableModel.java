/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.visao.CadastroMateria;

import br.ifmg.edu.trabalho_java_avancado.modelo.Fornecedor;
import br.ifmg.edu.trabalho_java_avancado.modelo.Materia_Prima;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vitor
 */
public class CadastroMateriaTableModel extends AbstractTableModel{

    private List<Materia_Prima> materias_prima;
    
    private String[] colunas ={"Código", "Nome", "Preço", "Estoque", "Est. Mínimo", "Fornecedor"};

    public CadastroMateriaTableModel(List<Materia_Prima> materias_prima) {
        this.materias_prima = materias_prima;
    }
    
    public CadastroMateriaTableModel(List<Materia_Prima> materias_prima, String[] colunas) {
        this.materias_prima = materias_prima;
        this.colunas = colunas;
    }
    
    @Override
    public int getRowCount() {
        return materias_prima.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return materias_prima.get(rowIndex).getID();
            case 1 : return materias_prima.get(rowIndex).getNome();
            case 2 : return materias_prima.get(rowIndex).getPreco();
            case 3 : return materias_prima.get(rowIndex).getEstoque();
            case 4 : return materias_prima.get(rowIndex).getEstoque_min();
            case 5 : return materias_prima.get(rowIndex).getFornecedor();            
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue == null) 
            return;
        
        switch (columnIndex){
            case 0 : materias_prima.get(rowIndex).setID((Integer)aValue);break;
            case 1 : materias_prima.get(rowIndex).setNome((String)aValue);break;
            case 2 : materias_prima.get(rowIndex).setPreco((Float)aValue);break;
            case 3 : materias_prima.get(rowIndex).setEstoque((Float) aValue);break;
            case 4 : materias_prima.get(rowIndex).setEstoque_min((Float) aValue);break;
            case 5 : materias_prima.get(rowIndex).setFornecedor((Fornecedor)aValue);break;                        
        }      
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void addRow(Materia_Prima a){
        materias_prima.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(Integer linha){
        materias_prima.remove(linha);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return  colunas[column]; 
    }
}
