package net.kzm.shoppingbackend.test;



import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;


	private static CategoryDAO categoryDAO;


	private Category category;


	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();

		try {
			context.scan("net.kzm.shoppingbackend");
			//context.refresh();
			System.out.println("Track:"+categoryDAO);
			categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		}
		catch(Exception ex) {
			System.out.println("Track:"+ex);
		}
	}


	@Test
	public void testAddCategory() {

		category = new Category();
		//category.setId(2);
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_105.png");
		System.out.println("Track:"+category);
		try {//}


			assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		}
		catch(Exception ex)
		{
			System.out.println("Track:"+ex);
		}

	}


	/*	@Test
	public void testGetCategory() {

		category = categoryDAO.get(3);


		assertEquals("Successfully fetched a single category from the table!","Television",category.getName());


	}
	 */

	/*	@Test
	public void testUpdateCategory() {

		category = categoryDAO.get(3);

		category.setName("TV");

		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));


	}
	 */

	/*	@Test
	public void testDeleteCategory() {

		category = categoryDAO.get(3);		
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));


	}
	 */	
	/*	
	@Test
	public void testListCategory() {

		assertEquals("Successfully fetched the list of categories from the table!",3,categoryDAO.list().size());


	}

	 */
	/*	
	@Test
	public void testCRUDCategory() {

		// add operation
		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");

		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));


		category = new Category();

		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");

		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));


		// fetching and updating the category
		category = categoryDAO.get(2);

		category.setName("TV");

		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));


		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));


		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());		


	}
	 */
}
