package models;

import java.math.BigDecimal;

public class Employee {

    private final String firstName;
    private final String surname;
    private final double annualSalary;
    private final double superRate;
    private final String startDate;
    private final String endDate;

    public Employee(String firstName, String surname, double annualSalary, double superRate, String startDate, String endDate) {
        this.firstName = firstName;
        this.surname = surname;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public double getSuperRate() {
        return superRate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
