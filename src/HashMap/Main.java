package HashMap;

public class Main {
    public static void main(String args[]) {

        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");
        hashMap.put(4, "4");
        hashMap.put(5, "5");
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(4));
        System.out.println(hashMap.get(5));

        hashMap.put(1, "1.1");
        hashMap.put(3, "3.1");
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
    }
}
