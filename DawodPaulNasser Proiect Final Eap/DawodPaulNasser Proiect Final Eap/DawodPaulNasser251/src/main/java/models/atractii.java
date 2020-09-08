package models;

public class atractii {
    private Integer idAtractii;
    private Integer ID_L;
    private String  NumeAtractie;
    private Double Rating;

    public atractii(Integer idAtractii, Integer ID_L, String numeAtractie, Double rating) {
        this.idAtractii = idAtractii;
        this.ID_L = ID_L;
        NumeAtractie = numeAtractie;
        Rating = rating;
    }



    public Integer getIdAtractii() {
        return idAtractii;
    }

    public void setIdAtractii(Integer idAtractii) {
        this.idAtractii = idAtractii;
    }

    public Integer getID_L() {
        return ID_L;
    }

    public void setID_L(Integer ID_L) {
        this.ID_L = ID_L;
    }

    public String getNumeAtractie() {
        return NumeAtractie;
    }

    public void setNumeAtractie(String numeAtractie) {
        NumeAtractie = numeAtractie;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }
}
