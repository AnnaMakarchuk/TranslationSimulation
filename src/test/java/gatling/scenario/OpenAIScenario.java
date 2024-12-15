package gatling.scenario;

import gatling.AppProperties;
import io.gatling.javaapi.core.ScenarioBuilder;

import java.util.Random;

import static gatling.scenario.Sentences.*;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class OpenAIScenario {

    private static final String PATH = "v1/chat/completions";

    private static final String TRANSLATION_SYSTEM_PROMPT = "You are a professional translator, responsible for translating content from English to Ukrainian. You will receive a JSON file containing an 'original' section with the object to translate. Your task is to respond with a JSON containing single section, 'translation', that replicates the structure of the 'original' section, replacing source text with translated values while maintaining all keys.";

    private static final String AUTHORIZATION = String.format("Bearer %s", AppProperties.getProperty("open.ai.api.key"));

    private final Random random = new Random();

    String body = """
            {
                "model": "%s",
                "messages": [
                    {
                        "role": "system",
                        "content": "%s"
                    },
                    {
                        "role": "user",
                        "content": "{\\n  \\"original\\": \\"%s\\"\\n}"
                    }
                ]
            }
            """;

    public ScenarioBuilder build300CharScenario() {
        return scenario("Translate via OpenAI")
                .exec(http(AppProperties.getProperty("open.ai.base.url")).post(PATH)
                        .header("content-type", "application/json")
                        .header("Authorization", AUTHORIZATION)
                        .body(StringBody(session -> body
                                .formatted(AppProperties.getProperty("open.ai.model"), TRANSLATION_SYSTEM_PROMPT,
                                        buildChar300(random.nextInt(99000) + ". "))
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

    public ScenarioBuilder build500CharScenario() {
        return scenario("Translate via OpenAI")
                .exec(http(AppProperties.getProperty("open.ai.base.url")).post(PATH)
                        .header("content-type", "application/json")
                        .header("Authorization", AUTHORIZATION)
                        .body(StringBody(session -> body
                                .formatted(AppProperties.getProperty("open.ai.model"), TRANSLATION_SYSTEM_PROMPT,
                                        buildChar500(random.nextInt(99000) + ". "))
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

    public ScenarioBuilder build5000CharScenario() {
        return scenario("Translate via OpenAI")
                .exec(http(AppProperties.getProperty("open.ai.base.url")).post(PATH)
                        .header("content-type", "application/json")
                        .header("Authorization", AUTHORIZATION)
                        .body(StringBody(session -> body
                                .formatted(AppProperties.getProperty("open.ai.model"), TRANSLATION_SYSTEM_PROMPT,
                                        buildChar5000(random.nextInt(99000) + ". "))
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
