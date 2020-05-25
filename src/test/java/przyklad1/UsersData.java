package przyklad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UsersData {

    // imiona męskie w tablicy
    static String[] firstNamesMale = {"Jan", "Stefan", "Marek", "Jacek"};

    public static String getRandomMaleName() {
        Random randomMn = new Random();
        int ManNameInteger = randomMn.nextInt(100);
        int randMaleNames = ManNameInteger % firstNamesMale.length;
        return firstNamesMale[randMaleNames];
    }


    // imiona żeńskie w tablicy:
    static String[] firstNameFemale = {"Ania", "Agnieszka", "Ewa", "Basia", "Jola"};

    public static String getRandomFemaleName(){
        Random randomFn = new Random();
        int FamNameInteger = randomFn.nextInt(100);
        int randFemaleNames = FamNameInteger % firstNameFemale.length;
        return firstNameFemale[randFemaleNames];

    }


    // nazwiska w liście
    static List<String> surname = Arrays.asList
            ("Jakubiak", "Stefanek", "Rakowicz", "Buczek", "Elefan");

    public static String getRandomSurname() {
        Random randomS = new Random();
        int surnameInteger = randomS.nextInt(100);
        int randSurname = surnameInteger % surname.size();
        return surname.get(randSurname);
    }
}

