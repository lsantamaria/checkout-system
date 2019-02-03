package com.codetest.lsantamaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * A product of the shop.
 */
@Data
@AllArgsConstructor
public class Product {
  private double price;
  private String name;
}