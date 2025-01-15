package Model;

public class Medikamente {
    public String name;
    public int Preis;
    public String Krankenheit;

    public Medikamente(String name, int preis, String krankenheit) {
        this.name = name;
        Preis = preis;
        Krankenheit = krankenheit;
    }

    public int getPreis() {
        return Preis;
    }

    public void setPreis(int preis) {
        Preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKrankenheit() {
        return Krankenheit;
    }

    public void setKrankenheit(String krankenheit) {
        Krankenheit = krankenheit;
    }

    @Override
    public String toString() {
        return "Medikamente{" +
                "name='" + name + '\'' +
                ", Preis=" + Preis +
                ", Krankenheit='" + Krankenheit + '\'' +
                '}';
    }
}
