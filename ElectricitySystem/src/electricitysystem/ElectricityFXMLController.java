/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitysystem;

import electricitysystem.Adminstrated.Admistrated;
import electricitysystem.customer.Customer;
import electricitysystem.customer.CustomerImpl;
import electricitysystem.empolyee.Empolyee;
import electricitysystem.empolyee.EmpolyeeImpl;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

/**
 *
 * @author unique
 */
public class ElectricityFXMLController implements Initializable {

    @FXML
    private AnchorPane loginpane;

    @FXML
    private ComboBox logincombo;

    @FXML
    private TextField loginuser;

    @FXML
    private PasswordField loginpass;

    @FXML
    private AnchorPane signuppane;

    @FXML
    private ComboBox signcombo;

    @FXML
    private TextField signemail;

    @FXML
    private TextField signnumber;

    @FXML
    private TextField signuser;

    @FXML
    private RadioButton signmale;

    @FXML
    private RadioButton signfemale;

    @FXML
    private TextArea signaddress;

    @FXML
    private TextField signpass;

    @FXML
    void logincomboaction(MouseEvent event) {
        logincombo.getItems().addAll("Empolyer", "Adminstration");
    }

    @FXML
    void signcomboaction(MouseEvent event) {
        signcombo.getItems().addAll("Empolyer", "Adminstration");
    }

    public Empolyee emp1;

    @FXML
    void login2btn(ActionEvent event) throws IOException {
        Window owner = loginpass.getScene().getWindow();

        if (logincombo.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Login As:");
            return;
        } else if (logincombo.getValue().equals("Empolyer")) {
            EmpolyeeImpl e = new EmpolyeeImpl();
            Empolyee emp = e.getEmp(loginuser.getText(), loginpass.getText());
            emp1 = emp;
            if (emp.getEmail() != null && emp.getPassword() != null) {
                clear();
                loginpass.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("ElectricityEmpFXML.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setTitle("Empolyee Page");
                mainStage.setScene(scene);
                mainStage.show();
            } else {
                showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                        "Please enter email and password or creact email and password");
                return;
            }
        } else if (logincombo.getValue().equals("Adminstration")) {
            clear();
            EmpolyeeImpl e = new EmpolyeeImpl();
            Admistrated a = e.getAdmin(loginuser.getText(), loginpass.getText());
            if (a.getEmail() != null && a.getPassword() != null) {
                loginpass.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("ElectricityEmpFXML.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setTitle("Adminstrate Page");
                mainStage.setScene(scene);
                mainStage.show();
            } else {
                showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                        "Please enter email and password or creact email and password");
                return;
            }
        }
    }

    static String s;

    @FXML
    void handleMaleBox() {
        signmale.setSelected(true);
        if (signmale.isSelected()) {
            signfemale.setSelected(false);
        }
        s = "Male";
    }

    @FXML
    void handleFemaleBox() {
        signfemale.setSelected(true);
        if (signfemale.isSelected()) {
            signmale.setSelected(false);
        }
        s = "Female";
    }

    @FXML
    void signinbtn(ActionEvent event) {
        loginpane.setVisible(false);
        signuppane.setVisible(true);

    }

    @FXML
    void signoutbtn(ActionEvent event) {
        signuppane.setVisible(false);
        loginpane.setVisible(true);
    }

    void clear() {
        signuser.clear();
        signpass.clear();
        signaddress.clear();
        signnumber.clear();
        signemail.clear();
        signmale.setSelected(false);
        signfemale.setSelected(false);
        loginuser.clear();
        loginpass.clear();
    }

    @FXML
    void signup2btn(ActionEvent event) {
        Window owner = loginpass.getScene().getWindow();

        if (signcombo.getValue() == null) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Login As:");
            return;
        } else if (signcombo.getValue().equals("Empolyer")) {
            if (signuser.getText() == null && signpass.getText() == null && signaddress.getText() == null && s == null && signemail.getText() == null && signnumber.getText() == null) {
                showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                        "Please enter entire field");
                return;
            }
            EmpolyeeImpl e = new EmpolyeeImpl();
            Empolyee emp = new Empolyee(signuser.getText(), signnumber.getText(), signaddress.getText(), signemail.getText(), s, signpass.getText());
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Form CONFIRMATION!",
                    "Are you want insert Empolyee?");
            int i = e.insert(emp);
            clear();
            signuppane.setVisible(false);
            loginpane.setVisible(true);
            return;

        } else if (signcombo.getValue().equals("Adminstration")) {
            if (signuser.getText() == null && signpass.getText() == null && signaddress.getText() == null && s == null && signemail.getText() == null && signnumber.getText() == null) {
                showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                        "Please enter entire field");
                return;
            }
            EmpolyeeImpl e = new EmpolyeeImpl();
            Admistrated admin = new Admistrated(signuser.getText(), signpass.getText(), signaddress.getText(), s, signemail.getText(), signpass.getText());
            showAlert(Alert.AlertType.CONFIRMATION, owner, "Form CONFIRMATION!",
                    "Are you want insert Adminstration?");
            int i = e.insertAdmin(admin);
            clear();
            signuppane.setVisible(false);
            loginpane.setVisible(true);
            return;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();//To change body of generated methods, choose Tools | Templates.
    }

