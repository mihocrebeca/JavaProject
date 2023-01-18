package org.ieti.MihocRebeca;

public class Employee {
    private String firstName;
    private String lastName;
    private String Departament;
    private int id;
    private boolean parttime;

    public Employee(){}

    public Employee(String firstName, String lastName, String Departament,int id,boolean parttime){
        this.firstName=firstName;
        this.lastName=lastName;
        this.Departament=Departament;
        this.id=id;
        this.parttime=parttime;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getDepartament() {
        return Departament;
    }
    public void setDepartament(String Departament){
        this.Departament=Departament;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
}
