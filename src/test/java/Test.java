package test.java;

public class Test {

    static class Employee {
        int id;
        String name;

        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee(1, "soumya");
        System.out.println("Employee:" + e.toString());
        Display(e);
        System.out.println("Employee:" + e.toString());
    }

    private static void Display(Employee e) {
        e.id = 100;
        e.name = "Shaurya";
        System.out.println("Employee:" + e.toString());
    }
}
