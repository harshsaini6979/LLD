package SplitWiseApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SplitWise {
    public static void main(String[] args) {
        Controller controller;

        Scanner scanner = new Scanner(System.in);

        controller = new Controller();

        while (true) {
            try{
                controller.display();
            }
            catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
