package models;

public class atractii_user {
    private Integer idAtractii_Userl;
    private Integer idA;
    private Integer id_v;
    private Integer  Rating_U;
    private Integer Bani;
    private String Recenzie;

    public atractii_user(Integer idAtractii_Userl, Integer idA, Integer id_v, Integer rating_U, Integer bani,String Recenzie) {
        this.idAtractii_Userl = idAtractii_Userl;
        this.idA = idA;
        this.id_v = id_v;
        Rating_U = rating_U;
        Bani = bani;
        this.Recenzie=Recenzie;
    }

    public atractii_user(Integer idA, Integer id_v, Integer rating_U, Integer bani) {
        this.idA = idA;
        this.id_v = id_v;
        Rating_U = rating_U;
        Bani = bani;
    }

    public Integer getIdAtractii_Userl() {
        return idAtractii_Userl;
    }

    public void setIdAtractii_Userl(Integer idAtractii_Userl) {
        this.idAtractii_Userl = idAtractii_Userl;
    }

    public Integer getIdA() {
        return idA;
    }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    public Integer getId_v() {
        return id_v;
    }

    public void setId_v(Integer id_v) {
        this.id_v = id_v;
    }

    public Integer getRating_U() {
        return Rating_U;
    }

    public void setRating_U(Integer rating_U) {
        Rating_U = rating_U;
    }

    public Integer getBani() {
        return Bani;
    }

    public void setBani(Integer bani) {
        Bani = bani;
    }

    public String getRecenzie() {
        return Recenzie;
    }

    public void setRecenzie(String recenzie) {
        Recenzie = recenzie;
    }

    @Override
    public String toString() {
        return "ID Atractie="+idA+" Bani cheltuiti="+Bani+" User Rating="+Rating_U+"Recenzie="+Recenzie;
    }
}
