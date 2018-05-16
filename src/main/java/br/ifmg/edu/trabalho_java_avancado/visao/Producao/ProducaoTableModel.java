package br.ifmg.edu.trabalho_java_avancado.visao.Producao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Producao;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vitor
 */
public class ProducaoTableModel extends AbstractTableModel{
    
    private List<Producao> producao;
    private List<Integer> num_itens;
    private String[] cols ={"Código", "Data_Produção", "n° Itens"};

    public ProducaoTableModel(List<Producao> producao, List<Integer> num_itens) {
        this.producao = producao;
        this.num_itens = num_itens;
    }
    
    public ProducaoTableModel(List<Producao> producao, List<Integer> num_itens, String[] cols) {
        this.producao = producao;
        this.num_itens = num_itens;
        this.cols = cols;
    }
    
    @Override
    public int getRowCount() {
        return producao.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return producao.get(rowIndex).getId();
            case 1 : return producao.get(rowIndex).getDataProducao();
            case 2 : return num_itens.get(rowIndex);     
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue == null) 
            return;
        
        switch (columnIndex){
            case 0 : producao.get(rowIndex).setId((Integer)aValue);break;
            case 1 : producao.get(rowIndex).setDataProducao((Date)aValue);break;
            case 2 : num_itens.add((Integer)aValue);break;                      
        }      
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void addRow(Producao a){
        producao.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(Integer linha){
        producao.remove(linha);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return  cols[column]; 
    }
}
