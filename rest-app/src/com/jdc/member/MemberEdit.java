package com.jdc.member;

import java.util.function.Consumer;

import com.jdc.client.Member;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MemberEdit {

	@FXML
	private Label title;

	@FXML
	private TextField name;

	@FXML
	private TextField phone;

	@FXML
	private TextField email;

	private Member oldMember;
	private Consumer<Member> saveHadler;

	public static void showView(Consumer<Member> consumer, Member oldMember) {

		try {
			FXMLLoader loader = new FXMLLoader(MemberEdit.class.getResource("MemberEdit.fxml"));
			Parent view = loader.load();
			MemberEdit controller = loader.getController();
			
			controller.setOldMember(oldMember);
			controller.saveHadler = consumer;
			
			Stage stage = new Stage();
			stage.setScene(new Scene(view));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setOldMember(Member oldMember) {
		this.oldMember = oldMember;
		title.setText(null == oldMember ? "Add New Member" : "Edit Member");
		
		if(null != oldMember) {
			name.setText(oldMember.getName());
			phone.setText(oldMember.getPhone());
			email.setText(oldMember.getEmail());
		}
	}

	public void save() {
		if(null == oldMember) {
			oldMember = new Member();
		}
		
		oldMember.setName(name.getText());
		oldMember.setPhone(phone.getText());
		oldMember.setEmail(email.getText());
		
		saveHadler.accept(oldMember);
		
		name.getScene().getWindow().hide();
	}

}
