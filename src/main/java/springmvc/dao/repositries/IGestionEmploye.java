package springmvc.dao.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import springmvc.dao.entities.Employe;

public interface IGestionEmploye extends JpaRepository<Employe, Integer>{

}
