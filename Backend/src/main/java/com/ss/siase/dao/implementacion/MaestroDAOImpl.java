package com.ss.siase.dao.implementacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ss.siase.dao.AlumnoDAO;
import com.ss.siase.dao.MaestroDAO;
import com.ss.siase.modelos.Alumno;
import com.ss.siase.modelos.Maestro;

@Repository
public class MaestroDAOImpl implements MaestroDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
	@Override
	public Maestro consultarPorUsuario(String usuario) {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Maestro m where m.usuario = :usuario", Maestro.class)
					  .setParameter("usuario", usuario)
					  .setMaxResults(1)
					  .uniqueResult();
	}

}
