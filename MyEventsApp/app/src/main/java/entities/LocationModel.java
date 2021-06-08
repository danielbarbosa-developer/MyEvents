package entities;

public class LocationModel {

    public LocationModel(int id, String name, String district, String city, int capacity) {
        Id = id;
        Name = name;
        District = district;
        City = city;
        Capacity = capacity;
    }

    private int Id;

    private String Name;

    private String District;

    private String City;

    private int Capacity;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    @Override
    public String toString(){
        return this.Name + "\n" + this.District + "\n" + this.City + "\n" + String.valueOf(this.Capacity);
    }
}
