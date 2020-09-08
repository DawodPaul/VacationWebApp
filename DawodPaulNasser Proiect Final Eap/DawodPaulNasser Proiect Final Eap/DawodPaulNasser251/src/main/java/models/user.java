package models;

public class user {
private Integer idUser;
private String userlogin;
private String password;
private String Nume;
private String Prenume;
private Integer BaniCheltuitiTotal;

    public user(String userlogin, String password, String nume, String prenume, Integer baniCheltuitiTotal) {
        this.userlogin = userlogin;
        this.password = password;
        Nume = nume;
        Prenume = prenume;
        BaniCheltuitiTotal = baniCheltuitiTotal;
    }

    public user(Integer idUser, String userlogin, String password, String nume, String prenume, Integer baniCheltuitiTotal) {
        this.idUser = idUser;
        this.userlogin = userlogin;
        this.password = password;
        Nume = nume;
        Prenume = prenume;
        BaniCheltuitiTotal = baniCheltuitiTotal;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(String userlogin) {
        this.userlogin = userlogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public Integer getBaniCheltuitiTotal() {
        return BaniCheltuitiTotal;
    }

    public void setBaniCheltuitiTotal(Integer baniCheltuitiTotal) {
        BaniCheltuitiTotal = baniCheltuitiTotal;
    }

    @Override
    public String toString() {
        return "user{" +
                "idUser=" + idUser +
                ", userlogin='" + userlogin + '\'' +
                ", password='" + password + '\'' +
                ", Nume='" + Nume + '\'' +
                ", Prenume='" + Prenume + '\'' +
                ", BaniCheltuitiTotal=" + BaniCheltuitiTotal +
                '}';
    }
}
