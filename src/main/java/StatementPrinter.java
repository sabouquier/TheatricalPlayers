import java.text.NumberFormat;
import java.util.*;

public class StatementPrinter { 
  

  public String print(Invoice invoice, Map<String, Play> plays) {
    Printer pri = new Printer();
    return pri.printToText(invoice, plays); 
  }

  public String printHtml(Invoice invoice, Map<String, Play> plays) {
    Printer pri = new Printer();
    return pri.printToHtml(invoice, plays); 
  }
}