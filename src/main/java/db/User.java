package db;

import java.io.Serializable;

public class User implements Serializable {
    private String nic;
    private String firstName;
    private String  lastNAme;
    private String address;

    public User(String nic, String firstName, String lastNAme, String address) {
        this.nic = nic;
        this.firstName = firstName;
        this.lastNAme = lastNAme;
        this.address = address;
    }

    public User() {
    }



    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNAme() {
        return lastNAme;
    }

    public void setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
