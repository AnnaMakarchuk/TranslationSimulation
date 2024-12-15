package gatling.simulation;

import gatling.AppProperties;
import gatling.scenario.DeeplScenario;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.http.HttpDsl.http;

public class DeeplSimulation extends Simulation {

    //run small test 8 users/2 min = 250000char app -> Compare with same OpenAi load
    final double userCount = AppProperties.config.getDouble("users");

    final Duration duration = Duration.ofSeconds(AppProperties.config.getLong("duration"));

    DeeplScenario scenario = new DeeplScenario();

    HttpProtocolBuilder httpProtocolBuilder = http.baseUrl(AppProperties.getProperty("deepl.base.url"))
            .acceptHeader("*/*") // Here are the common headers
            .contentTypeHeader("application/json")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader("Gatling/Performance Test");

    public DeeplSimulation() {
        this.setUp(scenario.build300CharScenario().injectOpen(constantUsersPerSec(userCount).during(duration))
                .protocols(httpProtocolBuilder));
    }
}
