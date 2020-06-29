/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Vector;

/**
 *
 * @author vuhoa
 */
public class EmpList extends Vector<Employees>{
    public EmpList(){
        super();
    }
    public int findCode(String code){
        for (int i = 0; i < this.size(); i++) {
            Employees emp = this.get(i);
            if (emp.getCode().equalsIgnoreCase(code)){
                return i;
            }
        }
        return -1;
    }
    public  EmpList findName(String name){
        EmpList empList = new EmpList();
        for (Employees x : this) {
            if(x.getName().contains(name)){
                empList.add(x);
            }
        }
        return empList;
    }
}
