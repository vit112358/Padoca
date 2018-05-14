package br.ifmg.edu.trabalho_java_avancado.visao.Vendas;

import br.ifmg.edu.trabalho_java_avancado.modelo.Venda;
import br.ifmg.edu.trabalho_java_avancado.modelo.Vendedor;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vitor
 */
public class VendaTableModel extends AbstractTableModel {

    private List<Venda> vendas;
    private String[] cols = {"ID", "Vendedor", "Data Venda", "Preço Venda"};

    public VendaTableModel(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public VendaTableModel(List<Venda> vendas, String[] cols) {
        this.vendas = vendas;
        this.cols = cols;
    }

    @Override
    public int getRowCount() {
        return vendas.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return vendas.get(rowIndex).getID();
            case 1 : return vendas.get(rowIndex).getVendedor().getNome();
            case 2 : return vendas.get(rowIndex).getDataVenda();
            case 3 : return vendas.get(rowIndex).getPrecoVenda();
                        
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue == null) 
            return;
        
        switch (columnIndex){
            case 0 : vendas.get(rowIndex).setID((Integer)aValue);break;
            case 1 : vendas.get(rowIndex).setVendedor((Vendedor)aValue);break;
            case 2 : vendas.get(rowIndex).setDataVenda((Date)aValue);break;
            case 3 : vendas.get(rowIndex).setPrecoVenda((Float) aValue);break;                     
        }      
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(Venda a){
        vendas.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(Integer linha){
        vendas.remove(linha);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return  cols[column]; 
    }
}
