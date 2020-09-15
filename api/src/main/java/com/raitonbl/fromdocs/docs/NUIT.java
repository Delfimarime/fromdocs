package com.raitonbl.fromdocs.docs;

import com.raitonbl.fromdocs.Document;

import java.time.LocalDate;

/**
 * @author Delfim Marime
 */
public class NUIT implements Document {

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
     * Date of Issue <br>
     * LocalDate
     */
    private LocalDate issuanceDate;

    private String issuingAuthority;

    private NUIT() {
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

    public LocalDate getIssuanceDate() {
        return issuanceDate;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public static class Builder {

        private String name;
        private String number;
        private LocalDate issuanceDate;
        private String issuingAuthority;

        private Builder() {
        }

        public static Builder get() {
            return new Builder();
        }

        public NUIT build() {

            NUIT instance = new NUIT();

            instance.name = name;
            instance.number = number;
            instance.issuanceDate = issuanceDate;
            instance.issuingAuthority = issuingAuthority;

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

        public Builder setIssuanceDate(LocalDate issuanceDate) {
            this.issuanceDate = issuanceDate;
            return this;
        }

        public Builder setIssuingAuthority(String issuingAuthority) {
            this.issuingAuthority = issuingAuthority;
            return this;
        }

    }


}
