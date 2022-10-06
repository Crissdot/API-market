package com.course.market.persistence.crud;

import com.course.market.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

//    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
//    List<Product> getByCategoryId (Integer idCategory);
//    List<Product> findByIdCategory (Integer idCategory);

    List<Product> findByIdCategoryOrderByNameAsc (Integer idCategory);

    Optional<List<Product>> findByStockLessThanAndStatus (Integer stock, Boolean status);
}
