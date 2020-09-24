package me.mlhmz.sqlApplication.objects;

public class Users {

    public int id = 0;
    public String firmenname = "";
    public String adresse = "";
    public String telefonnummer = "";
    public String firmenemail = "";

    public Users(int id, String firmenname, String adresse, String telefonnummer, String firmenemail) {
        this.id = id;
        this.firmenname = firmenname;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.firmenemail = firmenemail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getFirmenemail() {
        return firmenemail;
    }

    public void setFirmenemail(String firmenemail) {
        this.firmenemail = firmenemail;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firmenname='" + firmenname + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telefonnummer='" + telefonnummer + '\'' +
                ", firmenemail='" + firmenemail + '\'' +
                '}';
    }
}
