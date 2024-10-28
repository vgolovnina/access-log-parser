import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Statistics {
    private final HashSet<String> existingPages;
    private final HashMap<String, Integer> osFrequency;
    private final HashSet<String> nonExistentPages;
    private final HashMap<String, Integer> browserFrequency;

    public Statistics() {
        existingPages = new HashSet<>();
        osFrequency = new HashMap<>();
        nonExistentPages = new HashSet<>();
        browserFrequency = new HashMap<>();
    }

    public void addEntry(String url, int responseCode, String operatingSystem, String userAgent) {
        if (responseCode == 200) {
            existingPages.add(url);
        } else if (responseCode == 404) {
            nonExistentPages.add(url);
        }

        osFrequency.put(operatingSystem, osFrequency.getOrDefault(operatingSystem, 0) + 1); //Подсчет частоты ОС
        browserFrequency.put(userAgent, browserFrequency.getOrDefault(userAgent, 0) + 1); //Подсчет частоты браузеров

    }

    public HashSet<String> getExistingPages() { //Получение списка всех существующих страниц

        return existingPages;
    }
    public HashSet<String> getNonExistentPages() { //Получение списка несуществующих страниц
        return nonExistentPages;
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

    public HashMap<String, Double> getBrowserStatistics() { //Метод для получения статистики браузеров
        HashMap<String, Double> browserStatistics = new HashMap<>();
        int totalCount = browserFrequency.values().stream().mapToInt(Integer::intValue).sum();

        if (totalCount == 0) {
            return browserStatistics; //Пустая статистика если список пуст
        }

        for (Map.Entry<String, Integer> entry : browserFrequency.entrySet()) {
            double proportion = (double) entry.getValue() / totalCount;
            browserStatistics.put(entry.getKey(), proportion);
        }

        return browserStatistics;
    }

    public static void main(String[] args) {
        Statistics stats = new Statistics();

        stats.addEntry("https://online.stepup.study/course_sessions/active", 200, "Windows", "GoogleChrome/11.0 (Windows NT 10.0; Win64; x64)");
        stats.addEntry("https://veronicagolovnina.com/home", 404, "MacOS", "Safari/18.0 (Macintosh; M1 Mac OS Sonoma 12_0)");

        System.out.println("Существующие страницы:");
        for (String page : stats.getExistingPages()) {
            System.out.println(page);
        }
        System.out.println("Несуществующие страницы:");
        for (String page : stats.getNonExistentPages()) {
            System.out.println(page);
        }

        System.out.println("Статистика операционных систем:");
        for (Map.Entry<String, Double> entry : stats.getOSStatistics().entrySet()) {
            System.out.printf("%s: %.2f%% ", entry.getKey(), entry.getValue() * 100);
        }

        System.out.println();

        System.out.println("Статистика браузеров:");
        for (Map.Entry<String, Double> entry : stats.getBrowserStatistics().entrySet()) {
            System.out.printf("%s: %.2f%% ", entry.getKey(), entry.getValue() * 100);

        }
    }
}