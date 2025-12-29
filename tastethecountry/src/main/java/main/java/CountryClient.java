package main.java;

import io.github.cdimascio.dotenv.Dotenv;
import java.net.http.HttpClient;

public class CountryClient {
    
    private final Dotenv dotenv = Dotenv.load();
    private final HttpClient httpClient = HttpClient.newHttpClient();

    // 1. RestCountries - URL (Behöver oftast ingen nyckel)
    private final String countryApiUrl = dotenv.get("COUNTRY_API_URL"); 

    // 2. TheMealDB - URL och Nyckel
    private final String mealDbUrl = dotenv.get("MEAL_DB_URL");
    private final String mealDbKey = dotenv.get("MEAL_DB_API_KEY");

    // 3. OpenWeatherMap - URL och Nyckel (Den du hittade på bilden!)
    private final String weatherApiUrl = dotenv.get("WEATHER_API_URL");
    private final String weatherApiKey = dotenv.get("WEATHER_API_KEY");

    public void getCountryInfo(String countryName) {
        System.out.println("--- Hämtar information för: " + countryName + " ---");
        
        // Exempel på hur URL:erna kommer se ut när vi anropar dem:
        System.out.println("Anropar RestCountries på: " + countryApiUrl + "/name/" + countryName);
        System.out.println("Anropar Väder med nyckel: " + weatherApiKey);
        System.out.println("Anropar Mat-databas med nyckel: " + mealDbKey);
        
        // Härnäst kan vi börja skriva metoderna som faktiskt gör anropen!
    }
}