package Leetcode.Knowledge.IO集合到文件;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetToFileDemo {
    public static void main(String[] args) throws IOException {
        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num = o2.getSum() - o1.getSum();
                int num2 = num == 0 ? o1.getChinese() - o2.getChinese() : num;
                int num3 = num2 == 0 ? o1.getMath() - o2.getMath() : num2;
                int num4 = num3 == 0 ? o1.getEnglish() - o2.getEnglish() : num3;
                int num5 = num4 == 0 ? o1.getName().compareTo(o2.getName()) : num4;
                return num5;
            }
        });
        for (int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入第" + (i + 1) + "个学生信息：");
            System.out.println("请输入学生姓名：");
            String name = sc.next();
            System.out.println("请输入语文成绩：");
            int chinese = sc.nextInt();
            System.out.println("请输入数学成绩：");
            int math = sc.nextInt();
            System.out.println("请输入英语成绩：");
            int english = sc.nextInt();

            Student s = new Student();
            s.setName(name);
            s.setChinese(chinese);
            s.setMath(math);
            s.setEnglish(english);

            ts.add(s);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\JAVATest\\grade.txt"));
        for (Student t : ts) {
            StringBuilder str = new StringBuilder();
            str.append(t.getName()).append(",").append(t.getChinese()).append(",").append(t.getMath()).append(",").append(t.getEnglish()).append(",").append(t.getSum());
            bw.write(str.toString());
            bw.newLine();
            bw.flush();
        }

        bw.close();
    }
}
