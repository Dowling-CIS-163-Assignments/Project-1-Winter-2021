package project1GIVE_TO_STUDENTS;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.event.ActionListener;

public class StopWatchPanelFX extends GridPane {

	private StopWatch watch;
	private Timer javaTimer;

	private Button startButton;
	private TextField minField, secField, milliField;

	Label lblTime;

	public StopWatchPanelFX() {

		watch = new StopWatch();
		javaTimer = new Timer(8, new TimerListener());

		minField = new TextField("0");

		add(minField, 0, 0);
		add(new Label("Minutes:"), 1, 0);

		secField = new TextField("0");
		add(secField, 0, 1);
		add(new Label("Seconds:"), 1, 1);

		milliField = new TextField("0");

		add(milliField, 0, 2);
		add(new Label("Miliseconds:"), 1, 2);

		add(new Label(" "), 1, 7);

		lblTime = new Label();
		lblTime.setText(watch.toString());
		add(lblTime, 1, 8);

		add(new Label("Time:"), 0, 8);

		startButton = new Button("Start");
		add(startButton, 1, 10);

		// register the listeners
		startButton.setOnAction(this::actionPerformed);
	}

	public void actionPerformed(ActionEvent event) {

		int mins, sec, milli;

		if (event.getSource() == startButton) {
			try {
				mins = Integer.parseInt(minField.getText());
				sec = Integer.parseInt(secField.getText());
				milli = Integer.parseInt(milliField.getText());
				watch = new StopWatch(mins, sec, milli);
				javaTimer.start();
			} catch (NumberFormatException io) {
				errorMessageDialog("Number Format exception");
			} catch (IllegalArgumentException e) {
				errorMessageDialog("Number Format exception");
			}
		}

		lblTime.setText(watch.toString());
	}

	private void errorMessageDialog(String message) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle("Error Message");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}


	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			watch.add(10);

			Platform.runLater(() -> lblTime.setText(watch.toString()));
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					lblTime.setText(watch.toString());
				}
			});

			// How to use util timer: https://www.geeksforgeeks.org/java-util-timer-class-java/
			// How to use runLater: https://stackoverflow.com/questions/17124442/javafx2-illegalstateexception-with-label-settext
		}
	}
}
