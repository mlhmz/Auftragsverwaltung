package me.mlhmz.sqlApplication.objects;

public class Products {
    public int id = 0;
    public String produktname = "";



    public Products(int id, String produktname) {
        this.id = id;
        this.produktname = produktname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduktname() {
        return produktname;
    }

    public void setProduktname(String produktname) {
        this.produktname = produktname;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", produktname='" + produktname + '\'' +
                '}';
    }
}
