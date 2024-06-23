package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Interfaces.IUsuario;
import model.TblUsuariocl2;

public class ClassUsuarioImp implements IUsuario {
	
	private EntityManagerFactory emf;

    public ClassUsuarioImp() {
        emf = Persistence.createEntityManagerFactory("LPII_CL2_ESPINOZAMINAYACHRISTIAN");
    }

    public boolean ValidarUsuario(TblUsuariocl2 usuario) {
        EntityManager em = emf.createEntityManager();

        try {
            // Usamos una consulta JPA para buscar el usuario por el campo usuariocl2
            TypedQuery<TblUsuariocl2> query = em.createQuery("SELECT u FROM TblUsuariocl2 u WHERE u.usuariocl2 = :username", TblUsuariocl2.class);
            query.setParameter("username", usuario.getUsuariocl2());
            TblUsuariocl2 foundUser = query.getSingleResult();

            return foundUser != null && foundUser.getPasswordcl2().equals(usuario.getPasswordcl2());
        } catch (Exception e) {
            // Maneja la excepción (por ejemplo, NoResultException si no se encuentra el usuario)
            return false;
        } finally {
            em.close();  // Asegúrate de cerrar el EntityManager
        }
    }
}
