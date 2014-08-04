package com.daniel.javafxtest;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ChessController implements Initializable{

	@FXML public GridPane grid;
	
	@Override public void initialize(URL url, ResourceBundle rb) {
        System.out.println("You are initializing!");
		
		EventHandler filter = new EventHandler<InputEvent>() {
		    public void handle(InputEvent event) {
		        System.out.println("Filtering out event " + event.getEventType()); 
		        event.consume();
		    }
		};
		grid.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
    }
    public void handleResetButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    public void handleSquareAction(ActionEvent event) {
        System.out.println("You clicked a Square!");
    }
}
