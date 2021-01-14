package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    sample.CarDatabase DataBase = new sample.CarDatabase();

    @FXML private TextField txt_Input;
    @FXML private TextArea txt_Output;
    @FXML private Button quicksearch;

    public void getVehicle(MouseEvent event)
    {
        Object obn = event.getSource();
        Button btn = (Button)obn;
        boolean exact=false;

        if (btn.equals(quicksearch))
        {
            exact=true;
        }

        ArrayList cars = DataBase.search(txt_Input.getText().toUpperCase(),exact);
        String txt="";

        if (cars.size()!=0 && !cars.contains(null))
        {
            for (int i=0;i<cars.size();i++)
            {
                txt= txt + cars.get(i).toString();
            }
        }

        else {
            txt="No matches. Try again.";
        }
        txt_Output.setText(txt);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txt_Output.setEditable(false);
    }
}