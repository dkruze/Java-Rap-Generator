import java.util.*;

public class Song extends Default {
    Intro intro = new Intro();
    Outro outro = new Outro();
    Verse1 verse1 = new Verse1();
    Verse2 verse2 = new Verse2();
    Chorus chorus = new Chorus();
    Playlist playlist = new Playlist();
    String title;
    String label;
    transient Scanner takein = new Scanner(System.in);

    public Song() {
        super();
        title = "untitled";
        label = "Crazy-Go-Nutz";
    }

    public Song(String _title, String _label) {
        this.title = _title;
        this.label = _label;
    }

    public static void main(String[] args) {
        Song song = new Song();
        song.populate();
        song.menu();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public void menu() {
        System.out.print("Welcome to tha Mad Traxx Rap Song Generator 2k22: Select ya option below:");
        System.out.print("\n");
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.print("1) Instructions \n2) Make Custom Song \n3) Make Random Song \n4) Load Previous Songs \n5) Alter Random Keywords \nQ) Quit \n");
            String userInput = takein.nextLine();
            if (userInput.equals("2")) {
                prompt();
                finalSong();
            }
            else if (userInput.equals("1")) {
                instruct();
            }
            else if (userInput.equals("3")) {
                randomSong();
            }
            else if (userInput.equals("4")) {
                System.out.print(playlist.songs + "\n");
            }
            else if (userInput.equals("5")) {
                editDefaults();
            }
            else if (userInput.toUpperCase().equals("Q")) {
                System.out.print("Peace out.");
                keepGoing = false;
            }
            else {
                System.out.print("Pick from the options we gave you! \n");
            }
        }
    }

    public void finalSong() {
        System.out.print("\"" + title + "\" \n");
        System.out.print("c. " + label + " 2022 \n \n");
        intro.create();
        playlist.readIntro();
        verse1.create();
        playlist.readVerse1();
        chorus.create();
        playlist.readChorus();
        verse2.create();
        playlist.readVerse2();
        chorus.create();
        playlist.readChorus();
        outro.create();
        playlist.readOutro();
    }

    public void instruct() {
        System.out.print("From this menu, you can opt to make a song in two different ways by typing the number (or letter) associated with the option. \n");
        System.out.print("First, you can make a custom song that will ask for your input, and intersperse it into a template. \n");
        System.out.print("Second, you may ask for a random song to be put in the template instead, using a list of default keywords. \n");
        System.out.print("These keywords can be viewed or edited at any time, and so too can previously made songs. \n");
        System.out.print("To quit, simply select \"Quit\". \n");
    }

