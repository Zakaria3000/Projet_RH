package springmvc.service.IServiceImplementation;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import springmvc.dao.entities.CongeAnnuel;
import springmvc.dao.entities.CongeMaladie;
import springmvc.dao.repositries.IGestionCongeMaladie;
import springmvc.service.IService.IServiceCongeMaladie;

public class ServiceCongeMaladie implements IServiceCongeMaladie{
	public IGestionCongeMaladie gc;
	@Override
	public void ajouterConge(CongeMaladie conge) {
		// TODO Auto-generated method stub
		gc.save(conge);
	}

	@Override
	public Page<CongeMaladie> listerConges(int numpage) {
		// TODO Auto-generated method stub
		return gc.findAll(PageRequest.of(numpage, 12));
	}

	@Override
	public void supprimerConge(Integer id) {
		// TODO Auto-generated method stub
		gc.deleteById(id);
	}

	@Override
	public void modifierConge(CongeMaladie conge) {
		// TODO Auto-generated method stub
		gc.save(conge);
	}

	@Override
	public CongeMaladie rechercherConge(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<CongeMaladie> c= gc.findById(id);
		if(c.isPresent()) {
			return c.get();
		}
		else {
			throw new Exception("sick leave not found");
		}	}
	

}
