package com.codetest.lsantamaria.config;

import java.util.Currency;
import java.util.Locale;

/**
 * Global class for storing application configuration.
 */
public class AppConfig {

  //Could be loaded externally
  private Currency appCurrency = Currency.getInstance(Locale.UK);
  private static AppConfig instance;

  private AppConfig() {}

  public static AppConfig getInstance(){
    if(instance == null){
      instance = new AppConfig();
    }
    return instance;
  }

  public Currency getAppCurrency() {
    return appCurrency;
  }
}
