<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-15">
		<title>Actualizar Producto</title>		
		
		<style type="text/css">
		
			body{
			
				background-color: #52EDF2;
			
			}
			
			
			table {
				
				background-color: white;
				padding: 30px; 
					
			}
		
			th {
				text-align: left;
				padding-right: 20px;												
			}
			
			
			.botton{
				padding-top: 20px;
				
			}
					
		
		</style>
	</head>
	<body>
		
		<form action="ControladorProductos_MVC" method="get">
		
		<input type="hidden" name="instruccion" value="ActualizarBBDD">
		<input type="hidden" name="codigo" value="${productosAct.codigoArt}">
		
		<h1 style="padding-left: 40px;">Actualizar Producto</h1>
		<table>					
			
			<tr>
				<th>Sección</th><td> <input type="text" name="seccion" value="${productosAct.seccionArt}"> </td>			
			</tr>
			<tr>
				<th>Nombre Articulo</th><td> <input type="text" name="nombreArticulo" value="${productosAct.nombreArt}"> </td>			
			</tr>
			<tr>
				<th>Precio</th><td> <input type="text" name="precio" value="${productosAct.precioArt}"> </td>			
			</tr>
			<tr>
				<th>Fecha</th><td> <input type="text" name="fecha" value="${productosAct.fechaArt}"> </td>			
			</tr>
			<tr>
				<th>Importado</th><td> <input type="text" name="importado" value="${productosAct.importadoArt}"> </td>			
			</tr>
			<tr>
				<th>Pais Origen</th><td> <input type="text" name="paisOrigen" value="${productosAct.paisOrigenArt}"> </td>			
			</tr>
			<tr>
				<td class="botton"><input type="submit" value="Actualizar"></td>
				<td class="botton"><input type="button" value="Borrar" onclick="window.location.href='ActualizarProducto.jsp'"></td>			
			</tr>
				
		
		</table>
		</form>
		
		
	
	
	</body>
</html>