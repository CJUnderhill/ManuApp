package Form;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by DanielKim on 5/1/2017.
 */
public class CSVRecord {
    private final SimpleStringProperty formID = new SimpleStringProperty("");
    private final SimpleStringProperty repID = new SimpleStringProperty("");
    private final SimpleStringProperty permitNo = new SimpleStringProperty("");
    private final SimpleStringProperty source = new SimpleStringProperty("");
    private final SimpleStringProperty serialNo = new SimpleStringProperty("");
    private final SimpleStringProperty alcoholType = new SimpleStringProperty("");
    private final SimpleStringProperty brandName = new SimpleStringProperty("");
    private final SimpleStringProperty fancifulName = new SimpleStringProperty("");
    private final SimpleStringProperty alcoholContent = new SimpleStringProperty("");
    private final SimpleStringProperty street = new SimpleStringProperty("");
    private final SimpleStringProperty city = new SimpleStringProperty("");
    private final SimpleStringProperty state = new SimpleStringProperty("");
    private final SimpleStringProperty zip = new SimpleStringProperty("");
    private final SimpleStringProperty country = new SimpleStringProperty("");
    private final SimpleStringProperty mailing = new SimpleStringProperty("");
    private final SimpleStringProperty formula = new SimpleStringProperty("");
    private final SimpleStringProperty phoneNo = new SimpleStringProperty("");
    private final SimpleStringProperty email = new SimpleStringProperty("");
    private final SimpleStringProperty labelText = new SimpleStringProperty("");
    private final SimpleStringProperty signature = new SimpleStringProperty("");
    private final SimpleStringProperty vintageYear = new SimpleStringProperty("");
    private final SimpleStringProperty phLevel = new SimpleStringProperty("");
    private final SimpleStringProperty grapeVarietals = new SimpleStringProperty("");
    private final SimpleStringProperty wineAppellation = new SimpleStringProperty("");
    private final SimpleStringProperty typeOption = new SimpleStringProperty("");
    private final SimpleStringProperty typeText = new SimpleStringProperty("");

    public CSVRecord() {
        this( "", "", "", "", "", "", "", "", "", "","","","","","","","","","","","","","","","");
    }

    public CSVRecord(String repID, String permitNo, String source, String serialNo,
                     String alcoholType, String brandName, String fancifulName, String alcoholContent,
                     String street, String city, String state, String zip, String country, String mailing,
                     String formula, String phoneNo, String email, String labelText,
                     String signature, String vintageYear, String phLevel, String grapeVarietals,
                     String wineAppellation, String typeOption, String typeText) {
        setRepID(repID);
        setPermitNo(permitNo);
        setSource(source);
        setSerialNo(serialNo);
        setAlcoholType(alcoholType);
        setBrandName(brandName);
        setFancifulName(fancifulName);
        setAlcoholContent(alcoholContent);
        setStreet(street);
        setCity(city);
        setState(state);
        setZip(zip);
        setCountry(country);
        setMailing(mailing);
        setFormula(formula);
        setPhoneNo(phoneNo);
        setEmail(email);
        setLabelText(labelText);
        setSignature(signature);
        setVintageYear(vintageYear);
        setPhLevel(phLevel);
        setGrapeVarietals(grapeVarietals);
        setWineAppellation(wineAppellation);
        setTypeOption(typeOption);
        setTypeText(typeText);
    }


    public String getFormID() {
        return formID.get();
    }

    public SimpleStringProperty formIDProperty() {
        return formID;
    }

    public void setFormID(String formID) {
        this.formID.set(formID);
    }

    public String getRepID() {
        return repID.get();
    }

    public SimpleStringProperty repIDProperty() {
        return repID;
    }

    public void setRepID(String repID) {
        this.repID.set(repID);
    }

    public String getPermitNo() {
        return permitNo.get();
    }

    public SimpleStringProperty permitNoProperty() {
        return permitNo;
    }

    public void setPermitNo(String permitNo) {
        this.permitNo.set(permitNo);
    }

    public String getSource() {
        return source.get();
    }

    public SimpleStringProperty sourceProperty() {
        return source;
    }

    public void setSource(String source) {
        this.source.set(source);
    }

    public String getSerialNo() {
        return serialNo.get();
    }

    public SimpleStringProperty serialNoProperty() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo.set(serialNo);
    }

    public String getAlcoholType() {
        return alcoholType.get();
    }

    public SimpleStringProperty alcoholTypeProperty() {
        return alcoholType;
    }

    public void setAlcoholType(String alcoholType) {
        this.alcoholType.set(alcoholType);
    }

    public String getBrandName() {
        return brandName.get();
    }

    public SimpleStringProperty brandNameProperty() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName.set(brandName);
    }

    public String getFancifulName() {
        return fancifulName.get();
    }

    public SimpleStringProperty fancifulNameProperty() {
        return fancifulName;
    }

    public void setFancifulName(String fancifulName) {
        this.fancifulName.set(fancifulName);
    }

    public String getAlcoholContent() {
        return alcoholContent.get();
    }

    public SimpleStringProperty alcoholContentProperty() {
        return alcoholContent;
    }

    public void setAlcoholContent(String alcoholContent) {
        this.alcoholContent.set(alcoholContent);
    }

    public String getStreet() {
        return street.get();
    }

    public SimpleStringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getZip() {
        return zip.get();
    }

    public SimpleStringProperty zipProperty() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip.set(zip);
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getMailing() {
        return mailing.get();
    }

    public SimpleStringProperty mailingProperty() {
        return mailing;
    }

    public void setMailing(String mailing) {
        this.mailing.set(mailing);
    }

    public String getFormula() {
        return formula.get();
    }

    public SimpleStringProperty formulaProperty() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula.set(formula);
    }

    public String getPhoneNo() {
        return phoneNo.get();
    }

    public SimpleStringProperty phoneNoProperty() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo.set(phoneNo);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getLabelText() {
        return labelText.get();
    }

    public SimpleStringProperty labelTextProperty() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText.set(labelText);
    }

    public String getSignature() {
        return signature.get();
    }

    public SimpleStringProperty signatureProperty() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature.set(signature);
    }

    public String getVintageYear() {
        return vintageYear.get();
    }

    public SimpleStringProperty vintageYearProperty() {
        return vintageYear;
    }

    public void setVintageYear(String vintageYear) {
        this.vintageYear.set(vintageYear);
    }

    public String getPhLevel() {
        return phLevel.get();
    }

    public SimpleStringProperty phLevelProperty() {
        return phLevel;
    }

    public void setPhLevel(String phLevel) {
        this.phLevel.set(phLevel);
    }

    public String getGrapeVarietals() {
        return grapeVarietals.get();
    }

    public SimpleStringProperty grapeVarietalsProperty() {
        return grapeVarietals;
    }

    public void setGrapeVarietals(String grapeVarietals) {
        this.grapeVarietals.set(grapeVarietals);
    }

    public String getWineAppellation() {
        return wineAppellation.get();
    }

    public SimpleStringProperty wineAppellationProperty() {
        return wineAppellation;
    }

    public void setWineAppellation(String wineAppellation) {
        this.wineAppellation.set(wineAppellation);
    }

    public String getTypeOption() {
        return typeOption.get();
    }

    public SimpleStringProperty typeOptionProperty() {
        return typeOption;
    }

    public void setTypeOption(String typeOption) {
        this.typeOption.set(typeOption);
    }

    public String getTypeText() {
        return typeText.get();
    }

    public SimpleStringProperty typeTextProperty() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText.set(typeText);
    }
}
