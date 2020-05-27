package net.kzm.shoppingbackend.daoimpl;


import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzm.shoppingbackend.dao.TestCategoryDAO;
import net.kzm.shoppingbackend.dto.TestCategory;
@Repository("TestcategoryDAO")
@Transactional
public class TestCategoryDAOImpl implements TestCategoryDAO {

/*
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TestCategory> list() {
		String selectActiveCategory = "FROM Category WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		query.setParameter("active", true);

		return query.getResultList();
		//return null;
	}

	/*
	 * Getting single category based on id
	 */
	/*
	@Override
	public TestCategory get(int id) {
		System.out.println("SessionFactory"+sessionFactory.getCurrentSession().get(TestCategory.class, Integer.valueOf(id)));
		return sessionFactory.getCurrentSession().get(TestCategory.class, Integer.valueOf(id));
	//	return null;
	}

*/

}
