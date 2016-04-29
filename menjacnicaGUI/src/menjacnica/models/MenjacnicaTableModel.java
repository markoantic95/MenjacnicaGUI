package menjacnica.models;

import javax.swing.table.AbstractTableModel;

public class MenjacnicaTableModel extends AbstractTableModel {

	private String[] kolone = new String[]{"Sifra","Skraceni naziv","Prodajni","Srednji","Kupovni","Naziv"};
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
