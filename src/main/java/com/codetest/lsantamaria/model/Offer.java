package com.codetest.lsantamaria.model;

import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Offer {
  protected String productNameOfferApplies;

  public abstract void apply(List<Product> products);

  protected String getProductNameOfferApplies(){
    return productNameOfferApplies;
  }
}
