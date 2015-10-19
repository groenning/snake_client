package example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sdk.Logic;

import java.io.*;

/**
 * Created by BenjaminSelnaes on 15/10/15.
 */
public class Main {

    public static void main(String args[]) throws IOException {

        Logic.login("doek4life", "abc123");
        Logic.createGame("battle_to_death",1);
        Logic.createUser();

    }
}
