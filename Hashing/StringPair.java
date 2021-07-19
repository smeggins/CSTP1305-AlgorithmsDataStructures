public class StringPair {
    String key;
    String value;
    Occupancy status;

    public StringPair() {
        status = Occupancy.empty;
    }

    public StringPair(String a_key, String a_val) {
        key = a_key;
        value = a_val;
        status = Occupancy.occupied;
    }
}
