package hashing;

public class MyHashSet {

    class ListNode{
        int key;
        ListNode next;
        public ListNode(int key, ListNode next){
            this.key = key;
            this.next = next;
        }
    }

    static final int size = 19997;
    static final int mult = 12582917;
    ListNode[] data;

    public MyHashSet() {
        this.data = new ListNode[size];
    }

    private int hash(int key){
        return (int) ((long) key * mult % size);
    }

    public void add(int key) {
        if(contains(key)) return;
        int h = hash(key);
        data[h] = new ListNode(key, data[h]);
    }

    public void remove(int key) {
        int h = hash(key);
        if(data[h] == null) return;
        if(data[h].key == key){
            data[h] = data[h].next;
            return;
        }

        ListNode temp = data[h];
        while(temp.next != null){
            if(temp.next.key == key){
                temp.next = temp.next.next;
                return;
            }
            // if condition fails, move to the next node and check there
            temp = temp.next;
        }
    }

    public boolean contains(int key) {
        int h  = hash(key);
        ListNode temp = data[h];
        while(temp != null){
            if(temp.key == key) return true;
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args){
        MyHashSet set = new MyHashSet();
        set.add(90);
        System.out.println(set.contains(90));
        set.remove(90);
        System.out.println(set.contains(90));
    }
}
