package codesignal;

public class ImplementStrStr {
    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("aaaaa", "bba"));
    }
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
