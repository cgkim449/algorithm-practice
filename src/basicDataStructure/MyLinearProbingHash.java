package basicDataStructure;

/**
 * Date: 2021-12-13
 * Time: 12:31
 */
public class MyLinearProbingHash {
    public Slot[] hashTable; // Entry[]

    public MyLinearProbingHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if(this.hashTable[address] != null) {
            if(hashTable[address].key == key) {
                hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1;
                while (hashTable[currAddress].key != null) {
                    if(hashTable[currAddress].key == key) {
                        hashTable[currAddress].value =value;
                        return true;
                    } else {
                        currAddress++;
                        if(currAddress >= hashTable.length) {
                            return false;
                        }
                    }
                }
                hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        } else {
            hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = hashFunc(key);
        if(hashTable[address] != null) {
            if(hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currAddress = address + 1;
                while (hashTable[currAddress] != null) {
                    if(hashTable[currAddress].key == key) {
                        return hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if(currAddress >= hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyLinearProbingHash myHash = new MyLinearProbingHash(20);
    }
}
