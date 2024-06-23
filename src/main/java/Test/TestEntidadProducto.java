package Test;

import java.util.List;

import Dao.ClassProductoImp;
import model.TblProductocl2;

public class TestEntidadProducto {
	public static void main(String[] args) {
		//realizamos la respectiva instancia de las clases...
		TblProductocl2 producto=new TblProductocl2();
		ClassProductoImp crud=new ClassProductoImp();
		//asignamos valores
	/*	producto.setNombrecl2("fideos");
		producto.setPrecioventacl2(4);
		producto.setPreciocompcl2(2);
		producto.setEstadocl2("vigente");
	    producto.setDescripcl2("anita"); 
		
		//invocamos al metodo registrar...
		crud.RegistrarProducto(producto); */

		//TESTEANDO LISTADO
		  List<TblProductocl2> listado=crud.ListadoProducto();
		//aplicamos un bucle for...
		for(TblProductocl2 lis:listado) {
			//imprimimos por pantalla
			System.out.println("nombre: "+lis.getNombrecl2()+" precio venta: "+lis.getPrecioventacl2()+
					" precio compra: "+lis.getPreciocompcl2()+
					" estado: "+lis.getEstadocl2()+
					" descripcion: "+lis.getDescripcl2()); 
					
		}
	} 
}//fin del metodo main...

 //fin de la clase...

