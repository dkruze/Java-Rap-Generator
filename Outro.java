import java.io.*;

public class Outro extends AbsBar implements Serializable {
    
    public Outro() {
        super();
        template1 = "pourin\' up some ";
        template2 = "we outta here ";
        template3 = "another shout out to my man ";
        template4 = "y\'all better ";
        template5 = "peace, ";
    }

    public void create() {
        String line1 ="alright, " + template2 + noun1 + "s \n";
        System.out.print(line1);
        String line2 = template2 + "and we " + template1 + adj2 + " " + noun2 + " for the road \n";
        System.out.print(line2);
        String line3 = template3 + "Juicy " + verb1 + "a, and " + template3 + "lil " + adj1 + "y \n";
        System.out.print(line3);
        String line4 = template4 + verb2 + ", " + template2 + " man \n";
        System.out.print(line4);
        String line5 = template5 + noun1 + "heads \n \n";
        System.out.print(line5);
        try {
			FileWriter fw = new FileWriter("Outro.txt");
            fw.write(line1);
            fw.write(line2);
            fw.write(line3);
            fw.write(line4);
            fw.write(line5);
            fw.close();
		} 
        catch (IOException e){
			System.out.println(e.getMessage());
		}
    }
}
