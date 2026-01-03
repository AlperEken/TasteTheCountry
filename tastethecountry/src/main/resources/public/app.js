const searchForm = document.getElementById('searchForm');
const countryInput = document.getElementById('countryInput');

const countryNameEl = document.getElementById('countryName');
const regionEl = document.getElementById('region');
const capitalEl = document.getElementById('capital');
const populationEl = document.getElementById('population');
const flagImgEl = document.getElementById('flagImg');

// New elements for Food and Weather
const mealNameEl = document.getElementById('mealName');
const mealImgEl = document.getElementById('mealImg');
const mealLinkEl = document.getElementById('mealLink');
const tempEl = document.getElementById('temp'); // Make sure you have this ID in HTML
const weatherDescEl = document.getElementById('desc'); // Make sure you have this ID in HTML

searchForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    const query = countryInput.value.trim();
    if (!query) return;

    try {
        const response = await fetch(`/api/country/${query}`);
        if (!response.ok) {
            alert('Country not found!');
            return;
        }

        const data = await response.json();
        console.log("Data received:", data); // Debugging
        updateUI(data);
    } catch (error) {
        console.error('Error fetching data:', error);
        alert('Something went wrong!');
    }
});

function updateUI(data) {
    // 1. UNPACK COUNTRY DATA
    // We must access 'data.country' first because of the backend structure
    const c = data.country;

    if (c) {
        countryNameEl.textContent = c.name.common;
        regionEl.textContent = c.region;
        // Backend sends capital as an array, we take the first one
        capitalEl.textContent = c.capital ? c.capital[0] : 'N/A';
        populationEl.textContent = c.population.toLocaleString();
        flagImgEl.src = c.flags.svg;
        flagImgEl.alt = `Flag of ${c.name.common}`;
    }

    // 2. UNPACK MEAL DATA
    if (data.meals && data.meals.meals) {
        const meals = data.meals.meals;
        // Pick a random meal to show
        const randomMeal = meals[Math.floor(Math.random() * meals.length)];

        if(mealNameEl) mealNameEl.textContent = randomMeal.strMeal;
        if(mealImgEl) mealImgEl.src = randomMeal.strMealThumb;
        if(mealLinkEl) mealLinkEl.href = `https://www.themealdb.com/meal/${randomMeal.idMeal}`;
    } else {
        if(mealNameEl) mealNameEl.textContent = "No recipes found";
    }

    // 3. UNPACK WEATHER DATA (Bonus for VG)
    if (data.weather && data.weather.main) {
        // Round temp to 1 decimal
        const temp = Math.round(data.weather.main.temp * 10) / 10;
        if(tempEl) tempEl.textContent = temp;
        if(weatherDescEl) weatherDescEl.textContent = data.weather.weather[0].description;
    }
}