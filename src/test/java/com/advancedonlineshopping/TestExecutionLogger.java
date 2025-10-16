package com.advancedonlineshopping;

import io.cucumber.java.Scenario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestExecutionLogger {

    private static String reportPath;

    // Inicializa pastas
    public static void criarPasta() {
        File logsDir = new File("target/logs");
        if (!logsDir.exists()) logsDir.mkdirs();
    }

    // Inicializa arquivo de log único por execução
    static {
        try {
            criarPasta();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
            String timestamp = LocalDateTime.now().format(formatter);
            reportPath = "target/logs/test-execution-" + timestamp + ".txt";

            try (FileWriter writer = new FileWriter(reportPath, true)) {
                writer.write("==== INÍCIO DA EXECUÇÃO DOS TESTES ====\n\n");
            }

            System.out.println("Arquivo de log gerado em: " + reportPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void write(String content) {
        try (FileWriter writer = new FileWriter(reportPath, true)) {
            writer.write(content + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @io.cucumber.java.Before
    public void beforeScenario(Scenario scenario) {
        write("====================================================");
        write("INÍCIO DO SCENARIO: " + scenario.getName());
        write("====================================================\n");
    }

    @io.cucumber.java.After
    public void afterScenario(Scenario scenario) {
        write("\n----------------------------------------------------");
        write("FIM DO SCENARIO: " + scenario.getName());
        write("Status: " + (scenario.isFailed() ? "FAILED" : "PASSED"));
        write("----------------------------------------------------\n\n");
    }

    public static void log(String stepDescription, String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        write("[" + time + "] " + stepDescription + " -> " + message);
    }
}
