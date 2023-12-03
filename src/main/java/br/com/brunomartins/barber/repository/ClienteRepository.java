package br.com.brunomartins.barber.repository;

import br.com.brunomartins.barber.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

}
