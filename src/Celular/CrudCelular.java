package Celular;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class CrudCelular {

	private JFrame frmCelular;
	private JLabel lblId;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblSistema;
	private JLabel lblProcesador;
	private JTextField txtId;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtSistema;
	private JTextField txtProcesador;
	private JButton btnBorrar;
	Celular cel=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudCelular window = new CrudCelular();
					window.frmCelular.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrudCelular() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCelular = new JFrame();
		frmCelular.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\1698764131163.jpg"));
		frmCelular.setTitle("CrudCelular");
		frmCelular.setBounds(100, 100, 411, 251);
		frmCelular.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCelular.getContentPane().setLayout(null);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(10, 11, 116, 23);
		frmCelular.getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtId.getText().length()>11) {
					e.consume();
				}
				
			}
		});
		txtId.setBounds(132, 11, 103, 20);
		frmCelular.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtMarca.getText().length()>50) {
					e.consume();
				}
			}
		});
		txtMarca.setColumns(10);
		txtMarca.setBounds(132, 45, 103, 20);
		frmCelular.getContentPane().add(txtMarca);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMarca.setBounds(10, 45, 116, 23);
		frmCelular.getContentPane().add(lblMarca);
		
		txtModelo = new JTextField();
		txtModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtModelo.getText().length()>50) {
					e.consume();
				}
			}
		});
		txtModelo.setColumns(10);
		txtModelo.setBounds(132, 77, 103, 20);
		frmCelular.getContentPane().add(txtModelo);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo.setBounds(10, 77, 116, 23);
		frmCelular.getContentPane().add(lblModelo);
		
		txtSistema = new JTextField();
		txtSistema.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtSistema.getText().length()>30) {
					e.consume();
				}
			}
		});
		txtSistema.setColumns(10);
		txtSistema.setBounds(132, 109, 103, 20);
		frmCelular.getContentPane().add(txtSistema);
		
		lblSistema = new JLabel("Sistema");
		lblSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistema.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSistema.setBounds(10, 109, 116, 23);
		frmCelular.getContentPane().add(lblSistema);
		
		txtProcesador = new JTextField();
		txtProcesador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtProcesador.getText().length()>30) {
					e.consume();
				}
			}
		});
		txtProcesador.setColumns(10);
		txtProcesador.setBounds(132, 141, 103, 20);
		frmCelular.getContentPane().add(txtProcesador);
		
		lblProcesador = new JLabel("Procesador");
		lblProcesador.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcesador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProcesador.setBounds(10, 141, 116, 23);
		frmCelular.getContentPane().add(lblProcesador);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\add (1).png"));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Celular x=new Celular();
				
				x.setId(Integer.parseInt(txtId.getText()));
				x.setMarca(txtMarca.getText());
				x.setModelo(txtModelo.getText());
				x.setSistema(txtSistema.getText());
				x.setProcesador(txtProcesador.getText());
				if(x.insertarCel()) {
					JOptionPane.showMessageDialog(null, "Inserto Correctamente");
				}else {
				JOptionPane.showMessageDialog(null, "Error ");
				}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "Error Try");
				}
			}
		});
		btnAgregar.setBounds(245, 11, 125, 23);
		frmCelular.getContentPane().add(btnAgregar);
		
		JButton btnElimanar = new JButton("Eliminar");
		btnElimanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int Idcel=Integer.parseInt(JOptionPane.showInputDialog("ID a cargar"));
					cel.setId(Idcel);
					if(cel.eliminarCel()) {
						JOptionPane.showMessageDialog(null, "good");
					}else {
						JOptionPane.showMessageDialog(null, "Error ");
					}
			}catch(Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error ");
			}
			}
		});
		btnElimanar.setBounds(245, 43, 125, 23);
		frmCelular.getContentPane().add(btnElimanar);
		
		JButton btnEditar = new JButton("Edtiar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cel.setMarca(txtMarca.getText());
					cel.setModelo(txtModelo.getText());
				    cel.setSistema(txtSistema.getText());
					cel.setProcesador(txtProcesador.getText());
					if(cel.actualizarCel()) {
						JOptionPane.showMessageDialog(null, "Inserto Correctamente");
					}else {
					JOptionPane.showMessageDialog(null, "Error ");
					}
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Error Try");
					}
			}
		});
		btnEditar.setBounds(245, 75, 125, 23);
		frmCelular.getContentPane().add(btnEditar);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
					int Idcel=Integer.parseInt(JOptionPane.showInputDialog("ID a cargar"));
					cel.setId(Idcel);
					if(cel.cargarCel()) {
						txtId.setText(""+cel.getId());
						txtMarca.setText(cel.getMarca());
						txtModelo.setText(cel.getModelo());
						txtProcesador.setText(cel.getProcesador());
						txtSistema.setText(cel.getSistema());
						JOptionPane.showMessageDialog(null, "good");
					}else {
						JOptionPane.showMessageDialog(null, "Error ");
					}
			}catch(Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error ");
			}
			}
		});
		btnCargar.setBounds(245, 107, 125, 23);
		frmCelular.getContentPane().add(btnCargar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		btnBorrar.setBounds(245, 140, 125, 23);
		frmCelular.getContentPane().add(btnBorrar);
	}
	public void limpiarFormulario() {
		txtId.setText("");
		txtModelo.setText("");
		txtMarca.setText("");
		txtSistema.setText("");
		txtProcesador.setText("");
	}
}
