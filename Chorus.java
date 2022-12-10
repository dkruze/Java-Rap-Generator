import java.io.*;

public class Chorus extends AbsBar implements Serializable{
    
    public Chorus() {
        super();
        template1 = "in\' up on these ";
        template2 = "in\' down, ";
        template3 = "lookin\' ";
        template4 = "super ";
        template5 = "ain\'t no ";
    }

    public void create() {
        String line1 = verb1 + template1 + noun1 + "s, \n";
        System.out.print(line1);
        String line2 = verb2 + template2 + template3 + adj1 + "\n";
        System.out.print(line2);
        String line3 = verb1 + template1 + noun2 + "s, \n";
        System.out.print(line3);
        String line4 = template4 + adj2 + ", " + template5 + noun1 + "\n \n";
        System.out.print(line4);
        try {
			FileWriter fw = new FileWriter("Chorus.txt");
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
