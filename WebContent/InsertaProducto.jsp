<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-15">
		<title>Insertar Producto</title>
		
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
		
		<input type="hidden" name="instruccion" value="insertarBBDD">
		
		<h1 style="padding-left: 40px;">Insertar Producto</h1>
		<table>					
					
			<tr>
				<th>Código</th><td> <input type="text" name="codigo"> </td>			
			</tr>
			<tr>
				<th>Sección</th><td> <input type="text" name="seccion"> </td>			
			</tr>
			<tr>
				<th>Nombre Articulo</th><td> <input type="text" name="nombreArticulo"> </td>			
			</tr>
			<tr>
				<th>Precio</th><td> <input type="text" name="precio"> </td>			
			</tr>
			<tr>
				<th>Fecha</th><td> <input type="text" name="fecha"> </td>			
			</tr>
			<tr>
				<th>Importado</th><td> <input type="text" name="importado"> </td>			
			</tr>
			<tr>
				<th>Pais Origen</th><td> <input type="text" name="paisOrigen"> </td>			
			</tr>
			<tr>
				<td class="botton"><input type="submit" value="Enviar" ></td>
				<td class="botton"><input type="button" value="Borrar" onclick="window.location.href='InsertaProducto.jsp'"></td>			
			</tr>
				
		
		</table>
		</form>
		
		
		
	</body>
</html>