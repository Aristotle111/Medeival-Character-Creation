package com.mycompany.app;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        chooseCharacterType();
    }

    public static void chooseCharacterType() {
        try (Scanner input = new Scanner(System.in)) {
            //System.out.printf(format, args);
            while (true) {
                Character character = switch (input.next().toLowerCase()) {
                    case "swordsman" ->
                        new Swordsman();
                    case "mage" ->
                        new Mage();
                    //case "archer" ->
                        //new Archer();
                    default -> null;
                };
                
                if (character != null) break;
                System.out.println("please choose one of the options listed\n");
            }
        }
    }
}
