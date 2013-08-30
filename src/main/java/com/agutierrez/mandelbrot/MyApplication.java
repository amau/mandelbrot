package com.agutierrez.mandelbrot;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.PixelWriter;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
 
public class MyApplication extends Application {
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mandelbrot Set");
        Group root = new Group();
        Canvas canvas = new Canvas(400, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
    	PixelWriter pixelWriter = gc.getPixelWriter();

    	for(int i=0 ; i<400 ;i++)
    	{
	    	for(int j=0 ; j<300 ;j++)
	    	{
	    		pixelWriter.setColor(i, j, Color.rgb(0,100,255));
	    	}	
    	}
    	
    }
}