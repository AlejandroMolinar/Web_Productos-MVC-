package MVC_Productos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class ModeloProductos_MVC {
	
	private DataSource datosOrigen;		//Creacion del Pool de Conexion
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	public ModeloProductos_MVC(DataSource datosOrigen) {
		this.datosOrigen=datosOrigen;
		
	}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	public List<Productos> getProductos() throws SQLException {
		
		List<Productos> productos= new ArrayList<Productos>();			//creacion de la lista de productos 
		
		Connection conexion=null;
		Statement state=null;
		ResultSet sql=null;		
		
		try {
			conexion= datosOrigen.getConnection();				//Establecer la conexion
	
			state= conexion.createStatement();					//Ejecutar Statement 
			
			sql= state.executeQuery("SELECT * FROM PRODUCTOS");	//Ejecutar la sentencia 
			
			while (sql.next()) {								//Recorrer la sentencia obtenida
				
				String codigoArt= sql.getString("Codigo_Articulo");
				String seccionArt= sql.getString("Seccion");
				String nombreArt= sql.getString("Nombre_Articulo");
				String precioArt= sql.getString("Precio");
				String fechaArt= sql.getString("Fecha");
				String importadoArt= sql.getString("Importado");
				String paisOrigenArt= sql.getString("Pais_Origen");
	
				Productos tmpProd=new Productos(codigoArt, seccionArt, nombreArt, precioArt, fechaArt, importadoArt, paisOrigenArt);		//Agregamos todos los datos a la clase Productos 
				productos.add(tmpProd);																			//Agregamos en el List productos todos los datos que tiene la clase Productos 
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			state.close();
			conexion.close();
		}				
		
		
		return productos;
	}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	public Productos getProducto(String codigo) throws SQLException{
		
		Productos tmpProd= null;			
		
		Connection conexion=null;
		PreparedStatement state=null;
		ResultSet sql=null;
		String codigoA=codigo;
		
		try {
			conexion= datosOrigen.getConnection();													//Establecer la conexion
		
			state= conexion.prepareStatement("SELECT * FROM PRODUCTOS WHERE Codigo_Articulo=?");	//Ejecutar PreparedStatement 
			
			state.setString(1, codigoA);																//Crear la sentencia Preparada
			
			sql= state.executeQuery();																//Ejecutar la sentencia 
			
			if (sql.next()) {																		//Recorrer la sentencia obtenida
				
				String codigoArt= sql.getString("Codigo_Articulo");
				String seccionArt= sql.getString("Seccion");
				String nombreArt= sql.getString("Nombre_Articulo");
				String precioArt= sql.getString("Precio");
				String fechaArt= sql.getString("Fecha");
				String importadoArt= sql.getString("Importado");
				String paisOrigenArt= sql.getString("Pais_Origen");
	
				tmpProd=new Productos(codigoArt ,seccionArt, nombreArt, precioArt, fechaArt, importadoArt, paisOrigenArt);		//Agregamos todos los datos a la clase Productos 
																							
			}else {
				throw new Exception("No se ha encontrado el producto con el codigo " + codigoA);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			state.close();
			conexion.close();
		}														
		
		return tmpProd;
	}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	public void InsertarProductos(Productos producto) throws SQLException {

		Connection conexion=null;
		PreparedStatement state=null;
		Statement sql=null;
		
					
		try {
			
			//Establecer la conexion
			conexion= datosOrigen.getConnection();
						
		
			//Crear la instruccion que agregará el producto(sql y statement)
			state= conexion.prepareStatement("INSERT INTO PRODUCTOS (`Codigo_Articulo`, `Seccion`, `Nombre_Articulo`, `Precio`, `Fecha`, `Importado`, `Pais_Origen`) VALUES( ? , ? , ? , ? , ? , ? , ?)");			
							
			//Establecer parametros para el producto		
				
			state.setString(1, producto.getCodigoArt());
			state.setString(2, producto.getSeccionArt());
			state.setString(3, producto.getNombreArt());
			state.setString(4, producto.getPrecioArt());
			state.setString(5, producto.getFechaArt());
			state.setString(6, producto.getImportadoArt());
			state.setString(7, producto.getPaisOrigenArt()); 	
			
				
		/* 
		 Si en un tal caso se quiere agregar un variable, en este caso de tipo Producto, que sea Double, int o Date, simplemente si cambia la instruccion "setString" a
		 "setDouble" o "setInt" o "setDate". Pero en el caso de "setDate" hay un porblema y es que esta interfaz pide un tipo Date de la clase java.sql.Date y en este 
		 ejemplo se esta utilizando el java.util.Date, por ello se tiene que hacer una conversion de la siguiente forma:
				   
		    -java.util.Date utilDate= productos.getFechaArt();
		    -java.sql.Date sqlDate= new java.sql.Date(utilDate.getTime());  <-- El "getTime" es un metodo que transforma del util.Date al sql.Date
		    -state.setDate(5, sqlDate);
		*/
				
			int filas=state.executeUpdate();						//ejecutar el sql
				
			if (filas==0) {
				throw new Exception("No se inserto el registro");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			state.close();
			conexion.close();
		}	
	}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------	
	
	public void ActualizarProducto(Productos producto) throws SQLException {
		
		Connection conexion=null;
		PreparedStatement state=null;
		Statement sql=null;
		
					
		try {
			//Establecer la conexion
			conexion= datosOrigen.getConnection();							
						
		
			//Crear la instruccion que agregará el producto(sql y statement)
			state= conexion.prepareStatement("UPDATE `productos` SET `Seccion`=?, `Nombre_Articulo`=?,`Precio`=?, `Fecha`=?, `Importado`=?,`Pais_Origen`=? WHERE `Codigo_Articulo`=?");			
							
			//Establecer parametros para el producto		
				
			state.setString(1, producto.getSeccionArt());
			state.setString(2, producto.getNombreArt());
			state.setString(3, producto.getPrecioArt());
			state.setString(4, producto.getFechaArt());
			state.setString(5, producto.getImportadoArt());
			state.setString(6, producto.getPaisOrigenArt());
			state.setString(7, producto.getCodigoArt()); 	
	
				
			int filas=state.executeUpdate();						//ejecutar el sql
				
			if (filas==0) {
				throw new Exception("No se inserto el registro");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			state.close();
			conexion.close();
		}	
		
		
	}
	public void BorrarProducto(String codigoArt) throws SQLException {
		
		Connection conexion=null;
		PreparedStatement state=null;
		
		try {
			//Establecer la conexion
				
				conexion= datosOrigen.getConnection();							
			
			//Crear la instruccion que borrará el producto
				
				state= conexion.prepareStatement("DELETE FROM `productos` WHERE `Codigo_Articulo`=?");
				
			//Establecer parametros para el producto			
				
				state.setString(1, codigoArt);
				
			//Ejecutar la sentencia aql
				
				state.execute();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			state.close();
			conexion.close();
		}					
	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	