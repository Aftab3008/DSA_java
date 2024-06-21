public class hashmapImple {
    public static void main(String[] args) {
        hashmap<String, Integer> map = new hashmap<>();
        map.insert("abc", 10);
        map.insert("def", 20);
        map.insert("ghi", 30);
        map.insert("jkl", 40);
        map.insert("mno", 50);
        map.removekey("mno");
        System.out.println(map.getvalue("abc"));
        System.out.print(map.getvalue("mno"));
    }
}
