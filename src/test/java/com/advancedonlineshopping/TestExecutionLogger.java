package com.advancedonlineshopping;

import io.cucumber.java.Scenario;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestExecutionLogger {

    private static String reportPath;

    // Cria um nome de arquivo único para cada execução dos testes usando data e hora
    static {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        reportPath = "target/logs/test-execution-" + timestamp + ".txt";
    }

    // Método que escreve uma linha no arquivo de log
    private static void write(String content) {
        try (FileWriter writer = new FileWriter(reportPath, true)) {
            writer.write(content + "\n"); // escreve o conteúdo e pula uma linha
        } catch (IOException e) {
            e.printStackTrace(); // mostra erro se não conseguir escrever no arquivo
        }
    }

    // Antes de cada cenário do Cucumber, adiciona uma marcação de início no log
    @io.cucumber.java.Before
    public void beforeScenario(Scenario scenario) {
        write("====================================================");
        write("INÍCIO DO SCENARIO: " + scenario.getName()); // escreve o nome do cenário
        write("====================================================\n");
    }

    // Depois de cada cenário, adiciona marcação de fim e mostra se passou ou falhou
    @io.cucumber.java.After
    public void afterScenario(Scenario scenario) {
        write("\n----------------------------------------------------");
        write("FIM DO SCENARIO: " + scenario.getName());
        write("Status: " + (scenario.isFailed() ? "FAILED" : "PASSED")); // verifica o status
        write("----------------------------------------------------\n\n");
    }

    // Registra os passos no log
    public static void log(String stepDescription, String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        write("[" + time + "] " + stepDescription + " -> " + message);
    }
}
