public interface DictionaryInterface {
    // the key is the search object for the new entry
    // the value is the associated obvject with the key
    // if the key existsd, you should replace the old value with the new
    // no exception
    void insert(int key, String value);
    
    // TODO add spec
    void remove (int key);
    
    // TODO add spec
    void modify(int key, String value);
    
    // TODO add spec
    String lookup (int key);
}
