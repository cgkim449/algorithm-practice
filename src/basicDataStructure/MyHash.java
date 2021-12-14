package basicDataStructure;

/**
 * Date: 2021-12-13
 * Time: 12:31
 */
public class MyHash {
    public Slot[] hashTable; // Entry[]

    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String value;
        Slot(String value) {
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null) {
            hashTable[address].value = value; // put은 덮어쓴다
        } else {
            hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = hashFunc(key);
        if(hashTable[address] != null) {
            return hashTable[address].value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash myHash = new MyHash(20);
    }
}
