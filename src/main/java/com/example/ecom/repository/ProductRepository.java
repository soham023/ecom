package com.example.ecom.repository;

import com.example.ecom.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    //    what if i want to put filters jpa has not that capability , need write manual queries
    // this is a custom query method using HQL
    // hql
//    @Query("SELECT p from Product p WHERE p.price > :minPrice")
//    List<ProductEntity> findExpensiveProducts(@Param("minPrice") double minPrice);
//
//
//    // raw sql
//    @Query(value = "Select * From product Where MATCH(name, description) AGAINST (:keyword)", nativeQuery = true)
//    List<ProductEntity> searchFullText(@Param("keyword") String keyword);
//
//    @Query("Select p from Product p WHERE p.price > :minPrice AND p.brand = :brand")
//    List<ProductEntity> findByTitleAndPrice(
//            @Param("minPrice") int price,
//            @Param("title") String title
//    );
}
// here @NoRepositoryBean -> tells spring dont register this interface itself as a spring bean, it's a base template
// at start up of springboot  , it'll scan all the interfaces that JPA repository/ crud repository(insight packages scanned by springboot)
/* for each of these interfaces() we use a proxy factory/ proxy class at runtime
    then it registers proxy as a spring bean and wires it wherever you @Autowired the repository
* */


