package entity;

import java.util.Objects;
import java.util.Vector;
public class Supplier {

    String code = "";
    String name = "";
    String address = "";
    boolean colloboration = true;

    public Supplier() {
    }

    public Supplier(String code) {
        this.code = code;
    }

    public Supplier(String code, String name, String address, boolean colloboration) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.colloboration = colloboration;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isColloboration() {
        return colloboration;
    }

    public void setColloboration(boolean colloboration) {
        this.colloboration = colloboration;
    }

    @Override
    public String toString() {
        return name ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Supplier other = (Supplier) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
    
}
