import java.util.*;
import java.io.*;

public class Playlist {
    ArrayList<String> songs = new ArrayList<String>();
    String songName;
    String labelName;
    
    public Playlist() {
        songName = "untitled";
        labelName = "Crazy-go-Nutz";
    }

    public Playlist(String _songName, String _labelName) {
        this.songName = _songName;
        this.labelName = _labelName;
    }

    public String getSongName() {
        return this.songName;
    }

    public void setSongName(String _songName) {
        this.songName = _songName;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public void setLabelName(String _labelName) {
        this.labelName = _labelName;
    }

    public void readIntro() {
        try {
            File file = new File("Intro.txt");
            Scanner input = new Scanner(file);
            songs.add("\n \"" + songName + "\" \n");
            songs.add("c. " + labelName + " 2022\n \n");
            while (input.hasNextLine()){
                String bar = input.nextLine() + "\n";
                songs.add(bar);
            }
            input.close();
        } 
        catch (IOException e){
            System.out.println(e.getMessage());
        } 
    }

    public void readChorus() {
        try {
            File file = new File("Chorus.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()){
                String bar = input.nextLine() + "\n";
                songs.add(bar);
            }
            input.close();
        } 
        catch (IOException e){
            System.out.println(e.getMessage());
        } 
    }

    public void readVerse1() {
        try {
            File file = new File("Verse1.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()){
                String bar = input.nextLine() + "\n";
                songs.add(bar);
            }
            input.close();
        } 
        catch (IOException e){
            System.out.println(e.getMessage());
        } 
    }

    public void readVerse2() {
        try {
            File file = new File("Verse2.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()){
                String bar = input.nextLine() + "\n";
                songs.add(bar);
            }
            input.close();
        } 
        catch (IOException e){
            System.out.println(e.getMessage());
        } 
    }

    public void readOutro() {
        try {
            File file = new File("Outro.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()){
                String bar = input.nextLine() + "\n";
                songs.add(bar);
            }
            input.close();
        } 
        catch (IOException e){
            System.out.println(e.getMessage());
        } 
    }
}
