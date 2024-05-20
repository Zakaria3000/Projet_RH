package springmvc.dao.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import springmvc.dao.entities.CongeAnnuel;


public interface IGestionCongeAnnuel extends JpaRepository<CongeAnnuel, Integer>{

}
