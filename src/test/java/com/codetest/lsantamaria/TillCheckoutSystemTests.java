package com.codetest.lsantamaria;

import static org.junit.Assert.assertEquals;

import com.codetest.lsantamaria.model.Sum;
import com.codetest.lsantamaria.repository.ProductRepository;
import com.codetest.lsantamaria.service.OfferService;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit tests of {@link TillCheckoutSystem}.
 */
@RunWith(MockitoJUnitRunner.class)
public class TillCheckoutSystemTests {

  private ProductRepository productRepository = new InMemoryProductRepositoryMock();

  //Using Mockito to show another way of Mocking
  @Mock
  private OfferService offerService;
  private TillCheckoutSystem tillCheckoutSystem;

  @Before
  public void setUp() {
    tillCheckoutSystem = new TillCheckoutSystem(productRepository, offerService);
  }

  @Test
  public void givenAListOfProducts_whenCheckingOut_thenTheResultIsTheSumOfProductsPrices() {
    List<String> productsList = List.of("APPLE", "APPLE", "ORANGE", "ORANGE");

    Sum total = tillCheckoutSystem.checkout(productsList);

    assertEquals(total.getValue(), 170, 0);
    assertEquals(total.getCurrency(), Currency.getInstance(Locale.UK));
  }

  @Test(expected = IllegalArgumentException.class)
  public void givenNonExistingProduct_whenCheckingOut_thenExceptionIsThrown() {
    List<String> productsList = List.of("APPLE", "NONEXISTING", "ORANGE", "ORANGE");

    tillCheckoutSystem.checkout(productsList);
  }

}