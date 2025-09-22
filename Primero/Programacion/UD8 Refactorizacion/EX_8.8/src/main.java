public class main {
    public static void main(String[] args) {
        StaffMember staffMemberInterface = new StaffMember("John Doe", 5000, new
                StaffMember.Address("123 Main St", "Springfield", "12345"));
        System.out.println(staffMemberInterface.getDetails());
    }
}
