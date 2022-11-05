import java.text.NumberFormat;
import java.util.*;

public class StatementPrinter { 

  public String print(Invoice invoice, Map<String, Play> plays) {
    float totalAmount = 0;
    int volumeCredits = 0;
    StringBuffer sb=new StringBuffer(String.format("Statement for %s\n", invoice.customer));
    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    for (Performance perf : invoice.performances) {
      Play play = plays.get(perf.playID);
      float thisAmount = 0;
      thisAmount = amount(perf, play);
      
      // add volume credits
      volumeCredits += Math.max(perf.audience - 30, 0);
      // add extra credit for every five comedy attendees
      if ("comedy".equals(play.type)) volumeCredits += Math.floor(perf.audience / 5);

      sb.append(String.format("  %s: %s (%s seats)\n", play.name, frmt.format(thisAmount ), perf.audience));
      totalAmount += thisAmount;
    }
    sb.append(String.format("Amount owed is %s\n", frmt.format(totalAmount )));
    sb.append(String.format("You earned %s credits\n", volumeCredits));
    return sb.toString();
  }


  public float amount(Performance perf, Play play){
    final String TRAGEDY = "tragedy";
    final String COMEDY = "comedy";
    float thisAmount = 0;
    switch (play.type) {
        case TRAGEDY:
          thisAmount = 400;
          if (perf.audience > 30) {
            thisAmount += 10 * (perf.audience - 30);
          }
          break;
        case COMEDY:
          thisAmount = 300;
          if (perf.audience > 20) {
            thisAmount += 100 + 5 * (perf.audience - 20);
          }
          thisAmount += 3 * perf.audience;
          break;
        default:
          throw new Error("unknown type: ${play.type}");
      }
    return thisAmount;
  }

}
