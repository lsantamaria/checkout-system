package com.codetest.lsantamaria.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.codetest.lsantamaria.model.BuyOneGetOneFreeOffer;
import com.codetest.lsantamaria.model.Offer;
import com.codetest.lsantamaria.model.Product;
import com.codetest.lsantamaria.model.ThreeForThePriceOfTwoOffer;
import com.codetest.lsantamaria.repository.OfferRepository;
import com.codetest.lsantamaria.service.impl.OfferServiceImpl;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Tests for {@link com.codetest.lsantamaria.service.impl.OfferServiceImpl}.
 * This tests are done with Mockito to show another way.
 */
@RunWith(MockitoJUnitRunner.class)
public class OfferServiceImplTests {

  @Mock
  private OfferRepository offerRepository;

  private OfferService offerService;



  @Before
  public void setUp(){
    offerService = new OfferServiceImpl(offerRepository);
  }

  @Test
  public void givenAThreeForThePriceOfTwoOffer_whenCheckingOut_getDiscountAppliedToTotal(){
    Offer threeForThePriceOfTwoOffer = new ThreeForThePriceOfTwoOffer("ORANGE");

    //Creation could be extracted to another method
    Product orange1 = new Product(25, "ORANGE");
    Product orange2 = new Product(25, "ORANGE");
    Product orange3 = new Product(25, "ORANGE");
    Product orange4 = new Product(25, "ORANGE");
    Product orange5 = new Product(25, "ORANGE");

    List<Product> products = List.of(orange1, orange2, orange3, orange4, orange5);

    when(offerRepository.getCurrentOffers()).thenReturn(List.of(threeForThePriceOfTwoOffer));

    offerService.applyOffers(products);

    double productSum = products.stream().mapToDouble(Product::getPrice).sum();
    assertEquals(100, productSum, 0);
  }

  @Test
  public void givenBuyOneGetOneOffer_whenCheckingOut_getDiscountAppliedToTotal(){
    Offer buyOneAnotherFree = new BuyOneGetOneFreeOffer("APPLE");

    //Creation could be extracted to another method
    Product apple1 = new Product(60, "APPLE");
    Product apple2 = new Product(60, "APPLE");
    Product apple3 = new Product(60, "APPLE");
    Product apple4 = new Product(60, "APPLE");
    Product orange4 = new Product(25, "ORANGE");
    Product orange5 = new Product(25, "ORANGE");
    List<Product> products = List.of(apple1, apple2, apple3, apple4, orange4, orange5);

    when(offerRepository.getCurrentOffers()).thenReturn(List.of(buyOneAnotherFree));

    offerService.applyOffers(products);

    double productSum = products.stream().mapToDouble(Product::getPrice).sum();
    assertEquals(170, productSum, 0);
  }

  //Here we could add more tests for cases with mixed products, etc.
}
