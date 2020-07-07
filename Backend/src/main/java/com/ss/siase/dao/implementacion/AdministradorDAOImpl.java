package com.ss.siase.dao.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ss.siase.dao.AdministradorDAO;
import com.ss.siase.modelos.Administrador;


@Repository
public class AdministradorDAOImpl implements AdministradorDAO {

    @PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Administrador consultarPorUsuario(String usuario) {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Administrador a where a.usuario = :usuario", Administrador.class)
					  .setParameter("usuario", usuario)
					  .setMaxResults(1)
					  .uniqueResult();
	}
}
