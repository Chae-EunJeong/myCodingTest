package programmers.level02.StackPrice.PhoneBook;

public class PhoneBook {
    public boolean phoneBook(String[] phone_book) {
        boolean answer = true;
        
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book.length; j++) {
                if(i==j)
                    continue;
                if(phone_book[i].startsWith(phone_book[j]))
                    return false;
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        String[] phone_book = {"119, 9373841", "1193847"};
        System.out.println(pb.phoneBook(phone_book));
    }
}
