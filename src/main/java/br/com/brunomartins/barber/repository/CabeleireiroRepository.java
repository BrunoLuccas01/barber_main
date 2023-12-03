package br.com.brunomartins.barber.repository;

import br.com.brunomartins.barber.model.CabeleireiroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabeleireiroRepository extends JpaRepository<CabeleireiroModel, Integer> {

}
