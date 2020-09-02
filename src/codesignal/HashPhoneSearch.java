package codesignal;

public class HashPhoneSearch {
    public static void main(String[] args) {
        HashPhoneSearch hashPhoneSearch = new HashPhoneSearch();
        System.out.println(hashPhoneSearch.solution(new String[]{"123", "456", "789"}));
    }

    //HashMap만 사용가능
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
                if (phone_book[i].startsWith(phone_book[j])) {
                    return false;
                }
            }
        }
        return answer;
    }
}
