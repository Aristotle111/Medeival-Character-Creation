package com.mycompany.app;

import java.io.FileWriter;
import java.util.Scanner;

import com.mycompany.app.Weapon.Damage;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        userSetup();
        characterSetup();
        input.close();
    }

    public static void userSetup() {
        System.out.print("\n" +
        "  ╔════════════════════════════════════════════════╗\n" +
        "  ║                                                ║\n" +
        "  ║      ███╗   ███╗███████╗██████╗ ██╗███████╗    ║\n" +
        "  ║      ████╗ ████║██╔════╝██╔══██╗██║██╔════╝    ║\n" +
        "  ║      ██╔████╔██║█████╗  ██║  ██║██║█████╗      ║\n" +
        "  ║      ██║╚██╔╝██║██╔══╝  ██║  ██║██║██╔══╝      ║\n" +
        "  ║      ██║ ╚═╝ ██║███████╗██████╔╝██║██║         ║\n" +
        "  ║      ╚═╝     ╚═╝╚══════╝╚═════╝ ╚═╝╚═╝         ║\n" +
        "  ║                                                ║\n" +
        "  ║           )   CHARACTER CREATION   (           ║\n" +
        "  ║                                                ║\n" +
        "  ║   \"The anvil of destiny awaits your strike\"    ║\n" +
        "  ║                                                ║\n" +
        "  ╚════════════════════════════════════════════════╝\n");

        System.out.print("\n Declare yourself, wanderer: ");
        String username = input.nextLine().trim();
            
        while (username.isEmpty()) {
            System.out.print("\nA name is required, brave one. Try again: ");
            username = input.nextLine().trim();
        }
        
        User user = new User();
        user.setUsername(username);
        System.out.println("\nWelcome, " + username + "! Your journey begins...");
    }

    public static void characterSetup() {
        System.out.print("\n" +
    " _____________________________________________________________________ \n" +
    "/                                                                     \\\n" +
    "|   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  |\n" +
    "|   *                                                               *  |\n" +
    "|   *      ███╗   ███╗ █████╗  ██████╗ ███████╗                     *  |\n" +
    "|   *      ████╗ ████║██╔══██╗██╔════╝ ██╔════╝                     *  |\n" +
    "|   *      ██╔████╔██║███████║██║  ███╗█████╒═══════════╗           *  |\n" +
    "|   *      ██║╚██╔╝██║██╔══██║██║   ██║██╔══╝  Spells   ║           *  |\n" +
    "|   *      ██║ ╚═╝ ██║██║  ██║╚██████╔╝███████╗═════════╝           *  |\n" +
    "|   *      ╚═╝     ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝                     *  |\n" +
    "|   *      - Masters of arcane magic                                *  |\n" +
    "|   *      - Devastating area damage                                *  |\n" +
    "|   *      - Fragile but powerful                                   *  |\n" +
    "|   *                                                               *  |\n" +
    "|   *      █████╗ ██████╗  ██████╗██╗  ██╗███████╗██████╗           *  |\n" +
    "|   *     ██╔══██╗██╔══██╗██╔════╝██║  ██║██╔════╝██╔══██╗          *  |\n" +
    "|   *     ███████║██████╔╝██║     ███████║█████╗  ██████╔╝═════╗    *  |\n" +
    "|   *     ██╔══██║██╔══██╗██║     ██╔══██║██╔══╝  ██╔══██╗ Aim ║    *  |\n" +
    "|   *     ██║  ██║██║  ██║╚██████╗██║  ██║███████╗██║  ██║═════╝    *  |\n" +
    "|   *     ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝          *  |\n" +
    "|   *      - Deadly precision strikes                               *  |\n" +
    "|   *      - Excellent range and mobility                           *  |\n" +
    "|   *      - Specialized in single-target damage                    *  |\n" +
    "|   *                                                               *  |\n" +
    "|   *     ███████╗██╗    ██╗ ██████╗ ██████╗██████╗ ███████╗        *  |\n" +
    "|   *     ██╔════╝██║    ██║██╔═══██╗██╔══██╗██╔══██╗██╔════╝       *  |\n" +
    "|   *     ███████╗██║ █╗ ██║██║   ██║██████╔╝██║  ██║█████╗══════╗  *  |\n" +
    "|   *     ╚════██║██║███╗██║██║   ██║██╔══██╗██║  ██║██╔══╝ Parry║  *  |\n" +
    "|   *     ███████║╚███╔███╔╝╚██████╔╝██║  ██║██████╔╝███████╗════╝  *  |\n" +
    "|   *     ╚══════╝ ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚══════╝       *  |\n" +
    "|   *      - Unbreakable defense                                    *  |\n" +
    "|   *      - Master of melee combat                                 *  |\n" +
    "|   *      - High survivability                                     *  |\n" +
    "|   *                                                               *  |\n" +
    "|   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  |\n" +
    "\\_____________________________________________________________________/\n" +
    "\nChoose your destiny Mage, Archer, or Swordsman: ");
    
        Character character = null;
        while (character == null) {
            String choice = input.nextLine().trim().toLowerCase();
            switch (choice) {
                case "swordsman" -> character = new Swordsman();
                case "mage" -> character = new Mage();
                case "archer" -> character = new Archer();
                default -> System.out.print("Please choose one of the options listed: ");
            }
        }
                
        System.out.print("\nWhat is the name of your character?: ");
        character.setName(input.nextLine());

        System.out.print("\nWhat is the gender of your character (male/female)?: ");
        while (true) {
            String genderInput = input.nextLine().trim().toLowerCase();
            if (genderInput.equals("male")) {
                character.setGender(Character.Gender.MALE);
                break;
            } else if (genderInput.equals("female")) {
                character.setGender(Character.Gender.FEMALE);
                break;
            }
            System.out.print("Please enter either male or female: ");
        }

        System.out.print("\nHow old is your character?: "); 
        while (!input.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            input.next(); // consume invalid input
        }
        character.setAge(input.nextInt());
        input.nextLine(); // consume newline

        try (FileWriter fw = new FileWriter("Characters.txt")) {
            fw.write(character.toString());
        } catch (Exception e) {
            System.out.println("Failed to save character. Please try again.");
            characterSetup();
            return;
        }

        pickWeapon(character);
    }

    public static void pickWeapon(Character character) {
        if (character instanceof Mage) {
            //sout
            while (true) {
                String weaponChoice = input.nextLine().toLowerCase();
                    
                if ("".equals(weaponChoice)) {
                    character.setWeapon(new Weapon("", Item.Weight.LIGHT, Damage.WEAK));
                    break;
                } else if ("".equals(weaponChoice)) {
                    character.setWeapon(new Weapon("", Item.Weight.MODERATE, Damage.MODERATE));
                    break;
                } else if ("".equals(weaponChoice)) {
                    character.setWeapon(new Weapon("", Item.Weight.HEAVY, Damage.STRONG));
                    break;
                } else {
                    System.out.print("\nplease choose one of the options listed: ");
                }
            }
        } else if (character instanceof Archer) {
            //sout
            while (true) {
                String weaponChoice = input.nextLine().toLowerCase();
                    
                if ("".equals(weaponChoice)) {
                    character.setWeapon(new Weapon("", Item.Weight.LIGHT, Damage.WEAK));
                    break;
                } else if ("".equals(weaponChoice)) {
                    character.setWeapon(new Weapon("", Item.Weight.MODERATE, Damage.MODERATE));
                    break;
                } else if ("".equals(weaponChoice)) {
                    character.setWeapon(new Weapon("", Item.Weight.HEAVY, Damage.STRONG));
                    break;
                } else {
                    System.out.print("\nplease choose one of the options listed: ");
                }
            }
        } else if (character instanceof Swordsman) {
            //sout
            while (true) {
                String weaponChoice = input.nextLine().toLowerCase();
                    
                if ("".equals(weaponChoice)) {
                    character.setWeapon(new Weapon("", Item.Weight.LIGHT, Damage.WEAK));
                    break;
                } else if ("".equals(weaponChoice)) {
                    character.setWeapon(new Weapon("", Item.Weight.MODERATE, Damage.MODERATE));
                    break;
                } else if ("".equals(weaponChoice)) {
                    character.setWeapon(new Weapon("", Item.Weight.HEAVY, Damage.STRONG));
                    break;
                } else {
                    System.out.print("\nplease choose one of the options listed: ");
                }
            }
        } 
    }
}
