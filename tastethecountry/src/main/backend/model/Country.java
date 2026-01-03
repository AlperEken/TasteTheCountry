package model;

import org.json.JSONObject;

public class Country {
    private String name;
    private String region;
    private String capital;
    private long population;
    private String flagUrl;
    private String demonym; // Used to find food (e.g., "French")

    public Country(String name, String region, String capital, long population, String flagUrl, String demonym) {
        this.name = name;
        this.region = region;
        this.capital = capital;
        this.population = population;
        this.flagUrl = flagUrl;
        this.demonym = demonym;
    }

    // Convert to JSON so we can send it to the frontend easily
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", new JSONObject().put("common", name)); // Keeping structure compatible with your frontend
        json.put("region", region);
        // Frontend expects capital as an array
        json.put("capital", new org.json.JSONArray().put(capital));
        json.put("population", population);
        json.put("flags", new JSONObject().put("svg", flagUrl));
        return json;
    }

    public String getCapital() { return capital; }
    public String getDemonym() { return demonym; }
}