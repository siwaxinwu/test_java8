package org.roy.serializableDemo;

import org.roy.Student;

import java.io.*;

/**
 * description：
 * author：dingyawu
 * date：created in 11:15 2020/8/27
 * history:
 */
public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        FileOutputStream fos = new FileOutputStream("D:\\roy.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Student student1 = new Student(){{
            setPassword("123");
            setUserName("roy");
            setYear("2000");
        }};
        oos.writeObject(student1);
        oos.flush();
        oos.close();
        //反序列化
        FileInputStream fis = new FileInputStream("D:\\roy.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student2 = (Student) ois.readObject();
        System.out.println(student2.getUserName()+ " " +
                student2.getPassword() + " " + student2.getYear());
    }

}
