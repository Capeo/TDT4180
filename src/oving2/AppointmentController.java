package oving2;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class AppointmentController{
	
    @FXML
    private Button cancel;

    @FXML
    private Label slutTidMark;

    @FXML
    private Line line;

    @FXML
    private CheckBox gjentaBox;

    @FXML
    private TextField slutTidHH;

    @FXML
    private TextField formålField;

    @FXML
    private Label startLabel;

    @FXML
    private TextField startTidHH;

    @FXML
    private AnchorPane root;

    @FXML
    private Label repFrekvLabel;

    @FXML
    private Label sluttDatoLabel;

    @FXML
    private Label startTidMark;

    @FXML
    private Label formålLabel;

    @FXML
    private Label tittel;

    @FXML
    private TextField romField;

    @FXML
    private TextField slutTidMM;

    @FXML
    private Label romLabel;

    @FXML
    private Pane background;

    @FXML
    private TextField startTidMM;

    @FXML
    private TextField repfrekvens;

    @FXML
    private Button reset;

    @FXML
    private Label datoLabel;

    @FXML
    private Button send;

    @FXML
    private DatePicker startDate;

    @FXML
    private Label sluttLabel;

    @FXML
    private DatePicker sluttDato;
    
    @FXML
    private Label ugyldigRomLabel;

    @FXML
    private Label ugyldigDatoLabel;

    @FXML
    private Label ugyldigStartTid;

    @FXML
    private Label ugyldigSlutTid;
    
    @FXML
    private Label ugyldigFrekvens;

    @FXML
    private Label ugyldigSluttDato;
    
    
	@FXML
	public void initialize() {
		toggleDisabled();
		setInvisible();
		LocalDate now = LocalDate.now();
		startDate.setValue(now);
		sluttDato.setValue(now.plusDays(1));
		startTidHH.setAlignment(Pos.CENTER_RIGHT);
		startTidMM.setAlignment(Pos.CENTER_RIGHT);
		slutTidHH.setAlignment(Pos.CENTER_RIGHT);
		slutTidMM.setAlignment(Pos.CENTER_RIGHT);
		toggleSend();
		
		gjentaBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
			public void changed(ObservableValue<? extends Boolean> ov,Boolean old, Boolean ne){
				toggleDisabled();
			}
		});
		
		reset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				resetAll();
			}
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				resetAll();
				System.exit(0);
			}
		});
		
		send.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Appointment appointment = new Appointment();
				appointment.setFormal(formålField.getText());
				appointment.setRom(romField.getText());
				appointment.setDato(startDate.getValue());
				int[] startTime = convertTime(startTidHH.getText(), startTidMM.getText());
				appointment.setFra(LocalTime.of(startTime[0], startTime[1]));
				int[] slutTime = convertTime(slutTidHH.getText(), slutTidMM.getText());
				appointment.setTil(LocalTime.of(slutTime[0], slutTime[1]));
				appointment.setRepetisjon(getRepFrekvens());
				appointment.setSlutt(sluttDato.getValue());
				System.exit(0);
			}

		});
		
		gjentaBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (!event.getCode().equals(KeyCode.SPACE) && !event.getCode().equals(KeyCode.TAB)){
					gjentaBox.fire();					
				}
			}
		});
		
		romField.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
				toggleSend();
				if (!newValue){
					if(!checkRoomField()){
						ugyldigRomLabel.setVisible(true);						
					}
					else{
						ugyldigRomLabel.setVisible(false);
					}
				}
				else{
					ugyldigRomLabel.setVisible(false);
				}
			}
		});
		
		startTidHH.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
				toggleSend();
				if (!newValue){
					if(!(checkHour(startTidHH.getText()) && checkMin(startTidMM.getText()))){
						ugyldigStartTid.setVisible(true);						
					}
					else{
						if (!checkTime()){
							ugyldigSlutTid.setVisible(true);
						}
						else{
							ugyldigSlutTid.setVisible(false);
						}
					}
				}
				else{
					ugyldigStartTid.setVisible(false);
				}
			}
		});
		
		startTidMM.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
				toggleSend();
				if (!newValue){
					if(!(checkHour(startTidHH.getText()) && checkMin(startTidMM.getText()))){
						ugyldigStartTid.setVisible(true);						
					}
					else{
						if (!checkTime()){
							ugyldigSlutTid.setVisible(true);
						}
						else{
							ugyldigSlutTid.setVisible(false);
						}
					}
				}
				else{
					ugyldigStartTid.setVisible(false);
				}
			}
		});
		
		slutTidHH.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
				toggleSend();
				if (!newValue){
					if(!(checkHour(slutTidHH.getText()) && checkMin(slutTidMM.getText()))){
						ugyldigSlutTid.setVisible(true);						
					}
					else{
						if (!checkTime()){
							ugyldigSlutTid.setVisible(true);
						}
						else{
							ugyldigSlutTid.setVisible(false);
						}
					}
				}
				else{
					ugyldigSlutTid.setVisible(false);
				}
			}
		});
		
		slutTidMM.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
				toggleSend();
				if (!newValue){
					if(!(checkHour(slutTidHH.getText()) && checkMin(slutTidMM.getText()))){
						ugyldigSlutTid.setVisible(true);						
					}
					else{
						if (!checkTime()){
							ugyldigSlutTid.setVisible(true);
						}
						else{
							ugyldigSlutTid.setVisible(false);
						}
					}
				}
				else{
					ugyldigSlutTid.setVisible(false);
				}
			}
		});
		
		repfrekvens.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
				toggleSend();
				if (!newValue){
					if(!checkFrekvens()){
						ugyldigFrekvens.setVisible(true);						
					}
					else{
						ugyldigFrekvens.setVisible(false);
					}
				}
				else{
					ugyldigFrekvens.setVisible(false);
				}
			}
		});
		
		startDate.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
				toggleSend();
				if (!newValue){
					LocalDate selected = startDate.getValue();
					if(selected.isBefore(LocalDate.now())){
						ugyldigDatoLabel.setVisible(true);
					}
					else{
						ugyldigDatoLabel.setVisible(false);
					}
				}
				else{
					ugyldigDatoLabel.setVisible(false);
				}
			}
		});
		
		sluttDato.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
				toggleSend();
				if (!newValue){
					LocalDate selected = sluttDato.getValue();
					if(selected.isBefore(startDate.getValue().plusDays(getRepFrekvens()))){
						ugyldigSluttDato.setVisible(true);
					}
					else{
						ugyldigSluttDato.setVisible(false);
					}
				}
				else{
					ugyldigSluttDato.setVisible(false);
				}
			}
		});
		
		formålField.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0,
					Boolean oldValue, Boolean newValue) {
				toggleSend();
			}
			
		});
		
		
		reset.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0,
					Boolean arg1, Boolean arg2) {
				toggleSend();	
			}
		});
		
		cancel.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable,
					Boolean oldValue, Boolean newValue) {
				toggleSend();	
			}
		});
		
		gjentaBox.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable,
					Boolean oldValue, Boolean newValue) {
				toggleSend();	
			}
		});
		
		sluttDato.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				toggleSend();	
			}
		});
		
	}

	
	private void toggleSend(){
		if (ugyldigDatoLabel.isVisible() || ugyldigFrekvens.isVisible() || ugyldigRomLabel.isVisible() || ugyldigSluttDato.isVisible() ||
				ugyldigSlutTid.isVisible() || ugyldigStartTid.isVisible() || romField.getText().isEmpty() || startTidHH.getText().isEmpty()
						|| startTidMM.getText().isEmpty() || slutTidHH.getText().isEmpty() || slutTidHH.getText().isEmpty() || 
						formålField.getText().isEmpty() || (!repfrekvens.isDisabled() && repfrekvens.getText().isEmpty()) ||
						startDate.getValue().isBefore(LocalDate.now()) || sluttDato.getValue().isBefore(LocalDate.now().plusDays(getRepFrekvens()))){
			send.setDisable(true);
		}
		else{
			send.setDisable(false);			
		}
	}
	
	private int[] convertTime(String s1, String s2){
		try{
			return new int[]{Integer.parseInt(s1),Integer.parseInt(s2)};
		}
		catch (NumberFormatException e){
			return new int[]{0,0};			
		}
	}
	
	private boolean checkRoomField(){
		String str = romField.getText();
		String[] parts = str.split(" ");
		if (parts.length < 2){
			return false;
		}
		try{
			Integer.parseInt(parts[parts.length - 1]); 
			return true;
		}
		catch (NumberFormatException e){
			return false;			
		}
	}
	
	private boolean checkHour(String str){
		try{
			int hour = Integer.parseInt(str);
			if (hour < 0 || hour > 23){
				return false;
			}
			return true;
		}
		catch (NumberFormatException e){
			return false;			
		}
	}
	
	private boolean checkMin(String str){
		try{
			int min = Integer.parseInt(str);
			if (min < 0 || min > 59){
				return false;
			}
			return true;
		}
		catch (NumberFormatException e){
			return false;			
		}
	}
	
	private boolean checkTime(){
		try{
			int HH1 = Integer.parseInt(startTidHH.getText());
			int MM1 = Integer.parseInt(startTidMM.getText());
			int HH2 = Integer.parseInt(slutTidHH.getText());
			int MM2 = Integer.parseInt(slutTidMM.getText());
			if (HH1 < HH2){
				return true;
			}
			else if (HH1 == HH2){
				return MM1 < MM2;
			}
			else{
				return false;
			}
		}
		catch (NumberFormatException e){
			return false;			
		}
	}
	
	private boolean checkFrekvens(){
		try{
			int frekvens = Integer.parseInt(repfrekvens.getText());
			if (frekvens <= 0){
				return false;
			}
			return true;
		}
		catch (NumberFormatException e){
			return false;			
		}
	}
	
	private void resetAll(){
		romField.textProperty().setValue("");
		formålField.textProperty().setValue("");
		startTidHH.textProperty().setValue("");
		startTidMM.textProperty().setValue("");
		slutTidHH.textProperty().setValue("");
		slutTidMM.textProperty().setValue("");
		repfrekvens.textProperty().setValue("");
		startDate.setValue(LocalDate.now());
		sluttDato.setValue(LocalDate.now().plusDays(1));
	}
	
	private void setInvisible(){
		ugyldigDatoLabel.setVisible(false);
		ugyldigFrekvens.setVisible(false);
		ugyldigRomLabel.setVisible(false);
		ugyldigSluttDato.setVisible(false);
		ugyldigSlutTid.setVisible(false);
		ugyldigStartTid.setVisible(false);
	}
	
	private void toggleDisabled(){
		if (gjentaBox.isSelected()){
			sluttDato.setDisable(false);
	    	sluttDatoLabel.setDisable(false);
	    	repfrekvens.setDisable(false);
	    	repFrekvLabel.setDisable(false);
		}
		else{
			sluttDato.setDisable(true);
	    	sluttDatoLabel.setDisable(true);
	    	repfrekvens.setDisable(true);
	    	repFrekvLabel.setDisable(true);
		}
	}
	
	private int getRepFrekvens() {
		if (gjentaBox.isSelected()){
			try{
				return Integer.parseInt(repfrekvens.getText());
			}
			catch (NumberFormatException e){
				return 0;			
			}
		}
		return 0;
	}
	
}
