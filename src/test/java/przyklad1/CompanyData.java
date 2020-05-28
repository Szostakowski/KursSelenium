package przyklad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CompanyData {


    static List<String> alias = Arrays.asList("ELF", "DC", "MARVEL", "HBO");

    static int i;

    public static String getRandomAlias() {
        Random randomAl = new Random();
        int integerAl = randomAl.nextInt(100);
        i = integerAl % alias.size();
        return alias.get(i);
    }

    static String[] company = {"Elfowie sp. zo.o.", "Batmany i Supermeny S.J.", "Spider-Man S.A.", "Hobbit Bilbo Oportunista"};

    public static String getRadomCompany() {
        return company[i];

    }

}
