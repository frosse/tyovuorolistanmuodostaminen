package tyovuorolistanmuodostaminen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Paras tulos 76 työntekijää eikä lainkaan ylityksiä tunneissa eikä päivissä
    Ohjelma tulostaa kaikki työntekijät jos saadaan tulos joka on pienempi kuin 77
    Muuten tulostetaan vain tarvittavat työntekijät
    Voidaan myös ajaa vain kerran asettamalla for loop ykköseksi ja antamalla gd.setPrint -> True

 */

public class Main {
    public static void main(String[] args) {
        GreedyAlgorithm gd;

        for (int i = 0; i < 200; i++) {
            gd = new GreedyAlgorithm();

            // Jos loopataan vain kerran niin aseta True
            gd.setPrint(false);

            gd.setWorkingHours();

            try {
                gd.findSolution();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}

