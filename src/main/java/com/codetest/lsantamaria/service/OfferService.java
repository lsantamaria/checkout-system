package com.codetest.lsantamaria.service;

import com.codetest.lsantamaria.model.Offer;
import com.codetest.lsantamaria.model.Product;
import java.util.List;

/**
 * Service for handling {@link Offer}.
 */
public interface OfferService {
  void applyOffers(List<Product> products);
}
