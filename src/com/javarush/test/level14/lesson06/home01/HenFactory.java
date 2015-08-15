package com.javarush.test.level14.lesson06.home01;

public class HenFactory {

    static Hen getHen(String country) {

        Hen hen = null;
        switch (country)
        {
            case "Belarus":
                hen = new BelarusianHen();
                break;
            case "Russia":
                hen = new RussianHen();
                break;
            case "Ukraine":
                hen = new UkrainianHen();
                break;
            case "Moldova":
                hen = new MoldovanHen();
                break;
            default:
                hen = new UkrainianHen();
                break;
        }

        try
        {
            System.out.println(hen.getDescription());
        }
        catch (Exception e)
        {
            System.out.println("Object 'hen' is null");
        }
        return hen;
    }
}
