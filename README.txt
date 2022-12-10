These files may be run from the makefile or the jar file.

If you are reading this, you presumably already know how to do this, but good practice is good practice:
	RUN FROM MAKEFILE:
		On your command line, type the following commands (delineated by semicolons) in order:
		make clean;
		make;
		make run;

	RUN AS JAR:
		On your command line, enter this command:
		java -jar Song.jar

This code has been tested in Visual Studio 2022 as well as on the Tesla BASH command line. 
If you have any errors or missing files, please empty your directory of all files you downloaded and grab everything from this repository over again.