//    -----------------------------------------------------------------------------------------------------
//    -----------------------------------------------------------------------------------------------------
//                                   EmpolyeeController
//    -----------------------------------------------------------------------------------------------------
//    -----------------------------------------------------------------------------------------------------
    @FXML
    private AnchorPane customerpane;

    @FXML
    private TableView<Customer> customerlist;

    @FXML
    private TableColumn<Customer, String> cname;

    @FXML
    private TableColumn<Customer, String> cnumber;

    @FXML
    private TableColumn<Customer, String> caddress;

    @FXML
    private TableColumn<Customer, String> cmeterno;

    @FXML
    private TableColumn caction;

    @FXML
    private TextField cfiterlist;

    @FXML
    private AnchorPane caddpane;

    @FXML
    private TextField caddname;

    @FXML
    private TextField caddnumber;

    @FXML
    private TextField caddmeter;

    @FXML
    private TextField caddemail;

    @FXML
    private TextArea caddaddress;

    @FXML
    private Button caddback;

    @FXML
    private Button caddsubmit;

    @FXML
    private AnchorPane ceditpane;

    @FXML
    private TextField ceditname;

    @FXML
    private TextField ceditnumber;

    @FXML
    private TextField ceditmeter;

    @FXML
    private TextField ceditemail;

    @FXML
    private TextArea ceditaddress;

    @FXML
    private Button ceditback;

    @FXML
    private Button ceditsubmit;

    @FXML
    private Text filtercustdata;

    @FXML
    private Button cadd;

    @FXML
    private Button cback;

    @FXML
    private AnchorPane transctionpane;

    @FXML
    private TableView<?> transctionlist;

    @FXML
    private TableColumn<?, ?> tname;

    @FXML
    private TableColumn<?, ?> tnumber;

    @FXML
    private TableColumn<?, ?> tamount;

    @FXML
    private TableColumn<?, ?> tpaidmode;

    @FXML
    private TextField tfilter;

    @FXML
    private Button tback;

    @FXML
    private AnchorPane recordpane;

    @FXML
    private Button rback;

    @FXML
    private TableView<?> recordlist;

    @FXML
    private TableColumn<?, ?> rname;

    @FXML
    private TableColumn<?, ?> rnumber;

    @FXML
    private TableColumn<?, ?> rtotalunit;

    @FXML
    private TableColumn<?, ?> rlastunit;

    @FXML
    private TableColumn<?, ?> rpendingamount;

    @FXML
    private TableColumn<?, ?> rreminder;

    @FXML
    private TextField rfilter;

    @FXML
    private AnchorPane compane;

    @FXML
    private Button comback;

    @FXML
    private TableView<?> comList;

    @FXML
    private TableColumn<?, ?> comname;

    @FXML
    private TableColumn<?, ?> comnumber;

    @FXML
    private TableColumn<?, ?> comcomplainid;

    @FXML
    private TableColumn<?, ?> comstatus;

    @FXML
    private TableColumn<?, ?> comaction;

    @FXML
    private TextField comfilter;

    @FXML
    private ComboBox<?> comcombo;

    @FXML
    private Button comadd;

    @FXML
    private AnchorPane servicepane;

    @FXML
    private Button sback;

    @FXML
    private TextField snumber;

    @FXML
    private Button sgobtn;

    @FXML
    private Text sname;

    @FXML
    private Text smeterno;

    @FXML
    private Text saddress;

    @FXML
    private TextField sunit;

    @FXML
    private Text smouth;

    @FXML
    private Button ssubmit;

    @FXML
    private Text scouunit;

    @FXML
    private Text samount;

    @FXML
    private Button sprint;

    @FXML
    private ComboBox smouthcombo;

    @FXML
    private AnchorPane profilepane;

    @FXML
    private Button emailchangebtn;

    @FXML
    private Text pname;

    @FXML
    private Text pempolyerid;

    @FXML
    private Text pemail;

    @FXML
    private Text pnumber;

    @FXML
    void aboutbtn(ActionEvent event) {

    }
    

    @FXML
    void complainbtn(ActionEvent event) {
        comback.setOnAction(e->{
            compane.setVisible(false);
        });
        customerpane.setVisible(false);
        transctionpane.setVisible(false);
        recordpane.setVisible(false);
        compane.setVisible(true);
        servicepane.setVisible(false);
    }
    
    static String value;
    
    public void customerTable() {
        ObservableList<Customer> listM,listM2;
        cname.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        cnumber.setCellValueFactory(new PropertyValueFactory<Customer, String>("number"));
        cmeterno.setCellValueFactory(new PropertyValueFactory<Customer, String>("meterno"));
        caddress.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
        CustomerImpl c=new CustomerImpl();
        listM=c.getAllCustomer();
        customerlist.setItems(listM);
        Callback<TableColumn<Customer, String>, TableCell<Customer, String>> cellco = (params) -> {

            final TableCell<Customer, String> cell = new TableCell<Customer, String>() {
                //override updatesItem method
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //ensure that cell is creates only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        ComboBox com=new ComboBox();
                        com.setPromptText("Action Act");
                        com.getItems().addAll("Delete","Edit");
                        com.setOnAction(event -> {
                            value = (String) com.getValue();
                            if (value.equals("Edit")) {
                                Customer c=getTableView().getItems().get(getIndex());
                                CustomerImpl cimpl=new CustomerImpl();
                                ceditname.setText(c.getName());
                                ceditnumber.setText(c.getNumber());
                                ceditaddress.setText(c.getAddress());
                                ceditemail.setText(c.getEmail());
                                ceditmeter.setText(c.getMeterno());  
                                Customer c1=new Customer(c.getCustomerId(),ceditname.getText(),ceditnumber.getText(),ceditaddress.getText(),ceditmeter.getText(),ceditemail.getText());
                                cimpl.update(c1);
                                customerTable();
                                ceditpane.setVisible(true);
                            }else if (value.equals("Delete")) {
                                Customer c=getTableView().getItems().get(getIndex());
                                CustomerImpl cimpl=new CustomerImpl();
                                cimpl.delete(Integer.parseInt(c.getCustomerId()));
                                customerTable();
                            }
                        });
                        setGraphic(com);
                    }
                }
            };
            return cell;
        };
        caction.setCellFactory(cellco);
    }

    @FXML
    void customerlistbtn(ActionEvent event) {
        customerTable();
        caddsubmit.setOnAction(e->{
            CustomerImpl c=new CustomerImpl();
            Customer customer=new Customer(caddname.getText(),caddnumber.getText(),caddaddress.getText(),caddmeter.getText(),caddemail.getText());
            c.insert(customer);
            customerTable();
            caddpane.setVisible(false);
        });
        cback.setOnAction(e->{
            customerpane.setVisible(false);
        });
        cadd.setOnAction(e->{
            caddpane.setVisible(true);
        });
        ceditback.setOnAction(e->{
            ceditpane.setVisible(false);
        });
        caddback.setOnAction(e->{
            caddpane.setVisible(false);
        });
        customerpane.setVisible(true);
        transctionpane.setVisible(false);
        recordpane.setVisible(false);
        compane.setVisible(false);
        servicepane.setVisible(false);
    }

    @FXML
    void recordbtn(ActionEvent event) {
        rback.setOnAction(e->{
            recordpane.setVisible(false);
        });
        customerpane.setVisible(false);
        transctionpane.setVisible(false);
        recordpane.setVisible(true);
        compane.setVisible(false);
        servicepane.setVisible(false);
    }

    @FXML
    void servicebtn(ActionEvent event) {
        String[] months = new DateFormatSymbols().getMonths();
        smouthcombo.getItems().addAll(months);
        sgobtn.setOnAction(e->{
            Customer c=new CustomerImpl().getCustomer(snumber.getText());
            sname.setText(c.getName());
            smeterno.setText(c.getMeterno());
            saddress.setText(c.getAddress());
        });
        ssubmit.setOnAction(e->{
            
        });
        sback.setOnAction(e->{
            servicepane.setVisible(false);
        });
        customerpane.setVisible(false);
        transctionpane.setVisible(false);
        recordpane.setVisible(false);
        compane.setVisible(false);
        servicepane.setVisible(true);
    }

    @FXML
    void transctionhistorybtn(ActionEvent event) {
        tback.setOnAction(e->{
            transctionpane.setVisible(false);
        });
        customerpane.setVisible(false);
        transctionpane.setVisible(true);
        recordpane.setVisible(false);
        compane.setVisible(false);
        servicepane.setVisible(false);
    }

}
