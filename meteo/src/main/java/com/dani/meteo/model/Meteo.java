package com.dani.meteo.model;

@Entity
public class Meteo {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String città;
    private double temperatura;
    private String descrizione;

    public Meteo(String città, double temperatura, String descrizione) {
        this.città = città;
        this.temperatura = temperatura;
        this.descrizione = descrizione;
    }

    public String getCittà() {
        return città;
    }
    public void setCittà(String città) {
        this.città = città;
    }
    public double getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
