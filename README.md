# API Reference: Taste The Country
This API provides a "mashup" of information about countries, including geographic data, current weather in the capital city, and popular recipes from the region.

## Endpoints
Get Country Data
Returns a combination of country information, weather, and recipes based on the country's name.

* URL: /api/country/{name}

* Method: GET

* URL Parameters:

    * name (Required): The name of the country in English (e.g., sweden or turkey).

## Response Body (JSON)
Upon a successful request (Status 200), a JSON object is returned with the following structure:
```
{
  "country": {
    "capital": [
      "Stockholm"
    ],
    "fact": "The flag of Sweden has a blue field with a large golden-yellow cross that extend to the edges of the field. The vertical part of this cross is offset towards the hoist side.",
    "name": {
      "common": "Sweden"
    },
    "flags": {
      "svg": "https://flagcdn.com/se.svg"
    },
    "region": "Europe",
    "population": 10605098
  },
  "weather": {
    "weather": [
      {
        "description": "snow"
      }
    ],
    "main": {
      "temp": 0.25
    }
  },
  "meals": {
    "meals": [
      {
        "strMealThumb": "https://images.services.kitchenstories.io/hP04DDCA2zQ-oTBkgfZDNJ52CHw=/3840x0/filters:quality(85)/images.kitchenstories.io/wagtailOriginalImages/R2854-photo-final-1.jpg",
        "idMeal": "manual_1",
        "strMeal": "Swedish Meatballs",
        "strSource": "https://kitchenstories.com/en/recipes/traditional-swedish-meatballs",
        "strInstructions": "1. Mix meat and spices. 2. Fry in butter. 3. Serve with lingonberries. Smaklig måltid! :)"
      }
    ]
  }
}
```

## Error Handling
The API uses standard HTTP status codes and returns error messages in JSON format to assist external developers.

### 404 Not Found
Returned if the country could not be found in the database.

```
{
  "error": "Country not found"
}
```
### 500 Internal Server Error
Returned in case of unexpected server errors or issues with external API calls.

```
{
  "error": "Internal Server Error: [Detailed message]"
}
```
