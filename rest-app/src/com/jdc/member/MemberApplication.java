package com.jdc.member;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemberApplication extends Application {

	@Override
	public void start(Stage s) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("MemberList.fxml"));
		s.setScene(new Scene(root));
		s.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
