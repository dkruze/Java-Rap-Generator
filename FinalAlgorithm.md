/***********************************************************************************************************\
| "Raising the Bar"																	                        |
| An Object-oriented proposal by Daniel Kruze												                |
| A generator for nonsensical songs, in the hip-hop style, using class abstraction and serialization		|
| Intended for single, local use															                |
| Using java.util.*																	                        |
'***********************************************************************************************************'

**************************************************************************************************************************************************************************************************
USE CASE ANALYSIS:
	A typical use case for this program involves a user simply running the program for fun, being met with the UI in the command line, and interacting with a simple menu.
	For instance, when the main file is run (either through a makefile or a jar) this sample menus would be displayed:
		> Welcome to the random song generator 2022
		> Written and tested by Daniel Kruze
		> Please select from the options below:
			> 1) Generate a song
			> 2) Generate a random song for me
			> 3) Display sample keyword list
			> 4) Load previous songs
			> 5) Help
			> 6) Quit
			
	From this menu, options are selected by number and the corresponding methods will be run. 
		The load option will display the ArrayList of saved songs and their corresponding names.
		The generate option will prompt for a name, a label, and then a couple keywords that it will use to generate the song.
		The generate for me option will use a ArrayList of default keywords to randomly generate a sample song.
		The display option will show the ArrayList of default keywords, and allow it to be manipulated.
		The help option will print out simple instructions, and the quit option will end the program.
	
	When the user selects a menu that is designed to output another menu, such as the sample keyword list, that menu will consist of the option to add and to back out:
		> 1) Add Keyword
		> 2) Remove Keyword
		> 3) Cancel
	In this way, the user will not be forced to continue whenever they select this option.
	
	In general, the flow of a use case can be modeled by a simple tree:
	
										   MAIN MENU
                                               |--> song
                                random song <--|
                                               |<--> sample keywords <--> keyword menu
                                   playlist <--|
                                               |--> help
                                       Quit <--|
                                       
	Where the order of displayed items is indicated by arrows.
	A double-sided arrow implies that menus can be entered into and exited from, as a user can only quit from the main menu or by terminating the console.
**************************************************************************************************************************************************************************************************

**************************************************************************************************************************************************************************************************
DATA DESIGN:
	This program is primarily about string data stored very simply in blocks, but also about sets of strings stored in ArrayLists.
	These could admittedly be represented perhaps better as a database, but to avoid using external programs or alternate languages (not Java or C++) I decided to keep data in ArrayLists.
		This is also a good choice considering how few items will likely be saved, because not that many songs will be saved in the first place.
	This means that data will be persistent in that completed songs will be saved, and so will added keywords.
		The songs will need to be serialized in order to save them, so a separate class will exist to store songs after generation into a ArrayList, which will be serialized.
	There's no need to think too seriously about aggregating any of this data into a larger or more manipulable structure because not much data will be persistent anyway.
		Each ArrayList will exist as part of a class, and those classes will be serialized so that they can be saved and loaded at will, or when the program requires it.
	
	A simple idea of the data can be represented by a flowmap:
	
	User Input --> Abstract lyric class --> Specific lyric classes --> Completed song class --> SONG <--> Playlist
                             													^
                             													|
                          													 Defaults		
		
	Where arrows represent input from classes.
	The user may input keywords, or the default class may, and from there the completed song class inherits attributes and methods to create a song with the keyword.
	The song is created as a series of strings, with a name; this name is passed to the playlist to be stored and retrieved.
**************************************************************************************************************************************************************************************************

**************************************************************************************************************************************************************************************************
BASIC ALGORITHM:
	Start with an abstract class, lyrics
		Class has empty string attributes (templates)
		Class has empty strings for nouns, verbs, and adjectives (to be filled with user input)
		Class has a constructor which initializes no default values
	Specific classes exists as a direct child of the lyrics class
		This class inherits string attributes from abstract
		Constructor initializes inherited strings with values
			for example, template1 is set to "I got the rainbow colors in my ", template2 is set to "; Jolly Ranchers man this **** be good as "
		Protected methods for printing that print out inherited strings with user variables interjected at optimal (funny) positions
			For example, the create() method would print template1 + noun1 + template 2 + noun2
			This would result in the full bar "I got the rainbow colors in my cup; Jolly Ranchers man this **** be good as ****"
			This print method will serialize the bar it creates into a unique text file to be read later as part of the song saving method
			Each class will pertain to a bar or stanza of a song, and the polymorphic create() method will be included in each one
	A song class that exists to invoke the specific classes
		This class has attributes for a name, a label, and all the previous classes it invokes (including the playlist), as well as a scanner
		Constructor initializes with a default name (untitled) and a default label (Crazy-Go-Nutz)
		Method for printing out the main menu (detailed in the Use Case Analysis section)	
			See the above section and the cryptography example (canvas) for a sample menu algorithm
		Method for printing out the final song
			This will prompt the user for each of the six noun, verb, and adjective attributes
			It will then prompt for a name, and a record label
			It will then call the printing methods from the specific classes in order (intro, verse 1, chorus, verse 1, chorus, outro) after printing name and record label
			The song will then be saved to an ArrayList after each create method is called
		Method for printing out a random song
			This will print a random name and label, but not accept input from the user
			Instead, it will access the ArrayList of default keywords and use them to randomly assign keywords to variable values for nouns and verbs.
			Then, it will call the printing methods in order, like the normal song, and can be saved and viewed.
		Method for displaying sample keywords
			This method will simply display the ArrayList of default keywords
			The user, from here can add keywords to the list or return to the main menu
				The method for adding/removing keywords is in the default class
				However, this method will contain for loops to check if the default class contains the preferred word or not already
				This is possible because the song class technically inherits from the default class
		Method for displaying playlist
			This method will display the ArrayList of songs by file I/Object
			They will be separated by name/label values passed to the class by the song class
		Method for instructions
			Print out simple instructions to the command line
	A class for storing the ArrayList of songs will also exist (playlist)
		This will have the ArrayList of songs, and also a name and label attribute for sorting
		The constructor will set defaults for names and labels in case of emergency failure to pass variables
		The class will have five methods that all read in the unique files geenrated by each specific bar class	
			These methods are simple IO try/catch lines that use a CLOSED scanner to read in each txt file line by line, and add it to the ArrayList
	A class for storing default keywords will exist
		This also has the default keywords ArrayList and also a string buffer attribute for holding user input
		The constructor initializes no defaults
		Method for populating the initial ArrayList
			This method adds all the words that generate random songs if the user doesn't specify otherwise
			This has to be a method in order to have non-static members of the ArrayList that can be manipulated at will
			This also means that the program must start by quietly calling this function before even displaying the menu
		Method for adding keywords
			Ask the user what keyword they want to put in
			Read buffer (which contains user input), simply tack it onto the ArrayList
			Save and reload the ArrayList
		Method for removing keywords
			Same as before for the prompt and read in
			Except instead of tacking it on, delete it
			If they enter one that isnt in the list, tell them they are stupid and do nothing
			Save and reload the ArrayList
**************************************************************************************************************************************************************************************************

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
