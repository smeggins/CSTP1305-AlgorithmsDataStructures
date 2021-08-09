// used StringPair instead of this in the hash example

public class HashTableLocation {
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Occupancy getStatus() {
        return status;
    }

    public void setKey(String key) {
        this.key = key;
    }

    String key;
    String value;
    Occupancy status;

    public void setValue(String value) {
        this.value = value;
    }



    public void setStatus(Occupancy status) {
        this.status = status;
    }



    public HashTableLocation(){
        status = Occupancy.empty;
    }

    public HashTableLocation(String key, String value) {
        this.key = key;
        this.value = value;
//        this.status = Occupancy.Occupied;
    }
}