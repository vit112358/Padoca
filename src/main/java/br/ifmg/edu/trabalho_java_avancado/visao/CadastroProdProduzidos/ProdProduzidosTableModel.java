package br.ifmg.edu.trabalho_java_avancado.visao.CadastroProdProduzidos;

import br.ifmg.edu.trabalho_java_avancado.modelo.ProdutosProduzidos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vitor
 */
public class ProdProduzidosTableModel extends AbstractTableModel{

    private List<ProdutosProduzidos> prodProduzidos;
    private String[] cols = {"Código", "Nome", "Preço Custo", "Preço Venda", "Estoque", "Estoque Mín"};

    public ProdProduzidosTableModel(List<ProdutosProduzidos> prodProduzidos) {
        this.prodProduzidos = prodProduzidos;
    }
    
    public ProdProduzidosTableModel(List<ProdutosProduzidos> prodProduzidos, String[] cols) {
        this.prodProduzidos = prodProduzidos;
        this.cols = cols;
    }
    
    @Override
    public int getRowCount() {
        return prodProduzidos.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return prodProduzidos.get(rowIndex).getID();
            case 1 : return prodProduzidos.get(rowIndex).getNome();
            case 2 : return prodProduzidos.get(rowIndex).getPrecoCusto();
            case 3 : return prodProduzidos.get(rowIndex).getPrecoVenda();
            case 4 : return prodProduzidos.get(rowIndex).getEstoque();
            case 5 : return prodProduzidos.get(rowIndex).getEstoqueMin();
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue == null) 
            return;
        
        switch (columnIndex){
            case 0 : prodProduzidos.get(rowIndex).setID((Integer)aValue);break;
            case 1 : prodProduzidos.get(rowIndex).setNome((String)aValue);break;
            case 2 : prodProduzidos.get(rowIndex).setPrecoCusto((Float)aValue);break;
            case 3 : prodProduzidos.get(rowIndex).setPrecoVenda((Float)aValue);break;
            case 4 : prodProduzidos.get(rowIndex).setEstoque((Integer)aValue);break;
            case 5 : prodProduzidos.get(rowIndex).setEstoqueMin((Integer)aValue);break;
        }      
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(ProdutosProduzidos a){
        prodProduzidos.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(Integer linha){
        prodProduzidos.remove(linha);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return  cols[column]; 
    }
    
}
