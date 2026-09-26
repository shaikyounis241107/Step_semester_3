Instance vs staticclass 
SrmStudent {
    String name;
    String regNo;

    static String university =
            "SRM Institute of Science and Technology";

    static String campus = "SRM Kattankulathur";

    static int admissionCount = 0;

    SrmStudent(String name) {
        this.name = name;
        admissionCount++;
        this.regNo = "RA23110030101" + admissionCount;
    }

    void printIdCard() {
        System.out.println(regNo + " | " + name + " | " + campus);
    }

    static void printTotalAdmissions() {
        System.out.println(
                "Students admitted so far: " + admissionCount);
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        SrmStudent ravi = new SrmStudent("Ravi");
        SrmStudent meera = new SrmStudent("Meera");

        ravi.printIdCard();
        meera.printIdCard();

        SrmStudent.printTotalAdmissions();

        SrmStudent.campus = "SRM Ramapuram";

        ravi.printIdCard();
        meera.printIdCard();
    }
}