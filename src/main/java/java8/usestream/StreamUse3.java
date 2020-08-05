package java8.usestream;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.Comparator.comparing;
import java.util.ArrayList;

public class StreamUse3 {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        List<Transaction> tr2011 =
                transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(tr2011);
        
        List<String> cities =
                transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println(cities);
        
        Set<String> cities2 =
                transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());
        System.out.println(cities2);
        
        List<Trader> traders =
                transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(traders);
        
        String traderStr =
                transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);
        
        boolean milanBased =
                transactions.stream()
                .anyMatch(transaction -> transaction.getTrader()
                .getCity()
                .equals("Milan"));
        System.out.println(milanBased);
        
        Optional<Integer> highestValue =
                transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(highestValue);
        
        Optional<Transaction> smallestTransaction =
                transactions.stream()
                .reduce((t1, t2) ->
                t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(smallestTransaction);
    }

}
