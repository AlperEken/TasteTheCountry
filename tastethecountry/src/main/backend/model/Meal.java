package model;

import org.json.JSONObject;

public class Meal {
    private String name;
    private String imageUrl;
    private String id;

    public Meal(String name, String imageUrl, String id) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("strMeal", name);
        json.put("strMealThumb", imageUrl);
        json.put("idMeal", id);
        return json;
    }
}