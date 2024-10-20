import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Statistics {
    private final HashSet<String> existingPages;
    private final HashMap<String, Integer> osFrequency;

    public Statistics() {
        existingPages = new HashSet<>();
        osFrequency = new HashMap<>();
    }

    public void addEntry(String url, int responseCode, String operatingSystem) {
        if (responseCode == 200) {
            existingPages.add(url);
        }

        osFrequency.put(operatingSystem, osFrequency.getOrDefault(operatingSystem, 0) + 1); //Подсчет частоты ОС
    }

    public HashSet<String> getExistingPages() { //Получение списка всех страниц
        return existingPages;
    }


    public HashMap<String, Double> getOSStatistics() { //Метод для получения статистики ОС
        HashMap<String, Double> osStatistics = new HashMap<>();
        int totalCount = osFrequency.values().stream().mapToInt(Integer::intValue).sum();

        for (Map.Entry<String, Integer> entry : osFrequency.entrySet()) {
            double proportion = (double) entry.getValue() / totalCount;
            osStatistics.put(entry.getKey(), proportion);
        }

        return osStatistics;
    }

}
