import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import com.mysql.jdbc.Statement;


public class ListarClientes extends JFrame {

	private JPanel contentPane;
	Connection conexion = null; //maneja la conexión
	Statement instruccion = null;// instrucción de consulta
	ResultSet conjuntoResultados = null;// maneja los resultados


	/**
	 * Create the frame.
	 */
	public ListarClientes() {
		//DISEÑO
		setTitle("ListarClientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea listado = new JTextArea();
		listado.setBounds(10, 11, 422, 251);
		contentPane.add(listado);
		//BASE DE DATOS
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","tonphp");
			// crea objeto Statement para consultar la base de datos
			instruccion = (Statement) conexion.createStatement();
			// consulta la base de datos
			conjuntoResultados = instruccion.executeQuery("SELECT * FROM  datos_clientes ");
			while (conjuntoResultados.next())
			{
				listado.setText(listado.getText()+"\n"+Integer.valueOf((Integer)conjuntoResultados.getObject("Id"))
						+","+(String)conjuntoResultados.getObject("NombreContacto")
						+","+(String)conjuntoResultados.getObject("NombreEmpresa"));	
			}
			conexion.close();
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase ){
				noEncontroClase.printStackTrace();
		}// fin de catch
	}
}
