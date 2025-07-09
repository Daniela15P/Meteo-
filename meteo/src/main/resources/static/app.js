document.addEventListener("DOMContentLoaded", () => {
  const citySelect = document.getElementById("city-select");
  const fetchBtn = document.getElementById("fetch-weather");
  const errorMsg = document.getElementById("error-message");
  const chartContainer = document.querySelector(".chart-container");
  const chartTitle = document.getElementById("chart-title");
  const ctx = document.getElementById("weather-chart").getContext("2d");

  let currentChart = null;

  // Load cities
  fetch("http://localhost:8081/api/citta")
    .then(res => res.json())
    .then(data => {
      data.forEach(city => {
        const option = document.createElement("option");
        option.value = city.nome;
        option.textContent = city.nome;
        citySelect.appendChild(option);
      });
    })
    .catch(() => {
      errorMsg.textContent = "Failed to load cities.";
      errorMsg.style.display = "block";
    });

  // Fetch weather on button click
  fetchBtn.addEventListener("click", () => {
    const selectedCity = citySelect.value;
    if (!selectedCity) return;

    errorMsg.style.display = "none";
    chartContainer.style.display = "none";

    fetch(`http://localhost:8081/api/meteo?citta=${selectedCity}`)
      .then(res => {
        if (!res.ok) throw new Error("City not found");
        return res.json();
      })
      .then(weatherData => {
        chartTitle.textContent = `Temperature in ${selectedCity}`;
        chartContainer.style.display = "block";

        // Mostra solo le prime 24 ore
        const labels = weatherData.time.slice(0, 24).map(t => t.split("T")[1]); // estrae solo l’ora da "YYYY-MM-DDTHH:MM"
        const temperatures = weatherData.temperature.slice(0, 24);

        const data = {
          labels: labels,
          datasets: [{
            label: "Temperature (°C)",
            data: temperatures,
            borderColor: "rgba(75,192,192,1)",
            backgroundColor: "rgba(75,192,192,0.2)",
            fill: true,
            tension: 0.3
          }]
        };

        const options = {
          responsive: true,
          scales: {
            x: {
              title: {
                display: true,
                text: "Hour"
              }
            },
            y: {
              title: {
                display: true,
                text: "Temperature (°C)"
              }
            }
          }
        };

        if (currentChart) currentChart.destroy();
        currentChart = new Chart(ctx, {
          type: "line", // <-- Line chart per grafico cartesiano
          data,
          options
        });
      })
      .catch(() => {
        errorMsg.textContent = "Failed to load weather data.";
        errorMsg.style.display = "block";
      });
  });
});
