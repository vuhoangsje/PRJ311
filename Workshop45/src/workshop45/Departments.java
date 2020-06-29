/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop45;

/**
 *
 * @author vuhoa
 */
public class Departments {
    String code, name;

    public Departments(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Departments() {
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
public void validate(String code, String name) throws Exception {
        try {
            this.setCode(code);
        } catch (Exception e) {
            throw e;
        }
        try {
            this.setName(name);
        } catch (Exception e) {
            throw e;
        }
}
    @Override
    public String toString() {
        return code + "-" + name;
    }
}
