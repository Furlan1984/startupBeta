package br.com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory factory;
	private static Configuration configuration;

	public static SessionFactory initialize() {
		try {
			configuration = new Configuration().configure();

			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

			factory = configuration.buildSessionFactory(registro);

			System.out.println(">> HIBERNATE INICIADO COM SUCESSO.");
		}

		catch (Throwable e) {
			System.out.println(">> FALHA NA INICIA��O DO HIBERNATE.");
			e.printStackTrace();
		}

		return factory;
	}

    public static SessionFactory getFactory() {  
        if(factory == null)//verificar se a vari�vel j� foi instanciada
            initialize();//inicia a vari�vel caso seja null
        return factory;  
    }  

}