package com.example.meallog;



import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "record_table")
public class Record {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String cal; // 칼로리
    private String fro; // 단백질
    private String gibang; // 지방
    private String tan; // 탄수화물

    // 생성자
    public Record(String name, String cal, String fro, String gibang, String tan) {
        this.name = name;
        this.cal = cal;
        this.fro = fro;
        this.gibang = gibang;
        this.tan = tan;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getFro() {
        return fro;
    }

    public void setFro(String fro) {
        this.fro = fro;
    }

    public String getGibang() {
        return gibang;
    }

    public void setGibang(String gibang) {
        this.gibang = gibang;
    }

    public String getTan() {
        return tan;
    }

    public void setTan(String tan) {
        this.tan = tan;
    }
}
