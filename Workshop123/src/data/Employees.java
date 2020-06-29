/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author vuhoa
 */
public class Employees implements Comparable<Employees>{
    String code, name, address;
    boolean gender;
    int salary;

    public Employees() {
        code = "";
        name = "";
        address = "";
        gender = true;
        salary = 0;
    }
    
    
    public Employees(String code, String name,String address, boolean gender, int salary) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.salary = salary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        code = code.trim();
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(String salary) throws Exception{
        int temp;
        try {
            temp = Integer.parseInt(salary);
        }catch (Exception e){
            throw new Exception("Please input number!!!");
        }
        if (temp <= 0){
            throw new Exception("Salary can't less than 0");
        }
        this.salary = temp;
    }
    
    @Override
    public String toString() {
        return "Employees{" + "code=" + code + ", name=" + name + ", gender=" + gender + ", salary=" + salary + '}';
    }

    @Override
    public int compareTo(Employees o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }
    
}
