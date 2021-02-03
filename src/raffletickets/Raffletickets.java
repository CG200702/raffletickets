/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raffletickets;

/**
 *
 * @author tim
 */
import java.io.*;
import java.util.*;

public class Raffletickets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println(" Welcome to my raffle.\n Please make a selection: Are you going to buy a ticket or check one?");
//            System.out.println(" 1: print \"buy\"\n 2: print \"check\" ");
//            int menuSelection = Integer.parseInt(input.readLine());
            String name = "";
            String name2 = "";
            int min = 0;
            int max = 100;
            int winningnum = rand.nextInt((max - min) + 1) + min;;
            String str[] = name.split(",");
            List<String> al = new ArrayList<String>();
            al = Arrays.asList(str);
            boolean change = false;
            while (change == false) {
                System.out.println(" Welcome to my raffle.\n Please make a selection: Are you going to buy a ticket or check one?");
                System.out.println(" 1: print \"buy\"\n 2: print \"check\" ");
                int menuSelection = Integer.parseInt(input.readLine());
                switch (menuSelection) {
                    case (1):

                        System.out.println("What's your name?");
                        name = input.readLine();
                        name2 = name;

                        System.out.println("How many do you want to buy?");
                        int ticketsnum = Integer.parseInt(input.readLine());

                        for (int i = 0; i < ticketsnum; i++) {
                            int randNum = rand.nextInt((max - min) + 1) + min;
                            System.out.println("Your ticket number is " + randNum);
                            String randnum1 = Integer.toString(randNum);
                            name2 = name2 + ", " + randnum1;
                        }
                        System.out.println(name2);
                        System.out.println("Would you like to buy any more tickets or check your tickets");
                        String answer = input.readLine();
                        if (answer.equalsIgnoreCase("no")) {
                            change = true;
                        }

//                    System.out.println(" 1: print \"buy\"\n 2: print \"check\" ");
//                    menuSelection = Integer.parseInt(input.readLine());
//                    for (String s : al) {
//                        System.out.println(s);
//                    }
                        break;

                    case (2):
                        System.out.println("check");
                        System.out.println("What's your name?");
                        String username = input.readLine();
                        System.out.println(name2);
                        System.out.println(al);
                        String[] elements = name2.split(",");
                        System.out.println(elements);

                        List<String> result = Arrays.asList(name2.split("\\s*,\\s*"));

                        System.out.println(result);
                        for (int j = result.size(); 0 < j; j--) {
                            if ((result.indexOf(j) == winningnum)) {
                                int temp;
                                boolean isPrime = true;
                                Scanner scan = new Scanner(System.in);

                                scan.close();
                                for (int i = 2; i <= result.indexOf(j) / 2; i++) {
                                    temp = result.indexOf(j) % i;
                                    if (temp == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                                if (isPrime) {
                                    System.out.println(result.indexOf(j) + " is a Prime Number. Congratulations, you've won|!");
                                    break;
                                } else {
                                    System.out.println(result.indexOf(j) + " is not a Prime Number. Unfortunately you haven't won.");
                                }
                            }
                        }

//                     
                        menuSelection = Integer.parseInt(input.readLine());

                        break;

                    default:
                        System.out.println("not a valid choice");
                        break;

                }
            }

        } catch (Exception e) {
            System.out.println("EXCEPTION:ERROR OCCURED");
        }

    }
}

