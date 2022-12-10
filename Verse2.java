import java.io.*;

public class Verse2 extends AbsBar implements Serializable {
    
    public Verse2() {
        super();
        template1 = "gotta take it down ";
        template2 = "I don\'t take no ";
        template3 = "even when it\'s tough";
        template4 = "slide, slide, slippity-slide \n";
        template5 = "and I ";
    }

    public void create() {
        String line1 = "you " + verb2 + "in\' my " + noun1 + ", clingin\' to my cuffs \n";
        System.out.print(line1);
        String line2 = "you " + template1 + "a " + noun2 + ", " + adj1 + ",  or things\'ll get rough \n";
        System.out.print(line2);
        String line3 = template2 + noun2 + " and " + template2 + "guff \n";
        System.out.print(line3);
        String line4 = "but I " + verb1 + " and I " + verb2 + template3 + "\n";
        System.out.print(line4);
        String line5 = "so I " + template4;
        System.out.print(line5);
        String line6 = template5 +  "break boys off, " + template5 + " " + verb1 + " " + adj2 + " off \n \n";
        System.out.print(line6);
        try {
			FileWriter fw = new FileWriter("Verse2.txt");
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
