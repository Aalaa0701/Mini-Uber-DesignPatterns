import java.io.*;
import java.util.*;
import java.util.HashMap;


public class UserFile implements FileHandlingForUsersRead, FileHandlingForUsersWrite {
    private static UserFile instance = new UserFile();

    private UserFile(){};

    public static UserFile getInstance() {
        return instance;
    }

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
        File usersFile = new File("src/Users.txt");
        try{
            PrintWriter usersWriter = new PrintWriter(new FileWriter(usersFile));
            String Line="";
            // Printing all elements of a Map
            for(Object key:Users.keySet()){
                User userTemp = (User) Users.get(key);
                Line = userTemp.getUserName()+" "+userTemp.getPassword();
                usersWriter.println(Line);
            }
            usersWriter.close();
        } catch (IOException ex) {
            System.out.println("Exception");
        }
    }


}
