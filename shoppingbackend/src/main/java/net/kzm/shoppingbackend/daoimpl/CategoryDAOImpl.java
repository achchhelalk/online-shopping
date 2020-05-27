package net.kzm.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	private static  List<Category> categories = new ArrayList<>();


	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_105.png");
		categories.add(category);
		 category = new Category();
		category.setId(2);
		category.setName("Television");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_105.png");
		categories.add(category);
	     category = new Category();
		category.setId(3);
		category.setName("Mobile");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_105.png");
		categories.add(category);
	}
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	
	@Override
	public Category get(int id) {
		for (Category category:categories){
			if(category.getId()==id)
			return category;}
			
		// TODO Auto-generated method stub
	   return null;
		
	}
	
	//Not required Now 

	//@Autowired
	//private SessionFactory sessionFactory; 


	/*
	@Override
	public List<Category> list() {
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active",true);
		return query.getResultList();
	}
	//Getting single category

	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

//Adding the single category  latest
	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}


//Updating the single category
	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

//delete the single category
	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	 */
}
