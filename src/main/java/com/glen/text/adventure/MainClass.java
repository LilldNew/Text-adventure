/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glen.text.adventure;

/**6
 *
 * @author Admin
 */
import java.util.*;
public class MainClass {

    // used as currency
    public static int coins = 0;
    private static Person enemy1;
    private static Person enemy2;
    private static Scanner scan = new Scanner(System.in);
    public static Person main = new Person();

    public static void main(String[] args) {
        text("You are an adventurer about to embark on your adventue");
        main.updateName("Your");
        text("You have entered a cave and can make a decision");
        text("You can turn left, go stright, turn right or turn around");
        while (true) {
            caveDecision();
        }

    }

    private static void fight(Person enemy1, Person enemy2) {
        int Decision;
        text("You are now in a fight with " + enemy1.getName() + ", " + enemy2.getName());
        text("You can attack, rest and sharper your weapon, or heal");
        text("Choose wisley");
        while (true) {
            text("Enter 1 for attack, 2 for rest or 3 for heal");
            Decision = scan.nextInt();
            if (Decision == 1) {
                int ifdecision;
                text("Choose your emeny");
                text("Orc\'s health is " + enemy1.getHealth() + " And mercenery\'s health is " + enemy2.getHealth());
                text("Enter a 1 for orc or 2 for mercenery");
                ifdecision = scan.nextInt();
                if (ifdecision == 1) {
                    if (!enemy1.isDead())
                        main.attack(enemy1);
                    else {
                        text("The orc is dead.  You are now attacking the mercenery");
                        main.attack(enemy2);
                    }

                } else {
                    if (!enemy2.isDead())
                        main.attack(enemy2);
                    else {
                        text("The mercenery is dead.  You are now attacking the orc");
                        main.attack(enemy1);
                    }
                }
            } else if (Decision == 2) {
                main.rest();
                text("You sharpened your weapon, and it now does five more damage!");

            } else if (Decision==3){
                text("You decided to heal");
                main.heal();

            } else{
            char o = 108;
            char y = 71;
            char k = 0x6e; 
            char r = 101;
            text("" + y + o + r + k);
            }

            if (!enemy1.isDead()) {
                enemyMove(enemy1);
            }
            if (!enemy2.isDead()) {
                enemyMove(enemy2);
            }
            if ((enemy1.isDead() && enemy2.isDead())) {
                break;
            }
            if (main.isDead()) {
                text("You died");
                text("Re-run this program to try again");
                System.exit(0);
            }
        }
    }

    private static void enemyMove(Person enemy) {
        Random random = new Random();
        int decision = random.nextInt(5) + 1;
        if (decision == 1) {
            text(enemy.getName() + " decided to attack you.");
            enemy.attack(main);
        } else if (decision == 2) {
            text(enemy.getName() + " Decided to rest and sharpen his weapon.");
            enemy.rest();
        } else if (decision == 3) {
            text(enemy.getName() + " Decided to heal.");
            enemy.heal();
        } else {
            text(enemy.getName() + " did not make a move.");
        }
    }

    private static void caveDecision() {

        text("Enter a 1 for left, 2 for stright, 3 for right, and 4 to turn around");
        int Decision = scan.nextInt();
        switch (Decision) {
            case 1:
                turnLeft();
                break;
            case 2:
                goFoward();
                break;
            case 3:
                turnRight();
                break;
            case 4:
                turnAround();
                break;
            default:
            char t = 71;
            char j = 108;
            char u = 101;
            char o = 0x6e;
            text("" + t + j + u + o);
            break;
        }
    }

    private static void text(String gtext) {
        char holder = 0;
        for (int i = 0; i < gtext.length(); i++) {
            holder = gtext.charAt(i);
            System.out.print(holder);
            waitTime(50);
        }
        System.out.println();
        waitTime(1000);
    }

    private static void waitTime(int x) {
        long start = System.currentTimeMillis();
        long end = start + x;
        while (System.currentTimeMillis() < end) {

        }

    }

    private static void turnLeft() {
        Random random = new Random();
        int number = random.nextInt(100);

        if (number < 19) {
            text("You have reached a dead end, and you need to turn around");
            turnAround();
        } else if (number < 29) {
            text("You have encountered two enemmies in your path");
            enemy1 = new Person("Orc", true, false, 30, 30, 20);
            enemy2 = new Person("Mercenary", true, false, 30, 30, 20);
            fight(enemy1, enemy2);

        } else if (number < 39) {
            text("You are running down the passage and have bumped into a pressure plate.");
            text("The pressure plate is linked to an arrow  dispensor.");
            text("You lost 20 hit points");
            main.reduceHealth(20);
            if (main.isDead()) {
                text("You died");
                text("Re-run this program to try again");
                System.exit(0);
            }

        } else if (number < 49) {
            text("You are running down the passage and have bumped into a pressure plate.");
            text("The pressure plate is linked to an arrow  dispensor.");
            text("All of the arrows missed you");

        } else if (number < 59) {
            text("You have found the idol!");
            text("And you made it out alive");
            System.exit(0);

        } else if (number < 94) {
            text("You have not found anything unusual");
        } else {
            text("You feel your feet brush against a string");
            text("All of the doors have closed");
            text("You can hear the sound of a bomb arming");
            text("A hydrogen bomb has detonated beneth your feet, blowing you to smithereens");
            text("Re-run this program to try again");
            System.exit(0);
        }
    }

