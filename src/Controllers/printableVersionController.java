package Controllers;

import DBManager.DBManager;
import Initialization.Main;
import User.User;
import Form.Form;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * Status: incomplete.
 */
public class printableVersionController extends UIController {

    private DBManager dbManager = new DBManager();
    private Form form = new Form();

    @FXML
    private Text ttb_id, rep_id, permitNo, serialNo, brandName, fancifulName, formula, phoneNo,
            grapeVarietals, wineAppellation, email, labelText, submitDate, signature, applicantName,
            mailingAddress, differentMailingAddress, expirationDate, certExemptionText, distinctiveText, resubmissionText;
    @FXML
    private CheckBox domesticCheckbox, importedCheckbox, wineCheckbox, maltCheckbox, distilledCheckbox,
            certLabelApprovalCheckbox, certExemptionCheckbox, distinctiveCheckbox, resubmissionCheckbox;
    @FXML
    private ImageView imageView;
    @FXML
    private Button saveAsButton;

    public void start(Main main, Form form) {
        this.main = main;
        this.form = form;
        System.out.println(System.getProperty("user.dir"));
        setFormPrintableVersion();
    }

    public void setFormPrintableVersion() {
        ttb_id.setText(form.getttb_id());
        if(form.getrep_id() != null) {rep_id.setText(form.getrep_id());}
        else {rep_id.setText("");}
        permitNo.setText(form.getpermit_no());
        serialNo.setText(form.getserial_no());
        brandName.setText(form.getbrand_name());
        if(form.getfanciful_name() != null) {fancifulName.setText(form.getfanciful_name());}
        else {fancifulName.setText("");}
        if(form.getformula() != null) {formula.setText(form.getformula());}
        else {formula.setText("");}
        if(form.getphone_no() != null) {phoneNo.setText(form.getphone_no());}
        else {phoneNo.setText("");}

        if(form.getalcohol_type().equals("Wine")) {
            wineCheckbox.setSelected(true);
            if(form.getgrape_varietals() != null) {grapeVarietals.setText(form.getgrape_varietals());}
            else {grapeVarietals.setText("");}
            if(form.getwine_appellation() != null) {wineAppellation.setText(form.getwine_appellation());}
            else {wineAppellation.setText("");}
        } else if(form.getalcohol_type().equals("Distilled Spirits")) {
            distilledCheckbox.setSelected(true);
        } else {
            maltCheckbox.setSelected(true);
        }

        if(form.getSource().equals("Imported")) {
            importedCheckbox.setSelected(true);
        } else {
            domesticCheckbox.setSelected(true);
        }

        if(form.getapplication_type().get(0)) {
            certLabelApprovalCheckbox.setSelected(true);
        }
        if(form.getapplication_type().get(1)) {
            certExemptionCheckbox.setSelected(true);
            certExemptionText.setText(form.getapplication_type_text().get(0));
        }
        if(form.getapplication_type().get(2)) {
            distinctiveCheckbox.setSelected(true);
            distinctiveText.setText(form.getapplication_type_text().get(1));
        }
        if(form.getapplication_type().get(3)) {
            resubmissionCheckbox.setSelected(true);
            resubmissionText.setText(form.getapplication_type_text().get(2));
        }

        email.setText(form.getEmail());
        if(form.getlabel_text() != null) {labelText.setText(form.getlabel_text());}
        else {labelText.setText("");}

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        form.setsubmit_date(Date.valueOf(LocalDate.now()));
        submitDate.setText(form.getsubmit_date().toLocalDate().format(formatter));

        signature.setText(form.getSignature());

        form.setapplicant_id(main.getUser().getUid());
        User applicant = dbManager.findUser("user_id='" + form.getapplicant_id() + "'");
        String applicant_name = applicant.getFirstName() + " " + applicant.getMiddleInitial() + " " + applicant.getLastName();
        applicantName.setText(applicant_name);

        String combinedAddress = form.getapplicant_street(); //TODO: finish this
        mailingAddress.setText(""); //TODO: combine/make different lines for agent state, etc.

        differentMailingAddress.setText(form.getmailing_address());
        if(form.getexpiration_date() != null) {expirationDate.setText(form.getexpiration_date().toLocalDate().format(formatter));} //TODO: same as above
        else {expirationDate.setText("");}
    }

    /**
     * Saves form as a png
     */
    @FXML
    public void saveAsAction(){
        WritableImage image = imageView.snapshot(new SnapshotParameters(), null);
        // TODO: check working
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        File selectedFile = directoryChooser.showDialog(null);
        File file = new File(selectedFile.getPath() + "/printableForm_" + form.getttb_id() + ".png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
