package com.example.recyclerviewmenuselection;

public class Vocabulary {
    String eng;
    String uzb;
    boolean selected=false;

    public Vocabulary(String eng, String uzb) {
        this.eng = eng;
        this.uzb = uzb;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getUzb() {
        return uzb;
    }

    public void setUzb(String uzb) {
        this.uzb = uzb;
    }
}
