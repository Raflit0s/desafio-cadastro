package entity;

public class Address {

    private Object houseNumber;
    private String city;
    private String street;

    public Address() {
    }

    public Address(Object houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Address(String city, boolean bool) {
        this.city = city;
    }

    public Address(String street) {
        this.street = street;
    }

    public Address(Object houseNumber, String city, String street) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
    }

    public Object getHouseNumber() {
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
        return getStreet() + ", " + getHouseNumber() + ", " + getCity();
    }
}
