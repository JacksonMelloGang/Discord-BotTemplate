package fr.askyna.bot;

import fr.askyna.bot.modules.ModuleManager;

import java.util.Scanner;

public class UserThreadInput implements Runnable {
    @Override
    public void run() {
        while(true){
            System.out.print("Please enter a command: ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch(input){
                case "shutdown":
                    ModuleManager.unloadModules();
                    System.exit(0);
                case "stop":

                    break;
                case "start":

                    break;
                default:
                    System.out.println("Unknown command, please try again.");
                    break;
            }

        }
    }


}
