package Celular;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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
	public JButton btnPDf;
	Celular cel=new Celular();
	ArrayList<Celular> listaCelulares=new ArrayList<Celular>();

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
		frmCelular.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmCelular.setTitle("CrudCelular");
		frmCelular.setBounds(100, 100, 468, 329);
		frmCelular.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCelular.getContentPane().setLayout(null);
		
		lblId = new JLabel("ID");
		lblId.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15));
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
		lblMarca.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15));
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
		lblModelo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15));
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
		lblSistema.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15));
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
		lblProcesador.setFont(new java.awt.Font("Tahoma", Font.BOLD, 15));
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
		btnAgregar.setBounds(10, 172, 132, 59);
		frmCelular.getContentPane().add(btnAgregar);
		
		JButton btnElimanar = new JButton("Eliminar");
		btnElimanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int Idcel=Integer.parseInt(JOptionPane.showInputDialog("ID a eliminar"));
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
		btnElimanar.setBounds(253, 77, 132, 59);
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
						JOptionPane.showMessageDialog(null, "Editado Correctamente");
					}else {
					JOptionPane.showMessageDialog(null, "Error ");
					}
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Error Try");
					}
			}
		});
		btnEditar.setBounds(152, 172, 134, 59);
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
		btnCargar.setBounds(253, 11, 132, 59);
		frmCelular.getContentPane().add(btnCargar);
		
		btnPDf = new JButton("PDF");
		btnPDf.setBorder(null);
		btnPDf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarPDF();
			}
		});
        btnPDf.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\descarga (1) (1).png"));
        btnPDf.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        btnPDf.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPDf.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnPDf.setHorizontalAlignment(SwingConstants.CENTER);
        btnPDf.setBounds(296, 141, 97, 93);
        frmCelular.getContentPane().add(btnPDf);
	}
	public void generarPDF() {
        try {
               FileOutputStream archivo;
               //RUTA ABSOLUTA
               File file = new File("C:\\Users\\Alumno\\Documents\\kiss15\\practicassegundoparcial\\Proyecto\\src\\PDF\\PDF.pdf");
               //RUTA RELATIVA
//               File file = new File("pdf/reporteUsuario.pdf");
               //JOptionPane.showMessageDialog(frmCrudCelular, "Ruta Path:" + file.getPath());
               //JOptionPane.showMessageDialog(frmCrudCelular, "Ruta Absoluta:" + file.getAbsolutePath());
               //JOptionPane.showMessageDialog(frmCrudCelular, "Ruta Canonica:" + file.getCanonicalPath());
               archivo = new FileOutputStream(file);
               Document doc = new Document();
               PdfWriter.getInstance(doc, archivo);
               doc.open();
              Image img = Image.getInstance("C:\\\\Users\\\\Alumno\\\\Downloads\\\\descarga (1) (1).png");
//               Image img = Image.getInstance(getClass().getResource("/imagenes/logooxxo.png"));
               img.setAlignment(Element.ALIGN_CENTER);
               img.scaleToFit(50, 50);
               doc.add(img);
               Paragraph p = new Paragraph(10);
               Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
               p.add(Chunk.NEWLINE);
               p.add("CONTROL DE CELULARES");
               p.add(Chunk.NEWLINE);
               p.add(Chunk.NEWLINE);
               p.setAlignment(Element.ALIGN_CENTER);
               doc.add(p);
               //Tabla de datos
               PdfPTable tabla = new PdfPTable(5);
               tabla.setWidthPercentage(100);
               PdfPCell c1 = new PdfPCell(new Phrase("ID CEL", negrita));
               PdfPCell c2 = new PdfPCell(new Phrase("MARCA", negrita));
               PdfPCell c3 = new PdfPCell(new Phrase("MODELO", negrita));
               PdfPCell c4 = new PdfPCell(new Phrase("SISTEMA", negrita));
               PdfPCell c5 = new PdfPCell(new Phrase("PROCESADOR", negrita));
               c1.setHorizontalAlignment(Element.ALIGN_CENTER);
               c2.setHorizontalAlignment(Element.ALIGN_RIGHT);
               c3.setHorizontalAlignment(Element.ALIGN_CENTER);
               c4.setHorizontalAlignment(Element.ALIGN_CENTER);
               c5.setHorizontalAlignment(Element.ALIGN_CENTER);
               c1.setBackgroundColor(BaseColor.PINK);
               c2.setBackgroundColor(BaseColor.BLUE);
               c3.setBackgroundColor(BaseColor.ORANGE);
               c4.setBackgroundColor(BaseColor.GREEN);
               c5.setBackgroundColor(BaseColor.RED);
               tabla.addCell(c1);
               tabla.addCell(c2);
               tabla.addCell(c3);
               tabla.addCell(c4);
               tabla.addCell(c5);
               //Agregar los registros
               DataCelular dc=new DataCelular();
               listaCelulares=dc.selectCelulares();
               for (Celular c : listaCelulares) {
                   tabla.addCell("" +c.getId());
                   tabla.addCell("" + c.getMarca());
                   tabla.addCell("" + c.getModelo());
                   tabla.addCell("" + c.getSistema());
                   tabla.addCell("" + c.getProcesador());
               }
               doc.add(tabla);
               Paragraph p1 = new Paragraph(10);
               p1.add(Chunk.NEWLINE);
               p1.add("NÚMERO DE CELULARES: " + listaCelulares.size());
               p1.add(Chunk.NEWLINE);
               p1.add(Chunk.NEWLINE);
               p1.setAlignment(Element.ALIGN_RIGHT);
               doc.add(p1);
               doc.close();
               archivo.close();
               Desktop.getDesktop().open(file);
           } catch (FileNotFoundException ex) {
           } catch (DocumentException ex) {
           } catch (IOException ex) {
               JOptionPane.showMessageDialog(frmCelular, "" + ex.getMessage());
               //Logger.getLogger(todosPDF.class.getName()).log(Level.SEVERE, null, ex);
           }
   }
	private Font Font(FontFamily helvetica, int i, int bold, BaseColor black) {
		// TODO Auto-generated method stub
		return null;
	}
}
