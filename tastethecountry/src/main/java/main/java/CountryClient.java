package main.java;

import io.github.cdimascio.dotenv.Dotenv;
import java.net.http.HttpClient;

public class CountryClient {
    
    // Vi laddar in dotenv här så vi kan komma åt din API-nyckel
    private final Dotenv dotenv = Dotenv.load();
    private final String apiKey = dotenv.get("API_KEY"); 
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public void getCountryInfo(String countryName) {
        // Här kommer vi snart skriva koden som faktiskt hämtar data!
        System.out.println("Försöker hämta info om: " + countryName);
    }
}