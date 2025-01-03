package my.utem.ftmk.ViewApp.model;
public class Expense {
    private String expName;
    private String expDate;
    private float expValue;
    private int expQty;

    // Default constructor (no parameters)
    public Expense() {
    }

    // Constructor with parameters (as already defined)
    public Expense(String expName, String expDate, float expValue, int expQty) {
        this.expName = expName;
        this.expDate = expDate;
        this.expValue = expValue;
        this.expQty = expQty;
    }

    // Getter and setter methods
    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public float getExpValue() {
        return expValue;
    }

    public void setExpValue(float expValue) {
        this.expValue = expValue;
    }

    public int getExpQty() {
        return expQty;
    }

    public void setExpQty(int expQty) {
        this.expQty = expQty;
    }
}


