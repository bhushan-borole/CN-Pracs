import java.util.Arrays;
import java.util.Scanner;

class CRC{
    static String dataword;
    static String divisor;
    static int r;
    static String M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Dataword");
        dataword = sc.next();
        System.out.println("Enter Divisor");
        divisor = sc.next();

        r = divisor.length() - 1;
        M = String.valueOf(dataword);

        for(int i=0 ; i<r ; i++){
            M = M + "0";
        }
        int Marr[] = convertToIntArray(M);
        int divarr[] = convertToIntArray(divisor);

        for(int i=0 ; i < dataword.length() ; i++){
            if(Marr[i] == 1){
                for(int j=0 ; j<divarr.length ; j++)
                    Marr[i+j] = (Marr[i+j] + divarr[j]) % 2;
            }
        }

        int s[] = Arrays.copyOfRange(Marr, Marr.length-r, Marr.length);

        String rem = "";
        for(int x : s){
            rem += x;
        }

        System.out.println("Codeword: " + dataword + rem);

    }
    static int[] convertToIntArray(String s){

        String s1[] = s.split("");
        int arr[] = new int[s1.length];
        for(int i=0;i < arr.length ; i++){
            arr[i] = Integer.parseInt(s1[i]);
        }
        return arr;
    }

}