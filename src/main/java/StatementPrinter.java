import java.text.NumberFormat;
import java.util.*;

public class StatementPrinter { 
  

  public String print(Invoice invoice, Map<String, Play> plays) {
    Printer pri = new Printer();
    return pri.printToText(invoice, plays); 
  }
}