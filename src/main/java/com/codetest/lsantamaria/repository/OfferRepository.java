package com.codetest.lsantamaria.repository;

import com.codetest.lsantamaria.model.Offer;
import java.util.List;

public interface OfferRepository {
  List<Offer> getCurrentOffers();
}
