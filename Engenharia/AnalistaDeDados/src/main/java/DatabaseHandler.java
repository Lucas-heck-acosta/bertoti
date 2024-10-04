import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DatabaseHandler {
    private static final Map<String, String> countryMap = new HashMap<>();

    static {
        countryMap.put("bélgica", "BEL");
        countryMap.put("italia", "ITA");
        countryMap.put("australia", "AUS");
        countryMap.put("reino unido", "GBR");
        countryMap.put("estados unidos", "USA");
        countryMap.put("coreia do sul", "KOR");
        countryMap.put("tunisia", "TUN");
        countryMap.put("hong kong", "HKG");
        countryMap.put("frança", "FRA");
        countryMap.put("hungria", "HUN");
        countryMap.put("kazakhstan", "KAZ");
        countryMap.put("japão", "JPN");
        countryMap.put("espanha", "ESP");
        countryMap.put("mongólia", "MGL");
        countryMap.put("suécia", "SWE");
        countryMap.put("alemanha", "GER");
        countryMap.put("canadá", "CAN");
        countryMap.put("polônia", "POL");
        countryMap.put("egito", "EGY");
        countryMap.put("moldávia", "MDA");
        countryMap.put("uzbequistão", "UZB");
        countryMap.put("kosovo", "KOS");
        countryMap.put("china", "CHN");
        countryMap.put("índia", "IND");
        countryMap.put("sérvia", "SRB");
        countryMap.put("armênia", "ARM");
        countryMap.put("albania", "ALB");
        countryMap.put("cuba", "CUB");
        countryMap.put("peru", "PER");
        countryMap.put("dominica", "DOM");
        countryMap.put("cabo verde", "CPV");
        countryMap.put("fiji", "FIJ");
        countryMap.put("taiwan", "TPE");
        countryMap.put("bósnia e herzegovina", "BIH");
        countryMap.put("colômbia", "COL");
        countryMap.put("costa do marfim", "CIV");
        countryMap.put("géorgia", "GEO");
        countryMap.put("lituânia", "LTU");
        countryMap.put("suíça", "SUI");
        countryMap.put("moçambique", "MOZ");
        countryMap.put("togo", "TOG");
        countryMap.put("singapura", "SGP");
        countryMap.put("guatemala", "GUA");
        countryMap.put("jamaica", "JAM");
        countryMap.put("suriname", "SUR");
        countryMap.put("brasil", "BRA");
        countryMap.put("cazaquistão", "KAZ");
        countryMap.put("türquia", "TUR");
        countryMap.put("iran", "IRI");
        countryMap.put("sri lanka", "LKA");
    }

    public String handleDataAnalysis(String prompt, String csvFile) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> records = reader.readAll();

            if (prompt.toLowerCase().contains("atleta")) {
                return findTopAthlete(records, prompt);
            }

            String medalType = extractMedalTypeFromPrompt(prompt);
            return countMedals(records, medalType, prompt);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return "Erro ao tentar analisar os dados.";
        }
    }

    private String countMedals(List<String[]> records, String medalType, String prompt) {
        Set<String> uniqueTeams = new HashSet<>();
        int medalCount = 0;
        String countryName = extractCountryFromPrompt(prompt);
        String countryCode = countryMap.get(countryName.toLowerCase());

        if (countryCode == null) {
            return "Não reconheço o país mencionado na mensagem.";
        }

        for (String[] record : records) {
            String recordMedalType = record[1].trim();
            String recordCountryCode = record[5].trim();
            String teamCode = record[17].trim();
            String athleteCode = record[16].trim();

            if (medalType.equalsIgnoreCase(recordMedalType) && countryCode.equalsIgnoreCase(recordCountryCode)) {
                if (teamCode.isEmpty()) {
                    medalCount++;
                } else {
                    uniqueTeams.add(teamCode);
                }
            }
        }

        medalCount += uniqueTeams.size();
        String medalTypeInPortuguese = convertMedalTypeToPortuguese(medalType);
        return "O país " + countryName + " ganhou " + medalCount + " medalhas de " + medalTypeInPortuguese + ".";
    }

    private String findTopAthlete(List<String[]> records, String prompt) {
        Map<String, Integer> athleteMedalCount = new HashMap<>();
        String countryName = extractCountryFromPrompt(prompt);
        String countryCode = countryMap.get(countryName.toLowerCase());

        if (countryCode == null) {
            return "Não reconheço o país mencionado na mensagem.";
        }

        for (String[] record : records) {
            String recordCountryCode = record[5].trim();
            String athleteName = record[3].trim();
            String athleteCode = record[16].trim();

            if (countryCode.equalsIgnoreCase(recordCountryCode)) {
                athleteMedalCount.put(athleteName, athleteMedalCount.getOrDefault(athleteName, 0) + 1);
            }
        }

        String topAthlete = null;
        int maxMedals = 0;
        for (Map.Entry<String, Integer> entry : athleteMedalCount.entrySet()) {
            if (entry.getValue() > maxMedals) {
                maxMedals = entry.getValue();
                topAthlete = entry.getKey();
            }
        }

        if (topAthlete != null) {
            return "O atleta com mais medalhas do(a) " + countryName + " é " + topAthlete + " com " + maxMedals + " medalhas.";
        } else {
            return "Nenhum atleta encontrado para o país " + countryName + ".";
        }
    }

    private String convertMedalTypeToPortuguese(String medalType) {
        if (medalType.equalsIgnoreCase("Gold Medal")) {
            return "ouro";
        } else if (medalType.equalsIgnoreCase("Silver Medal")) {
            return "prata";
        } else if (medalType.equalsIgnoreCase("Bronze Medal")) {
            return "bronze";
        }
        return "medalhas desconhecidas";
    }

    private String extractMedalTypeFromPrompt(String prompt) {
        if (prompt.toLowerCase().contains("ouro")) {
            return "Gold Medal";
        } else if (prompt.toLowerCase().contains("prata")) {
            return "Silver Medal";
        } else if (prompt.toLowerCase().contains("bronze")) {
            return "Bronze Medal";
        }
        return "";
    }

    private String extractCountryFromPrompt(String prompt) {
        for (Map.Entry<String, String> entry : countryMap.entrySet()) {
            if (prompt.toLowerCase().contains(entry.getKey())) {
                return entry.getKey();
            }
        }
        return "";
    }
}
