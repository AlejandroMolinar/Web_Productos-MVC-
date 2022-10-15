<%@ page language="java" contentType="text/html; charset=ISO-8859-15"
    pageEncoding="ISO-8859-15"%>
<%@ page import="java.util.*, MVC_Productos.*" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-15">
		<title>Productos</title>
		
		<style type="text/css">
			
			body {
				background-color: #EAA547;
			}
			
			table {
							
				background-color: white;
				margin: auto;
				padding:20px 20px; 
				border: 2px solid black;				
				float: left; 
				
			}
			tr, td, th{
				border: 1px solid black;
				padding: 10px 10px;
				text-align: center;
			}
			
			#ContenidoAgrgar{
				margin-left: 900px;
			}
		
		</style>
		
	</head>
	<!--  El Float Left que se pudo en la tabla es para que la tabla "Flote" por las izquierda     -->
	
	
	<% 	List<Productos> productos= (List<Productos>) request.getAttribute("ListaProductos"); %>
	<body>
		
		<table>
			<tr>
				<th>Código</th>
				<th>Sección</th>
				<th>Nombre Articulo</th>
				<th>Precio</th>
				<th>Fecha</th>			
				<th>Importado</th>
				<th>Pais Origen</th>
				<th>Actualizar</th>
			</tr>
						
			
			<c:forEach var="prod" items="${ListaProductos}">
			
			<!-- Link para Actualizar cada producto con su campo clave -->
			<c:url var="actualiza" value="ControladorProductos_MVC">
				<c:param name="instruccion" value="cargarBBDD"></c:param>
				<c:param name="codigoArt" value="${prod.codigoArt}"></c:param>
			</c:url>
			
			<!-- Link para borrar el producto con su campo clave -->
			<c:url var="borrar" value="ControladorProductos_MVC">
				<c:param name="instruccion" value="borrarBBDD"></c:param>
				<c:param name="codigoArt" value="${prod.codigoArt}"></c:param>
			</c:url>
			
				<tr>
					<td> ${prod.codigoArt } 	</td>
					<td> ${prod.seccionArt } 	</td>
					<td> ${prod.nombreArt } 	</td>
					<td> ${prod.precioArt } 	</td>
					<td> ${prod.fechaArt } 		</td>			
					<td> ${prod.importadoArt } 	</td>
					<td> ${prod.paisOrigenArt } </td>
					<td> <a href="${actualiza}">Actualizar</a> </td>
					<td> <a href="${borrar}">Borrar</a> </td>
				</tr>
								
			
			</c:forEach>

		
		</table>
		
		<h4 style=" margin-left: 900px;">Configuracion</h4>
		
		<div id="ContenidoAgrgar">
			<input type="button" value="Insertar Producto" onclick="window.location.href='InsertaProducto.jsp'"> 	<!-- La instruccion "onclick" se utiliza para
																													 	 realizar una acion cuando se presione el boton -->
		
		</div>		
		
		
	</body>
</html>












