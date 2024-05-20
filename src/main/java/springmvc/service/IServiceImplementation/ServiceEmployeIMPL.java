package springmvc.service.IServiceImplementation;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.Data;
import springmvc.dao.entities.Employe;
import springmvc.dao.repositries.IGestionEmploye;
import springmvc.service.IService.IServiceEmploye;

@Data
@Service
@Transactional
public class ServiceEmployeIMPL implements IServiceEmploye {

	private final IGestionEmploye ge;
	@Override
	public void ajouterEmploye(Employe e) {
		// TODO Auto-generated method stub
		ge.save(e);
	}

	@Override
	public Page<Employe> listerEmploye(int numpage) {
		// TODO Auto-generated method stub
		return ge.findAll(PageRequest.of(numpage, 12));
	}

	@Override
	public void supprimerEmploye(Integer id) {
		// TODO Auto-generated method stub
		ge.deleteById(id);
	}

	@Override
	public void modifierEmploye(Employe e) {
		// TODO Auto-generated method stub
		ge.save(e);
	}

	@Override
	public Employe rechercherEmploye(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Employe> c= ge.findById(id);
		if(c.isPresent()) {
			return c.get();
		}
		else {
			throw new Exception("employee not found");
		}
	}
	


}
