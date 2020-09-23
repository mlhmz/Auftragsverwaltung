package me.mlhmz.sqlApplication.objects;

public class Department {
    public int id = 0;
    public String abteilungsName = "";
    public String abteilungsNummer = "";
    public String abteilungsleiter = "";


    public Department (int id, String abteilungsName, String abteilungsNummer, String abteilungsleiter) {
        this.id = id;
        this.abteilungsName = abteilungsName;
        this.abteilungsNummer = abteilungsNummer;
        this.abteilungsleiter = abteilungsleiter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbteilungsName() {
        return abteilungsName;
    }

    public void setAbteilungsName(String abteilungsName) {
        this.abteilungsName = abteilungsName;
    }

    public String getAbteilungsNummer() {
        return abteilungsNummer;
    }

    public void setAbteilungsNummer(String abteilungsNummer) {
        this.abteilungsNummer = abteilungsNummer;
    }

    public String getAbteilungsleiter() {
        return abteilungsleiter;
    }

    public void setAbteilungsleiter(String abteilungsleiter) {
        this.abteilungsleiter = abteilungsleiter;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", abteilungsName='" + abteilungsName + '\'' +
                ", abteilungsNummer='" + abteilungsNummer + '\'' +
                ", abteilungsleiter='" + abteilungsleiter + '\'' +
                '}';
    }
}
