package net.kzm.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"net.kzm.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	
	//Change the DBMS as per your requirement
		private final static String DATBASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
		private final static String DATBASE_DRIVER="org.h2.Driver";
		private final static String DATBASE_DIALECT="org.hibernate.dialect.H2Dialect";
		private final static String DATBASE_USERNAME="sa";
		private final static String DATBASE_PASSWORD="";
		
		@Bean
		public DataSource getDataSource() {

			BasicDataSource dataSource = new BasicDataSource();

			dataSource.setDriverClassName(DATBASE_DRIVER);
			dataSource.setUrl(DATBASE_URL);
			dataSource.setUsername(DATBASE_USERNAME);
			dataSource.setPassword(DATBASE_PASSWORD);

			return dataSource;
		}
		
		
		//Session Factory Bean will be available		
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource) {
			
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
			builder.addProperties(getHibernateProperties());
			builder.scanPackages("net.kzm.shoppingbackend.dto");
			
			return builder.buildSessionFactory();
		}

		//All the Hibernate properties return in these method
		private Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.dialect", DATBASE_DIALECT);
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");
			return properties;
		}
		
		
		@Bean
		public HibernateTransactionManager getTransactionManagement(SessionFactory sessionFactory) {

			HibernateTransactionManager  transactionManagement = new HibernateTransactionManager(sessionFactory);
			return transactionManagement;
		}
		
}