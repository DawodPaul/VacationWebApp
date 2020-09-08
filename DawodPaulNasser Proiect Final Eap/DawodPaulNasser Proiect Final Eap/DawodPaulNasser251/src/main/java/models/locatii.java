package models;

public class locatii {
    private Integer idLocatii;
    private String  Nume;

    public locatii(Integer idLocatii,String nume) {
        this.idLocatii = idLocatii;
        Nume = nume;
    }

    public Integer getIdLocatii() {
        return idLocatii;
    }

    public void setIdLocatii(Integer idLocatii) {
        this.idLocatii = idLocatii;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    @Override
    public String toString() {
        return idLocatii+" "+Nume;
    }
}
