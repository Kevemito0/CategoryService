package com.category.categoryservice.repo;
import com.category.categoryservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CategoryRepo extends JpaRepository<Category, Long> {

}