package me.mlhmz.sqlApplication.objects;

public class Orders {
    public int auftragsid = 0;
    public String firmenname = "";
    public String firmentelefonnummer = "";
    public String firmenadresse = "";
    public String firmenemail = "";
    public String produkt = "";
    public int menge = 0;
    public String abteilungsname = "";
    public String abteilungsleiter = "";
    public String abteilungstelefonnummer = "";
    public String auftragsdatum = "";
    public String deadline = "";

    public Orders (int auftragsid, String firmenname, String firmentelefonnummer, String firmenadresse, String firmenemail, String produkt, int menge, String abteilungsname,
                    String abteilungsleiter, String abteilungstelefonnummer, String auftragsdatum, String deadline) {
        this.auftragsid = auftragsid;
        this.firmenname = firmenname;
        this.firmentelefonnummer = firmentelefonnummer;
        this.firmenadresse = firmenadresse;
        this.firmenemail = firmenemail;
        this.produkt = produkt;
        this.menge = menge;
        this.abteilungsname = abteilungsname;
        this.abteilungsleiter = abteilungsleiter;
        this.abteilungstelefonnummer = abteilungstelefonnummer;
        this.auftragsdatum = auftragsdatum;
        this.deadline = deadline;
    }

    public int getAuftragsid() {
        return auftragsid;
    }

    public void setAuftragsid(int auftragsid) {
        this.auftragsid = auftragsid;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }

    public String getFirmentelefonnummer() {
        return firmentelefonnummer;
    }

    public void setFirmentelefonnummer(String firmentelefonnummer) {
        this.firmentelefonnummer = firmentelefonnummer;
    }

    public String getFirmenadresse() {
        return firmenadresse;
    }

    public void setFirmenadresse(String firmenadresse) {
        this.firmenadresse = firmenadresse;
    }

    public String getFirmenemail() {
        return firmenemail;
    }

    public void setFirmenemail(String firmenemail) {
        this.firmenemail = firmenemail;
    }

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public String getAbteilungsname() {
        return abteilungsname;
    }

    public void setAbteilungsname(String abteilungsname) {
        this.abteilungsname = abteilungsname;
    }

    public String getAbteilungsleiter() {
        return abteilungsleiter;
    }

    public void setAbteilungsleiter(String abteilungsleiter) {
        this.abteilungsleiter = abteilungsleiter;
    }

    public String getAbteilungstelefonnummer() {
        return abteilungstelefonnummer;
    }

    public void setAbteilungstelefonnummer(String abteilungstelefonnummer) {
        this.abteilungstelefonnummer = abteilungstelefonnummer;
    }

    public String getAuftragsdatum() {
        return auftragsdatum;
    }

    public void setAuftragsdatum(String auftragsdatum) {
        this.auftragsdatum = auftragsdatum;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "auftragsid=" + auftragsid +
                ", firmenname='" + firmenname + '\'' +
                ", firmentelefonnummer='" + firmentelefonnummer + '\'' +
                ", firmenadresse='" + firmenadresse + '\'' +
                ", firmenemail='" + firmenemail + '\'' +
                ", produkt='" + produkt + '\'' +
                ", menge=" + menge +
                ", abteilungsname='" + abteilungsname + '\'' +
                ", abteilungsleiter='" + abteilungsleiter + '\'' +
                ", abteilungstelefonnummer='" + abteilungstelefonnummer + '\'' +
                ", auftragsdatum='" + auftragsdatum + '\'' +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
