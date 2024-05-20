package springmvc.service.IService;

import org.springframework.data.domain.Page;

import springmvc.dao.entities.Employe;


public interface IServiceEmploye {
	public void ajouterEmploye(Employe e) ;
	public Page<Employe> listerEmploye(int numPage);
	public void supprimerEmploye(Integer id);
	public void modifierEmploye(Employe e);
	public Employe rechercherEmploye(Integer id)throws Exception;
	
}
