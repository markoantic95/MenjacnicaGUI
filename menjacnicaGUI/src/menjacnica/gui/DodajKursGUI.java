package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica1.Kurs;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSifra;
	private JTextField textFieldNaziv;
	private JTextField textFieldProdajni;
	private JTextField textFieldKupovni;
	private JTextField textFieldSrednji;
	private JTextField textFieldSkraceni;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public DodajKursGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			}
		});
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u0160ifra");
		label.setBounds(9, 5, 200, 14);
		label.setPreferredSize(new Dimension(200, 14));
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("Naziv");
		lblNewLabel.setBounds(214, 5, 200, 14);
		lblNewLabel.setPreferredSize(new Dimension(200, 14));
		panel.add(lblNewLabel);
		
		textFieldSifra = new JTextField();
		textFieldSifra.setBounds(10, 24, 200, 20);
		textFieldSifra.setMinimumSize(new Dimension(200, 14));
		textFieldSifra.setMaximumSize(new Dimension(200, 14));
		textFieldSifra.setPreferredSize(new Dimension(200, 20));
		panel.add(textFieldSifra);
		textFieldSifra.setColumns(10);
		
		textFieldNaziv = new JTextField();
		textFieldNaziv.setBounds(214, 24, 200, 20);
		textFieldNaziv.setPreferredSize(new Dimension(200, 20));
		textFieldNaziv.setMaximumSize(new Dimension(200, 14));
		textFieldNaziv.setMinimumSize(new Dimension(200, 14));
		panel.add(textFieldNaziv);
		textFieldNaziv.setColumns(10);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setPreferredSize(new Dimension(200, 14));
		lblProdajniKurs.setBounds(9, 55, 200, 14);
		panel.add(lblProdajniKurs);
		
		JLabel lblKupovniKurs = new JLabel("Kupovni kurs");
		lblKupovniKurs.setPreferredSize(new Dimension(200, 14));
		lblKupovniKurs.setBounds(214, 55, 200, 14);
		panel.add(lblKupovniKurs);
		
		textFieldProdajni = new JTextField();
		textFieldProdajni.setPreferredSize(new Dimension(200, 20));
		textFieldProdajni.setMinimumSize(new Dimension(200, 14));
		textFieldProdajni.setMaximumSize(new Dimension(200, 14));
		textFieldProdajni.setColumns(10);
		textFieldProdajni.setBounds(9, 73, 200, 20);
		panel.add(textFieldProdajni);
		
		textFieldKupovni = new JTextField();
		textFieldKupovni.setPreferredSize(new Dimension(200, 20));
		textFieldKupovni.setMinimumSize(new Dimension(200, 14));
		textFieldKupovni.setMaximumSize(new Dimension(200, 14));
		textFieldKupovni.setColumns(10);
		textFieldKupovni.setBounds(213, 73, 200, 20);
		panel.add(textFieldKupovni);
		
		JLabel lblSrednjiKurs = new JLabel("Srednji kurs");
		lblSrednjiKurs.setPreferredSize(new Dimension(200, 14));
		lblSrednjiKurs.setBounds(9, 104, 200, 14);
		panel.add(lblSrednjiKurs);
		
		JLabel lblKupovniKurs_1 = new JLabel("Skra\u0107eni naziv");
		lblKupovniKurs_1.setPreferredSize(new Dimension(200, 14));
		lblKupovniKurs_1.setBounds(214, 104, 200, 14);
		panel.add(lblKupovniKurs_1);
		
		textFieldSrednji = new JTextField();
		textFieldSrednji.setPreferredSize(new Dimension(200, 20));
		textFieldSrednji.setMinimumSize(new Dimension(200, 14));
		textFieldSrednji.setMaximumSize(new Dimension(200, 14));
		textFieldSrednji.setColumns(10);
		textFieldSrednji.setBounds(9, 122, 200, 20);
		panel.add(textFieldSrednji);
		
		textFieldSkraceni = new JTextField();
		textFieldSkraceni.setPreferredSize(new Dimension(200, 20));
		textFieldSkraceni.setMinimumSize(new Dimension(200, 14));
		textFieldSkraceni.setMaximumSize(new Dimension(200, 14));
		textFieldSkraceni.setColumns(10);
		textFieldSkraceni.setBounds(213, 122, 200, 20);
		panel.add(textFieldSkraceni);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kurs k = new Kurs();
				double kupovni = Double.parseDouble(textFieldKupovni.getText());
				k.setKupovni(kupovni);
				double prodajni = Double.parseDouble(textFieldProdajni.getText());
				k.setProdajni(prodajni);
				double srednji = Double.parseDouble(textFieldSrednji.getText());
				k.setSrednji(srednji);
				k.setNaziv(textFieldNaziv.getText());
				k.setSifra(textFieldSifra.getText());
				k.setSkraceniNaziv(textFieldSkraceni.getText());
				GUIKontroler.dodajUListu(k);
				GUIKontroler.dodaj(k);
				
				dispose();
			}
		});
		btnDodaj.setBounds(10, 190, 199, 23);
		panel.add(btnDodaj);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOdustani.setBounds(214, 190, 200, 23);
		panel.add(btnOdustani);
	}
}
