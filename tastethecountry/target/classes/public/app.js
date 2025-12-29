const searchForm = document.getElementById('searchForm');
const countryInput = document.getElementById('countryInput');

const countryNameEl = document.getElementById('countryName');
const regionEl = document.getElementById('region');
const capitalEl = document.getElementById('capital');
const populationEl = document.getElementById('population');
const flagImgEl = document.getElementById('flagImg');

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
        updateUI(data);
    } catch (error) {
        console.error('Error fetching country data:', error);
        alert('Something went wrong!');
    }
});

function updateUI(data) {
    // RestCountries v3.1 structure
    const name = data.name.common;
    const region = data.region;
    const capital = data.capital ? data.capital[0] : 'N/A';
    const population = data.population.toLocaleString();
    const flagUrl = data.flags.svg;

    countryNameEl.textContent = name;
    regionEl.textContent = region;
    capitalEl.textContent = capital;
    populationEl.textContent = population;
    flagImgEl.src = flagUrl;
    flagImgEl.alt = `Flag of ${name}`;
}
