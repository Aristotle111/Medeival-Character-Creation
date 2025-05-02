package com.mycompany.app;

import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character character = new Character();
        characterSetup(character);
    }

    public static void characterSetup(Character character) {
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
                character = switch (input.next().toLowerCase()) {
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
                        e.printStackTrace();
                    }

                    break;
                }
                System.out.print("\nplease choose one of the options listed: ");
            }
        }
    }
}
