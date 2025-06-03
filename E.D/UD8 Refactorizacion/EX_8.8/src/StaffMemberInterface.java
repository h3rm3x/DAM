public interface StaffMemberInterface {
    int NUMERO_MESES = 12;

    String getDetails();

    default double getYearlySalary() {
        return salary * NUMERO_MESES;
    }
}
