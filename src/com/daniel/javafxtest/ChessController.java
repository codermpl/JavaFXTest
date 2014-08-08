package com.daniel.javafxtest;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ChessController implements Initializable{
 
	@FXML public GridPane grid;
	@FXML public ImageView knightImage;
	private KnightsTourModel tour;
	List<Circle> adjCircles;
	
	@Override public void initialize(URL url, ResourceBundle rb) {
        System.out.println("You are initializing!");
        
        adjCircles = new ArrayList<Circle>();
        for(int i=0; i<8;i++){
        	Circle circle = new Circle(10,Color.GREEN);
        	circle.setVisible(false);
        	adjCircles.add(circle);
        	grid.add(circle, 1, 1);
        }
//		grid.addEventFilter(MouseEvent.MOUSE_CLICKED, squareHandle);

/*		EventHandler filter = new EventHandler<InputEvent>() {
		    public void handle(InputEvent event) {
		        System.out.println("Filtering out event " + event.getEventType()); 
		        
		        Circle circle = new Circle(10);
		        ColumnConstraints column1 = new ColumnConstraints();
		        column1.setHalignment(HPos.CENTER);
		        
		        grid.add(circle,0,0);
		        GridPane.setConstraints(circle, 3, 3, 1, 1, HPos.CENTER, VPos.CENTER);
		        event.consume();
		    }
		};
		grid.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);
    */
    }
    public void handleResetButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    public void setTour(KnightsTourModel tour){
    	this.tour = tour;
    }
    public void addSquareEvents(){
    	EventHandler squareHandle = new EventHandler<InputEvent>() {
	    public void handle(InputEvent event) {
	        System.out.println("Handling event " + event.getEventType()); 
	        System.out.println(event.getSource());
	        int row = grid.getRowIndex((Node)event.getSource());
	        int column = grid.getColumnIndex((Node)event.getSource());
	        Square clickedSquare = tour.getSquare(column, row);
	        List<Square> adjList = clickedSquare.getAdjacentNodes();
	        
	        Iterator<Square> squareIterator = adjList.iterator();
	        for(int index = 0;index<8; index++){
	        	if(squareIterator.hasNext()){
	        		Square sq = squareIterator.next();
	        	System.out.println(sq.toString());
	        	//Circle circle = new Circle(10);   
	        	//grid.add(circle,0,0);
        		adjCircles.get(index).setVisible(true);
			    GridPane.setConstraints(adjCircles.get(index), sq.x, sq.y, 1, 1, HPos.CENTER, VPos.CENTER);
	        	}
	        	else{
	        		adjCircles.get(index).setVisible(false);
	        	}
	        }
	        
	        //Move knight

		    	GridPane.setConstraints(knightImage, column, row);
		    	//GridPane.setConstraints(circle1, 2,2);
	        event.consume();
	    }
	};
    Iterator<Node> rectIterator = grid.getChildren().iterator();
	    while(rectIterator.hasNext()){
	    	Node n = rectIterator.next();
	    	n.addEventFilter(MouseEvent.MOUSE_CLICKED, squareHandle);
	    }
    }
    public void handleSquareAction(ActionEvent event) {
        System.out.println("You clicked a Square!");

    }
}
