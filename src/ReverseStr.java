/*
(문제)
reverseStr 메소드는 String형 변수 str을 매개변수로 입력받습니다.
str에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 String을 리턴해주세요.
str는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
예를들어 str이 Zbcdefg면 gfedcbZ을 리턴하면 됩니다.

 */


public class ReverseStr {

    StringBuilder sb = new StringBuilder();


    public String reverseStr(String str) {
        char[] units = str.toCharArray();
        selectionSort(units);
        return sb.toString();
    }

    public void selectionSort(char[] units) {
        int i, j, max;

        for (i = 0; i < units.length - 1; i++) {
            max = i;

            System.out.println("i : " + i + "=" + units[i]);

            for (j = i + 1; j < units.length; j++) {
                if (units[j] > units[max]) {
                    max = j;
                }
            }
             swap(units, max, i) ;
        }

        for (int k = 0; k < units.length; k++) {
            sb.append(units[k]);
        }
    }

    public void swap(char[] units, int max, int i) {
        char temp = units[i];
        units[i] = units[max];
        units[max] = temp;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        ReverseStr rs = new ReverseStr();
        System.out.println(rs.reverseStr("ZLvlDgIdOaDwZ"));

        // ZLvlDgIdOaDwZ
        // wvlgdaZZOLIDD

        // Zbcdefg
        // gfedcbZ
    }

}