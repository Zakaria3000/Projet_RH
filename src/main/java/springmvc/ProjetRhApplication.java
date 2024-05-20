package springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import springmvc.dao.entities.Employe;
import springmvc.service.IServiceImplementation.ServiceEmployeIMPL;

@SpringBootApplication
public class ProjetRhApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjetRhApplication.class, args);
		/*
		ServiceEmployeIMPL sc = ctx.getBean(ServiceEmployeIMPL.class);

		 * Employe c1 = new Employe
		 * (null,"client1","prenom1","adresse1@gmail.com","0606060606",null); Employe c2
		 * = new Employe
		 * (null,"client2","prenom2","adresse2@gmail.com","0789632276",null); Employe c3
		 * = new Employe
		 * (null,"client3","prenom3","adresse3@gmail.com","0627365243",null);
		 * sc.ajouterEmploye(c1); sc.ajouterEmploye(c2); sc.ajouterEmploye(c3);
		 */
	}

}
