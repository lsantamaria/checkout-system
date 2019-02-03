package com.codetest.lsantamaria.model;

import java.util.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Holds a sum of values with a concrete currency.
 */
@AllArgsConstructor
@Data
public class Sum {
  private double value;
  private Currency currency;
}