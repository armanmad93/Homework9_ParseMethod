package com.company.employee;

/**
 * @author Arman Karapetyan
 */

public class Employee {

    private static final long ID = 0;
    private static final String FIRST_NAME = "DEFAULT_FIRST_NAME";
    private static final String LAST_NAME = "DEFAULT_LAST_NAME";
    private static final float SALARY = 0f;


    private long id;
    private String firstName;
    private String lastName;
    private float salary;

    public Employee() {
        id = ID;
        firstName = FIRST_NAME;
        lastName = LAST_NAME;
        salary = SALARY;
    }

    public Employee(long id, String firstName, String lastName, float salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}
