import java.io.*;
import java.util.Scanner;

/**
 * Created by LinkClink on 26.04.2019.
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        int connections_1[] = new int[100];
        int [] tall = new int [100];

        int charter = 0;
        int charter_2 = 0;
        int charter_3 = 0;

        int flag_err=0;

        File file_in = new File("C:/Users/LinkClink/IdeaProjects/Graph/src/in_1.txt");
        Scanner scanner = new Scanner(file_in);

        int i = 0;
        int a=0;
        int c=0;
        int int_scan;


        while(scanner.hasNextInt())
        {
            int_scan = scanner.nextInt();

            if(int_scan != 0) // scan all number with file
            {
                connections_1[a]=int_scan;
                c++;
            }

            for (charter = 0; charter < tall.length; charter++)
            {
                if (tall[charter] == int_scan || int_scan == 0)
                {
                    flag_err = 1;
                }
            }
            if (flag_err == 0)
            {
                tall[i] = int_scan;
                i++;
            }

            flag_err=0;
            a++;
        }

        int loc_table[][] = new int[i][i];


        // not used in this ver
        /*
        for( charter=0; charter<i; charter++)
        {
            loc_table[0][charter]= tall[charter];
            loc_table[charter][0]= tall[charter];
        }
        */

        //parse 1
        int connections_2[][] = new int[c/2][2];

        for( charter=0; charter<c/2; charter++)
        {
            for(charter_2=0;charter_2<2;charter_2++) // transfer of numbers from a one-dimensional array to a two-dimensional array
            {
                connections_2[charter][charter_2] = connections_1[charter_3];
                charter_3++;
            }
        }


        // print 1
        System.out.print("In:\n");
        for( charter=0; charter<c/2; charter++)
        {
            for(charter_2=0;charter_2<2;charter_2++) // print graph connections
            {
                System.out.print(connections_2[charter][charter_2]);
            }
            System.out.print("\n");
        }


        //parse 2
        charter_2=0;
        int ch,ch_1;

        for(charter=0;charter<c/2;charter++) // insert graph connect in two-dimensional array
        {
                ch = connections_2[charter][charter_2] -1;
                ch_1 = connections_2[charter][charter_2+1] -1;

              loc_table[ch][ch_1] = 1 ;
              loc_table[ch_1][ch] = 1 ;
        }


        //print 2
        System.out.print("Out:\n");
        for(charter=0;charter<loc_table.length;charter++)
        {
            for(charter_2=0;charter_2<loc_table.length;charter_2++) // print graph connect in two-dimensional array
            {
                System.out.print(loc_table[charter][charter_2]);
            }
            System.out.print("\n");
        }


    }
}
