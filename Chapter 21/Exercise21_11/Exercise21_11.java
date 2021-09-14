import java.net.URL;
import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  private int yearConv = 0;
  private int genderConv = 1;
  List<Map> boyMaps = new ArrayList();
  List<Map> girlMaps = new ArrayList();
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    Scanner[] boys = new Scanner[10];
    Scanner[] girls = new Scanner[10];
    try {
      boys[0] = new Scanner(new File("baby2001.txt"));
      boys[1] = new Scanner(new File("baby2002.txt"));
      boys[2] = new Scanner(new File("baby2003.txt"));
      boys[3] = new Scanner(new File("baby2004.txt"));
      boys[4] = new Scanner(new File("baby2005.txt"));
      boys[5] = new Scanner(new File("baby2006.txt"));
      boys[6] = new Scanner(new File("baby2007.txt"));
      boys[7] = new Scanner(new File("baby2008.txt"));
      boys[8] = new Scanner(new File("baby2009.txt"));
      boys[9] = new Scanner(new File("baby2010.txt"));
      girls[0] = new Scanner(new File("baby2001girl.txt"));
      girls[1] = new Scanner(new File("baby2002girl.txt"));
      girls[2] = new Scanner(new File("baby2003girl.txt"));
      girls[3] = new Scanner(new File("baby2004girl.txt"));
      girls[4] = new Scanner(new File("baby2005girl.txt"));
      girls[5] = new Scanner(new File("baby2006girl.txt"));
      girls[6] = new Scanner(new File("baby2007girl.txt"));
      girls[7] = new Scanner(new File("baby2008girl.txt"));
      girls[8] = new Scanner(new File("baby2009girl.txt"));
      girls[9] = new Scanner(new File("baby2010girl.txt"));
    }
    catch(FileNotFoundException e) {
      System.out.println("Missing required files");
    }
    try {
      for(int i = 0; i < boys.length; i++) {
        Map<String, Integer> map = new HashMap<>();
        while(boys[i].hasNext()) {
          map.put(boys[i].next().toLowerCase(), boys[i].nextInt());
        }
        boyMaps.add(map);
      }
      for(int i = 0; i < girls.length; i++) {
        Map<String, Integer> map = new HashMap<>();
        while(girls[i].hasNext()) {
          map.put(girls[i].next().toLowerCase(), girls[i].nextInt());
        }
        girlMaps.add(map);
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
    }
    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");
    cboYear.setOnAction(e -> {
      switch(cboYear.getValue()) {
        case 2001:
        yearConv = 0;
        break;
        case 2002:
        yearConv = 1;
        break;
        case 2003:
        yearConv = 2;
        break;
        case 2004:
        yearConv = 3;
        break;
        case 2005:
        yearConv = 4;
        break;
        case 2006:
        yearConv = 5;
        break;
        case 2007:
        yearConv = 6;
        break;
        case 2008:
        yearConv = 7;
        break;
        case 2009:
        yearConv = 8;
        break;
        case 2010:
        yearConv = 9;
        break;
      }
    });
    cboGender.setOnAction(e -> {
      if(cboGender.getValue().equals("Male")) {
        genderConv = 1;
      }
      else {
        genderConv = 0;
      }
    });
    btFindRanking.setOnAction(e -> {
      if(genderConv == 1) {
        for(int i = 0; i < boyMaps.size(); i++) {
          if(yearConv == i) {
            if(boyMaps.get(i).get(tfName.getText().toLowerCase()) != null) {
              lblResult.setText("Ranking for " + tfName.getText() + " is #" + boyMaps.get(i).get(tfName.getText().toLowerCase()));
            }
            else {
              lblResult.setText("We do not have a ranking for " + tfName.getText());
            }
          }
        }
      }
      else {
        for(int i = 0; i < girlMaps.size(); i++) {
          if(yearConv == i) {
            if(girlMaps.get(i).get(tfName.getText().toLowerCase()) != null) {
              lblResult.setText("Ranking for " + tfName.getText() + " is #" + girlMaps.get(i).get(tfName.getText().toLowerCase()));
            }
            else {
              lblResult.setText("We do not have a ranking for " + tfName.getText());
            }
          }
        }
      }
    });
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
