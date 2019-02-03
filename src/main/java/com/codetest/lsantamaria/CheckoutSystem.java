package com.codetest.lsantamaria;

import com.codetest.lsantamaria.model.Sum;
import java.util.List;

/**
 * A checkout system. Users of this interface must implement a <code>checkout()</code> method that
 * returns the sum of the products prices.
 */
public interface CheckoutSystem {

  /**
   * Add up the prices of the products with the given identifiers.
   *
   * @param productIdentifiers identifiers of the products to add.
   * @return the sum of the products prices with the current application currency.
   */
  Sum checkout(List<String> productIdentifiers);
}