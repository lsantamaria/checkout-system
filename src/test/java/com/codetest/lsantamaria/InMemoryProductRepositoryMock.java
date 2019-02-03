package com.codetest.lsantamaria;

import com.codetest.lsantamaria.model.Product;
import com.codetest.lsantamaria.repository.ProductRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * In memory DB implementation example of {@link ProductRepository}
 */
public class InMemoryProductRepositoryMock implements ProductRepository {

  private static final List<Product> PRODUCTS_DB = List.of(
      new Product(60.0, "APPLE"),
      new Product(25.0, "ORANGE")
  );

  @Override
  public Optional<Product> findByName(String productName) {
    Objects.requireNonNull(productName);
    return PRODUCTS_DB
        .stream()
        .filter(p -> productName.equals(p.getName()))
        .findFirst();
  }
}