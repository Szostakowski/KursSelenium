package przyklad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AddressesData {


    static List<String> alias = Arrays.asList("ZUS", "US", "GUS", "NIK");

    public static String getRandomAlias() {
        Random randomAl = new Random();
        int IntegerAl = randomAl.nextInt(100);
        int randomAlias = IntegerAl % alias.size();
        return alias.get(randomAlias);
    }

    static String[] company = {"Zakład Ubespieczeń Społecznych", "Urząd Skarbowy", "Główny Urzad Statystyczny", "Najwyższa Izba Kontroli"};

    public static String getRadomCompany() {
        int i = alias.indexOf(getRandomAlias());
        return company[i];

        }

}
