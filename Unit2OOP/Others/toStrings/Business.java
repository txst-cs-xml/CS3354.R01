public class Business {
    protected String name;
    protected String address;

    public void setName(String busName) {
        name = busName;
    }

    public void setAddress(String busAddress) {
        address = busAddress;
    }

    @Override
    public String toString() {
        return name + " -- " + address;
    }

    public boolean equals(Business obj) {
        return this.name.equals(obj.name) && this.address.equals(obj.address);
    }
}
