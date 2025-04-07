package util;

public class Address {

    private Integer houseNumber;
    private String city;
    private String street;

    public Address() {
    }

    public Address(Integer houseNumber, String city, String street) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber=" + houseNumber +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
