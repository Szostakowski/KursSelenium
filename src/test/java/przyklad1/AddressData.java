package przyklad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AddressData {

    // Lista adresów która zwiera metodę Random dla lowoego wyboru

    static List<String> address = Arrays.asList
            ("DC Street 22", "Aleja Gwiazd 100", "Super Hero avenue 5", "Ulica Sezamkowa 10", "Goblińska 15");

    public static String getRandomAddress() {
        Random randomAdrs = new Random();
        int adrsInteger = randomAdrs.nextInt(100);
        int randAdrs = adrsInteger % address.size();
        return address.get(randAdrs);
    }


    static List<String> city = Arrays.asList
            ("Shire", "Gotham City", "Pcin Dolny", "Przemyśl (się)", "Śródziemiedzin");

    public static String getRandomCity(){
        Random randomCity = new Random();
        int cityInteger = randomCity.nextInt(100);
        int randCit = cityInteger % city.size();
        return city.get(randCit);
    }


    static List<String> zipCode = Arrays.asList
            ("01-000", "20-222", "00-666", "69-999", "33-777");

    public static String getRandomZip(){
        Random randomZip = new Random();
        int zipInteger = randomZip.nextInt(100);
        int randZip = zipInteger % zipCode.size();
        return zipCode.get(randZip);
    }

}
