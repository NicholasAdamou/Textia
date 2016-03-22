package GameEngine;
/**
 * Text Based Game: Textia
 * A Text Based Game where the player takes on a different enemies and has to destroy them. 
 * You start off with 3 Health Potions, there is a random chance that an enemy will drop a Health Potion if you defeat it.  
 * 
 * 
 * Textia.java
 * @author Nick Adamou
 * @version 1.0 | Date: 9/6/14, September 6th, 2014
 */

import java.util.*;

public class Game
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        
        //Game Variables
        String[] enemies = {
        "Skeleton", 
        "Zombie", 
        "Warrior", 
        "Assassin", 
        "Dragon", 
        "Cataclyst", 
        "SrBombalot", 
        "Orc", 
        "VanDoom",
        "Xenon", 
        "Radon",
        "Prof. Lead", 
        "Captain Krypton"};
        int maxEnemyHealth = 75; 
        int enemyAttackDamage = 25;
        
        //Player Variables
        int health = 100;
        int attackDamage = 50; 
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; //Percentage 
        
        boolean running = true;
        
        System.out.println("Text Based Game: Textia!\nMade and Developed By: Nick Adamou (9/6/14)");
        System.out.println("-----------------------------------------");
        
        GAME: 
        while(running) 
        {
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)]; //AI Picks random Enemy
            /*
             * This function fixes the Grammar with certain enemy names w/:
             * 1. An
             * 2. A
             */
            if(enemy.equals("Assassin"))
            {
                System.out.println("###########################################");
                System.out.println("\t# An " + enemy + " has appeared! #"); //Prints the Randomized Enemy to the Screen
                System.out.println("###########################################\n");
            }
            else if(enemy.equals("Orc"))
            {
                System.out.println("###########################################");
                System.out.println("\t# An " + enemy + " has appeared! #"); //Prints the Randomized Enemy to the Screen
                System.out.println("###########################################\n");
            }
            else if(enemy.equals("VanDoom"))
            {
                System.out.println("###########################################");
                System.out.println("\t# The " + enemy + " has appeared! #"); //Prints the Randomized Enemy to the Screen
                System.out.println("###########################################\n");
            }
            else if(enemy.equals("Prof. Lead"))
            {
                System.out.println("################################################");
                System.out.println("\t# The " + enemy + " has appeared! #"); //Prints the Randomized Enemy to the Screen
                System.out.println("################################################\n");
            }
            else if(enemy.equals("Captain Krypton"))
            {
                System.out.println("#####################################################");
                System.out.println("\t# The " + enemy + " has appeared! #"); //Prints the Randomized Enemy to the Screen
                System.out.println("#####################################################\n");
            }
            else if(enemy.equals("SrBoomalot"))
            {
                System.out.println("####################################################");
                System.out.println("\t# " + enemy + " has appeared! #"); //Prints the Randomized Enemy to the Screen
                System.out.println("####################################################\n");
            }
            else if(enemy.equals("Radon"))
            {
                System.out.println("#########################################");
                System.out.println("\t# A " + enemy + " has appeared! #"); //Prints the Randomized Enemy to the Screen
                System.out.println("#########################################\n");
            }
            else
            {
                System.out.println("###########################################");
                System.out.println("\t# A " + enemy + " has appeared! #"); //Prints the Randomized Enemy to the Screen
                System.out.println("###########################################\n");
            }
            
            while(enemyHealth > 0)
            {
                /*
                 * This below function displays your:
                 * HP (Health)
                 * The Enemies HP (Health)
                 * Then asks the User to do several options:
                 * 1. Attack
                 * 2. Drink a Health Potion
                 * 3. Switch Enemy 
                 * 4. Quit Game
                 */
                System.out.println("\tYour HP: " + health);
                System.out.println("\tHealth Potions: " + numHealthPotions);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.println("\t3. Switch Enemy");
                System.out.println("\t4. Quit Game");
                
                /*
                 * The below function handles the Users input
                 */
                String input = in.nextLine();
                if (input.equals("1")) 
                {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);
                    
                    enemyHealth-= damageDealt;
                    health -=damageTaken;
                    
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + 
                                        " DMG.");
                    System.out.println("\t> You recieve " + damageTaken + " in retaliation!\n");
                    
                    /*
                     * This function handles what goes on when the User Dies
                     */
                    if(health < 1)
                    {
                        System.out.println("\t> You have taken too much DMG, you are\n\ttoo weak to go on!");
                        break;
                    }
                    
                }
                else if(input.equals("2")) 
                {
                    if(numHealthPotions > 0) 
                    {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a Health Potion,\n\t  healing yourself for " +
                                            healthPotionHealAmount +  "." + "\n\t> you now have " + 
                                            health + " HP." + "\n\t> You have " + numHealthPotions + 
                                            " Health Potions left.\n");
                        
                    }
                    else 
                    {
                        System.out.println("\t> You have no Health Potions left!\n\tDefeat enemies for a chance to get one!");
                    }
                }
                else if(input.equals("3"))
                {
                    System.out.println("\t> You Switched Enemies!\n\t  Previous Enemy: " + enemy + "!\n");
                    continue GAME;
                }
                else if(input.equals("4"))
                {
                    System.out.println("Are you sure you want to Quit?\nIf Yes, please press the\nfollowing number to exit:\n[2]\nIf No, please press the\nfollowing number to continue:\n[1]");
                    break;
                }
                 else if(input.equalsIgnoreCase("CHEATS"))
                {
                    numHealthPotions = 1337; 
                    health = 1337; 
                    healthPotionHealAmount = 1337;
                    healthPotionDropChance = 100;
                    attackDamage = 1337;
                    
                    System.out.println("\t#########################");
                    System.out.println("\t    # GOD MODE ON! #");
                    System.out.println("\t#########################\n");
                }
                else if(input.equalsIgnoreCase("CHEATS OFF"))
                {
                    numHealthPotions = 3; 
                    health = 100; 
                    healthPotionHealAmount = 30;
                    healthPotionDropChance = 50;
                    attackDamage = 50;
                    
                    System.out.println("\t#########################");
                    System.out.println("\t   # GOD MODE OFF! #");
                    System.out.println("\t#########################\n");
                }
                else 
                {
                    System.out.println("\t> Invalid Command!\n\tPlease make sure you only type:\n\t1. To Attack\n\t2. To Drink a Health Potion\n\t3. To Switch Enemies\n\t4. To Quit The Game\n\tThank You!\n");
                }
            }
            /*
             * The below function handles the Users health if its too low to continue fighting
             */
            if(health < 1)
            {
                System.out.println("\nYou limp out of the dungeon, weak from battle.\n");
                System.out.println("#########################");
                System.out.println("     # GAME OVER! #");
                System.out.println("#########################\n");
                break;
            }
            /*
             * Below, this code prints to the screen when a Enemy dies
             * 1. Users HP (Health) after the fight
             */
            System.out.println("-----------------------------------------");
            System.out.println(" \t# " + enemy + " was defeated! #");
            System.out.println(" \t# You have " + health + " HP left. #");
            /*
             * The below function handles the random chance a Enemy drops a Health Potion
             * Then prints the updated amount of Health Potions you now have to the Screen
             * Then it asks if you would like to do the following:
             * 1. Continue Fighting
             * 2. Exit Dungeon
             */
            if(rand.nextInt(100) < healthPotionDropChance)
            {
               numHealthPotions++;
               System.out.println(" # The " + enemy + " dropped a Health Potion! #"); 
               System.out.println(" # You now have " + numHealthPotions + " Health Potion(s). #");
            }
            System.out.println("-----------------------------------------\n");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue Fighting");
            System.out.println("2. Exit Dungeon (Quit Game)");
            
            String input = in.nextLine();
            /*
             * This function handles invalid commands
             */
            while(!input.equals("1") && !input.equals("2") && !input.equalsIgnoreCase("CHEATS") && !input.equalsIgnoreCase("CHEATS OFF"))
            {
                System.out.println("> Invalid Command!\nPlease make sure you only type:\n1. To Continue Fighting\n2. To Exit the Dungeon (Quit Game)\nThank You!\n");
                input = in.nextLine();
            }
            /* 
             * This function handles the User input:
             * 1. To Continue Fighting
             * 2. Leave Dungeon and close Game
             */
            if(input.equals("1"))
            {
                System.out.println("You continue on your adventure!\n");
            }
            else if(input.equals("2"))
            {
                System.out.println("You exit the Dungeon successful from\nyour adventures!");
                break;
            }
            else if(input.equalsIgnoreCase("CHEATS"))
            {
               numHealthPotions = 1337; 
               health = 1337; 
               healthPotionHealAmount = 1337;
               healthPotionDropChance = 100;
               attackDamage = 1337;
                    
               System.out.println("\t#########################");
               System.out.println("\t    # GOD MODE ON! #");
               System.out.println("\t#########################\n");
            }
            else if(input.equalsIgnoreCase("CHEATS OFF"))
            {
               numHealthPotions = 3; 
               health = 100; 
               healthPotionHealAmount = 30;
               healthPotionDropChance = 50;
               attackDamage = 50;
                    
               System.out.println("\t#########################");
               System.out.println("\t   # GOD MODE OFF! #");
               System.out.println("\t#########################\n");
            }
    }
    System.out.println("#########################");
    System.out.println(" # THANKS FOR PLAYING! #");
    System.out.println("#########################");
  }
}
