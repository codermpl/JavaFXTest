package com.daniel.javafxtest;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.*;

public class FxmlView extends Application {

	KnightsTourModel tour;
	
	@Override
	public void start(Stage stage) {
	    try{
	    	tour = new KnightsTourModel();
	    	//Parent root = FXMLLoader.load(getClass().getResource("chessLayout.fxml"));
	    	
	    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("chessLayout.fxml"));
	    	Scene scene = new Scene((Parent)fxmlLoader.load(), 300, 275);
	    	ChessController controller = fxmlLoader.getController();
	    	controller.setTour(tour);
	    	//System.out.println("startingGroup = " + startingGroup);
	    	
	    	System.out.println(System.getProperty("user.dir"));

	        BorderPane p = (BorderPane)scene.getRoot();
	        System.out.println(p.toString());
	        GridPane grid = (GridPane)p.getChildrenUnmodifiable().get(0);
	        System.out.println(grid.toString());
	        
			grid.setAlignment(Pos.CENTER);
			grid.getStyleClass().add("grid-node");
    	    grid.setPrefSize(400, 400);
    	    Insets inset = grid.getInsets();
			int i,j;
		    NumberBinding rectsAreaSize = Bindings.min(scene.heightProperty(), scene.widthProperty());

			for(i=0;i<8;i++){
				for(j=0;j<8;j++){

					Rectangle helpIcon = new Rectangle(30.0, 30.0);
					if(i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1){
						   helpIcon.setFill(Color.BEIGE);

					}
					else{
						   //helpIcon.setFill(Color.BROWN);
						   helpIcon.setFill(Color.BLACK);
					}

				helpIcon.widthProperty().bind(rectsAreaSize.divide(8).subtract(5));
				helpIcon.heightProperty().bind(rectsAreaSize.divide(8).subtract(5));
					grid.add(helpIcon, i, j);
					helpIcon.toBack();
				}
			}
	    	Image image1 = new Image("file:Knight_3.gif");

	    	System.out.println(image1.errorProperty().getValue());
	    	ImageView iv = new ImageView();
	    	//iv.fitWidthProperty().bind(rectsAreaSize.divide(8).subtract(5));
	    	//iv.fitHeightProperty().bind(rectsAreaSize.divide(8).subtract(5));

	    	//iv.setImage(image1);
	    	//grid.add(iv, 0, 0);
	    	controller.addSquareEvents();
	    	controller.bindSquareSize(rectsAreaSize.divide(8).subtract(5));
	    	controller.createMoveGraphics();
	        stage.setTitle("Knight's Tour");
	        stage.setScene(scene);
	        stage.show();
	    }
	    catch(Exception e){
	        e.printStackTrace(System.out);    	
	    }
	}

	public static void main(String[] args) {
		launch(args);
	}
}
