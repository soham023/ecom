package com.example.ecom.repository;

import com.example.ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
// here @NoRepositoryBean -> tells spring dont register this interface itself as a spring bean, it's a base template
// at start up of springboot  , it'll scan all the interfaces that JPA repository/ crud repository(insight packages scanned by springboot)
/* for each of these interfaces() we use a proxy factory/ proxy class at runtime
    then it registers proxy as a spring bean and wires it wherever you @Autowired the repository
* */