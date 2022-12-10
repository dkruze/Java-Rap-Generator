import java.util.*;
import java.io.*;

public class Default implements Serializable {
    ArrayList<String> defaults = new ArrayList<String>();
    String buffer;

    public Default() {
    }

    public Default(ArrayList<String> _defaults) {
        this.defaults = _defaults;
    }

    public ArrayList<String> getDefaults() {
        return this.defaults;
    }

    public void setDefaults(ArrayList<String> _defaults) {
        this.defaults = _defaults;
    }

    public String getBuffer() {
        return this.buffer;
    }

    public void setBuffer(String _buffer) {
        this.buffer = _buffer;
    }

    public void populate() {
        defaults.add("lean");
        defaults.add("ice");
        defaults.add("drank");
        defaults.add("bust");
        defaults.add("smooth");
        defaults.add("real");
        defaults.add("glock");
        defaults.add("blick");
        defaults.add("clap");
        defaults.add("cruise");
    }

    public void addWord() {
        Default df = new Default();
            defaults.add(buffer);
        try {
			FileOutputStream fo = new FileOutputStream("DefaultWords.txt");
			ObjectOutputStream obOut = new ObjectOutputStream(fo);
			obOut.writeObject(df);
            obOut.close();
		} 
        catch (Exception e){
			System.out.println(e.getMessage());
		}
        try {
    		FileInputStream fi = new FileInputStream("DefaultWords.txt");
    		ObjectInputStream obIn = new ObjectInputStream(fi);
    		df = (Default)obIn.readObject();
            obIn.close();
    	}
        catch (Exception e){
    		System.out.println(e.getMessage());
    	} 
    }

    public void killWord(){
        Default df = new Default();
        for (int i = 0; i < defaults.size(); i++) {
            if (defaults.get(i).equals(buffer)) {
                defaults.remove(i);
                break;
            }
            else {
                continue;
            }
        }
        try {
			FileOutputStream fo = new FileOutputStream("DefaultWords.txt");
			ObjectOutputStream obOut = new ObjectOutputStream(fo);
			obOut.writeObject(df);
            obOut.close();
		} 
        catch (Exception e){
			System.out.println(e.getMessage());
		}
        try {
    		FileInputStream fi = new FileInputStream("DefaultWords.txt");
    		ObjectInputStream obIn = new ObjectInputStream(fi);
    		df = (Default)obIn.readObject();
            obIn.close();
    	}
        catch (Exception e){
    		System.out.println(e.getMessage());
    	} 
    }
}

