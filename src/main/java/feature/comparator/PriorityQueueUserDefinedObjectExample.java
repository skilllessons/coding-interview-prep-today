package main.java.feature.comparator;

import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;


public class PriorityQueueUserDefinedObjectExample {

    public static void main(String[] args) {

        PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        // Add items to the Priority Queue
        employeePriorityQueue.add(new Employee("Rajeev", 100000.00));
        employeePriorityQueue.add(new Employee("Chris", 145000.00));
        employeePriorityQueue.add(new Employee("Andrea", 115000.00));
        employeePriorityQueue.add(new Employee("Jack", 167000.00));



        /*
            The compareTo() method implemented in the Employee class is used to determine
            in what order the objects should be dequeued.
        */
        while (!employeePriorityQueue.isEmpty()) {
            System.out.println(employeePriorityQueue.remove());
        }

    }


    static class Employee implements Comparable<Employee> {

        private String name;
        private double salary;


        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }


        @Override
        public int compareTo(Employee employee) {

            if (this.getSalary() > employee.getSalary()) {
                return 1;
            } else if (this.getSalary() < employee.getSalary()) {
                return -1;
            } else {
                return 0;
            }

        }

        @Override
        public int hashCode() {
            return Objects.hash(name, salary);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}


