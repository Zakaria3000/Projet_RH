package springmvc.service.IService;

import java.util.List;

import org.springframework.data.domain.Page;

import springmvc.dao.entities.CongeAnnuel;

public interface IServiceCongeAnnuel  {
	public void ajouterConge(CongeAnnuel conge);
	public Page<CongeAnnuel> listerConges(int numpage);
	public void supprimerConge(Integer id);
	public void modifierConge(CongeAnnuel conge);
	public CongeAnnuel rechercherConge(Integer id) throws Exception;
}
