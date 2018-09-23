import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class BattleShipTwo {

    public static void main(String[]args) throws IOException {
        File fileToRead = new File("src/ExampleFile");
        System.out.println(fileToRead.getCanonicalPath());

        if(fileToRead.exists()){
            Scanner input = new Scanner(fileToRead);
            while (input.hasNext()){
                System.out.println(input.nextLine());
            }
            input.close();
        }
        else{
            System.out.println("File not found");
        }

        HashMap hashMap = new HashMap();
        ArrayList<String> heroTeams = new ArrayList<>();
        heroTeams.add("DC");
        heroTeams.add("Avengers");
        heroTeams.add("Marvel");
        hashMap.put("HeroTeams", heroTeams);
        hashMap.put("Marvel", "IronMan");
        hashMap.put("DC", "BatMan");

        ArrayList<String> superHeroTeams = new ArrayList<>();
        superHeroTeams.addAll(((ArrayList) hashMap.get("HeroTeams")));
        System.out.println(superHeroTeams);
        System.out.println(hashMap.keySet());

        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1, "DC");
        treeMap.put(2, "Marvel");
        System.out.println(treeMap.values());

    }
}
