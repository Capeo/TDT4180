package oving1;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Currency extends Application{

	private AnchorPane root;
	private Scene scene;
	private Pane uPane;
	private Pane jPane;
	private Pane ePane;
	private Pane gPane;
	private ImageView uFlag;
	private ImageView jFlag;
	private ImageView eFlag;
	private ImageView gFlag;
	private Label usd;
	private Label jpy;
	private Label eur;
	private Label gbp;
	private Label uv;
	private Label jv;
	private Label ev;
	private Label gv;
	
	public void draw(){
		//Root
		root.setPrefHeight(800);
		root.setPrefWidth(500);
		
		//usPane
		uPane = new Pane();
		uPane.setPrefHeight(200);
		uPane.setPrefWidth(500);
		uPane.setLayoutX(0);
		uPane.setLayoutY(0);
		uPane.setStyle("-fx-background-color: #E1C2A7; -fx-border-width: 1; -fx-border-color: #C7A88E");
		root.getChildren().add(uPane);
		
		Image uImage = new Image("usd.png");
		uFlag = new ImageView(uImage);
		uFlag.setLayoutX(30);
		uFlag.setLayoutY(50);
		uPane.getChildren().add(uFlag);
		
		usd = new Label("USD");
		usd.setPrefHeight(100);
		usd.setPrefWidth(100);
		usd.setLayoutX(130);
		usd.setLayoutY(50);
		usd.setStyle("-fx-alignment: CENTER; -fx-font-size: 25; -fx-text-fill: #A98C74");
		uPane.getChildren().add(usd);
		
		uv = new Label("10,000");
		uv.setPrefHeight(200);
		uv.setPrefWidth(200);
		uv.setLayoutX(250);
		uv.setLayoutY(0);
		uv.setAlignment(Pos.BASELINE_RIGHT);
		uv.setStyle(" -fx-font-size: 55; -fx-text-fill: #D45C5C");
		uPane.getChildren().add(uv);
		
		//jPane
		jPane = new Pane();
		jPane.setPrefHeight(200);
		jPane.setPrefWidth(500);
		jPane.setLayoutX(0);
		jPane.setLayoutY(200);
		jPane.setStyle("-fx-background-color: #E1C2A7; -fx-border-width: 1; -fx-border-color: #C7A88E");
		root.getChildren().add(jPane);
		
		Image jImage = new Image("jpy.png");
		jFlag = new ImageView(jImage);
		jFlag.setLayoutX(30);
		jFlag.setLayoutY(50);
		jPane.getChildren().add(jFlag);
		
		jpy = new Label("JPY");
		jpy.setPrefHeight(100);
		jpy.setPrefWidth(100);
		jpy.setLayoutX(130);
		jpy.setLayoutY(50);
		jpy.setStyle("-fx-alignment: CENTER; -fx-font-size: 25; -fx-text-fill: #A98C74");
		jPane.getChildren().add(jpy);
		
		jv = new Label("992,815");
		jv.setPrefHeight(200);
		jv.setPrefWidth(200);
		jv.setLayoutX(250);
		jv.setLayoutY(0);
		jv.setAlignment(Pos.BASELINE_RIGHT);
		jv.setStyle(" -fx-font-size: 55; -fx-text-fill: #000000");
		jPane.getChildren().add(jv);
		
		//ePane
		ePane = new Pane();
		ePane.setPrefHeight(200);
		ePane.setPrefWidth(500);
		ePane.setLayoutX(0);
		ePane.setLayoutY(400);
		ePane.setStyle("-fx-background-color: #E1C2A7; -fx-border-width: 1; -fx-border-color: #C7A88E");
		root.getChildren().add(ePane);
		
		Image eImage = new Image("eur.png");
		eFlag = new ImageView(eImage);
		eFlag.setLayoutX(30);
		eFlag.setLayoutY(50);
		ePane.getChildren().add(eFlag);
		
		eur = new Label("EUR");
		eur.setPrefHeight(100);
		eur.setPrefWidth(100);
		eur.setLayoutX(130);
		eur.setLayoutY(50);
		eur.setStyle("-fx-alignment: CENTER; -fx-font-size: 25; -fx-text-fill: #A98C74");
		ePane.getChildren().add(eur);
		
		ev = new Label("7,694");
		ev.setPrefHeight(200);
		ev.setPrefWidth(200);
		ev.setLayoutX(250);
		ev.setLayoutY(0);
		ev.setAlignment(Pos.BASELINE_RIGHT);
		ev.setStyle(" -fx-font-size: 55; -fx-text-fill: #000000");
		ePane.getChildren().add(ev);
		
		//ePane
		gPane = new Pane();
		gPane.setPrefHeight(200);
		gPane.setPrefWidth(500);
		gPane.setLayoutX(0);
		gPane.setLayoutY(600);
		gPane.setStyle("-fx-background-color: #E1C2A7; -fx-border-width: 1; -fx-border-color: #C7A88E");
		root.getChildren().add(gPane);
				
		Image gImage = new Image("gbp.png");
		gFlag = new ImageView(gImage);
		gFlag.setLayoutX(30);
		gFlag.setLayoutY(50);
		gPane.getChildren().add(gFlag);
		
		gbp = new Label("GBP");
		gbp.setPrefHeight(100);
		gbp.setPrefWidth(100);
		gbp.setLayoutX(130);
		gbp.setLayoutY(50);
		gbp.setStyle("-fx-alignment: CENTER; -fx-font-size: 25; -fx-text-fill: #A98C74");
		gPane.getChildren().add(gbp);
		
		gv = new Label("6,559");
		gv.setPrefHeight(200);
		gv.setPrefWidth(200);
		gv.setLayoutX(250);
		gv.setLayoutY(0);
		gv.setAlignment(Pos.BASELINE_RIGHT);
		gv.setStyle(" -fx-font-size: 55; -fx-text-fill: #000000");
		gPane.getChildren().add(gv);
	}
	
	@Override
	public void start(Stage primStage) throws Exception {
		root = new AnchorPane();
		draw();
		scene = new Scene(root);
		primStage.setScene(scene);
		primStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
	
}
