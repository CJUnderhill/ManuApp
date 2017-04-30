package Controllers;

import Form.Form;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

/**
 * Created by erickmoo on 4/29/17.
 */
public class applicationController {

    private Form form = new Form();

    @FXML
    private ComboBox source_combobox, alcohol_type_combobox;
    @FXML
    private TextField repID, permitNO, serialNO, brandName, fancifulName,
            alcoholContent, formula, phoneNo, email, applicantStreet, applicantCity,
            applicantState, applicantZip, applicantCountry, otherStreet, otherCity,
            otherState, otherZip, otherCountry, option_2_text, option_3_text, option_4_text,
            signature, grapeVarietals, wineAppellation, vintageYear, phLevel;
    @FXML
    private Button nextButton, backButton, browseButton;
    @FXML
    private CheckBox sameAsApplicantBox, option_1_checkbox, option_2_checkbox,
            option_3_checkbox, option_4_checkbox;
    @FXML
    private ImageView label_image;
    @FXML
    private TextArea extraLabelInfo;
    public Label otherCityLabel;
    public Label otherStateLabel;
    public Label otherZipcodeLabel;
    public Label otherCountryLabel;
    public Label otherStreetLabel;

    public void createPage1() {
        source_combobox.setItems(FXCollections.observableArrayList("Imported", "Domestic"));
        alcohol_type_combobox.setItems(FXCollections.observableArrayList("Malt Beverages", "Wine", "Distilled Spirits"));
        form.setSource((String)source_combobox.getValue());
        form.setalcohol_type((String)alcohol_type_combobox.getValue());
        form.setrep_id(repID.getText());
        form.setpermit_no(permitNO.getText());
        form.setserial_no(serialNO.getText());
        form.setbrand_name(brandName.getText());
        form.setfanciful_name(fancifulName.getText());
        form.setalcohol_content(Double.parseDouble(alcoholContent.getText()));
        form.setFormula(formula.getText());
    }

    //TODO move address labels and textboxes to the center through code
    //TODO add "same as applicant box" functionality, if checked move address stuff to the right and set mailing stuff to visible
    public void createPage2() {
        form.setphone_no(phoneNo.getText());
        form.setEmail(email.getText());
        form.setapplicant_street(applicantStreet.getText());
        form.setapplicant_city(applicantCity.getText());
        form.setapplicant_state(applicantState.getText());
        form.setapplicant_zip(applicantZip.getText());
        form.setapplicant_country(applicantCountry.getText());

        if (sameAsApplicantBox.isSelected()) {
            form.setmailing_address("");
        } else {
            form.setmailing_address(otherStreet.getText() + "\n" + otherCity.getText() + " " + otherState.getText()
                    + "," + otherZip.getText() + "\n" + otherCountry.getText());
        }
    }

    public void createPage3() {
        ArrayList<Boolean> application_type = new ArrayList<Boolean>();
        for (int i = 0; i < 5; i++) {
            application_type.add(false);
        }
        ArrayList<String> application_type_text = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            application_type_text.add("hello");
        }
        if (option_1_checkbox.isSelected()) {//choice 0
            application_type.set(0, true);
        } else if (option_2_checkbox.isSelected()) {
            application_type_text.set(1, option_2_text.getText());
            application_type.set(1, true);
        } else if (option_3_checkbox.isSelected()) {
            application_type_text.set(2, option_3_text.getText());
            application_type.set(2, true);
        } else if (option_4_checkbox.isSelected()) {
            application_type_text.set(3, option_4_text.getText());
            application_type.set(3, true);
        }

        form.setapplication_type(application_type);
        form.setapplication_type_text(application_type_text);
    }

    public void createPage4() {
        form.setlabel_text(extraLabelInfo.getText());
        form.setSignature(signature.getText());
    }

    // Only display this if "Wine" was selected as the type of alcohol
    public void createWinePage() {
        form.setgrape_varietals(grapeVarietals.getText());
        form.setwine_appellation(wineAppellation.getText());
        form.setvintage_year(vintageYear.getText());
        form.setpH_level(Integer.parseInt(phLevel.getText()));
    }

    @FXML
    public void browseForFile() {
        FileChooser fc = new FileChooser();
        String currentDir = System.getProperty("user.dir");
//        System.out.println(currentDir);

        fc.setInitialDirectory(new File(currentDir));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files (.jpg .png)", "*.jpg", "*.png"));
        File selectedFile = fc.showOpenDialog(null);


        if (selectedFile != null) {
            try {
                BufferedImage bufferedImage = ImageIO.read(selectedFile);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                label_image.setImage(image);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid File");
        }

        Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");

        String newFileName = selectedFile.getName().split("\\.")[0] + dateFormat.format(date) + "." + selectedFile.getName().split("\\.")[1];
        File destInSys = new File(System.getProperty("user.dir") + "/src/main/resources/Controllers/images/" + newFileName);
        try {
            Files.copy(selectedFile.toPath(), destInSys.toPath(), StandardCopyOption.REPLACE_EXISTING, NOFOLLOW_LINKS);

        } catch (Exception e) {
            e.printStackTrace();
        }

        form.setlabel_image(newFileName);
        try {
            System.out.println("here");
            String path = (System.getProperty("user.dir") + "/src/main/resources/Controllers/images/" + newFileName);
            File file = new File(path);
            String localURL = file.toURI().toURL().toString();
            Image image = new Image(localURL);
            System.out.println("Now here");
            System.out.println("down");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void showSecondAddress() {
        System.out.println("Showing second address");
        if (sameAsApplicantBox.isSelected()) {
            otherCityLabel.setVisible(true);
            otherStateLabel.setVisible(true);
            otherStreetLabel.setVisible(true);
            otherZipcodeLabel.setVisible(true);
            otherCityLabel.setVisible(true);
            otherCountry.setVisible(true);
            otherCountryLabel.setVisible(true);
            otherZip.setVisible(true);
            otherState.setVisible(true);
            otherStreet.setVisible(true);
            otherCity.setVisible(true);
        } else {
            otherCityLabel.setVisible(false);
            otherStateLabel.setVisible(false);
            otherStreetLabel.setVisible(false);
            otherZipcodeLabel.setVisible(false);
            otherCityLabel.setVisible(false);
            otherCountry.setVisible(false);
            otherCountryLabel.setVisible(true);
            otherZip.setVisible(false);
            otherState.setVisible(false);
            otherStreet.setVisible(false);
            otherCity.setVisible(false);
        }
    }

    @FXML
    public void checkType() {}

}
