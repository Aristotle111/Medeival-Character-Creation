package com.mycompany.app;

import java.io.FileWriter;
import java.util.Scanner;

import com.mycompany.app.Weapon.Damage;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        try (input) {
            userSetup();
        }
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
        characterSetup(user);
    }

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

    public static void pickArmor(Character character, User user) {
        System.out.println("""

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
          Enter your choice (1-3): """);

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
                                                "|             |   | |   |                                            |\r\n" + //
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
                                                "|                   {|}                                                 |\r\n" + //
                                                "|                  .---.                                                |\r\n" + //
                                                "|                 /_____\\                                               |\r\n" + //
                                                "|                 |+++++|                                               |\r\n" + //
                                                "|                 |+++++|                                               |\r\n" + //
                                                "|             .-;`\\_____/`;-.                                           |\r\n" + //
                                                "|           /   |_________|   \\                                         |\r\n" + //
                                                "|          |    /         \\    |                                        |\r\n" + //
                                                "|          ;---'\\         /'---;                                        |\r\n" + //
                                                "|          <___>,>._____.<,<___>                                        |\r\n" + //
                                                "|          |   |/_________\\|   |                                        |\r\n" + //
                                                "|          \\:::/|         |\\:::/                                        |\r\n" + //
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
        System.out.print("\nWould you like to create another character? (yes or no): ");
        while (true) {
            String answer = input.next().toLowerCase();
            if ("yes".equals(answer)) {
                characterSetup(user);
            } else if ("no".equals(answer)) {
                System.exit(0);
            } else {
                System.out.println("please choose one of the options listed: ");
            }
        }
    }
}
