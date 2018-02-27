package br.com.check.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.check.market.model.Iten;

@Repository
public interface ItenRepository extends JpaRepository<Iten, Long>{

}
