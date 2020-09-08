package models;


import java.util.Date;

public class vacUserFriendly {
    String nume;
    Date data_st;
    Date data_sf;

    public vacUserFriendly(String nume, Date data_st, Date data_sf) {
        this.nume = nume;
        this.data_st = data_st;
        this.data_sf = data_sf;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Date getData_st() {
        return data_st;
    }

    public void setData_st(Date data_st) {
        this.data_st = data_st;
    }

    public Date getData_sf() {
        return data_sf;
    }

    public void setData_sf(Date data_sf) {
        this.data_sf = data_sf;
    }

    @Override
    public String toString() {
        return   nume + " "+ data_st ;
    }
}
