
class Person {

    String name;
    short age;
    String address;

    Person(String name, short age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    Person() {
        this("Unknown", (short) 0, "Not Available");
    }

    void setDetails(String name, short age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}

class Student extends Person {

    byte semester;
    String branch;

    Student(String name, short age, String address, byte semester, String branch) {
        super(name, age, address);
        this.semester = semester;
        this.branch = branch;
    }

    Student() {
        this("Unknown", (short) 0, "Not Available", (byte) 0, "Not Available");
    }

    void setDetails(String name, short age, String address, byte semester, String branch) {
        super.setDetails(name, age, address);
        this.semester = semester;
        this.branch = branch;
    }

    void display() {
        super.display();
        System.out.println("Semester: " + semester);
        System.out.println("Branch: " + branch);
    }
}

class Employee extends Person {

    String organization;
    String designation;
    double salary;

    Employee(String name, short age, String address, String organization, String designation, double salary) {
        super(name, age, address);
        this.organization = organization;
        this.designation = designation;
        this.salary = salary;
    }

    Employee() {
        this("Unknown", (short) 0, "Not Available", "Not Available", "Not Available", 0.0);
    }

    void setDetails(String name, short age, String address, String organization, String designation, double salary) {
        super.setDetails(name, age, address);
        this.organization = organization;
        this.designation = designation;
        this.salary = salary;
    }

    void display() {
        super.display();
        System.out.println("Organization: " + organization);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
    }
}

class Q1 {

    public static void main(String[] args) {
        // #===== Person Class =====#
        System.out.println("Person Class");
        Person person1 = new Person();
        person1.display();

        System.out.println("\n");
        Person person2 = new Person("Aditya", (short) 19, "Varanasi");
        person2.display();

        System.out.println("\n");

        // #===== Student Class =====#
        System.out.println("Student Class");
        Student student1 = new Student();
        student1.display();

        System.out.println("\n");
        Student student2 = new Student("Aditya", (short) 19, "Varanasi", (byte) 3, "CSE");
        student2.display();

        System.out.println("\n");

        // #===== Employee Class =====#
        System.out.println("Employee Class");
        Employee employee1 = new Employee();
        employee1.display();

        System.out.println("\n");
        Employee employee2 = new Employee("Aditya", (short) 19, "Varanasi", "Google", "Software Developer", 1000000.0);
        employee2.display();
    }
}
