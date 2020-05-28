package przyklad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AddressesData {


    static List<String> alias = Arrays.asList("ZUS", "US", "GUS", "NIK");

    static int i;

    public static String getRandomAlias() {
        Random randomAl = new Random();
        int integerAl = randomAl.nextInt(100);
        i = integerAl % alias.size();
        return alias.get(i);
    }

    static String[] company = {"Zakład Ubespieczeń Społecznych", "Urząd Skarbowy", "Główny Urzad Statystyczny", "Najwyższa Izba Kontroli"};

    public static String getRadomCompany() {
        return company[i];

    }

}
