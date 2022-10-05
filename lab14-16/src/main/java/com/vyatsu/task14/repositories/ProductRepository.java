package com.vyatsu.task14.repositories;

import com.vyatsu.task14.entities.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
//public interface ProductRepository extends PagingAndSortingRepository<Product,Long>, JpaSpecificationExecutor<Product> {
//}
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAll(Specification specification, Pageable pageable);
}