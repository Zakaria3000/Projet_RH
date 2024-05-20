package springmvc.service.IService;

import org.springframework.data.domain.Page;

import springmvc.dao.entities.CongeMaladie;

public interface IServiceCongeMaladie {
	public void ajouterConge(CongeMaladie conge);
	public Page<CongeMaladie> listerConges(int numpage);
	public void supprimerConge(Integer id);
	public void modifierConge(CongeMaladie conge);
	public CongeMaladie rechercherConge(Integer id) throws Exception;
}
