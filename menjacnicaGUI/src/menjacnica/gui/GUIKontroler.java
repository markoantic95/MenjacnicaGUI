package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.models.MenjacnicaTableModel;
import menjacnica1.Kurs;

public class GUIKontroler {

	private JPanel contentPane;
	private static MenjacnicaGUI menjacnica;
	private static LinkedList<Kurs> kursevi = new LinkedList<Kurs>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new MenjacnicaGUI();
					menjacnica.setVisible(true);
					menjacnica.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void otvoriDijalogUcitaj() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(menjacnica.getContentPane());

			if (returnVal == fc.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				menjacnica.azurirajStatusUcitaniFajl(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(menjacnica.getContentPane(), e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public static void otvoriDijalogSacuvaj() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(menjacnica.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				menjacnica.azurirajStatusSacuvaniFajl(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(menjacnica.getContentPane(), e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void otvoriDijalogZatvori() {
		int opcija = JOptionPane.showConfirmDialog(menjacnica.getContentPane(), "Da li zelite da zatvorite program?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_CANCEL_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}

	public static void otvoriDijalogAbout() {
		JOptionPane.showMessageDialog(menjacnica.getContentPane(), "Marko Antiæ");
		
	}

	public static void otvoriProzorZaDodavanje() {
		DodajKursGUI dodaj = new DodajKursGUI();
		dodaj.setVisible(true);
		dodaj.setLocationRelativeTo(null);
	}

	public static void dodaj(Kurs k) {
		menjacnica.ispisKursa(k);
		menjacnica.osveziTabelu();
		
	}

	public static LinkedList<Kurs> vratiSveKurseve() {
		return kursevi;
		
	}

	public static void dodajUListu(Kurs k) {
		kursevi.add(k);
		
	}
	

}
