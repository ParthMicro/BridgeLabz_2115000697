class CustomHashMap { 
    private static final int SIZE = 1000; 
 
    private Node[] map; 
    private static class Node { 
        int key, value; 
        Node next; 
        Node(int key, int value) { 
            this.key = key; 
            this.value = value; 
        } 
    } 
    public CustomHashMap() { 
        map = new Node[SIZE]; 
    } 
    private int hash(int key) { 
        return key % SIZE; 
    } 
    public void put(int key, int value) { 
        int index = hash(key); 
        if (map[index] == null) { 
            map[index] = new Node(key, value); 
            return; 
        } 
        Node curr = map[index]; 
        while (true) { 
            if (curr.key == key) { 
                curr.value = value; 
                return; 
            } 
            if (curr.next == null) break; 
            curr = curr.next; 
        } 
        curr.next = new Node(key, value); 
    } 
    public int get(int key) { 
        int index = hash(key); 
        Node curr = map[index]; 
        while (curr != null) { 
            if (curr.key == key) return curr.value; 
            curr = curr.next; 
        } 
        return -1; 
    } 
 
    public void remove(int key) { 
        int index = hash(key); 
        Node curr = map[index]; 
        if (curr == null) return; 
        if (curr.key == key) { 
            map[index] = curr.next; 
            return; 
        } 
        Node prev = null; 
        while (curr != null) { 
            if (curr.key == key) { 
                prev.next = curr.next; 
                return; 
            } 
            prev = curr; 
            curr = curr.next; 
        } 
    } 
    public static void main(String[] args) { 
        CustomHashMap hashMap = new CustomHashMap(); 
        hashMap.put(1, 10); 
        hashMap.put(2, 20); 
        hashMap.put(1001, 30); 
        System.out.println(hashMap.get(1)); 
        System.out.println(hashMap.get(2)); 
        System.out.println(hashMap.get(1001)); 
        hashMap.remove(1); 
        System.out.println(hashMap.get(1)); 
    } 
} 
