import java.util.ArrayList;
import java.util.Arrays;

class FindKimInSeoul {
    public String findKimInSeoul(String[] seoul) {
        String answer = "";
        int where = 0;
        ArrayList<String> seoulToList = new ArrayList<>(Arrays.asList(seoul));
        where = seoulToList.indexOf("Kim");
        answer = "김서방은 " + where + "에 있다";
        return answer;
    }
    public static void main(String[] args) {
        FindKimInSeoul findKim = new FindKimInSeoul();
        String[] test = {"Jane", "Kim"};
        String whereIsKim = findKim.findKimInSeoul(test);
        System.out.println(whereIsKim);
    }
}