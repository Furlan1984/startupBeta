package br.com.check.market.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.check.market.model.Establishment;

@Repository
public interface EstablishmentRepository extends JpaRepository<Establishment, Long>{


}
