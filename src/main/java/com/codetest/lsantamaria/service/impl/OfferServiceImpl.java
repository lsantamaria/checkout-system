package com.codetest.lsantamaria.service.impl;

import com.codetest.lsantamaria.model.Product;
import com.codetest.lsantamaria.repository.OfferRepository;
import com.codetest.lsantamaria.service.OfferService;
import java.util.List;

public class OfferServiceImpl implements OfferService {
  private final OfferRepository offerRepository;

  public OfferServiceImpl(OfferRepository offerRepository) {
    this.offerRepository = offerRepository;
  }

  @Override
  public void applyOffers(List<Product> products) {
    offerRepository.getCurrentOffers().forEach(offer -> offer.apply(products));
  }
}
