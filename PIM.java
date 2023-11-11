import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;
import static java.lang.System.in;

public class PIM {

    List<PIR> pirList = new ArrayList<>();
    PIR pir;
    static String path = "C:\\Users\\85255\\OneDrive - The Hong Kong Polytechnic University\\Documents\\java\\COMP3211\\PIM";  // for demonstration

    public PIM(){
        PIR pir;
    }
    public void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        initial();
        while(true){
            System.out.print("Welcome to Personal Information Manager\n1.Create\n2.Modify\n3.Search\n4.Print\n5.Delete\n6.Load\n7.Exit\nPlease enter a number: ");
            int input = sc.nextInt();
            select(input);
        }
    }

    public void select(int input){
        if(input == 1){
            create();
        } else if (input == 2) {
            modify();
        } else if (input == 3){
            search();
        } else if (input == 4){
            print();
        } else if (input == 5){
            delete();
        } else if (input == 6){
            load();
        } else if(input == 7){
            System.out.println("=== Exit Successfully ===");
            exit(0);
        } else{
            System.out.println("=== Wrong input ===");
        }
    }

    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Create =====");
        System.out.print("Which type of PIR you want to create?\n1.Contact\n2.Note\n3.To-do\n4.Event\nEnter a number: ");
        int input = sc.nextInt();
        sc.nextLine();
        if(input == 1){
            String type = "Contact";
            int id = getCountNo();
            System.out.print("Please enter the topic of the PIR");
            String topic = sc.nextLine();
            System.out.print("Please enter the name of contact: ");
            String name = sc.nextLine();
            System.out.print("Please enter the address of contact: ");
            String address = sc.nextLine();
            System.out.print("Please enter the mobile number of contact: ");
            String mobileNo = sc.nextLine();
            pir = new ContactPIR(type,id,topic,name,address,mobileNo);
            pir.store();
            pirList.add(pir);
        } else if(input == 2){
            String type = "Note";
            int id = getCountNo();
            System.out.print("Please enter the topic of the PIR");
            String topic = sc.nextLine();
            System.out.print("Please enter the title of note: ");
            String title = sc.nextLine();
            System.out.print("Please enter the content of note: ");
            String content = sc.nextLine();
            pir = new NotePIR(type,id,topic,title,content);
            pir.store();
            pirList.add(pir);
        } else if(input == 3){
            String type = "todo";
            int id = getCountNo();
            System.out.print("Please enter the topic of the PIR");
            String topic = sc.nextLine();
            System.out.print("Please enter the title of to-do: ");
            String title = sc.nextLine();
            System.out.print("Please enter the description of to-do: ");
            String description = sc.nextLine();
            System.out.print("Please enter the date (DD-MM-YY): ");
            String date = sc.nextLine();
            pir = new ToDoPIR(type,id,topic,title,description,date);
            pir.store();
            pirList.add(pir);
        } else if(input == 4){
            String type = "Event";
            int id = getCountNo();
            System.out.print("Please enter the topic of the PIR");
            String topic = sc.nextLine();
            System.out.print("Please enter the title of event: ");
            String title = sc.nextLine();
            System.out.print("Please enter the description of event: ");
            String description = sc.nextLine();
            System.out.print("Please enter the date of event (DD-MM-YY): ");
            String date = sc.nextLine();
            System.out.print("Please enter the start time of the event (hh-mm): ");
            String startTime = sc.nextLine();
            System.out.print("Please enter the end time of the event (hh-mm): ");
            String endTime = sc.nextLine();
            pir = new EventPIR(type,id,topic,title,description,date,startTime,endTime);
            pir.store();
            pirList.add(pir);
        }
    }

    public void modify(){
        Scanner sc = new Scanner(System.in);
        int fileCounter = 1;
        System.out.println("===== Modify =====");
        System.out.println("There are "+getCountNo()+" PIRs");
        for(PIR pir:pirList){
            System.out.println(fileCounter+"."+pir.type+"\t");
        }
    }

    public void search(){
        // ___ Part
        // take it as reference
        /*public class FileSearchExample {
            public static void main(String[] args) {
                File file = new File("path/to/file.txt");
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains("searchWord")) {
                            System.out.println("Found the word: " + line);
                        }
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }*/
    }

    public void print(){
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Print =====");
        System.out.print("1.Contact\n2.Note\n3.To-do\n4.Event\n5.All\nPlease enter a number: ");
        int input = sc.nextInt();
        sc.nextLine();
        if(input == 1){
            for(PIR pir: pirList){
                if(pir.type.equals("Contact")){
                    pir.print();
                }
            }
        } else if(input == 2){
            for(PIR pir:pirList){
                if(pir.type.equals("Note")){
                    pir.print();
                }
            }
        } else if(input == 3){
            for(PIR pir:pirList){
                if(pir.type.equals("Todo")){
                    pir.print();
                }
            }
        } else if(input == 4){
            for(PIR pir:pirList){
                if(pir.type.equals("Event")){
                    pir.print();
                }
            }
        } else if(input == 5){
            for(PIR pir:pirList){
                pir.print();
            }
        }
    }

    public void delete(){
        // ___ Part
        // delete file easy part
    }

    public void load(){
        // Philbert's gf Part?
        // enter "I give up" to earn 3 pts
        // ask user to enter path and filename then save it to the file

    }

    public void initial() throws IOException {
        File directory = new File(path);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                System.out.println("For loop"); // test
                if (file.getName().contains("A")) {
                    // Create ContactPIR
                    System.out.println("A loop"); // test
                    String fileNameA = file.getName();
                    Pattern idPatternA = Pattern.compile("[A-Za-z]*(\\d+).*");
                    Matcher idMatcherA = idPatternA.matcher(fileNameA);
                    if (idMatcherA.matches()) {
                        String id = idMatcherA.group(1);
                        String type = "Contact";
                        String topic = null;
                        String name = null;
                        String address = null;
                        String mobileNo = null;
                        Pattern pattern = Pattern.compile(":\\s*(.*)");
                        try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                Matcher matcher = pattern.matcher(line);
                                if (matcher.find()) {
                                    String information = matcher.group(1);
                                    if(line.contains("Topic: ")){
                                        topic = information;
                                    } else if (line.contains("Name: ")) {
                                        name = information;
                                    } else if (line.contains("Address: ")) {
                                        address = information;
                                    } else if (line.contains("Mobile Number: ")) {
                                        mobileNo = information;
                                    }
                                }
                            }
                            PIR pir = new ContactPIR(type, Integer.parseInt(id), topic, name, address, mobileNo);
                            pirList.add(pir);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (file.getName().contains("B")) {
                    // Create NotePIR
                    System.out.println("B loop"); // test
                    String fileNameB = file.getName();
                    Pattern idPatternB = Pattern.compile("[A-Za-z]*(\\d+).*");
                    Matcher idMatcherB = idPatternB.matcher(fileNameB);
                    if (idMatcherB.matches()) {
                        String id = idMatcherB.group(1);
                        String type = "Note";
                        String topic = null;
                        String title = null;
                        String text = null;
                        Pattern pattern = Pattern.compile(":\\s*(.*)");
                        try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                Matcher matcher = pattern.matcher(line);
                                if (matcher.find()) {
                                    String information = matcher.group(1);
                                    if(line.contains("Topic: ")){
                                        topic = information;
                                    }else if (line.contains("Title: ")) {
                                        title = information;
                                    } else if (line.contains("Texts: ")) {
                                        text = information;
                                    }
                                }
                            }
                            PIR pir = new NotePIR(type, Integer.parseInt(id), topic, title, text);
                            pirList.add(pir);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (file.getName().contains("C")) {
                    // Create ToDoPIR
                    System.out.println("C loop"); // test
                    String fileNameC = file.getName();
                    Pattern idPatternC = Pattern.compile("[A-Za-z]*(\\d+).*");
                    Matcher idMatcherC = idPatternC.matcher(fileNameC);
                    if (idMatcherC.matches()) {
                        String id = idMatcherC.group(1);
                        String type = "ToDo";
                        String topic = null;
                        String title = null;
                        String description = null;
                        String deadline = null;
                        Pattern pattern = Pattern.compile(":\\s*(.*)");
                        try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                Matcher matcher = pattern.matcher(line);
                                if (matcher.find()) {
                                    String information = matcher.group(1);
                                    if(line.contains("Topic: ")) {
                                        topic = information;
                                    }else if (line.contains("Title: ")) {
                                        title = information;
                                    } else if (line.contains("Description: ")) {
                                        description = information;
                                    } else if (line.contains("Deadline:")) {
                                        deadline = information;
                                    }
                                }
                            }
                        PIR pir = new ToDoPIR(type, Integer.parseInt(id), topic,title, description, deadline);
                        pirList.add(pir);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (file.getName().contains("D")) {
                    // Create EventPIR
                    System.out.println("D loop"); // test
                    String fileNameD = file.getName();
                    Pattern idPatternD = Pattern.compile("[A-Za-z]*(\\d+).*");
                    Matcher idMatcherD = idPatternD.matcher(fileNameD);
                    if (idMatcherD.matches()) {
                        String id = idMatcherD.group(1);
                        String type = "Event";
                        String topic = null;
                        String title = null;
                        String description = null;
                        String date = null;
                        String startTime = null;
                        String endTime = null;
                        Pattern pattern = Pattern.compile(":\\s*(.*)");
                        try (BufferedReader br = new BufferedReader(new FileReader((file)))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                Matcher matcher = pattern.matcher(line);
                                if (matcher.find()) {
                                    String information = matcher.group(1);
                                    if(line.contains("Topic: ")){
                                        topic = information;
                                    }else if (line.contains("Title: ")) {
                                        title = information;
                                    } else if (line.contains("Description: ")) {
                                        description = information;
                                    } else if (line.contains("Date: ")) {
                                        date = information;
                                    } else if (line.contains("Start Time: ")) {
                                        startTime = information;
                                    } else if (line.contains("End Time: ")) {
                                        endTime = information;
                                    }
                                }
                            }
                            PIR pir = new EventPIR(type, Integer.parseInt(id), topic,title, description, date, startTime, endTime);
                            pirList.add(pir);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("=== Wrong FileName Detected ===");
                        break;
                    }
                }
            }
        }
    }

    public int getCountNo(){
        File directory = new File(path);
        if(directory.exists() && directory.isDirectory()){
            File[] files = directory.listFiles();
            int documentCount = 0;
            for(File file: files){
                if(file.isFile()){
                    documentCount++;
                }
            }
            return documentCount;
        } else{
            return 0;
        }
    }


}
