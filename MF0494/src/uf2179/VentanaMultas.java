package uf2179;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaMultas extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JLabel lblCantidadImporte;
	private JTextArea textResultado;
	private static JComboBox comboSancion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMultas frame = new VentanaMultas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][][][grow]"));
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(lblMatricula, "cell 0 0,alignx trailing");
		
		textMatricula = new JTextField();
		contentPane.add(textMatricula, "flowx,cell 1 0,growx");
		textMatricula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(lblNombre, "cell 2 0,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		contentPane.add(textNombre, "cell 3 0,growx");
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(lblApellidos, "cell 0 1,alignx trailing");
		
		textApellidos = new JTextField();
		contentPane.add(textApellidos, "cell 1 1,growx");
		textApellidos.setColumns(10);
		
		JLabel lblSancion = new JLabel("Sanci\u00F3n:");
		lblSancion.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(lblSancion, "cell 0 2,alignx trailing");
		
		comboSancion = new JComboBox();
		comboSancion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cambiaLabel();
			}
		});
		comboSancion.setModel(new DefaultComboBoxModel(new String[] {"No llevar casco", "Conduccion temeraria"}));
		contentPane.add(comboSancion, "cell 1 2,growx");
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(lblImporte, "cell 0 3");
		
		lblCantidadImporte = new JLabel("------");
		lblCantidadImporte.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(lblCantidadImporte, "cell 1 3");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				String apellidos = textApellidos.getText();
				String infraccion = (String) comboSancion.getSelectedItem();
				int importe;
				if (infraccion =="No llevar casco") {
					importe = 200;
				}else {
					importe = 500;
				}
				double prontopago = calculaProntoPago(importe);
				textResultado.setText("Conductor: " + nombre + " " + apellidos + "\n" +
										"Infraccion: " + infraccion + "\n" +
										"Importe: " + "\n" + 
										"Pronto pago: " + prontopago);
			}
		});
		contentPane.add(btnAceptar, "cell 2 4");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 5 3 1,grow");
		
		textResultado = new JTextArea();
		scrollPane.setViewportView(textResultado);
	}
	
	public double calculaProntoPago(int importe) {
		return importe/2;
	}
	
	public void cambiaLabel() {
		String seleccionado = (String) comboSancion.getSelectedItem();
		if (seleccionado.equals("No llevar casco")) {
			lblCantidadImporte.setText("200");
		} else {
			lblCantidadImporte.setText("500");
		}
	}

}
