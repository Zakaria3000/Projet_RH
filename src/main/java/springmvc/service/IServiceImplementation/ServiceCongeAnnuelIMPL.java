package springmvc.service.IServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import springmvc.dao.entities.CongeAnnuel;
import springmvc.dao.repositries.IGestionCongeAnnuel;
import springmvc.service.IService.IServiceCongeAnnuel;

public class ServiceCongeAnnuelIMPL implements IServiceCongeAnnuel  {
	public IGestionCongeAnnuel gc;
	@Override
	public void ajouterConge(CongeAnnuel conge) {
		// TODO Auto-generated method stub
		gc.save(conge);
	}

	@Override
	public Page<CongeAnnuel> listerConges(int numpage) {
		// TODO Auto-generated method stub
		return gc.findAll(PageRequest.of(numpage, 12));
	}
	@Override
	public void supprimerConge(Integer id) {
		// TODO Auto-generated method stub
		gc.deleteById(id);
	}

	@Override
	public void modifierConge(CongeAnnuel conge) {
		// TODO Auto-generated method stub
		gc.save(conge);
	}

	@Override
	public CongeAnnuel rechercherConge(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<CongeAnnuel> c= gc.findById(id);
		if(c.isPresent()) {
			return c.get();
		}
		else {
			throw new Exception("leave not found");
		}	}




}
