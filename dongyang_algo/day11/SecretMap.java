package day11;

public class SecretMap {
    public static void main(String[] args) {
        int arr1[] = { 8, 20, 28, 18, 11 };
        int arr2[] = { 30, 1, 21, 17, 28 };
        int n = 5;
        String[] rs=decode(n, arr1, arr2);

        for(String str: rs){
            System.out.print("[");
            System.out.print(str);
            System.out.println("]");
        }
    }

    public static String[] decode(int n, int[] arr1, int[] arr2) {
        int[] map = new int[n];
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            map[i] = arr1[i] | arr2[i];
        }

        for (int i = 0; i < map.length; i++) {
            String temp = Integer.toBinaryString(map[i]);
            if (temp.length() < n) {
                int cha = n - temp.length();
                for (int j = 0; j < cha; j++) { 
                    temp = "0" + temp;
                }
            }
            temp = temp.replaceAll("1", "#");
            temp = temp.replaceAll("0", " ");
            answer[i] = temp;
        }
        return answer;
    }

}
