package com.mycompany.app;

import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.mycompany.app.Weapon.Damage;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    /**
     * initializes the user setup menu when the user runs the code in order to start the game.
     */
    public static void main(String[] args) {
        try (input) {
            userSetup();
        }
    }

    /**
     * static comparator class that sorts characters by their weapon damage.
     * characters without weapon damage are considered the lowest damage.
     */
    public static class WeaponDamageComparator implements Comparator<Character> {

        /**
         * compares two character objects based on their weapon damage
         * @param c1 the first character to compare
         * @param c2 the second character to compare
         */
        @Override
        public int compare(Character c1, Character c2) {
            if (c1.weapon == null && c2.weapon == null) return 0;
            if (c1.weapon == null) return -1;
            if (c2.weapon == null) return 1;
    
            return c1.weapon.damage.compareTo(c2.weapon.damage);
        }
    }

    /**
     * The initial user setup menu where the user is asked for their name. 
     * This method creates a new User object.
     * This method then asks the user to choose whether they want to create a new character or to leave the game.
     * Initializes the character setup if the user chooses option 1.
     */
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

        System.out.print("\n Declare yourself: ");
        String username = input.nextLine().trim();
            
        while (username.isEmpty()) {
            System.out.print("\nA name is required. Try again: ");
            username = input.nextLine().trim();
        }
        
        User user = new User();
        user.setUsername(username);
        System.out.println("\nWelcome, " + username);
        System.out.print("What is your next move? \n\n1. create a new character\n2. exit\n\nEnter your choice (1-2): ");
        boolean choicePicked = false;
        while (!choicePicked) { 
            int menuChoice = input.nextInt();
            switch (menuChoice) {
                case 1 -> {
                    characterSetup(user);
                    choicePicked = true;
                }
                case 2 -> {
                    System.out.println("Thank you for playing");
                    System.exit(0);
                    choicePicked = true;
                }
                default -> System.out.print("please choose one of the options listed: ");
            }
        }
    }

    /**
     * This method handles the character creation process.
     * It prompts the user to pick between 3 different character types, then uses their choice to create a new character of that type.
     * Then it gets details from the user about the character they are making in order to make their creation come to life.
     * Initializes the weapon selection method.
     * @param user the input User object made in the userSetup method, containing the user's name and an arraylist of characters to be appended
     */
    public static void characterSetup(User user) {
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
        input.nextLine();
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
            input.next();
        }
        character.setAge(input.nextInt());
        input.nextLine();

        pickWeapon(character, user);
    }

    /**
     * This method handles the weapon selection process.
     * It allows a player to select a weapon for their character based on their selected character class.
     * It displays an ASCII-art menu of weapon choices and assigns the selected weapon to the character.
     * @param character The character receiving the weapon (must be Mage, Archer, or Swordsman)
     * @param user The player making the selection
     */
    public static void pickWeapon(Character character, User user) {
        if (character instanceof Mage) {
            System.out.print("\n" +
    " __________________________________________________________________\n" +
    "/                                                                  \\\n" +
    "|                      ~ MAGICAL ARTIFACTS ~                       |\n" +
    "|__________________________________________________________________|\n" +
    "|                                                                  |\n" +
    "|  [1] PHANTOM SHIV (Light)                                        |\n" +
    "|                                                                  |\n" +
    "|           /| ____________                                        |\n" +
    "|       O|===|* >____________>                                     |\n" +
    "|           \\|                                                     |\n" +
    "|                                                                  |\n" +
    "|  [2] OBSCURE TOME (Moderate)                                     |\n" +
    "|                                                                  |\n" +
    "|       ______                                                     |\n" +
    "|      /     /|                                                    |\n" +
    "|     /_____/ |                                                    |\n" +
    "|    |     |  |                                                    |\n" +
    "|    |     |  |                                                    |\n" +
    "|    |_____|  |                                                    |\n" +
    "|    |     |  |                                                    |\n" +
    "|    |     |  /                                                    |\n" +
    "|    |_____| /                                                     |\n" +
    "|    (_____(/                                                      |\n" +
    "|                                                                  |\n" +
    "|  [3] ELDRITCH STAFF (Heavy)                                      |\n" +
    "|                                                                  |\n" +
    "|       \\ .,||,. /                                                 |\n" +
    "|        \\'║║║║'/                                                  |\n" +
    "|    =--+=║║██║║=+--=                                              |\n" +
    "|         /║║║║\\                                                   |\n" +
    "|        /  ||  \\                                                  |\n" +
    "|           ||                                                     |\n" +
    "|           ||                                                     |\n" +
    "|           ||                                                     |\n" +
    "|           ||                                                     |\n" +
    "|           ||                                                     |\n" +
    "|           ||                                                     |\n" +
    "|           ||                                                     |\n" +
    "|           ||                                                     |\n" +
    "|           ||                                                     |\n" +
    "|           ||                                                     |\n" +
    "|           ||                                                     |\n" +
    "|                                                                  |\n" +
    "|__________________________________________________________________|\n" +
    "|                                                                  |\n" +
    "| 1. Cursed Dagger  2. Forbidden Tome  3. Eldritch Staff           |\n" +
    "|__________________________________________________________________|\n" +
    "\\__________________________________________________________________/\n" +
    "\nEnter your choice (1-3): "
);
            OUTER:
            while (true) {
                int weaponChoice = input.nextInt();
                switch (weaponChoice) {
                    case 1 -> {
                        character.setWeapon(new Weapon("Cursed Dagger", Item.Weight.LIGHT, Damage.WEAK, "|           /| ____________                                        |\n" +
                        "|       O|===|* >____________>                                     |\n" + "|           \\|                                                     |\n"));
                        System.out.println("\ngreat choice!");
                        character.weapon.weild();
                        break OUTER;
                    }
                    case 2 -> {
                        character.setWeapon(new Weapon("Forbidden Tome", Item.Weight.BALANCED, Damage.BALANCED, "|       ______                                                     |\n" +
                        "|      /     /|                                                    |\n" +
                        "|     /_____/ |                                                    |\n" +
                        "|    |     |  |                                                    |\n" +
                        "|    |     |  |                                                    |\n" +
                        "|    |_____|  |                                                    |\n" +
                        "|    |     |  |                                                    |\n" +
                        "|    |     |  /                                                    |\n" +
                        "|    |_____| /                                                     |\n" +
                        "|    (_____(/                                                      |\n"));
                        System.out.println("\ngreat choice!");
                        break OUTER;
                    }
                    case 3 -> {
                        character.setWeapon(new Weapon("Eldritch Staff", Item.Weight.HEAVY, Damage.STRONG, "|       \\ .,||,. /                                                 |\n" +
                        "|        \\'||||'/                                                  |\n" +
                        "|    =--+=||{}||=+--=                                              |\n" +
                        "|         /||||\\                                                   |\n" +
                        "|        /  ||  \\                                                  |\n" +
                        "|           ||                                                     |\n" +
                        "|           ||                                                     |\n" +
                        "|           ||                                                     |\n" +
                        "|           ||                                                     |\n" +
                        "|           ||                                                     |\n" +
                        "|           ||                                                     |\n" +
                        "|           ||                                                     |\n" +
                        "|           ||                                                     |\n" +
                        "|           ||                                                     |\n" +
                        "|           ||                                                     |\n" +
                        "|           ||                                                     |\n"));
                        System.out.println("\ngreat choice!");
                        character.weapon.weild();
                        break OUTER;
                    }
                    default -> System.out.print("\nplease choose one of the options listed: ");
                }
            }
        } else if (character instanceof Archer) {
            System.out.print("\n" +
    " ______________________________________________________________________\n" +
    "/                                                                      \\\n" +
    "|                         ~ ARCHERY WEAPONS ~                          |\n" +
    "|______________________________________________________________________|\n" +
    "|                                                                      |\n" +
    "|  [1] LIGHT: Swiftstrike Bow                                          |\n" +
    "|                                                                      |\n" +
    "|       \\                                                              |\n" +
    "|        \\                                                             |\n" +
    "|         )                                                            |\n" +
    "|    #===---->                                                         |\n" +
    "|         )                                                            |\n" +
    "|        /                                                             |\n" +
    "|       /                                                              |\n" +
    "|                                                                      |\n" +
    "|  [2] MODERATE: Hunter's Recurve                                      |\n" +
    "|                                                                      |\n" +
    "|       (                                                              |\n" +
    "|        \\\\                                                            |\n" +
    "|         \\\\                                                           |\n" +
    "|          \\\\                                                          |\n" +
    "|           ))                                                         |\n" +
    "|   ###===========>>                                                   |\n" +
    "|           ))                                                         |\n" +
    "|          //                                                          |\n" +
    "|         //                                                           |\n" +
    "|        //                                                            |\n" +
    "|       (                                                              |\n" +
    "|                                                                      |\n" +
    "|  [3] HEAVY: Titan's War Bow                                          |\n" +
    "|                                                                      |\n" +
    "|                     \\.                                               |\n" + 
    "|                  /   |.                                              |\n" + 
    "|               /      '|.                                             |\n" + 
    "|            /          |\\                                             |\n" + 
    "|         /             ||                                             |\n" + 
    "|       /               ||                                             |\n" +
    "|    ||                 ||                                             |\n" + 
    "|    || ================##==========>                                  |\n" + 
    "|    ||                 ##                                             |\n" + 
    "|      \\                ##                                             |\n" + 
    "|          \\            ||                                             |\n" + 
    "|             \\         ||                                             |\n" + 
    "|                \\      ||                                             |\n" + 
    "|                   \\   |/                                             |\n" + 
    "|                      /.                                              |\n" +
    "|                                                                      |\n" +
    "|______________________________________________________________________|\n" +
    "|                                                                      |\n" +
    "| 1. Swiftstrike  2. Hunter's Recurve  3. Titan's War Bow              |\n" +
    "|______________________________________________________________________|\n" +
    "\\______________________________________________________________________/\n" +
    "\nEnter your choice (1-3): ");
            OUTER:
            while (true) {
                int weaponChoice = input.nextInt();
                switch (weaponChoice) {
                    case 1 -> {
                        character.setWeapon(new Weapon("Swiftstrike", Item.Weight.LIGHT, Damage.WEAK, "|       \\                                                              |\n" +
                        "|        \\                                                             |\n" +
                        "|         )                                                            |\n" +
                        "|    #===---->                                                         |\n" +
                        "|         )                                                            |\n" +
                        "|        /                                                             |\n" +
                        "|       /                                                              |\n"));
                        System.out.println("\ngreat choice!");
                        character.weapon.weild();
                        break OUTER;
                    }
                    case 2 -> {
                        character.setWeapon(new Weapon("Hunter's Recurve", Item.Weight.BALANCED, Damage.BALANCED, "|       (                                                              |\n" +
                        "|        \\\\                                                            |\n" +
                        "|         \\\\                                                           |\n" +
                        "|          \\\\                                                          |\n" +
                        "|           ))                                                         |\n" +
                        "|   ###===========>>                                                   |\n" +
                        "|           ))                                                         |\n" +
                        "|          //                                                          |\n" +
                        "|         //                                                           |\n" +
                        "|        //                                                            |\n" +
                        "|       (                                                              |\n"));
                        System.out.println("\ngreat choice!");
                        character.weapon.weild();
                        break OUTER;
                    }
                    case 3 -> {
                        character.setWeapon(new Weapon("Titan's War Bow", Item.Weight.HEAVY, Damage.STRONG, "|                     \\.                                               |\n" + 
                        "|                  /   |.                                              |\n" + 
                        "|               /      '|.                                             |\n" + 
                        "|            /          |\\                                             |\n" + 
                        "|         /             ||                                             |\n" + 
                        "|       /               ||                                             |\n" +
                        "|    ||                 ||                                             |\n" + 
                        "|    || ================##==========>                                  |\n" + 
                        "|    ||                 ##                                             |\n" + 
                        "|      \\                ##                                             |\n" + 
                        "|          \\            ||                                             |\n" + 
                        "|             \\         ||                                             |\n" + 
                        "|                \\      ||                                             |\n" + 
                        "|                   \\   |/                                             |\n" + 
                        "|                      /.                                              |\n"));
                        System.out.println("\ngreat choice!");
                        character.weapon.weild();
                        break OUTER;
                    }
                    default -> System.out.print("\nplease choose one of the options listed: ");
                }
            }
        } else if (character instanceof Swordsman) {
            System.out.print(
            "\n" +
            "  ____________________________________________________________\n" +
            " /                                                            \\\n" +
            "|                    ~ SELECT YOUR SWORD ~                     |\n" +
            "|______________________________________________________________|\n" +
            "|                                                              |\n" +
            "|  [1] LIGHT                                                   |\n" +
            "|          //                                                  |\n" +
            "|  ()======>>=====================--                           |\n" +
            "|          \\\\                                                  |\n" +
            "|                                                              |\n" +
            "|  [2] MODERATE                                                |\n" +
            "|           |\\                                                 |\n" +
            "|           | \\                                                |\n" +
            "|  ()########|  =================================*             |\n" +
            "|           | /                                                |\n" +
            "|           |/                                                 |\n" +
            "|                                                              |\n" +
            "|  [3] HEAVY                                                   |\n" +
            "|                />                                            |\n" +
            "|   ()          //-----------------------------------(         |\n" +
            "|  (*)OXOXOXOXO(*>      --------------------         \\         |\n" +
            "|   ()          \\-------------------------------------)        |\n" +
            "|                \\>                                            |\n" +
            "|______________________________________________________________|\n" +
            "|                                                              |\n" +
            "| 1. Quick Dagger   2. Versatile Longsword                     |\n" +
            "| 3. Massive Zweihänder                                        |\n" +
            "|______________________________________________________________|\n" +
            "\\_____________________________________________________________/\n" +
            "\nEnter your choice (1-3): ");
            OUTER:
            while (true) {
                int weaponChoice = input.nextInt();
                switch (weaponChoice) {
                    case 1 -> {
                        character.setWeapon(new Weapon("Shortsword", Item.Weight.LIGHT, Damage.WEAK, "|          //                                      |\n" +
                        "|  ()======>>=====================--               |\n" +
                        "|          \\\\                                      |\n"));
                        System.out.println("\ngreat choice!");
                        character.weapon.weild();
                        break OUTER;
                    }
                    case 2 -> {
                        character.setWeapon(new Weapon("Rapier", Item.Weight.BALANCED, Damage.BALANCED, "|           |\\                                                 |\n" + 
                        "|           | \\                                                |\n" + "|  ()########|  =================================*             |\n" +
                        "|           | /                                                |\n" + "|           |/                                                 |\n"));
                        System.out.println("\ngreat choice!");
                        character.weapon.weild();
                        break OUTER;
                    }
                    case 3 -> {
                        character.setWeapon(new Weapon("Zweihander", Item.Weight.HEAVY, Damage.STRONG, "|                />                                            |\n" +
                        "|   ()          //-----------------------------------(         |\n" + "|  (*)OXOXOXOXO(*>      --------------------         \\         |\n" +
                        "|   ()          \\-------------------------------------)        |\n" + "|                \\>                                            |\n"));
                        System.out.println("\ngreat choice!");
                        character.weapon.weild();
                        break OUTER;
                    }
                    default -> System.out.print("\nplease choose one of the options listed: ");
                }
            }
        }
        pickArmor(character, user);
    }

    /**
     * This method handles the armor selection process.
     * It displays an interactive ASCII-art armor selection menu and assigns armor to the character.
     * @param character character The character receiving armor
     * @param user The player making the selection
     * Once the armor has been selected, the character is complete.
     * The completed character is added the the User's "characters" arrayList.
     * The characters arrayList is writen into a text file where the user can view and save their creations.
     * The user is prompted to make a choice: (make a new character, view their existing characters, or exit the program)
     */
    public static void pickArmor(Character character, User user) {
        System.out.print("""

          ╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
          ║                                                                                                                                  ║
          ║                                               █████╗ ██████╗ ███╗   ███╗ ██████╗ ██████╗                                         ║
          ║                                              ██╔══██╗██╔══██╗████╗ ████║██╔═══██╗██╔══██╗                                        ║
          ║                                              ███████║██████╔╝██╔████╔██║██║   ██║██████╔╝                                        ║
          ║                                              ██╔══██║██╔══██╗██║╚██╔╝██║██║   ██║██╔══██╗                                        ║
          ║                                              ██║  ██║██║  ██║██║ ╚═╝ ██║╚██████╔╝██║  ██║                                        ║
          ║                                              ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝                                        ║
          ║                                                                                                                                  ║
          ║    ╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗    ║
          ║    ║                                                      ARMOR SELECTION                                                   ║    ║
          ║    ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝    ║
          ║                                                                                                                                  ║
          ║            [1] LEATHER ARMOR                              [2] CHAINMAIL                              [3] PLATE ARMOR             ║
          ║                                                                                                                                  ║
          ║          Lightweight and flexible                       Balanced protection                         Maximum protection           ║
          ║                                                                                                                                  ║
          ║                  _____                                          {}                                         {|}                   ║
          ║                 /=====\\                                        .--.                                       .---.                  ║
          ║                 ||   ||                                       /.--.\\                                     /_____\\                 ║
          ║                 |`   `|                                       |====|                                     |+++++|                 ║
          ║             .-;`\\=====/`;-.                                   |`::`|                                     |+++++|                 ║
          ║            /  |=========|  \\                              .-;`\\..../`;-.                             .-;`\\_____/`;-.             ║
          ║           |   /=========\\   |                            /''|...::...|''\\                          /   |_________|   \\           ║
          ║           ;--'\\=========/'--;                           |'''/::::::::\\'''|                        |    /         \\    |          ║
          ║           <__>,>.=====.<,<__>                           ;--'\\::::::::/'--;                        ;---'\\         /'---;          ║
          ║           |  |/=========\\|  |                           <__>,>._::_.<,<__>                        <___>,>._____.<,<___>          ║
          ║           \\::/|=========|\\::/                           |::|/:::^^:::\\|::|                        |   |/_________\\|   |          ║
          ║           |||\\|=========|/|||                           \\::/|::::::::|\\::/                        \\:::/|         |\\:::/          ║
          ║               |___/ \\___|                               |||\\|::::::::|/|||                         |||\\|_________|/|||           ║
          ║               \\_  | |  _/                               ''' |___/\\___| '''                            |____/ \\____|              ║
          ║               <_ >| | <_>                                   \\_  ||  _/                                \\__  | |  __/              ║
          ║               |   | |   |                                   <_ >|| <_>                                <__ >| | <__>              ║
          ║               |   | |   |                                   |'''||'''|                                |    | |    |              ║
          ║               _\\.:| |:./_                                   |'''||'''|                                |    | |    |              ║
          ║              /____\\ /____\\                                  _\\.:||:./_                                _\\ .:| |:. /_              ║
          ║                                                            /____\\/____\\                              /_____\\ /_____\\             ║
          ║                                                                                                                                  ║
          ║                                                                                                                                  ║
          ║                                                                                                                                  ║
          ╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝
          Enter your choice (1-3):  """);

        boolean armorSelected = false;
        while (!armorSelected) {
            int armorChoice = input.nextInt();
            switch (armorChoice) {
                case 1 -> {
                    character.setArmor(new Armor("Leather", Item.Weight.LIGHT, Armor.Defense.WEAK, 
                                                "|                _____                                                |\r\n" + //
                                                "|               /=====\\                                               |\r\n" + //
                                                "|               ||   ||                                               |\r\n" + //
                                                "|               |`   `|                                               |\r\n" + //
                                                "|           .-;`\\=====/`;-.                                           |\r\n" + //
                                                "|          /  |=========|  \\                                          |\r\n" + //
                                                "|         |   /=========\\  |                                          |\r\n" + //
                                                "|         ;--'\\========/'--;                                          |\r\n" + //
                                                "|         <__>,>.=====.<,<__>                                         |\r\n" + //
                                                "|         |  |/=========\\|  |                                         |\r\n" + //
                                                "|         \\::/|=========|\\::/                                         |\r\n" + //
                                                "|         |||\\|=========|/|||                                         |\r\n" + //
                                                "|             |___/ \\___|                                             |\r\n" + //
                                                "|             \\_  | |  _/                                             |\r\n" + //
                                                "|             <_ >| | <_>                                             |\r\n" + //
                                                "|             |   | |   |                                             |\r\n" + //
                                                "|             |   | |   |                                             |\r\n" + //
                                                "|             _\\.:| |:./_                                             |\r\n" + //
                                                "|            /____\\ /____\\                                            |"));
                    character.armor.wear();
                    armorSelected = true;
                }
                case 2 -> {
                    character.setArmor(new Armor("Chainmail", Item.Weight.BALANCED, Armor.Defense.DECENT, 
                                                "|                  {}                                                  |\r\n" + //
                                                "|                 .--.                                                 |\r\n" + //
                                                "|                /.--.\\                                                |\r\n" + //
                                                "|                |====|                                                |\r\n" + //
                                                "|                |`::`|                                                |\r\n" + //
                                                "|            .-;`\\..../`;-.                                            |\r\n" + //
                                                "|           /  |...::...|  \\                                           |\r\n" + //
                                                "|          |   /'''::'''\\   |                                          |\r\n" + //
                                                "|          ;--'\\   ::   /'--;                                          |\r\n" + //
                                                "|          <__>,>._::_.<,<__>                                          |\r\n" + //
                                                "|          |  |/   ^^   \\|  |                                          |\r\n" + //
                                                "|          \\::/|        |\\::/                                          |\r\n" + //
                                                "|          |||\\|        |/|||                                          |\r\n" + //
                                                "|          ''' |___/\\___| '''                                          |\r\n" + //
                                                "|              \\_  ||  _/                                              |\r\n" + //
                                                "|              <_ >|| <_>                                              |\r\n" + //
                                                "|              |   ||   |                                              |\r\n" + //
                                                "|              |   ||   |                                              |\r\n" + //
                                                "|              _\\.:||:./_                                              |\r\n" + //
                                                "|             /____\\/____\\                                             |"));
                    character.armor.wear();
                    armorSelected = true;
                }
                case 3 -> {
                    character.setArmor(new Armor("Steel Plated", Item.Weight.HEAVY, Armor.Defense.STRONG, 
                                                "|                   {|}                                            |\r\n" + //
                                                "|                  .---.                                           |\r\n" + //
                                                "|                 /_____\\                                          |\r\n" + //
                                                "|                 |+++++|                                          |\r\n" + //
                                                "|                 |+++++|                                          |\r\n" + //
                                                "|             .-;`\\_____/`;-.                                      |\r\n" + //
                                                "|           /   |_________|   \\                                    |\r\n" + //
                                                "|          |    /         \\    |                                   |\r\n" + //
                                                "|          ;---'\\         /'---;                                   |\r\n" + //
                                                "|          <___>,>._____.<,<___>                                   |\r\n" + //
                                                "|          |   |/_________\\|   |                                   |\r\n" + //
                                                "|          \\:::/|         |\\:::/                                   |\r\n" + //
                                                "|           |||\\|_________|/|||                                    |\r\n" + //
                                                "|              |____/ \\____|                                       |\r\n" + //
                                                "|              \\__  | |  __/                                       |\r\n" + //
                                                "|              <__ >| | <__>                                       |\r\n" + //
                                                "|              |    | |    |                                       |\r\n" + //
                                                "|              |    | |    |                                       |\r\n" + //
                                                "|              _\\ .:| |:. /_                                       |\r\n" + //
                                                "|             /_____\\ /_____\\                                      |\r\n" + //
                                                ""));
                    character.armor.wear();
                    armorSelected = true;
                }
                default ->  System.out.print("\nplease choose one of the options listed: ");
            }
        }

        user.characters.add(character);

        try (FileWriter fw = new FileWriter("Characters.txt")) {
            fw.write(user.toString());
        } catch (Exception e) {
            System.out.println("Failed to run.");
        }
        System.out.print("What is your next move? \n\n1. create a new character\n2. view my character(s)\n3. exit\n\nEnter your choice (1-3): ");
        boolean choicePicked = false;
        while (!choicePicked) { 
            int menuChoice = input.nextInt();
            switch (menuChoice) {
                case 1 -> {
                    characterSetup(user);
                    choicePicked = true;
                }
                case 2 -> {
                    System.out.print("How would you like them sorted? \n\n1. By character name alphabetically\n2. By weapon damage\n\nEnter your choice (1-2): ");
                    boolean printTypePicked = false;
                    OUTER:
                    while (!printTypePicked) {
                        int printTypeChoice = input.nextInt();
                        switch (printTypeChoice) {
                            case 1 -> {
                                Collections.sort(user.characters);
                                System.out.println(user.toString());
                                break OUTER;
                            }
                            case 2 -> {
                                user.characters.sort(new WeaponDamageComparator());
                                System.out.println(user.toString());
                                break OUTER;
                            }
                            default -> System.out.print("please choose one of the options listed: "); 
                        }
                    }
                    System.out.print("What is your next move? \n\n1. create a new character\n2. view my character(s)\n3. exit\n\nEnter your choice (1-3): ");
                }
                case 3 -> {
                    System.out.println("Thank you for playing");
                    System.exit(0);
                    choicePicked = true;
                }
                default -> System.out.print("please choose one of the options listed: ");
            }
        }
    }
}
