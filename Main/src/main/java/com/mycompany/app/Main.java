package com.mycompany.app;

import java.io.FileWriter;
import java.util.Scanner;

import com.mycompany.app.Weapon.Damage;

public class Main {
    public static void main(String[] args) {
        characterSetup();
    }

    public static void characterSetup() {
        try (Scanner input = new Scanner(System.in)) {
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
            while (true) {
                Character character = switch (input.next().toLowerCase()) {
                    case "swordsman" ->
                        new Swordsman();
                    case "mage" ->
                        new Mage();
                    case "archer" ->
                        new Archer();
                    default -> null;
                };
                
                if (character != null) {
                    System.out.print("\nwhat is the name of your character?: ");
                    character.setName(input.next());

                    input.nextLine();

                    System.out.print("\nwhat is the gender of your character?: ");
                    while (true) {
                        String genderInput = input.nextLine().toLowerCase();
                        
                        if ("male".equals(genderInput)) {
                            character.setGender(Character.Gender.MALE);
                            break;
                        } else if ("female".equals(genderInput)) {
                            character.setGender(Character.Gender.FEMALE);
                            break;
                        } else {
                            System.out.print("\nplease enter either male or female: ");
                        }
                    }

                    System.out.print("\nhow old is your character?: ");
                    character.setAge(input.nextInt());

                    try (FileWriter fw = new FileWriter("Characters.txt")) {
                        fw.write(character.toString());
                    } catch (Exception e) {
                        System.out.println("something went wrong, please try again");
                        e.printStackTrace();
                    }
                    pickWeapon(character);
                    break;
                }
                System.out.print("\nplease choose one of the options listed: ");
            }
        }
    }

    public static void pickWeapon(Character character) {
        try (Scanner input = new Scanner(System.in)) {
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
        } catch (Exception e) {
            System.out.println("something went wrong, please try again");
            e.printStackTrace();
        }
    }
}
