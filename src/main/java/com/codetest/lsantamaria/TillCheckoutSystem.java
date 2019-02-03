package com.codetest.lsantamaria;

import com.codetest.lsantamaria.config.AppConfig;
import com.codetest.lsantamaria.model.Product;
import com.codetest.lsantamaria.model.Sum;
import com.codetest.lsantamaria.repository.ProductRepository;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link CheckoutSystem}.
 */
public class TillCheckoutSystem implements CheckoutSystem {

  private final ProductRepository productRepository;

  public TillCheckoutSystem(
      ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Sum checkout(List<String> productNames) {
    double total = 0;
    for (String productName : productNames) {
      Optional<Product> productOptional = productRepository.findByName(productName);
      if (productOptional.isPresent()) {
        Product product = productOptional.get();
        total += product.getPrice();
      } else {
        throw new IllegalArgumentException(
            String.format("Product %s not found!", productName));
      }
    }
    Currency currentCurrency = AppConfig.getInstance().getAppCurrency();
    return new Sum(total, currentCurrency);
  }
}