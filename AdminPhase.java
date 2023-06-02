package application;

//Its an Admin Side
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import application.Main.Report;
import application.Main.Transaction;



public class Main extends Application {
	  private TableView<Report> reportTable;
	    private Label totalRevenueLabel;
	    private TableView<Transaction> reportTable1;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Toll Management System");

        // Create the root pane
        BorderPane rootPane = new BorderPane();

        // Set the background image
        Image backgroundImage = new Image("C:\\\\Users\\\\G3\\\\Downloads\\\\Toll_Log.jpg");
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        rootPane.setBackground(new Background(backgroundImg));

        // Create the VBox
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER_RIGHT);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        // Create the title label
        Label titleLabel = new Label("Toll Tax Management System");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleLabel.setStyle("-fx-text-fill: black");

        

        // Create the buttons
        Button SignUpButton = new Button("Sign_Up");
        Button LogInButton = new Button("Log_In");

        // Add the components to the VBox
        vbox.getChildren().addAll(titleLabel, LogInButton, SignUpButton);

        // Set the VBox as the center content
        rootPane.setCenter(vbox);
        
        
        LogInButton.setOnAction(login->{
        	viewLoginPage();
        });
        
        SignUpButton.setOnAction(signUp->{
        	//code
        	viewSignUpPage();
        });

        // Create the scene
        Scene scene = new Scene(rootPane, 600, 400);

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void viewSignUpPage()
    {
    	Stage primaryStage=new Stage();
            primaryStage.setTitle("Toll Management System");

            // Create the root pane
            BorderPane rootPane = new BorderPane();

            // Set the background image
            Image backgroundImage = new Image("C:\\\\Users\\\\G3\\\\Downloads\\\\Toll_Log.jpg");
            BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
            rootPane.setBackground(new Background(backgroundImg));

            // Create the VBox
            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER_RIGHT);
            vbox.setPadding(new Insets(10));
            vbox.setSpacing(10);

            // Create the title label
            Label titleLabel = new Label("Toll Management System");
            titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            titleLabel.setStyle("-fx-text-fill: black");
            
            // Create the title label
            Label titleLabel1 = new Label("Sign Up");
            titleLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            titleLabel1.setStyle("-fx-text-fill: black");

            // Create the labels
            Label nameLabel = new Label("Enter Full Name");
            Label ageLabel = new Label("Enter Username");
            Label addressLabel = new Label("Enter Password");
            Label CNICLabel = new Label("Enter CNIC");

            // Create the text fields
            TextField nameTextField = new TextField();
            nameTextField.setMaxWidth(200);
            TextField ageTextField = new TextField();
            ageTextField.setMaxWidth(200);
            TextField addressTextField = new TextField();
            addressTextField.setMaxWidth(200);
            TextField CNICTextField = new TextField();
            CNICTextField.setMaxWidth(200);

            // Create the buttons
            Button saveButton = new Button("Sign Up");

            // Add the components to the VBox
            vbox.getChildren().addAll(titleLabel,titleLabel1, nameLabel, nameTextField,CNICLabel,CNICTextField, ageLabel, ageTextField, addressLabel,
                    addressTextField, saveButton);

            // Set the VBox as the center content
            rootPane.setCenter(vbox);

            saveButton.setOnAction(success->{
            	showSignUpMessage();
            });
            // Create the scene
            Scene scene = new Scene(rootPane, 600, 400);

            // Set the scene and show the stage
            primaryStage.setScene(scene);
            primaryStage.show();
        
    }
    //Screen shows after Sign Up Page
    private void showSignUpMessage() {
        Stage stage = new Stage();
        stage.setTitle("Signed Up");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

        Label messageLabel = new Label("You are successfully signed Up!");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> stage.close());

        vbox.getChildren().addAll(messageLabel, backButton);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    private void viewLoginPage()
    {
    	Stage primaryStage=new Stage();
            primaryStage.setTitle("Login Page");

            // Create a grid layout
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(10));
            gridPane.setHgap(10);
            gridPane.setVgap(10);

            // Create the title
            Label title = new Label("Toll Tax Management System");
            title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            GridPane.setColumnSpan(title, 2);
            gridPane.add(title, 27, 0);

            // Load the background image
            Image backgroundImage = new Image("C:\\Users\\G3\\Downloads\\Toll_Log.jpg");
            ImageView backgroundImageView = new ImageView(backgroundImage);

            // Create a stack pane to hold the background image and the grid layout
            StackPane stackPane = new StackPane();
            stackPane.getChildren().addAll(backgroundImageView, gridPane);

            // Create labels, text fields, and button
            Label usernameLabel = new Label("Username:");
            Label passwordLabel = new Label("Password:");
            TextField usernameTextField = new TextField();
            PasswordField passwordTextField = new PasswordField();
            Button loginButton = new Button("Login");

            // Add the labels, text fields, and button to the grid layout
            gridPane.add(usernameLabel, 27, 5);
            gridPane.add(usernameTextField, 27, 6);
            gridPane.add(passwordLabel, 27, 8);
            gridPane.add(passwordTextField, 27, 9);
            gridPane.add(loginButton, 27, 12);

            // Event handling for login button
            loginButton.setOnAction(e -> {
            	//DB work
                System.out.println("Login Success");
                Stage primaryStage1 = new Stage();
                primaryStage1.setTitle("Toll Tax Management System");

                // Create a menu bar
                MenuBar menuBar = new MenuBar();

                // Create menus
                Menu fileMenu = new Menu("File");
                Menu vehicleMenu = new Menu("Vehicle");
                Menu reportMenu = new Menu("Report");

                // Create menu items
                MenuItem exitItem = new MenuItem("Exit");
                MenuItem addVehicleItem = new MenuItem("Add Vehicle");
                MenuItem viewVehiclesItem = new MenuItem("View Vehicles");
                MenuItem generateReportItem = new MenuItem("Generate Report");
                MenuItem complaintsItem = new MenuItem("Customer Complaints");

                // Add menu items to the menus
                fileMenu.getItems().addAll(exitItem);
                vehicleMenu.getItems().addAll(addVehicleItem, viewVehiclesItem);
                reportMenu.getItems().addAll(generateReportItem);
                reportMenu.getItems().addAll(complaintsItem);

                // Add menus to the menu bar
                menuBar.getMenus().addAll(fileMenu, vehicleMenu, reportMenu);

                // Create the main layout
                BorderPane rootPane1 = new BorderPane();
                rootPane1.setTop(menuBar);

                // Set the background image
                Image backgroundImage1 = new Image("C:\\Users\\G3\\Downloads\\Toll_Log.jpg");
                BackgroundImage backgroundImg = new BackgroundImage(backgroundImage1,
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
                rootPane1.setBackground(new Background(backgroundImg));

                // Set the center content
                VBox centerBox = new VBox();
                centerBox.setAlignment(Pos.CENTER_RIGHT);
                centerBox.setSpacing(10);
                centerBox.setPadding(new Insets(20));

                Label titleLabel = new Label("Toll Tax Management System");
                titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

                Button feedbackButton = new Button("View Feedbacks");
                Button generateReportButton = new Button("Generate Report");
                Button MaintainedBoothButton = new Button("Maintaned Booths");
                Button complaintsButton = new Button("View Complaints");

                // Event handling for generate report button
                generateReportButton.setOnAction(report_Generate -> {
                    System.out.println("Report Generation");
                    generateReport(primaryStage1);
                });

                // Event handling for customer complaints button
                complaintsButton.setOnAction(complaints -> {
                    System.out.println("Customer Complaints");
                    //openCustomerComplaintsScreen(primaryStage1);
                });
                
                // Event handling for Add vehicle button
                feedbackButton.setOnAction(vehicle -> {
                    System.out.println("Feedback");
                    //show_add_vehicle_events();
                });
                
                MaintainedBoothButton.setOnAction(view -> {
                	System.out.println("MAintained Booths");
                	maintained_booth();
                });
                

                centerBox.getChildren().addAll(titleLabel, feedbackButton, generateReportButton, MaintainedBoothButton, complaintsButton);
                rootPane1.setCenter(centerBox);

                // Create the scene
                Scene scene1 = new Scene(rootPane1, 600, 400);

                // Set the scene and show the stage
                primaryStage1.setScene(scene1);
                primaryStage1.show();
            });

            // Create a scene with the stack pane
            Scene scene = new Scene(stackPane, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        
    }
    //Maintained Booth Function
    private void maintained_booth()
    {
    	Stage primaryStage=new Stage();
    	        primaryStage.setTitle("Toll Booth Maintenance");

    	        // Create the root pane
    	        BorderPane rootPane = new BorderPane();

    	        // Set the background image
    	        Image backgroundImage = new Image("C:\\\\Users\\\\G3\\\\Downloads\\\\Toll_Log.jpg");
    	        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
    	                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
    	                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
    	        rootPane.setBackground(new Background(backgroundImg));

    	        // Create the VBox
    	        VBox vbox = new VBox();
    	        vbox.setAlignment(Pos.CENTER_RIGHT);
    	        vbox.setPadding(new Insets(10));
    	        vbox.setSpacing(10);

    	        // Create the title label
    	        Label titleLabel = new Label("Toll Booth Maintenance");
    	        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    	        titleLabel.setStyle("-fx-text-fill: black");

    	        // Create the labels
    	        Label nameLabel = new Label("Scheduled Maintenance Work:");
    	        Label ageLabel = new Label("Assigned Staff:");
    	        Label addressLabel = new Label("Set Date & Time:");

    	        // Create the text fields
    	        TextField nameTextField = new TextField();
    	        nameTextField.setMaxWidth(200);
    	        TextField ageTextField = new TextField();
    	        ageTextField.setMaxWidth(200);
    	        TextField addressTextField = new TextField();
    	        addressTextField.setMaxWidth(200);

    	        // Create the buttons
    	        Button saveButton = new Button("Save");
    	        Button cancelButton = new Button("Maintained");

    	        // Add the components to the VBox
    	        vbox.getChildren().addAll(titleLabel, nameLabel, nameTextField, ageLabel, ageTextField, addressLabel,
    	                addressTextField, saveButton, cancelButton);

    	        // Set the VBox as the center content
    	        rootPane.setCenter(vbox);

    	        // Create the scene
    	        Scene scene = new Scene(rootPane, 600, 400);

    	        // Set the scene and show the stage
    	        primaryStage.setScene(scene);
    	        primaryStage.show();
    	    
    }
    
    
    private void generateReport(Stage primaryStage3) {
        primaryStage3.setTitle("Report Generation");

        // Create the root pane
        BorderPane rootPane2 = new BorderPane();

        // Set the background image
        Image backgroundImage3 = new Image("C:\\\\Users\\\\G3\\\\Downloads\\\\resize-168522146192391757637aeecf2ba40c81b21fbcf88a5b6e27d.jpg");
        ImageView imageView = new ImageView(backgroundImage3);

        // Create the VBox for the right side content
        VBox rightVBox = new VBox();
        rightVBox.setPadding(new Insets(10));
        rightVBox.setSpacing(10);

        // Create the title label for Report Generation
        Label reportTitleLabel = new Label("Report Generation");
        reportTitleLabel.setFont(Font.font("Arial", 16));

        // Create the TableView for the report
        reportTable = new TableView<>();

        // Create the table columns
        TableColumn<Report, Integer> noColumn = new TableColumn<>("No");
        noColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNo()).asObject());

        TableColumn<Report, LocalDate> dateColumn = new TableColumn<>("Date of Day");
        dateColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDate()));

        TableColumn<Report, Integer> carsPassedColumn = new TableColumn<>("Cars Passed");
        carsPassedColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCarsPassed()).asObject());

        TableColumn<Report, Double> totalRevenueColumn = new TableColumn<>("Total Revenue");
        totalRevenueColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTotalRevenue()).asObject());

        // Add the table columns to the reportTable
        reportTable.getColumns().addAll(noColumn, dateColumn, carsPassedColumn, totalRevenueColumn);

        // Add sample data to the reportTable
        addSampleData();

        // Create the total revenue label
        totalRevenueLabel = new Label("Total Revenue: $0.00");

        // Create the report generate button
        Button generateButton = new Button("Generate Report");
        generateButton.setOnAction(e -> generateReport());

        // Add all the components to the right VBox
        rightVBox.getChildren().addAll(reportTitleLabel, reportTable, totalRevenueLabel, generateButton);

        // Set the right VBox as the right content of the root pane
        rootPane2.setRight(rightVBox);

        // Create the scene
        Scene scene = new Scene(new HBox(imageView, rootPane2), 1000, 500);

        // Set the scene and show the stage
        primaryStage3.setScene(scene);
        primaryStage3.show();
    }

    private void openCustomerComplaintsScreen(Stage primaryStage2) {
        primaryStage2.setTitle("Toll Tax Management System");

        // Create the root pane
        BorderPane rootPane3 = new BorderPane();

        // Set the background image
        Image backgroundImage2 = new Image("C:\\Users\\G3\\Downloads\\Toll_Log.jpg", 400, 600, true, true);
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage2,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        rootPane3.setBackground(new Background(backgroundImg));

        // Create the VBox for the right side content
        VBox rightVBox2 = new VBox();
        rightVBox2.setPadding(new Insets(10));
        rightVBox2.setSpacing(10);

        // Create the title label for Toll Tax Management System
        Label tollTaxTitleLabel = new Label("Toll Tax Management System");
        tollTaxTitleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        // Create the title label for Customer Complaints
        Label complaintsTitleLabel = new Label("Customer Complaints");
        complaintsTitleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        // Create labels and text fields for customer complaints
        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailTextField = new TextField();

        Label phoneLabel = new Label("Phone:");
        TextField phoneTextField = new TextField();

        Label subjectLabel = new Label("Subject:");
        TextField subjectTextField = new TextField();

        Label messageLabel = new Label("Message:");
        TextField messageTextField = new TextField();
        messageTextField.setPrefHeight(150); // Increase the height of the text field

        // Create the submit button
        Button submitButton = new Button("Submit");

        // Add all the components to the right VBox
        rightVBox2.getChildren().addAll(tollTaxTitleLabel, complaintsTitleLabel, nameLabel, nameTextField,
                emailLabel, emailTextField, phoneLabel, phoneTextField, subjectLabel, subjectTextField,
                messageLabel, messageTextField, submitButton);

        // Set the right VBox as the right content of the root pane
        rootPane3.setRight(rightVBox2);

        // Create the scene
        Scene scene = new Scene(rootPane3, 800, 600);

        // Set the scene and show the stage
        primaryStage2.setScene(scene);
        primaryStage2.show();
    }

    private void addSampleData() {
        List<Report> reports = Arrays.asList(
                new Report(1, LocalDate.now(), 10, 100.00),
                new Report(2, LocalDate.now().minusDays(1), 15, 150.00),
                new Report(3, LocalDate.now().minusDays(2), 12, 120.00),
                new Report(4, LocalDate.now().minusDays(3), 8, 80.00)
        );

        ObservableList<Report> reportData = FXCollections.observableArrayList(reports);
        reportTable.setItems(reportData);
    }

    private void generateReport() {
        try {
            // Open the file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"));

            // Write the report header
            writer.write("Report\n");
            writer.write("No\tDate\tCars Passed\tTotal Revenue\n");

            // Write each report entry
            for (Report report : reportTable.getItems()) {
                writer.write(report.getNo() + "\t" + report.getDate() + "\t" +
                        report.getCarsPassed() + "\t" + report.getTotalRevenue() + "\n");
            }

            // Close the file
            writer.close();

            // Show the report generated message
            showReportGeneratedMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showReportGeneratedMessage() {
        Stage stage = new Stage();
        stage.setTitle("Report Generated");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

        Label messageLabel = new Label("Report has been generated!");
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> stage.close());

        vbox.getChildren().addAll(messageLabel, backButton);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    
    //Now Making add vehicle screens
    private void show_add_vehicle_events()
    {
    	Stage primaryStage=new Stage();
            primaryStage.setTitle("Toll Booth Maintenance");

            // Create the root pane
            BorderPane rootPane = new BorderPane();

            // Set the background image
            Image backgroundImage = new Image("C:\\Users\\G3\\Downloads\\Toll_Log.jpg");
            BackgroundImage backgroundImg = new BackgroundImage(backgroundImage,
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
            rootPane.setBackground(new Background(backgroundImg));

            // Create the VBox
            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER_RIGHT);
            vbox.setPadding(new Insets(10));
            vbox.setSpacing(10);

            // Create the title label
            Label titleLabel = new Label("Toll Tax Management System");
            titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            titleLabel.setStyle("-fx-text-fill: black");

            // Create the labels
            Label nameLabel = new Label("Enter Vehicle Number:");

            // Create the text fields
            TextField nameTextField = new TextField();
            nameTextField.setMaxWidth(200);

            // Create the buttons
            Button saveButton = new Button("Identify");
            saveButton.setOnAction(event -> {
                Stage secondaryStage = new Stage();
                secondaryStage.setTitle("Toll Tax Management System");

                // Create the root pane
                BorderPane secondaryRootPane = new BorderPane();

                // Set the background image
                Image secondaryBackgroundImage = new Image("C:\\Users\\G3\\Downloads\\Toll_Log.jpg");
                BackgroundImage secondaryBackgroundImg = new BackgroundImage(secondaryBackgroundImage,
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
                secondaryRootPane.setBackground(new Background(secondaryBackgroundImg));

                // Create the VBox
                VBox secondaryVbox = new VBox();
                secondaryVbox.setAlignment(Pos.CENTER_RIGHT);
                secondaryVbox.setPadding(new Insets(10));
                secondaryVbox.setSpacing(10);

                // Create the title label
                Label secondaryTitleLabel = new Label("Toll Tax Management System");
                secondaryTitleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                secondaryTitleLabel.setStyle("-fx-text-fill: black");

                Label secondaryTitleLabel1 = new Label("Vehicle Identification");
                secondaryTitleLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                secondaryTitleLabel1.setStyle("-fx-text-fill: black");

                // Create the labels
                Label secondaryNameLabel = new Label("Vehicle Type:");
                Label secondaryAgeLabel = new Label("Vehicle Number:");

                // Create the text fields
                TextField secondaryNameTextField = new TextField();
                secondaryNameTextField.setMaxWidth(200);
                TextField secondaryAgeTextField = new TextField();
                secondaryAgeTextField.setMaxWidth(200);

                // Create the buttons
                Button secondarySaveButton = new Button("Inserted");
                secondarySaveButton.setOnAction(secondaryEvent -> {
                    Stage tertiaryStage = new Stage();
                    tertiaryStage.setTitle("Toll Collection");

                    // Create the root pane
                    BorderPane tertiaryRootPane = new BorderPane();

                    // Set the background image
                    Image tertiaryBackgroundImage = new Image("C:\\Users\\G3\\Downloads\\Toll_Log.jpg");
                    BackgroundImage tertiaryBackgroundImg = new BackgroundImage(tertiaryBackgroundImage,
                            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
                    tertiaryRootPane.setBackground(new Background(tertiaryBackgroundImg));

                    // Create the VBox
                    VBox tertiaryVbox = new VBox();
                    tertiaryVbox.setAlignment(Pos.CENTER_RIGHT);
                    tertiaryVbox.setPadding(new Insets(10));
                    tertiaryVbox.setSpacing(10);

                    // Create the title label
                    Label tertiaryTitleLabel = new Label("Toll Tax Management System");
                    tertiaryTitleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                    tertiaryTitleLabel.setStyle("-fx-text-fill: black");

                    Label tertiaryTitleLabel1 = new Label("Toll Collection");
                    tertiaryTitleLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                    tertiaryTitleLabel1.setStyle("-fx-text-fill: black");

                    // Create the labels
                    Label tertiaryNameLabel = new Label("Enter Amount:");

                    // Create the text field
                    TextField tertiaryNameTextField = new TextField();
                    tertiaryNameTextField.setMaxWidth(200);

                    // Create the button
                    Button tertiarySaveButton = new Button("Handed");
                    tertiarySaveButton.setOnAction(tertiaryEvent -> {
                        Stage finalStage = new Stage();
                        VBox finalVBox = new VBox();
                        finalVBox.setAlignment(Pos.CENTER);
                        finalVBox.setPadding(new Insets(10));
                        finalVBox.setSpacing(10);

                        Label finalLabel = new Label("Thank you for your cooperation!");

                        Button finalBackButton = new Button("Back");
                        finalBackButton.setOnAction(finalBackEvent -> {
                            finalStage.close();
                        });

                        finalVBox.getChildren().addAll(finalLabel, finalBackButton);
                        Scene finalScene = new Scene(finalVBox, 300, 200);
                        finalStage.setScene(finalScene);
                        finalStage.show();
                    });

                    // Add the components to the tertiaryVBox
                    tertiaryVbox.getChildren().addAll(tertiaryTitleLabel, tertiaryTitleLabel1, tertiaryNameLabel, tertiaryNameTextField, tertiarySaveButton);

                    // Set the tertiaryVBox as the center content of tertiaryRootPane
                    tertiaryRootPane.setCenter(tertiaryVbox);

                    // Create the tertiaryScene
                    Scene tertiaryScene = new Scene(tertiaryRootPane, 600, 400);

                    // Set the tertiaryScene on the tertiaryStage
                    tertiaryStage.setScene(tertiaryScene);
                    tertiaryStage.show();
                });

                // Add the components to the secondaryVBox
                secondaryVbox.getChildren().addAll(secondaryTitleLabel, secondaryTitleLabel1, secondaryNameLabel, secondaryNameTextField, secondaryAgeLabel, secondaryAgeTextField, secondarySaveButton);

                // Set the secondaryVBox as the center content of secondaryRootPane
                secondaryRootPane.setCenter(secondaryVbox);

                // Create the secondaryScene
                Scene secondaryScene = new Scene(secondaryRootPane, 600, 400);

                // Set the secondaryScene on the secondaryStage
                secondaryStage.setScene(secondaryScene);
                secondaryStage.show();
            });

            // Add the components to the VBox
            vbox.getChildren().addAll(titleLabel, nameLabel, nameTextField, saveButton);

            // Set the VBox as the center content
            rootPane.setCenter(vbox);

            // Create the scene
            Scene scene = new Scene(rootPane, 600, 400);

            // Set the scene and show the stage
            primaryStage.setScene(scene);
            primaryStage.show();
        
    	
    }    
    //View Transactions Function
    private void viewTransactions()
    {
    	Stage primaryStage=new Stage();
            primaryStage.setTitle("Toll Transaction Report");

            // Create an Image and ImageView for the image
            Image image = new Image("C:\\Users\\G3\\Downloads\\resize-168522146192391757637aeecf2ba40c81b21fbcf88a5b6e27d.jpg", 600, 400, true, true);
            ImageView imageView = new ImageView(image);

            // Create TableView columns for the report
            TableColumn<Transaction, String> vehicleNameColumn = new TableColumn<>("Vehicle Name");
            vehicleNameColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleName"));

            TableColumn<Transaction, String> vehicleIdColumn = new TableColumn<>("Vehicle ID");
            vehicleIdColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));

            TableColumn<Transaction, Double> amountColumn = new TableColumn<>("Amount");
            amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

            // Create the TableView for the report
            reportTable1 = new TableView<>();
            reportTable1.getColumns().addAll(vehicleNameColumn, vehicleIdColumn, amountColumn);

            // Create a VBox for the report section
            VBox reportSection = new VBox();
            reportSection.setSpacing(10);
            reportSection.setAlignment(Pos.CENTER);
            reportSection.setPadding(new Insets(10));
            //reportSection.getChildren().addAll(new Label("Toll Transaction Report"), reportTable);
            
            Label label = new Label("Toll Transaction Report");
            TableView<Transaction> reportTable = new TableView<>();
            if (label != null && reportTable != null) {
                reportSection.getChildren().add(label);
                reportSection.getChildren().add(reportTable);
            } else {
                System.out.println("An error occurred while adding components to the report section: Child node is null.");
                // Perform alternate action or show an error message to the user
            }



            // Create an HBox to hold the image and report section
            HBox contentBox = new HBox();
            contentBox.setSpacing(20);
            contentBox.setAlignment(Pos.CENTER);
            contentBox.getChildren().addAll(imageView, reportSection);

            // Create the scene
            Scene scene = new Scene(contentBox, 900, 400);

            // Set the scene and show the stage
            primaryStage.setScene(scene);
            primaryStage.show();

            // Add sample data to the report
            addSampleData1();
    }
    
    private void addSampleData1() {
        // Add sample data to the report
        Transaction transaction1 = new Transaction("Car 1", "123", 10.50);
        Transaction transaction2 = new Transaction("Car 2", "456", 15.75);
        Transaction transaction3 = new Transaction("Car 3", "789", 20.25);

        reportTable1.getItems().addAll(transaction1, transaction2, transaction3);
    }

    public static void main(String[] args) {
        launch(args);
    }
    public static class Report {
        private int no;
        private LocalDate date;
        private int carsPassed;
        private double totalRevenue;

        public Report(int no, LocalDate date, int carsPassed, double totalRevenue) {
            this.no = no;
            this.date = date;
            this.carsPassed = carsPassed;
            this.totalRevenue = totalRevenue;
        }

        public int getNo() {
            return no;
        }

        public LocalDate getDate() {
            return date;
        }

        public int getCarsPassed() {
            return carsPassed;
        }

        public double getTotalRevenue() {
            return totalRevenue;
        }
    }
    
    //There is a Transaction Class
    public static class Transaction {
        private String vehicleName;
        private String vehicleId;
        private double amount;

        public Transaction(String vehicleName, String vehicleId, double amount) {
            this.vehicleName = vehicleName;
            this.vehicleId = vehicleId;
            this.amount = amount;
        }

        public String getVehicleName() {
            return vehicleName;
        }

        public String getVehicleId() {
            return vehicleId;
        }

        public double getAmount() {
            return amount;
        }
    }
}
