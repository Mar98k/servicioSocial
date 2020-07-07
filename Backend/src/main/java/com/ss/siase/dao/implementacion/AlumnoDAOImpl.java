package com.ss.siase.dao.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ss.siase.dao.AlumnoDAO;
import com.ss.siase.modelos.Alumno;

@Repository
public class AlumnoDAOImpl implements AlumnoDAO {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public Alumno consultarPorUsuario(String usuario) {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Alumno a where a.usuario = :usuario", Alumno.class)
					  .setParameter("usuario", usuario)
					  .setMaxResults(1)
					  .uniqueResult();
	}
    
}
