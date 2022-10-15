package MVC_Productos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/Servlets_Pruebas")
public class Servlets_Pruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Establecer el DataSource	
	@Resource(name="JDBC/Productos")
	private DataSource pool;
	
    public Servlets_Pruebas() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter salida= response.getWriter();		//Crear el PrintWriter
		response.setContentType("text/html");			//Especificar el tipo de contenido que tendra el servlet
		Connection conexion= null;						
		Statement state= null;							
		ResultSet sql= null;
		
		try {
			
			conexion= pool.getConnection();				//Esta instruccion es mara utilizar el pool en la conexion
			state= conexion.createStatement();
			sql= state.executeQuery("SELECT * FROM PRODUCTOS");
			
			salida.println("<html><body><table style='border: 1px solid #000000'>");
			
			while (sql.next()) {
				//String nombrePdt= sql.getString(3);
				
				salida.println("<tr><td>" + sql.getString(3) + "</td></tr>");				
			}
	
			salida.println("</table></body></html>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
