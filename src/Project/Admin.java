package Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    String user;
    int password;

    public Admin(String user, int password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "user='" + user + '\'' +
                ", password=" + password ;
    }

    public static void main(String[] args) {
        int count =0;
        ArrayList<Admin> adminList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter username");
        String user = input.next();
        int password = Integer.parseInt(input.next());

        File file = new File("C:\\Users\\Mohammed\\IdeaProjects\\SWE 206\\src\\Project\\login.txt");
        try {
            Scanner read = new Scanner(file);
            while (read.hasNext()) {
                adminList.add(new Admin(read.next(), read.nextInt()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (adminList.contains(user)) {
            while (!adminList.get(count).user.equals(user)) {
                count++;
            }
        }
        if (adminList.get(count).user.equals(user) && adminList.get(count).password == password) {
            System.out.println("Welcome");
        } else {
            System.out.println("There is something wrong");
        }
    }
}
