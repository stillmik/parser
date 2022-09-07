import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FileParser fileParser = new FileParser();
        String iPhone = "C:\\Users\\User\\IdeaProjects\\AKG_1\\data\\Iphone seceond version finished.obj";
        String person ="C:\\Users\\User\\IdeaProjects\\AKG_1\\data\\FinalBaseMesh.obj";
        fileParser.initParameters(person);
    }
}
