import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;


public class InsertarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField campoEmpresa;
	private JTextField campoContacto;
	private JTextField campoTel;
	private JTextField campoPoblacion;
	private JTextField campoPais;


	/**
	 * Create the frame.
	 */
	public InsertarCliente() {
		//Diseño
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Empresa");
		lblNewLabel.setBounds(35, 40, 100, 14);
		contentPane.add(lblNewLabel);
		
		campoEmpresa = new JTextField();
		campoEmpresa.setBounds(197, 37, 176, 20);
		contentPane.add(campoEmpresa);
		campoEmpresa.setColumns(10);
		
		JLabel lblNombreContacto = new JLabel("Nombre Contacto");
		lblNombreContacto.setBounds(35, 88, 100, 14);
		contentPane.add(lblNombreContacto);
		
		campoContacto = new JTextField();
		campoContacto.setColumns(10);
		campoContacto.setBounds(197, 85, 176, 20);
		contentPane.add(campoContacto);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(35, 135, 100, 14);
		contentPane.add(lblTelefono);
		
		campoTel = new JTextField();
		campoTel.setColumns(10);
		campoTel.setBounds(197, 132, 176, 20);
		contentPane.add(campoTel);
		
		JLabel lblPoblacion = new JLabel("Poblacion");
		lblPoblacion.setBounds(35, 177, 100, 14);
		contentPane.add(lblPoblacion);
		
		campoPoblacion = new JTextField();
		campoPoblacion.setColumns(10);
		campoPoblacion.setBounds(197, 174, 176, 20);
		contentPane.add(campoPoblacion);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(35, 221, 100, 14);
		contentPane.add(lblPais);
		
		campoPais = new JTextField();
		campoPais.setColumns(10);
		campoPais.setBounds(197, 218, 176, 20);
		contentPane.add(campoPais);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection conexion = null; //maneja la conexión
				Statement instruccion = null;// instrucción de consulta
				ResultSet conjuntoResultados = null;// maneja los resultados
				
				//BASE DE DATOS
				try{
					Class.forName("com.mysql.jdbc.Driver");
					// establece la conexión a la base de datos
					conexion = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","tonphp");
					// crea objeto Statement para consultar la base de datos
					instruccion = (Statement) conexion.createStatement();
					// consulta la base de datos
					String insercion="INSERT INTO datos_clientes ( NombreEmpresa,NombreContacto,Tel,Poblacion,Pais) VALUES('"+
							campoEmpresa.getText()+"','"+campoContacto.getText()+"','"+campoTel.getText()+"','"+campoPoblacion.getText()+"','"+campoPais.getText()+"'"+
							")";
					instruccion.executeUpdate(insercion);
					conexion.close();
				}catch( SQLException excepcionSql ){
					excepcionSql.printStackTrace();
				}// fin de catch
				catch( ClassNotFoundException noEncontroClase ){
						noEncontroClase.printStackTrace();
				}// fin de catch
			}
		});
		btnNewButton.setBounds(35, 261, 91, 41);
		contentPane.add(btnNewButton);
		
		//Base de datos
		

	}
}
