package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;
import model.TblProductocl2;

public class ClassProductoImp implements IProducto {

	public void RegistrarProducto(TblProductocl2 producto) {
		//establecer conexion con la unidad de persistencia...
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_ESPINOZAMINAYACHRISTIAN");
			    //permite gestionar entidades
				EntityManager em=fabr.createEntityManager();
				//iniciar transaccion
				em.getTransaction().begin();
				//registramos
				em.persist(producto);
				//emitimos mensaje por consola
				System.out.println("Producto registrado en la BD correctamente");
				//confirmamos
				em.getTransaction().commit();
				//cerramos la transaccion
				em.close();
			}  //fin del metodo registrar...

	public void ActualizarProducto(TblProductocl2 producto) {
		// TODO Auto-generated method stub
		
	}

	public void EliminarProducto(TblProductocl2 producto) {
		// TODO Auto-generated method stub
		
	}

	public TblProductocl2 BuscarProducto(TblProductocl2 producto) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TblProductocl2> ListadoProducto() {
		//establecer conexion con la unidad de psersistencia
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL2_ESPINOZAMINAYACHRISTIAN");
				//gestionamos las entidades
				EntityManager em=fabr.createEntityManager();
				//iniciamos la transaccion
				em.getTransaction().begin();
				//recuperamos los productos de la bd
				//****utilizando jpql
				List<TblProductocl2> listadoproductos=em.createQuery("select c from TblProductocl2 c",TblProductocl2.class).getResultList();
				//confirmamos la trasnaccion
				em.getTransaction().commit();
				//cerramos
				em.close();
				
				return listadoproductos;
	}

}
