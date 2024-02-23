package JAVA.ExecutiveFramework;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightService {
    public Stream<CompletableFuture<Quote>> getQuotes() {
        var sites = List.of("site 1", "site 2", "site 3");


        return sites.stream()
                .map(this::getQuote);
    }

    public CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a Quote from " + site);
            var random = new Random();

            LongTask.simulate(1_000 + random.nextInt(2_000));

            var price = 100 + random.nextInt(20);

            return new Quote(site, price);
        });
    }
}
