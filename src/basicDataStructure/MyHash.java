package basicDataStructure;

/**
 * Created by cgkim449
 * Date: 2021-12-06
 * Time: 00:06
 */
public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size) {
        hashTable = new Slot[size];
    }

    public class Slot {
        String value;
        Slot(String value) {
            value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = hashFunc(key);
        if(hashTable[address]!=null){
            hashTable[address].value = value;
        } else {
            hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if(hashTable[address] != null) {
            return hashTable[address].value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash mainObject = new MyHash(20);
    }
}
