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
public class Employees {
    String code, name;
    int salary;

    public Employees(String code, String name, int salary) {
        this.code = code;
        this.name = name;
        this.salary = salary;
    }

    public Employees() {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(String salary) throws Exception {
        int temp;
        try {
            temp = Integer.parseInt(salary);
        } catch (Exception e) {
            throw new Exception("Salary must be number");
        }
        if (temp <= 0) {
            throw new Exception("Salary cannot less than 0");
        }
        this.salary = temp;

    }
    public void validate(String code, String name, String salary) throws Exception {
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
        try {
            this.setSalary(salary);
        } catch (Exception e) {
            throw e;
        }
    }
    @Override
    public String toString() {
        return code + "-" + name ; 
    }
}
