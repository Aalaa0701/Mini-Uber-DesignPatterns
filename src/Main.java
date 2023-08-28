import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        Motorbike motorbikeObj=new Motorbike("ahmed",2f);
        NormalRide normalRideObj =new NormalRide("ahmed",2f);
        PremiumRide premiumRideObj=new PremiumRide("ahmed",2f);
        Bus busObj =new Bus("ahmed",2f);
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        do {
            System.out.println("Choose 1 for Normal ride or 2 for Premium ride or 3 for motor bike ride or 4 for bus ride :");
            userChoice = scanner.nextInt();

            if (userChoice == 1) {
                normalRideObj.requestRide();
                normalRideObj.chooseLocation();
            } else if (userChoice == 2) {
                premiumRideObj.requestRide();
                premiumRideObj.chooseLocation();
            } else if (userChoice == 3) {
                motorbikeObj.requestRide();
                motorbikeObj.chooseLocation();
            } else if (userChoice == 4) {
                busObj.requestRide();
                busObj.chooseLocation();
            } else {
                System.out.println("Invalid choice plea5se try again!");
            }
        }while (userChoice > 4 || userChoice <1);

    }
}