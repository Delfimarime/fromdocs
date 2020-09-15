package com.raitonbl.fromdocs.docs;

import com.raitonbl.fromdocs.Document;

import java.time.LocalDate;

/**
 * @author Delfim Marime
 */
public class ID implements Document {

    /**
     * Unique document identification number.
     */
    private String number;

    /**
     * All names before the Surname. <br>
     * For example, if the full name is: <b>Elton Tomas</b> Laice <br>
     * String givenNames = "Elton Tomas"
     */
    private String name;

    /**
     * Date of birth
     * LocalDate
     */
    private LocalDate birthDate;

    /**
     * Place of Birth
     */
    private String placeOfBirth;

    /**
     * Sex, 'F' or 'M'
     */
    private Character sex;

    /**
     * Date of Issue <br>
     * LocalDate
     */
    private LocalDate issuanceDate;

    /**
     * Date of Expiry <br>
     * LocalDate
     */
    private LocalDate expiryDate;

    /**
     * Place of Issue
     */
    private String issuedIn;

    private String mothersName;

    private String fathersName;

    private String maritalStatus;

    private String address;

    private String height;

    private ID() {
    }

    public String getId() {
        return getNumber();
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public Character getSex() {
        return sex;
    }

    public LocalDate getIssuanceDate() {
        return issuanceDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getIssuedIn() {
        return issuedIn;
    }

    public String getMothersName() {
        return mothersName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public String getHeight() {
        return height;
    }

    public static class Builder {

        private String name;
        private String number;
        private String height;
        private Character sex;
        private String address;
        private String issuedIn;
        private String placeOfBirth;
        private String mothersName;
        private String fathersName;
        private LocalDate birthDate;
        private LocalDate expiryDate;
        private String maritalStatus;
        private LocalDate issuanceDate;

        private Builder() {
        }

        public static Builder get() {
            return new Builder();
        }

        public ID build() {

            ID instance = new ID();

            instance.sex = sex;
            instance.name = name;
            instance.number = number;
            instance.height = height;
            instance.address = address;
            instance.issuedIn = issuedIn;
            instance.birthDate = birthDate;
            instance.expiryDate = expiryDate;
            instance.fathersName = fathersName;
            instance.mothersName = mothersName;
            instance.placeOfBirth = placeOfBirth;
            instance.issuanceDate = issuanceDate;
            instance.maritalStatus = maritalStatus;

            return instance;
        }

        public Builder setNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder setPlaceOfBirth(String placeOfBirth) {
            this.placeOfBirth = placeOfBirth;
            return this;
        }

        public Builder setSex(Character sex) {
            this.sex = sex;
            return this;
        }

        public Builder setIssuanceDate(LocalDate issuanceDate) {
            this.issuanceDate = issuanceDate;
            return this;
        }

        public Builder setExpiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder setIssuedIn(String issuedIn) {
            this.issuedIn = issuedIn;
            return this;
        }

        public Builder setMothersName(String mothersName) {
            this.mothersName = mothersName;
            return this;
        }

        public Builder setFathersName(String fathersName) {
            this.fathersName = fathersName;
            return this;
        }

        public Builder setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setHeight(String height) {
            this.height = height;
            return this;
        }

    }


}
