## Daniela Punzi - SWD

# Meteo

**Meteo** è una web app semplice e intuitiva che consente di consultare il meteo attuale e le previsioni per le città.  
Realizzata in **Java**, **HTML**, **JavaScript** e con supporto completo a **Docker**, si appoggia a un'API esterna per ottenere dati meteo aggiornati.

---
## Obiettivo

L'app permette all’utente di:
- Selezionare il nome di una città.
- Visualizzare in tempo reale le condizioni meteo attuali e le previsioni.
- Utilizzare l’app sia in ambiente locale che via Docker.


---

## Funzionalità principali

- Ricerca meteo per nome città.
- Visualizzazione di temperatura e grafico.
- Integrazione con API esterna (OpenWeatherMap).
- Interfaccia semplice e responsive.
- Supporto a Docker e Docker Compose.

---

## Tecnologie utilizzate

- **Java** 
- **JavaScript** 
- **HTML5** 
- **Docker & Docker Compose**
- **OpenWeatherMap API** 

---



## Installazione & Utilizzo


### 1. Clonazione del repo

```bash
git clone https://github.com/Daniela15P/Meteo-.git
cd Meteo-
```

### 2. Avvio rapido con Docker Compose
Per avviare o riavviare completamente l'applicazione in ambiente Docker, usa i comandi seguenti:

```bash
docker-compose down -v 

docker-compose up --build -d
```

### 3. Visualizzazione nel browser
Per visualizzare l'applicazione apri il browser e inserisci:
```bash
localhost:8081
```