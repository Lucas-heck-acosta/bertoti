import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;

import java.io.IOException;

public class Ollama {
    private final String host = "http://localhost:11434/";
    private final DatabaseHandler databaseHandler = new DatabaseHandler();
    private final String csvFile = "/Users/lucas/Documents/engenharia/automacaoChat/AnalistaDeDados/src/main/java/medallists.csv";

    public String getOllamaResponse(String prompt) throws OllamaBaseException, IOException, InterruptedException {
        OllamaAPI ollamaAPI = new OllamaAPI(host);
        ollamaAPI.setRequestTimeoutSeconds(200);

        // Check if the prompt requests a data analysis from the CSV
        if (prompt.toLowerCase().contains("medalha") || prompt.toLowerCase().contains("medalhista") || prompt.toLowerCase().contains("esporte") || prompt.toLowerCase().contains("todos os atletas")) {
            return databaseHandler.handleDataAnalysis(prompt, csvFile);
        }

        OllamaResult result =
                ollamaAPI.generate("gemma2:2b", prompt, true, new OptionsBuilder().build());
        return result.getResponse();
    }
}