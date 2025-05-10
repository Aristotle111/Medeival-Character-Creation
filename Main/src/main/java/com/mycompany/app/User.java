package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String username;
    public List<Character> characters;

    public User() {
        this.username = null;
        this.characters = new ArrayList<>();
    }

    public User(String username, List<Character> characters) {
        this.username = username;
        this.characters = characters;
    }
    

    @Override
    public String toString() {
        return "User [ " + username + " ]\n\ncharacters: \n\n" + characters;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
