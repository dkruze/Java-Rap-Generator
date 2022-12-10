import java.io.*;

public class Verse1 extends AbsBar implements Serializable {
    
    public Verse1() {
        super();
        template1 = "straight out the ";
        template2 = "I live for the ";
        template3 = "while I put \'em in the ";
        template4 = "on the road from your ";
        template5 = "I can\'t slow ";
    }

    public void create() {
        String line1 = template1 + noun1 + " Imma " + verb1 + " a damn " + noun2 + "\n";
        System.out.print(line1);
        String line2 = "but homie I ain\'t " + adj2 + " but " + template2 + noun2 + "-- \n";
        System.out.print(line2);
        String line3 = "ghouls, goblins, " + template1 + verb2 + "a \n";
        System.out.print(line3);
        String line4 = noun1 + " " + verb2 + "in\', " + noun2 + "s " + verb1 + "in\' " + template3 + "ground \n";
        System.out.print(line4);
        String line5 = noun2 + " " + template4 + adj1 + " " + noun1 + "\n";
        System.out.print(line5);
        String line6 = "but " + template5 + "down and " + template5 + adj2 + "own \n \n";
        System.out.print(line6);
        try {
			FileWriter fw = new FileWriter("Verse1.txt");
            fw.write(line1);
            fw.write(line2);
            fw.write(line3);
            fw.write(line4);
            fw.write(line5);
            fw.write(line6);
            fw.close();
		} 
        catch (IOException e){
			System.out.println(e.getMessage());
		}
    }
}
