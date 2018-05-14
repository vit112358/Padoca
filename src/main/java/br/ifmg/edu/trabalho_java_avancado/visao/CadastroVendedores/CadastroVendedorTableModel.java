package br.ifmg.edu.trabalho_java_avancado.visao.CadastroVendedores;

import br.ifmg.edu.trabalho_java_avancado.modelo.Vendedor;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vitor
 */
public class CadastroVendedorTableModel extends AbstractTableModel{
    
    private List<Vendedor> vendedores;
    
    private String[] colunas ={"Código","Nome","Idade",
                               "Login","Data de Admissão"};

    public CadastroVendedorTableModel(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }
    
    public CadastroVendedorTableModel(List<Vendedor> vendedores, String[] colunas) {
        this.vendedores = vendedores;
        this.colunas = colunas;
    }
    
    @Override
    public int getRowCount() {
        return vendedores.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return vendedores.get(rowIndex).getID();
            case 1 : return vendedores.get(rowIndex).getNome();
            case 2 : return vendedores.get(rowIndex).getIdade();
            case 3 : return vendedores.get(rowIndex).getLogin();
            case 4 : return vendedores.get(rowIndex).getDataAdmissão();            
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue == null) 
            return;
        
        switch (columnIndex){
            case 0 : vendedores.get(rowIndex).setId((Integer)aValue);break;
            case 1 : vendedores.get(rowIndex).setNome((String)aValue);break;
            case 2 : vendedores.get(rowIndex).setIdade((Integer)aValue);break;
            case 3 : vendedores.get(rowIndex).setLogin((String) aValue);break;
            case 4 : vendedores.get(rowIndex).setDataAdmissão((Date)aValue);break;                        
        }      
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    public void addRow(Vendedor a){
        vendedores.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(Integer linha){
        vendedores.remove(linha);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return  colunas[column]; 
    }
    
}
