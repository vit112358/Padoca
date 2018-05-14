package br.ifmg.edu.trabalho_java_avancado.visao.CadastroProdTerceiros;

import br.ifmg.edu.trabalho_java_avancado.modelo.ProdutosTerceiros;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vitor
 */
public class ProdTercTableModel extends AbstractTableModel{
    
    private List<ProdutosTerceiros> prods;
    private String[] cols = {"Codigo","Nome", "Preço Custo", "Preço Venda", "Estoque", "Estoque Mín"};

    public ProdTercTableModel(List<ProdutosTerceiros> prods) {
        this.prods = prods;
    }

    public ProdTercTableModel(List<ProdutosTerceiros> prods, String[] cols) {
        this.prods = prods;
        this.cols = cols;
    }
    
    @Override
    public int getRowCount() {
        return prods.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return prods.get(rowIndex).getID();
            case 1 : return prods.get(rowIndex).getNome();
            case 2 : return prods.get(rowIndex).getPrecoCusto();
            case 3 : return prods.get(rowIndex).getPrecoVenda();
            case 4 : return prods.get(rowIndex).getEstoque();
            case 5 : return prods.get(rowIndex).getEstoqueMin();
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue == null) 
            return;
        
        switch (columnIndex){
            case 0 : prods.get(rowIndex).setID((Integer)aValue);break;
            case 1 : prods.get(rowIndex).setNome((String)aValue);break;
            case 2 : prods.get(rowIndex).setPrecoCusto((Float)aValue);break;
            case 3 : prods.get(rowIndex).setPrecoVenda((Float)aValue);break;
            case 4 : prods.get(rowIndex).setEstoque((Integer)aValue);break;
            case 5 : prods.get(rowIndex).setEstoqueMin((Integer)aValue);break;
        }      
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(ProdutosTerceiros a){
        prods.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(Integer linha){
        prods.remove(linha);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return  cols[column]; 
    }
}
