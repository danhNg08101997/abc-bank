package fis.abcBank.dto.response;

public class GDVResponse {
    private int gdvID;
    private String gdvName;
    private int gdvAvailable;

    public int getGdvID() {
        return gdvID;
    }

    public void setGdvID(int gdvID) {
        this.gdvID = gdvID;
    }

    public String getGdvName() {
        return gdvName;
    }

    public void setGdvName(String gdvName) {
        this.gdvName = gdvName;
    }

    public int getGdvAvailable() {
        return gdvAvailable;
    }

    public void setGdvAvailable(int gdvAvailable) {
        this.gdvAvailable = gdvAvailable;
    }
}
