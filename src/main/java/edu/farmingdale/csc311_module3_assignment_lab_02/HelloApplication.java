package edu.farmingdale.csc311_module3_assignment_lab_02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
/*
Author: Kervin Francois
Date: 9/13/2024
 */

import java.io.IOException;

public class HelloApplication extends Application {
    // Define the text fields for user input and output display
    private TextField annualInterestRate = new TextField();
    private TextField numberOfYears = new TextField();
    private TextField loanAmount = new TextField();
    private TextField monthlyPayment = new TextField();
    private TextField totalPayment = new TextField();
    private Button calculate = new Button("Calculate"); // Button to trigger loan calculation

    @Override
    public void start(Stage stage) throws IOException {
        // Set layout positions for text fields
        annualInterestRate.setLayoutX(130);
        annualInterestRate.setLayoutY(10);

        numberOfYears.setLayoutX(130);
        numberOfYears.setLayoutY(50);

        loanAmount.setLayoutX(130);
        loanAmount.setLayoutY(90);

        monthlyPayment.setLayoutX(130);
        monthlyPayment.setLayoutY(130);

        totalPayment.setLayoutX(130);
        totalPayment.setLayoutY(170);

        calculate.setLayoutX(215);
        calculate.setLayoutY(210);

        // Create labels and text fields
        Label annualInterestRateLabel = new Label("Annual Interest Rate:");
        annualInterestRateLabel.setLayoutX(10);
        annualInterestRateLabel.setLayoutY(20);

        Label numberOfYearsLabel = new Label("Number of Years:");
        numberOfYearsLabel.setLayoutX(10);
        numberOfYearsLabel.setLayoutY(60);

        Label loanAmountLabel = new Label("Loan Amount:");
        loanAmountLabel.setLayoutX(10);
        loanAmountLabel.setLayoutY(100);

        Label monthlyPaymentLabel = new Label("Monthly Payment:");
        monthlyPaymentLabel.setLayoutX(10);
        monthlyPaymentLabel.setLayoutY(140);

        Label totalPaymentLabel = new Label("Total Payment:");
        totalPaymentLabel.setLayoutX(10);
        totalPaymentLabel.setLayoutY(180);

        // Set the background color for the scene
        Color col1 = Color.LIGHTGRAY;

        // Event handler for button click
        calculate.setOnAction(e -> calculateLoanPayment());

        // Create a scene and place it in the stage
        Group grp = new Group(annualInterestRate, annualInterestRateLabel, numberOfYears, numberOfYearsLabel, loanAmount, loanAmountLabel, monthlyPayment, monthlyPaymentLabel, totalPayment, totalPaymentLabel, calculate);
        Scene scene = new Scene(grp, 290, 245, col1);
        stage.setTitle("Loan Calculator"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }

    private void calculateLoanPayment() {
        // Get values from the text fields
        double annualInterestRateValue = Double.parseDouble(annualInterestRate.getText());
        int numberOfYearsValue = Integer.parseInt(numberOfYears.getText());
        double loanAmountValue = Double.parseDouble(loanAmount.getText());

        // Calculate monthly interest rate
        double monthlyInterestRate = annualInterestRateValue / 1200;

        // Calculate monthly payment
        double monthlyPaymentValue = loanAmountValue * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYearsValue * 12)));

        // Calculate total payment
        double totalPaymentValue = monthlyPaymentValue * numberOfYearsValue * 12;

        // Display solutions
        monthlyPayment.setText(String.format("$%.2f", monthlyPaymentValue));
        totalPayment.setText(String.format("$%.2f", totalPaymentValue));

    }

    public static void main(String[] args) {
        launch();
    }
}