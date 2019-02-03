package com.codetest.lsantamaria;

import com.codetest.lsantamaria.config.AppConfig;
import com.codetest.lsantamaria.model.Product;
import com.codetest.lsantamaria.model.Sum;
import com.codetest.lsantamaria.repository.ProductRepository;
import com.codetest.lsantamaria.service.OfferService;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of {@link CheckoutSystem}.
 */
public class TillCheckoutSystem implements CheckoutSystem {

  private final ProductRepository productRepository;
  private final OfferService offerService;

  public TillCheckoutSystem(
      ProductRepository productRepository,
      OfferService offerService) {
    this.productRepository = productRepository;
    this.offerService = offerService;
  }

  public Sum checkout(List<String> productNames) {
    double total = 0;
    //A different way of iterating with regard to step 1
    List<Product> productList =
        productNames
            .stream()
            .map(productName -> productRepository.findByName(productName)
                .orElseThrow(() -> new IllegalArgumentException(
                    String.format("Product %s not found!", productName))))
            .collect(Collectors.toList());

    offerService.applyOffers(productList);
    total = productList.stream().mapToDouble(Product::getPrice).sum();
    Currency currentCurrency = AppConfig.getInstance().getAppCurrency();
    return new Sum(total, currentCurrency);
  }
}