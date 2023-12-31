import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NotePIR extends PIR{

    private String title;
    private String texts;

    NotePIR(String type, int id,String topic, String title, String texts){
        super(type, id, topic);
        this.title = title;
        this.texts = texts;
    }

    void store(){
        String fileName = "B"+id+".pim";
        String heading = "=== Note ===\n";
        String topic = "Topic: "+super.topic+"\n";
        String contentTitle = "Title: "+title+"\n";
        String contentText = "Texts: "+texts+"\n";
        String closing = "--- End of "+fileName+" PIR ---\n=====================";
        try{
            File file = new File(path+"/"+fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(heading+topic+contentTitle+contentText+closing);
            fileWriter.close();
            System.out.println("=== File created successfully ===");
        } catch (IOException e){
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }

    }

    void print(){
        String fileName = "B"+id+".pim";
        String heading = "=== Note ===\n";
        String topic = "Topic: "+super.topic+"\n";
        String contentTitle = "Title: "+title+"\n";
        String contentText = "Texts: "+texts+"\n";
        String closing = "--- End of "+fileName+" PIR ---\n=====================";
        System.out.println(heading+topic+contentTitle+contentText+closing);
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTexts(String texts){
        this.texts = texts;
    }
    public String getTexts(){
        return texts;
    }
}