package com.raitonbl.fromdocs.docs;

import com.raitonbl.fromdocs.Document;

import java.time.LocalDate;

/**
 * @author Delfim Marime
 */
public class Passport implements Document {

    /**
     * Unique document identification number.
     */
    private String number;

    /**
     * All names before the Surname. <br>
     * For example, if the given Names is: <b>Elton Tomas</b> Laice <br>
     * String givenNames = "Elton Tomas"
     */
    private String givenNames;

    private String surname;

    /**
     * Date of birth
     * LocalDate
     */
    private LocalDate dateOfBirth;

    private String type;

    private String countryCode;

    private String nationality;

    private String idNumber;

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
    private LocalDate dateOfIssue;

    /**
     * Date of Expiry <br>
     * LocalDate
     */
    private LocalDate dateOfExpiry;


    private String issuingAuthority;

    private Passport() {
    }

    public String getId() {
        return getNumber();
    }

    public String getNumber() {
        return number;
    }

    public String getGivenNames() {
        return givenNames;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getType() {
        return type;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getNationality() {
        return nationality;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public Character getSex() {
        return sex;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public static class Builder {

        private String type;
        private String number;
        private Character sex;
        private String surname;
        private String idNumber;
        private String givenNames;
        private String countryCode;
        private String nationality;
        private String placeOfBirth;
        private LocalDate dateOfBirth;
        private LocalDate dateOfIssue;
        private LocalDate dateOfExpiry;
        private String issuingAuthority;

        private Builder() {
        }

        public static Builder get() {
            return new Builder();
        }

        public Passport build() {

            Passport instance = new Passport();

            instance.sex = sex;
            instance.type = type;
            instance.number = number;
            instance.surname = surname;
            instance.idNumber = idNumber;
            instance.givenNames = givenNames;
            instance.nationality = nationality;
            instance.countryCode = countryCode;
            instance.dateOfBirth = dateOfBirth;
            instance.dateOfIssue = dateOfIssue;
            instance.dateOfExpiry = dateOfExpiry;
            instance.placeOfBirth = placeOfBirth;
            instance.issuingAuthority = issuingAuthority;

            return instance;
        }

        public Builder setNumber(String number) {
            this.number = number;
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

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setIdNumber(String idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public Builder setGivenNames(String givenNames) {
            this.givenNames = givenNames;
            return this;
        }

        public Builder setCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder setNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setDateOfIssue(LocalDate dateOfIssue) {
            this.dateOfIssue = dateOfIssue;
            return this;
        }

        public Builder setDateOfExpiry(LocalDate dateOfExpiry) {
            this.dateOfExpiry = dateOfExpiry;
            return this;
        }

        public Builder setIssuingAuthority(String issuingAuthority) {
            this.issuingAuthority = issuingAuthority;
            return this;
        }

    }


}
