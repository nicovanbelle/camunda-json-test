package be.powerdale.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class FunctionalLocation implements Serializable {

    private String city;
    private String street;
    private String zipcode;
    private String streetNumber;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @JsonIgnore
    public String getAddress() {
        StringBuilder result = new StringBuilder();
        if (street != null && street.length() > 0) {
            result.append(String.format("%s %s", street, streetNumber).trim());
        }
        if (zipcode != null && zipcode.length() > 0) {
            if (result.length() > 0) {
                result.append(", ");
            }

            result.append(zipcode);
        }
        if (city != null && city.length() > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(city);
        }
        return result.toString();
    }
}
