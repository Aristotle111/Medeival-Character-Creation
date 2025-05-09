package com.mycompany.app;
import java.util.Comparator;

public class WeaponDamageComparator implements Comparator<Character> {
    @Override
    public int compare(Character c1, Character c2) {
        if (c1.weapon == null && c2.weapon == null) return 0;
        if (c1.weapon == null) return -1;
        if (c2.weapon == null) return 1;

        return c1.weapon.damage.compareTo(c2.weapon.damage);
    }
}