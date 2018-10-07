package utils;

import java.util.Random;

public class randomGenerator{

    public int createRandomNumber()
    {

        Random rand = new Random();


        int randomOutput = rand.nextInt(3000);
        return randomOutput;

    }
}