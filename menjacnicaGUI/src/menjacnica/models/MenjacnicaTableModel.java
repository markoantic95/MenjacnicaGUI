package menjacnica.models;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;


import menjacnica1.Kurs;

public class MenjacnicaTableModel extends AbstractTableModel {

	private String[] kolone = new String[]{"Šifra","Skraæeni naziv","Prodajni","Srednji","Kupovni","Naziv"};
	private LinkedList<Kurs> kursevi;
	
	public MenjacnicaTableModel(LinkedList<Kurs> kursevi) {
		if(kursevi==null){
			this.kursevi = new LinkedList<Kurs>();
		}else{
			this.kursevi=kursevi;
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return kursevi.size();
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
		Kurs k = kursevi.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return k.getSifra();
		case 1:
			return k.getSkraceniNaziv();
		case 2:
			return k.getProdajni();
		case 3:
			return k.getSrednji();
		case 4:			
			return k.getKupovni();
		case 5:
			return k.getNaziv();
		default:
			return "NN";
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}
	public void ucitajKurseve(LinkedList<Kurs> kursevi) {
		this.kursevi=kursevi;
		fireTableDataChanged();
		
	}
	
}
