package br.ifmg.edu.trabalho_java_avancado.visao.CadastroProdProduzidos;

import br.ifmg.edu.trabalho_java_avancado.modelo.Itens;
import br.ifmg.edu.trabalho_java_avancado.modelo.Materia_Prima;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vitor
 */
public class ItemTableModel extends AbstractTableModel {

    private List<Itens> materiais;
    private String[] cols = {"Código", "Nome", "Quantidade"};

    public ItemTableModel(List<Itens> materiais) {
        this.materiais = materiais;
    }

    public ItemTableModel(List<Itens> materiais, String[] cols) {
        this.materiais = materiais;
        this.cols = cols;
    }

    @Override
    public int getRowCount() {
        return materiais.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return materiais.get(rowIndex).getID();
            case 1:
                return materiais.get(rowIndex).getMp();
            case 2:
                return materiais.get(rowIndex).getQtde();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue == null) {
            return;
        }

        switch (columnIndex) {
            case 0:
                materiais.get(rowIndex).setID((Integer) aValue);
                break;
            case 1:
                materiais.get(rowIndex).setMp((Materia_Prima) aValue);
                break;
            case 2:
                materiais.get(rowIndex).setQtde((Integer) aValue);
                break;
        }
        this.fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void addRow(Itens a) {
        materiais.add(a);
        this.fireTableDataChanged();
    }

    public void removeRow(Integer linha) {
        materiais.remove(linha);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
}
