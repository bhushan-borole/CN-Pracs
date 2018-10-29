import java.util.*;

public class FramingMethods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String frame = sc.nextLine();
        System.out.println("1.Character Count\n2.Bit Stuffing\n3.Byte Stuffing\n4.Physical layer violation\nEnter Option: ");
        int op = sc.nextInt();

        switch(op){
            case 1:
                characterCount(frame);
                break;
            case 2:
                bitStuffing(frame);
                break;
            case 3:
                byteStuffing(frame);
                break;
            case 4:
                physicalLayerViolation(frame);
                break;
            default: System.out.println("Enter valid option!");
        }


    }
    static boolean validateString(String frame){
        return frame.matches("[0-1]");
    }

    static void  characterCount(String frame){
        String []frame_list = frame.split(" ");

        for(int i=0;i<frame_list.length;i++){
            frame_list[i] = frame_list[i].length() + frame_list[i];
        }
        System.out.println(Arrays.asList(frame_list));
    }

    static void bitStuffing(String frame){
        frame = "01111110_"+frame.replace("11111", "111110")+"_01111110";
        System.out.println(frame);

    }
    static void byteStuffing(String frame){
        frame = frame.replace("flag", "Esc flag");
        frame = "flag_" + frame.replace("esc", "esc esc") + "_flag";
        System.out.println(frame);
    }
    static void physicalLayerViolation(String frame){
        frame = frame.replace("0", "L ");
        frame = frame.replace("1", "H ");
        System.out.println(frame);
    }

}

/*
Output:
Enter String:
abc ghi jkl
1.Character Count
2.Bit Stuffing
3.Byte Stuffing
4.Physical layer violation
Enter Option:
1
[3abc, 3ghi, 3jkl]
Enter String:
0101111110010
1.Character Count
2.Bit Stuffing
3.Byte Stuffing
4.Physical layer violation
Enter Option:
2
01111110_01011111010010_01111110
Enter String:
esc abc flag rgh flag esc
1.Character Count
2.Bit Stuffing
3.Byte Stuffing
4.Physical layer violation
Enter Option:
3
flag_esc esc abc Esc flag rgh Esc flag esc esc_flag
Enter String:
101010100000101
1.Character Count
2.Bit Stuffing
3.Byte Stuffing
4.Physical layer violation
Enter Option:
4
H L H L H L H L L L L L H L H
 */
