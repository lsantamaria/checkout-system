package com.codetest.lsantamaria.repository;

import com.codetest.lsantamaria.model.Product;
import java.util.Optional;

/**
 * Repository of {@link Product} entity.
 */
public interface ProductRepository {

  /**
   * Find a product instance with the given category.
   *
   * @param productName the product's name.
   * @return an optional of Product object.
   */
  Optional<Product> findByName(String productName);
}