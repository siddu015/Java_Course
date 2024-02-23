package JavaLAB;


import java.io.*;
import java.util.*;

class Person implements Serializable {
    int id;
    String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Student extends Person{
    String course;
    int fee;
    public Student(int id, String name, String course, int fee) {
        super(id, name);
        this.course = course;
        this.fee = fee;
    }
}


public class SerializeExample {

    public static void main(String[] args) {
        try {
            var scanner = new Scanner(System.in);
            System.out.println("Enter Student Details");
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter course: ");
            String course = scanner.next();
            System.out.print("Enter fee: ");
            int fee = scanner.nextInt();


            var student1 = new Student(id, name, course, fee);
            var out = new ObjectOutputStream(new FileOutputStream(("f.txt")));

            out.writeObject(student1);
            out.flush();
            out.close();
            System.out.println("Serialization process success");
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            var in =  new ObjectInputStream(new FileInputStream("f.txt"));
            var student2 = (Student)in.readObject();
            System.out.println("id: " + student2.id
                                + "\nname: " + student2.name
                                + "\ncourse: " + student2.course
                                + "\nfee: "+student2.fee);
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
