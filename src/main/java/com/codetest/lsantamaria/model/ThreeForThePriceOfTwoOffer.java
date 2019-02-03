package com.codetest.lsantamaria.model;

import java.util.List;
import java.util.stream.Collectors;

public class ThreeForThePriceOfTwoOffer extends Offer {

  public ThreeForThePriceOfTwoOffer(String productNameOfferApplies) {
    super(productNameOfferApplies);
  }

  @Override
  public void apply(List<Product> products) {
    String productNameOfferApliesTo = getProductNameOfferApplies();

    List<Product> filteredProducts =
        products
            .stream()
            .filter(product -> productNameOfferApliesTo.equals(product.getName()))
            .collect(Collectors.toList());

    filteredProducts
        .subList(0, Math.floorDiv(filteredProducts.size(), 3))
        .forEach(product -> product.setPrice(0));
  }
}