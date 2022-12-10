import java.io.*;

public class Intro extends AbsBar implements Serializable {
    
    public Intro() {
        super();
        template1 = "welcome to the ";
        template2 = "shouts out to ";
        template3 = " in the studio";
        template4 = "you already know ";
        template5 = "rest in peace to DJ ";
    }

    public void create() {
        String line1 = template1 + noun1 + " of " + verb2 + "in\' \n";
        System.out.print(line1);
        String line2 = template2 + "MC " + noun2 + " " + template3 + "\n";
        System.out.print(line2);
        String line3 = "And DJ " + adj1 + template3 + ", " + template4 + "we " + adj2 + "\n";
        System.out.print(line3);
        String line4 = template5 + "Smitty " + verb1 + "$$ \n \n";
        System.out.print(line4);
        try {
			FileWriter fw = new FileWriter("Intro.txt");
            fw.write(line1);
            fw.write(line2);
            fw.write(line3);
            fw.write(line4);
            fw.close();
		} 
        catch (IOException e){
			System.out.println(e.getMessage());
		} 
    }
}