    private static void turnRight() {
        Random random = new Random();
        int number = random.nextInt(100);

        if (number < 19) {
            text("You have reached a dead end, and you need to turn around");
            turnAround();
        } else if (number < 29) {
            text("You have encountered two enemmies in your path");
            enemy1 = new Person("Orc", true, false, 30, 30, 20);
            enemy2 = new Person("Mercenary", true, false, 30, 30, 20);
            fight(enemy1, enemy2);

        } else if (number < 39) {
            text("You are running down the passage and have bumped into a pressure plate.");
            text("The pressure plate is linked to an arrow  dispensor.");
            text("You lost 20 hit points");
            main.reduceHealth(20);
            if (main.isDead()) {
                text("You died");
                text("Re-run this program to try again");
                System.exit(0);
            }

        } else if (number < 49) {
            text("You are running down the passage and the cave collapses");
            text("You lose 40 health and have to wait 30 seconds");
            main.reduceHealth(40);
            if (main.isDead()) {
                text("You died");
                text("Re-run this program to try again");
                System.exit(0);
            }
            waitTime(30000);

        } else if (number < 59) {
            text("You have found the idol!");
            text("And you made it out alive");
            System.exit(0);

        } else if (number < 94) {
            text("You have not found anything unusual");
        } else {
            text("You feel your feet brush against a string");
            text("All of the doors have closed");
            text("You can hear the sound of a bomb arming");
            text("A hydrogen bomb has detonated beneth your feet, blowing you to smithereens");
            text("Re-run this program to try again");
            System.exit(0);
        }
    }   
    private static void turnAround() {
        Random random = new Random();
        int number = random.nextInt(100);

        if (number < 19) {
            text("You have found a button");
            text("Do you want to press it");
            text("Enter 1 to press the button, 2 to not press the button");
            int decision = scan.nextInt();
            if (decision == 1) {
                int numnber2 = random.nextInt(6);
                text("You press the button");
                if (numnber2 == 1) {

                    text("All of the doors have closed");
                    text("You can hear the sound of a bomb arming");
                    text("A hydrogen bomb has detonated beneth your feet, blowing you to smithereens");
                    text("Re-run this program to try again");
                    System.exit(0);
                } else if (numnber2 == 2) {
                    text("You have gained 100 health");
                    main.reduceHealth(-100);
                } else if (numnber2 == 3) {
                    text("You have sharpened your weapon to do 30 damage");
                    main.rest();
                    main.rest();
                    main.rest();
                    main.rest();
                    main.rest();
                    main.rest();
                } else {
                    text("Nothning happened");
                }
            } else {

            }
        } else if (number < 29) {
            text("You have encountered two enemmies in your path");
            enemy1 = new Person("Orc", true, false, 30, 30, 20);
            enemy2 = new Person("Mercenary", true, false, 30, 30, 20);
            fight(enemy1, enemy2);

        } else if (number < 39) {
            text("You are running down the passage and have bumped into a pressure plate.");
            text("The pressure plate is linked to an arrow  dispensor.");
            text("You lost 20 hit points");
            main.reduceHealth(20);
            if (main.isDead()) {
                text("You died");
                text("Re-run this program to try again");
                System.exit(0);
            }

        } else if (number < 49) {
            text("You are running down the passage and have bumped into a pressure plate.");
            text("The pressure plate is linked to an arrow  dispensor.");
            text("All of the arrows missed you");

        } else if (number < 59) {
            text("You have found the idol!");
            text("And you made it out alive");
            System.exit(0);

        } else if (number < 94) {
            text("You have not found anything unusual");
        } else {
            text("You feel your feet brush against a string");
            text("All of the doors have closed");
            text("You can hear the sound of a bomb arming");
            text("A hydrogen bomb has detonated beneth your feet, blowing you to smithereens");
            text("Re-run this program to try again");
            System.exit(0);
        }

    }

    private static void goFoward() {
        Random random = new Random();
        int number = random.nextInt(100);

        if (number < 19) {
            text("You have reached a dead end, and you need to turn around");
            turnAround();
        } else if (number < 29) {
            text("You have encountered two enemmies in your path");
            enemy1 = new Person("Orc", true, false, 30, 30, 20);
            enemy2 = new Person("Mercenary", true, false, 30, 30, 20);
            fight(enemy1, enemy2);

        } else if (number < 39) {
            text("You are running down the passage and have bumped into a pressure plate.");
            text("The pressure plate is linked to an arrow  dispensor.");
            text("You lost 20 hit points");
            main.reduceHealth(20);
            if (main.isDead()) {
                text("You died");
                text("Re-run this program to try again");
                System.exit(0);
            }

        } else if (number < 49) {
            text("You are running down the passage and have bumped into a pressure plate.");
            text("The pressure plate is linked to an arrow  dispensor.");
            text("All of the arrows missed you");

        } else if (number < 59) {
            text("You have found the idol!");
            text("And you made it out alive");
            System.exit(0);

        } else if (number < 94) {
            text("You have not found anything unusual");
        } else {
            text("You feel your feet brush against a string");
            text("All of the doors have closed");
            text("You can hear the sound of a bomb arming");
            text("A hydrogen bomb has detonated beneth your feet, blowing you to smithereens");
            text("Re-run this program to try again");
            System.exit(0);
        }
    }
}