    public void editDefaults() {
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.print("Current Keywords: \n");
            for (int i = 0; i < defaults.size(); i++) {
                System.out.print(defaults.get(i));
                if (defaults.indexOf(defaults.get(i)) == (defaults.size() - 1)) {
                    System.out.print("\n");
                }
                else {
                    System.out.print(", ");
                }
            }
            System.out.print("\n");
            System.out.print("Would you like to: \n1) Add Keyword \n2) Remove Keyword \n3) Return \n");
            String editInput = takein.nextLine();
                if (editInput.equals("1")) {
                    System.out.print("Leave your keyword below: \n");
                    boolean keepGoing1 = true;
                    while (keepGoing1) {
                        String addWord = takein.nextLine();
                        if (addWord.matches(".*[0-9].*")) {
                                System.out.print("Keywords cannot contain numbers. \n");
                        }
                        else {
                            buffer = addWord;
                            for (int i = 0; i < defaults.size(); i++) {
                                if (defaults.get(i).equals(buffer)) {
                                    System.out.print("Word is already in the list! \n \n");
                                    break;
                                }
                                else if (i == defaults.size() - 1) {
                                    addWord();
                                    System.out.print("You have added \"" + buffer + "\" to the list of keywords. \n \n");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                else if (editInput.equals("2")) {
                    int check = defaults.size();
                    System.out.print("Select keyword to be removed: \n");
                    boolean keepGoing2 = true;
                    while (keepGoing2) {
                        String killWord = takein.nextLine();
                        if (killWord.matches(".*[0-9].*")) {
                            System.out.print("Keywords cannot contain numbers. \n");
                        }
                        else {
                            buffer = killWord;
                            killWord();
                            System.out.print("You have removed \"" + buffer + "\" from the list of keywords. \n");
                            if (defaults.size() == check) {
                                System.out.print("Not that it was there to begin with...\n");
                            }
                            System.out.print("\n");
                            keepGoing2 = false;
                        }
                    }
                }
                else if (editInput.equals("3")) {
                    System.out.print("\n");
                    keepGoing = false;
                }
                else {
                    System.out.print("Please pick from the provided options. \n \n");
                }
            }
    }

    public void randomSong() {
        Random rand = new Random();
            int r1index = rand.nextInt(defaults.size());
            String randomNoun1 = defaults.get(r1index);
                intro.noun1 = randomNoun1;
                outro.noun1 = randomNoun1;
                chorus.noun1 = randomNoun1;
                verse1.noun1 = randomNoun1;
                verse2.noun1 = randomNoun1;
            int r2index = rand.nextInt(defaults.size());
            String randomNoun2 = defaults.get(r2index);
                intro.noun2 = randomNoun2;
                outro.noun2 = randomNoun2;
                chorus.noun2 = randomNoun2;
                verse1.noun2 = randomNoun2;
                verse2.noun2 = randomNoun2;
            int r3index = rand.nextInt(defaults.size());
            String randomVerb1 = defaults.get(r3index);
                intro.verb1 = randomVerb1;
                outro.verb1 = randomVerb1;
                chorus.verb1 = randomVerb1;
                verse1.verb1 = randomVerb1;
                verse2.verb1 = randomVerb1;
            int r4index = rand.nextInt(defaults.size());
            String randomNVerb2 = defaults.get(r4index);
                intro.verb2 = randomNVerb2;
                outro.verb2 = randomNVerb2;
                chorus.verb2 = randomNVerb2;
                verse1.verb2 = randomNVerb2;
                verse2.verb2 = randomNVerb2;
            int r5index = rand.nextInt(defaults.size());
            String randomAdj1 = defaults.get(r5index);
                intro.adj1 = randomAdj1;
                outro.adj1 = randomAdj1;
                chorus.adj1 = randomAdj1;
                verse1.adj1 = randomAdj1;
                verse2.adj1 = randomAdj1;
            int r6index = rand.nextInt(defaults.size());
            String randomAdj2 = defaults.get(r6index);
                intro.adj2 = randomAdj2;
                outro.adj2 = randomAdj2;
                chorus.adj2 = randomAdj2;
                verse1.adj2 = randomAdj2;
                verse2.adj2 = randomAdj2;
            int r7index = rand.nextInt(defaults.size());
            String randomName = defaults.get(r7index);
                title = "Big " + randomName + "in\'";
                playlist.songName =  "Big " + randomName + "in\'";
            int r8index = rand.nextInt(defaults.size());
            String randomLabel = defaults.get(r8index);
                label = "Cash " + randomLabel + " Records";
                playlist.labelName = "Cash " + randomLabel + " Records";
            finalSong();
    }

    public void prompt() {
        boolean keepGoing1 = true;
        while (keepGoing1) {
            System.out.print("Gimme a noun: \n");
            String noun1Input = takein.nextLine();
            if (noun1Input.matches(".*[0-9].*")) {
                System.out.print("Use letters, fool.\n");
            }
            else {
                intro.noun1 = noun1Input;
                outro.noun1 = noun1Input;
                chorus.noun1 = noun1Input;
                verse1.noun1 = noun1Input;
                verse2.noun1 = noun1Input;
                keepGoing1 = false;
            }
        }
        boolean keepGoing2 = true;
        while (keepGoing2) {
            System.out.print("Gimme another noun: \n");
            String noun2Input = takein.nextLine();
            if (noun2Input.matches(".*[0-9].*")) {
                System.out.print("Use letters, fool.\n");
            }
            else {
                intro.noun2 = noun2Input;
                outro.noun2 = noun2Input;
                chorus.noun2 = noun2Input;
                verse1.noun2 = noun2Input;
                verse2.noun2 = noun2Input;
                keepGoing2 = false;
            }
        }
        boolean keepGoing3 = true;
        while (keepGoing3) {
            System.out.print("Gimme a verb: \n");
            String verb1Input = takein.nextLine();
            if (verb1Input.matches(".*[0-9].*")) {
                System.out.print("Use letters, fool.\n");
            }
            else {
                intro.verb1 = verb1Input;
                outro.verb1 = verb1Input;
                chorus.verb1 = verb1Input;
                verse1.verb1 = verb1Input;
                verse2.verb1 = verb1Input;
                keepGoing3 = false;
            }
        }
        boolean keepGoing4 = true;
        while (keepGoing4) {
            System.out.print("Gimme another verb: \n");
            String verb2Input = takein.nextLine();
            if (verb2Input.matches(".*[0-9].*")) {
                System.out.print("Use letters, fool.\n");
            }
            else {
                intro.verb2 = verb2Input;
                outro.verb2 = verb2Input;
                chorus.verb2 = verb2Input;
                verse1.verb2 = verb2Input;
                verse2.verb2 = verb2Input;
                keepGoing4 = false;
            }
        }
        boolean keepGoing5 = true;
        while (keepGoing5) {
            System.out.print("Gimme a adjective: \n");
            String adj1Input = takein.nextLine();
            if (adj1Input.matches(".*[0-9].*")) {
                System.out.print("Use letters, fool.\n");
            }
            else {
                intro.adj1 = adj1Input;
                outro.adj1 = adj1Input;
                chorus.adj1 = adj1Input;
                verse1.adj1 = adj1Input;
                verse2.adj1 = adj1Input;
                keepGoing5 = false;
            }
        }
        boolean keepGoing6 = true;
        while (keepGoing6) {
            System.out.print("Gimme another adjective: \n");
            String adj2Input = takein.nextLine();
            if (adj2Input.matches(".*[0-9].*")) {
                System.out.print("Use letters, fool.\n");
            }
            else {
                intro.adj2 = adj2Input;
                outro.adj2 = adj2Input;
                chorus.adj2 = adj2Input;
                verse1.adj2 = adj2Input;
                verse2.adj2 = adj2Input;
                keepGoing6 = false;
            }
        }
            System.out.print("Name the track: \n");
            String trackName = takein.nextLine();
                title = trackName;
                playlist.songName = trackName;
            System.out.print("What's the label name? \n");
            String trackLabel = takein.nextLine();
                label = trackLabel + " Records";
                playlist.labelName = trackLabel + " Records";
            System.out.print("\n");
            System.out.print("\n");
        }
}
