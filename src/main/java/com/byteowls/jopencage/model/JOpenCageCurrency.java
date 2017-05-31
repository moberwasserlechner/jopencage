package com.byteowls.jopencage.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JOpenCageCurrency {

  @JsonProperty("alternate_symbols")
  private List<String> alternateSymbols;
  @JsonProperty("decimal_mark")
  private String decimalMark;
  @JsonProperty("html_entity")
  private String htmlEntity;
  @JsonProperty("iso_code")
  private String isoCode;
  @JsonProperty("iso_numeric")
  private int isoNumeric;
  private String name;
  @JsonProperty("smallest_denomination")
  private int smallestDenomination;
  private String subunit;
  @JsonProperty("subunit_to_unit")
  private int subunitToUnit;
  private String symbol;
  @JsonProperty("symbol_first")
  private boolean symbolFirst;
  @JsonProperty("thousands_separator")
  private String thousandsSeparator;


  public List<String> getAlternateSymbols() {
    return alternateSymbols;
  }

  public String getDecimalMark() {
    return decimalMark;
  }

  public String getHtmlEntity() {
    return htmlEntity;
  }

  public String getIsoCode() {
    return isoCode;
  }

  public int getIsoNumeric() {
    return isoNumeric;
  }

  public String getName() {
    return name;
  }

  public int getSmallestDenomination() {
    return smallestDenomination;
  }

  public String getSubunit() {
    return subunit;
  }

  public int getSubunitToUnit() {
    return subunitToUnit;
  }

  public String getSymbol() {
    return symbol;
  }

  public boolean isSymbolFirst() {
    return symbolFirst;
  }

  public String getThousandsSeparator() {
    return thousandsSeparator;
  }
}
