package sg.edu.rp.webservices.p12_mydatabook;

/**
 * Created by 15017569 on 8/10/2017.
 */


import java.io.Serializable;


public class Data implements Serializable{
    private int id;
    private String data;

    public Data(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}