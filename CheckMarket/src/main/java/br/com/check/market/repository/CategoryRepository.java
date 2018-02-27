package br.com.check.market.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.check.market.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{


}
