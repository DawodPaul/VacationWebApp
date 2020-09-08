package models;

import java.util.Date;

public class vacante {
    private Integer idVacante;
    private Integer  ID_U ;
    private Integer ID_L ;
    private Date Data_St;
    private Date Data_Sf ;
    private Integer BaniV ;

    public vacante(Integer idVacante,Integer ID_U, Integer ID_L, Date data_St, Date data_Sf, Integer baniV) {
        this.idVacante= idVacante;
        this.ID_U = ID_U;
        this.ID_L = ID_L;
        Data_St = data_St;
        Data_Sf = data_Sf;
        BaniV = baniV;
    }

    public Integer getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(Integer idVacante) {
        this.idVacante = idVacante;
    }

    public Integer getID_U() {
        return ID_U;
    }

    public void setID_U(Integer ID_U) {
        this.ID_U = ID_U;
    }

    public Integer getID_L() {
        return ID_L;
    }

    public void setID_L(Integer ID_L) {
        this.ID_L = ID_L;
    }

    public Date getData_St() {
        return Data_St;
    }

    public void setData_St(Date data_St) {
        Data_St = data_St;
    }

    public Date getData_Sf() {
        return Data_Sf;
    }

    public void setData_Sf(Date data_Sf) {
        Data_Sf = data_Sf;
    }

    public Integer getBaniV() {
        return BaniV;
    }

    public void setBaniV(Integer baniV) {
        BaniV = baniV;
    }


    @Override
    public String toString() {
        return "vacante{" +
                "idVacante=" + idVacante +
                ", ID_U=" + ID_U +
                ", ID_L=" + ID_L +
                ", Data_St=" + Data_St +
                ", Data_Sf=" + Data_Sf +
                ", BaniV=" + BaniV +
                '}';
    }
}
