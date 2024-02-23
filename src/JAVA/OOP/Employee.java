package JAVA.OOP;

public class Employee{
    private int baseSalary;
    private int hourlyRate;

    public Employee(int baseSalary, int hourlyRate){
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
    }
    
    public int calculateWage(int extraHours){
        return baseSalary + (hourlyRate * extraHours);
    }


    private void setBaseSalary(int baseSalary){
        if(baseSalary <= 0)
            throw new IllegalArgumentException("Salary should be greater than 0");
        this.baseSalary = baseSalary;
    }

    private void setHourlyRate(int hourlyRate){
        if(hourlyRate <= 0)
            throw new IllegalArgumentException("Salary should be greater than 0");
        this.hourlyRate = hourlyRate;
    }

}



