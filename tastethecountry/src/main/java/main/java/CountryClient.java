package main.java;

import io.github.cdimascio.dotenv.Dotenv;
import java.net.http.HttpClient;

public class CountryClient {
    
    private final Dotenv dotenv;
    private final HttpClient httpClient = HttpClient.newHttpClient();

    // 1. RestCountries - URL (Behöver oftast ingen nyckel)
    private final String countryApiUrl;

    // 2. TheMealDB - URL och Nyckel
    private final String mealDbUrl;
    private final String mealDbKey;

    // 3. OpenWeatherMap - URL och Nyckel (Den du hittade på bilden!)
    private final String weatherApiUrl;
    private final String weatherApiKey;

    public CountryClient() {
        Dotenv env;
        try {
            env = Dotenv.load();
        } catch (Exception e) {
            try {
                env = Dotenv.configure().directory("../").load();
            } catch (Exception e2) {
                env = Dotenv.configure().ignoreIfMissing().load();
            }
        }
        this.dotenv = env;

        this.countryApiUrl = dotenv.get("COUNTRY_API_URL");
        this.mealDbUrl = dotenv.get("MEAL_DB_URL");
        this.mealDbKey = dotenv.get("MEAL_DB_API_KEY");
        this.weatherApiUrl = dotenv.get("WEATHER_API_URL");
        this.weatherApiKey = dotenv.get("WEATHER_API_KEY");
    }

    public org.json.JSONObject getCountryInfo(String countryName) {
        try {
            String url = countryApiUrl + "/name/" + countryName;
            java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .build();

            java.net.http.HttpResponse<String> response = httpClient.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                org.json.JSONArray jsonArray = new org.json.JSONArray(response.body());
                return jsonArray.getJSONObject(0);
            } else {
                System.out.println("Error: " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}