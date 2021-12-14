package basicDataStructure;

/**
 * Date: 2021-12-13
 * Time: 12:31
 */
public class MyChainingHash {
    public Slot[] hashTable; // Entry[]

    public MyChainingHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot next;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null) {
            Slot findSlot = hashTable[address]; // head
            Slot prevSlot = hashTable[address]; // head

            while (findSlot != null) {
                if(findSlot.key == key) {
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = hashFunc(key);
        if(hashTable[address] != null) {
            Slot findSlot = hashTable[address]; // head
            while (findSlot!=null) {
                if(findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyChainingHash myHash = new MyChainingHash(20);
    }
}
