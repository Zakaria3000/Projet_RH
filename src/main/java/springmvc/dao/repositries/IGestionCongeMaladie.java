package springmvc.dao.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import springmvc.dao.entities.CongeMaladie;

public interface IGestionCongeMaladie extends JpaRepository<CongeMaladie, Integer>{

}
