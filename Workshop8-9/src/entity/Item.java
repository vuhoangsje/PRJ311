package entity;
public class Item {

    String code = "";
    String name = "";
    String supCode = "";
    String unit = "";
    int price = 0;
    boolean supplying = true;

    public Item(String code) {
        this.code = code;
    }

    public Item() {
    }

    public Item(String code, String name, String supCode, String unit, int price, boolean supplying) {
        this.code = code;
        this.name = name;
        this.supCode = supCode;
        this.unit = unit;
        this.price = price;
        this.supplying = supplying;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSupplying() {
        return supplying;
    }

    public void setSupplying(boolean supplying) {
        this.supplying = supplying;
    }

    

}
