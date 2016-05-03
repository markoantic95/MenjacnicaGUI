	package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.ButtonGroup;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldKupovni;
	private JTextField textFieldProdajni;
	private JTextField textFieldIznos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	
	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setResizable(false);
		setTitle("Izvr\u0161i zamenu");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblI = new JLabel("Kupovni kurs");
		lblI.setBounds(25, 22, 86, 14);
		panel.add(lblI);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setBounds(289, 22, 86, 14);
		panel.add(lblProdajniKurs);
		
		textFieldKupovni = new JTextField();
		textFieldKupovni.setEditable(false);
		textFieldKupovni.setBounds(25, 54, 86, 20);
		panel.add(textFieldKupovni);
		textFieldKupovni.setColumns(10);
		
		textFieldProdajni = new JTextField();
		textFieldProdajni.setEditable(false);
		textFieldProdajni.setBounds(289, 54, 86, 20);
		panel.add(textFieldProdajni);
		textFieldProdajni.setColumns(10);
		
		JLabel lblIznos = new JLabel("Iznos");
		lblIznos.setBounds(25, 106, 76, 14);
		panel.add(lblIznos);
		
		textFieldIznos = new JTextField();
		textFieldIznos.setColumns(10);
		textFieldIznos.setBounds(25, 131, 86, 20);
		panel.add(textFieldIznos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "CHF"}));
		comboBox.setBounds(172, 54, 62, 20);
		panel.add(comboBox);
		
		JRadioButton rdbtnKupovina = new JRadioButton("Kupovina");
		buttonGroup.add(rdbtnKupovina);
		rdbtnKupovina.setBounds(266, 116, 109, 23);
		panel.add(rdbtnKupovina);
		
		JRadioButton rdbtnProdaja = new JRadioButton("Prodaja");
		buttonGroup.add(rdbtnProdaja);
		rdbtnProdaja.setBounds(266, 139, 109, 23);
		panel.add(rdbtnProdaja);
		
		JLabel lblVrstaTransakcije = new JLabel("Vrsta transakcije");
		lblVrstaTransakcije.setBounds(266, 95, 93, 14);
		panel.add(lblVrstaTransakcije);
		
		JButton btnIzvrsiZamenu = new JButton("Izvr\u0161i zamenu");
		btnIzvrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vrsta = "";
				if(rdbtnKupovina.isSelected()){
					vrsta= rdbtnKupovina.getText().toLowerCase();
				}else if (rdbtnProdaja.isSelected()){ 
					vrsta = rdbtnProdaja.getText().toLowerCase();
				}else{ 
					JOptionPane.showMessageDialog(contentPane, "Niste izabrali vrstu transakcije!");
					return;
				}
				String iznos = textFieldIznos.getText();
				if(iznos.isEmpty()){
					JOptionPane.showMessageDialog(contentPane, "Niste uneli iznos!");
					return;
				}
				String valuta = comboBox.getSelectedItem().toString();
				String tekst = "Naziv valute: "+ valuta+ ", iznos: "+iznos+ ", vrsta transakcije: "+vrsta+".\n";
				GUIKontroler.getMenjacnica().ispisiPoruku(tekst);
				dispose();
			}
		});
		btnIzvrsiZamenu.setBounds(25, 220, 130, 30);
		panel.add(btnIzvrsiZamenu);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOdustani.setBounds(270, 220, 130, 30);
		panel.add(btnOdustani);
		
		JSlider slider = new JSlider();
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textFieldIznos.setText(""+slider.getValue());
			}
		});
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(10);
		slider.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		slider.setBounds(25, 162, 375, 45);
		panel.add(slider);
		
	}
}
