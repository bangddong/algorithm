package DataStructure;

public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    public static class Slot {
        String key;
        String value;
        Slot next;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public Integer hashFunc(String key) {
        int n = 0;
        for (int x : key.toCharArray()) {
            n += x;
        }
        return n % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        // 이미 Key가 존재함
        if (this.hashTable[address] != null) {
            // key가 저장된 key와 같다면
            if (this.hashTable[address].key == key) {
                // 새 value로 update
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1;
                // 값이 있다면
                while (this.hashTable[currAddress] != null) {
                    // 값이 같은지 검사
                    if (this.hashTable[currAddress].key.equals(key)) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        // 다음슬롯으로 이동
                        currAddress++;
                        // 슬롯의 끝까지 봤음에도 못찾았으면 데이터가 없다고 가정
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                }
                // while에서 return 받지 못했다면 새로 생성
                this.hashTable[currAddress] = new Slot(key, value);
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key.equals(key)) {
                return this.hashTable[address].value;
            } else {
                // saveData와 로직 동일
                Integer currAddress = address;
                while(this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        return hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyHash mainObject = new MyHash(20);
        mainObject.saveData("DaveLee", "01022223333");
        mainObject.saveData("fun-coding", "01033334444");
        mainObject.saveData("David", "01044445555");
        mainObject.saveData("Dave", "01055556666");
        System.out.println(mainObject.getData("David"));
    }
}
