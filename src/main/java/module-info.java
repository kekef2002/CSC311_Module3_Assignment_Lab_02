module edu.farmingdale.csc311_module3_assignment_lab_02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.csc311_module3_assignment_lab_02 to javafx.fxml;
    exports edu.farmingdale.csc311_module3_assignment_lab_02;
}