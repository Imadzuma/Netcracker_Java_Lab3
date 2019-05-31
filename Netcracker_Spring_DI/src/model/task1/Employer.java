package model.task1;

public class Employer {
    private String name;
    private char gender;
    private int salary;

    public Employer() {
        System.out.println("\t-->Employer.Employer(empty)");
    }
    public Employer(String name, char gender, int salary) {
        System.out.println("\t-->Employer.Employer(all params)");
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    public void setName(String name) {
        System.out.println("\t-->Employer.setName");
        this.name = name;
    }
    public void setGender(char gender) {
        System.out.println("\t-->Employer.setGender");
        this.gender = gender;
    }
    public void setSalary(int salary) {
        System.out.println("\t-->Employer.setSalary");
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                '}';
    }
}
