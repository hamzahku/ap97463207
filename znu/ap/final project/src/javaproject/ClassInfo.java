/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

/**
 *
 * @author Administrator
 */
public class ClassInfo {
    
    private String name;
    private int vahed;
    private String DateTime;

    public String getName() {
        return name;
    }

    public int getVahed() {
        return vahed;
    }

    public String getDateTime() {
        return DateTime;
    }

    @Override
    public String toString() {
        return "name=" + name + ", vahed=" + vahed + ", DateTime=" + DateTime + '}';
    }

    public ClassInfo(String name, int vahed, String DateTime) {
        this.name = name;
        this.vahed = vahed;
        this.DateTime = DateTime;
    }
public ClassInfo() {
        this.name = "";
        this.vahed = 0;
        this.DateTime = "";
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setVahed(int vahed) {
        this.vahed = vahed;
    }

    public void setDateTime(String DateTime) {
        this.DateTime = DateTime;
    }
    
    
}
