package com.shubhambharti.productservice.repositories;

import com.shubhambharti.productservice.models.Category;
import com.shubhambharti.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long id);

    // select * from products where title = title
    Optional<Product> findByTitle(String title);

    @Override
    List<Product> findAllById(Iterable<Long> longs);

    //JOIN
    //select id from categories where name = name;
    //select * from products where category_id = id;
    List<Product> findByCategory_Name(String name);

    List<Product> findByCategory(Category category);
    //    @Query("select * from products p join categories c on p.category_id = c.id where c.name = "mobile" " )
    //    List<Product> customQuery();
    @Override
    void deleteById(Long id);
}
