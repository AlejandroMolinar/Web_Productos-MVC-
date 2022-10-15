package MVC_Productos;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ControladorProductos_MVC")
public class ControladorProductos_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ModeloProductos_MVC modeloProductos;
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Resource(name="JDBC/Productos")
	private DataSource pool;
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	@Override
	public void init() throws ServletException {
		
		super.init();
		
		try {
			modeloProductos= new ModeloProductos_MVC(pool);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String parametro= request.getParameter("instruccion");			//Leer el parametro del formulario			
		if (parametro==null) parametro="listar";						//si no recibio el parametro del formulario listará los productos			
		
		try {
			
			switch (parametro) {
			case "listar":
				ObtenerProductos(request, response);
				break;

			case "insertarBBDD":
				InsertarProducto(request, response);
				break;	
				
			case "cargarBBDD":
				CargarProducto(request, response);
				break;	
			
			case "ActualizarBBDD":
				ActualizarProducto(request, response);
				break;	
			
			case "borrarBBDD":
				BorrarProducto(request, response);
				break;	
			
			default:
				
				ObtenerProductos(request, response);
				break;
			}
			 
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
	
	public void ObtenerProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		List<Productos> productos;   								//obtener lista de producto desde el modelo
		
		try {
			productos= modeloProductos.getProductos();				//Con esta sentencia obtenemos la lista de productos por el metodo getProductos antes creada 
			
			request.setAttribute("ListaProductos", productos);		//agregar lista de productos al request
									
			RequestDispatcher disp= request.getRequestDispatcher("/VistaProductos_MVC.jsp");	//enviar esa lista al JSP
			disp.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	

	public void InsertarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//Leer la informacion de Producto que viene del formulario
		
		String codigoArt= request.getParameter("codigo");
		String seccionArt= request.getParameter("seccion");
		String nombreArt= request.getParameter("nombreArticulo");
		String precioArt= request.getParameter("precio");
		String fechaArt= request.getParameter("fecha");
		String importadoArt= request.getParameter("importado");
		String paisOrigenArt= request.getParameter("paisOrigen");		
		
		/*	Cuando una variable es de tipo Date y quieres pasarle un dato de un Formato, sabiendo que el metodo "getParameter()" te invia la informacion en formato String, 
		 	por ello no se puede pasar la informacion asi por asi. Cuando esto sucede con un double o un int, es sencillo ya que utilizas el metodo parseDouble o parseInt; 
		 	en cambio con una variable de tipo Date se necesita las siquientes clases y metodos:
		 	
		 	  -SimpleDateFormat elnombre= new SimpleDateFormat("yyyy-MM-dd"); <-- Formato
		 	  -Date fecha=null;
		 	  -try{
		 	  	fecha= elnombre.parce(request.getParameter("Fecha")); <---Pide un String
		 	  }catch(...){
		 	  	...
		 	  }
		*/
		
		//Crear objeto de tipo Producto
		
		Productos prodInsertar= new Productos(codigoArt, seccionArt, nombreArt, precioArt, fechaArt, importadoArt, paisOrigenArt);
		
		//Enviar el objeto al ModeloProductos_MVC e insertar en BBDD
		
		modeloProductos.InsertarProductos(prodInsertar);
		
		//volver al listado de productos 
		
		ObtenerProductos(request, response);
	}
	

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	private void CargarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		try {
			
			//Leer el Codigo Articulo que viene de VistaProduto
			
			String codigoArt= request.getParameter("codigoArt");
			
			//Comunicar con el ModeloProducto para hacer una consulta  
				
			Productos produc= modeloProductos.getProducto(codigoArt);  
			
			//Agregar el Atributo correspondiente al Codigo Articulo
			
			request.setAttribute("productosAct", produc);
			
			//Enviar toda la informacion al Formulario ActualizarProducto
			
			RequestDispatcher dispatch= request.getRequestDispatcher("/ActualizarProducto.jsp");
			
			dispatch.forward(request, response);
			
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	public void ActualizarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
		//Leer los datos que vienen del formulario ActualizarProducto
			
			String codigoArt= request.getParameter("codigo");
			String seccionArt= request.getParameter("seccion");
			String nombreArt= request.getParameter("nombreArticulo");
			String precioArt= request.getParameter("precio");
			String fechaArt= request.getParameter("fecha");
			String importadoArt= request.getParameter("importado");
			String paisOrigenArt= request.getParameter("paisOrigen");		
		
		//Crear un objeto tipo producto con la informacion del formulario
			
			Productos prodActualizar= new Productos(codigoArt, seccionArt, nombreArt, precioArt, fechaArt, importadoArt, paisOrigenArt);
			
		//Actualizar la base de datos con la informacion
			
			modeloProductos.ActualizarProducto(prodActualizar);
			
		//Volver al listado con la tabla actualizada
			
			ObtenerProductos(request, response);
	}
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	

	private void BorrarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		//Leer el campo clave
			
			String codigoArt= request.getParameter("codigoArt");
		
		//Borrar producto de la base de datos
			
			modeloProductos.BorrarProducto(codigoArt);
			
		//Volver a la tabla del inicio 
			
			ObtenerProductos(request, response);
	}
		
	
}




















