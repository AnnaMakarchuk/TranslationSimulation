package gatling.simulation;

import gatling.AppProperties;
import gatling.scenario.OpenAIScenario;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.http.HttpDsl.http;

public class OpenAISimulation extends Simulation {

    final String charCount = AppProperties.config.getString("char");

    final double userCount = AppProperties.config.getDouble("users");

    final Duration duration = Duration.ofSeconds(AppProperties.config.getLong("duration"));

    OpenAIScenario scenario = new OpenAIScenario();

    HttpProtocolBuilder httpProtocolBuilder = http.baseUrl(AppProperties.getProperty("open.ai.base.url"))
            .acceptHeader("*/*") // Here are the common headers
            .contentTypeHeader("application/json")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader("Gatling/Performance Test");

    private ScenarioBuilder getScenario(String charCount) {
        switch (charCount) {
            case "300":
                return scenario.build300CharScenario();
            case "500":
                return scenario.build500CharScenario();
            case "5000":
                return scenario.build5000CharScenario();
            default:
                throw new IllegalArgumentException("Wrong count for scenario");
        }
    }

    public OpenAISimulation() {
        this.setUp(getScenario(charCount).injectOpen(constantUsersPerSec(userCount).during(duration))
                .protocols(httpProtocolBuilder));
    }
}
