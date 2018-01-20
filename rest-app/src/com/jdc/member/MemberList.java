package com.jdc.member;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdc.client.Member;
import com.jdc.client.MemberClient;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MemberList implements Initializable {

    @FXML
    private TextField searchName;

    @FXML
    private TableView<Member> table;

    @FXML
    public void addNew() {
    		MemberEdit.showView(this::save, null);
    }
    
    private MemberClient client;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		client = new MemberClient();
		
		searchName.textProperty().addListener((a,b,c) -> search());
		
		MenuItem edit = new MenuItem("Edit");
		MenuItem delete = new MenuItem("Delete");
		
		edit.setOnAction(event -> MemberEdit.showView(MemberList.this::save, table.getSelectionModel().getSelectedItem()));
		delete.setOnAction(event -> {
			Member m = table.getSelectionModel().getSelectedItem();
			client.delete(m.getId());
			search();
		});
		
		table.setContextMenu(new ContextMenu(edit, delete));
		
		
		search();
	}

	private void search() {
		table.getItems().clear();
		table.getItems().addAll(client.findByNameLike(searchName.getText()));
	}
	
	private void save(Member member) {
		if(member.getId() == 0) {
			client.create(member);
		} else {
			client.update(member);
		}
		
		search();
	}

}
