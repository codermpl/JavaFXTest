package com.daniel.javafxtest;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
	


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.getStyleClass().add("grid-node");
    	    grid.setPrefSize(400, 400);
    	    Insets inset = grid.getInsets();
			int i,j;
		    NumberBinding rectsAreaSize = Bindings.min(root.heightProperty(), root.widthProperty());

			for(i=0;i<8;i++){
				for(j=0;j<8;j++){

					Rectangle helpIcon = new Rectangle(30.0, 30.0);
					if(i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1){
						   helpIcon.setFill(Color.BEIGE);

					}
					else{
						   helpIcon.setFill(Color.BROWN);
					}

					
							   /*new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
						        new Stop[]{
						        new Stop(0,Color.web("#4977A3")),
						        new Stop(0.5, Color.web("#B0C6DA")),
						        new Stop(1,Color.web("#9CB6CF")),}));
						    helpIcon.setStroke(Color.web("#D0E6FA"));
						    helpIcon.setArcHeight(3.5);
						    helpIcon.setArcWidth(3.5);*/
				helpIcon.widthProperty().bind(rectsAreaSize.divide(8).
						subtract(2));
				helpIcon.heightProperty().bind(rectsAreaSize.divide(8).
						subtract(2));
;

					grid.add(helpIcon, i, j);
				}
			}
			root.setCenter(grid);	    
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			 inset = grid.getInsets();
    	    System.out.println(inset.getLeft());

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
