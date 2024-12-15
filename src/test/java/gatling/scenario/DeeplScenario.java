package gatling.scenario;

import gatling.AppProperties;
import io.gatling.javaapi.core.ScenarioBuilder;

import java.util.Random;

import static gatling.scenario.Sentences.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class DeeplScenario {

    private static final String PATH = "v2/translate";

    private static final String AUTHORIZATION = String.format("DeepL-Auth-Key %s", AppProperties.getProperty("deepl.api.key"));

    private final Random random = new Random();

    String body = """
            {
              "text": [
                "%s"
              ],
              "target_lang": "UK"
            }
            """;

    public ScenarioBuilder build300CharScenario() {
        return scenario("Translate via DeeplAI")
                .exec(http(AppProperties.getProperty("deepl.base.url")).post(PATH)
                        .header("content-type", "application/json")
                        .header("Authorization", AUTHORIZATION)
                        .body(StringBody(session -> body
                                .formatted(buildChar300(random.nextInt(99000) + ". "))
                        ))
                        .asJson()
                        .check(status().is(200))
                        .check(bodyString().saveAs("responseBody")))
//                .exec(session -> {
//                    System.out.println("Response Body:");
//                    System.out.println(session.getString("responseBody"));
//                    return session;
//                })
                ;
    }
}
