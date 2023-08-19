import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class UserFile implements FileHandlingForUsersRead, FileHandlingForUsersWrite {

    @Override
    public void readUsers(HashMap Users) {
        try{
            File usersFile = new File("src/Users.txt");
            Scanner usersScan = new Scanner(usersFile);
            while(usersScan.hasNextLine()){
                String[] LineSplit = usersScan.nextLine().split(" ");
                String username, password;
                username = LineSplit[0];
                password = LineSplit[1];
                User UserTemp = new User(username,password);
                Users.put(username,UserTemp);

            }
            usersScan.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found!");
        }


    }

    @Override
    public void Write(HashMap Users) {

    }


}
