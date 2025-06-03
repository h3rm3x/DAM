class StaffMember implements StaffMemberInterface {
    private String name;
    private double salary;
    private Address address;
    private double yearlySalary;

    public StaffMember(String name, double salary, Address address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    @Override
    public String getDetails() {
        yearlySalary = getYearlySalary();
        return "Employee: " + name + ", Yearly Salary: " + yearlySalary + " Address: " + address.getFullAddress();
    }

}
