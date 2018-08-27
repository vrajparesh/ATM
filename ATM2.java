import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
class ATM2 extends dbwrite 
{

    static Date dNow = new Date( );
    static SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    static int b = 0;
    static int bal = 1000;
    static int ca = 35000  ; 
    static int g; 
    static Scanner database = new Scanner("database.txt"); 
    static Scanner a= new Scanner(System.in);

    public  void main ()
    {

        ATM2 a = new ATM2 ();
        a.display ();
        a.input ();

        a.setBalance();
        a.menu();
    }

    public void display()
    {

        System.out.println("                    VV     VBBBBB                                                   ");
        System.out.println("                     VV    VB    BB                                              ");
        System.out.println("                      VV   VB    BB                                            ");
        System.out.println("                       VV  VBBBBBBB                                                ");
        System.out.println("                        VV VB     BB                                          ");
        System.out.println("                         VVVB      BB                                      ");
        System.out.println("                          VVBBBBBBBB                                      ");

        System.out.println("**********************************************************************************************");                
        System.out.println("* VVV      VVV  RRRRR       AA         JJJJJJJJ *   BBBBB       AA       NNNN     NN  KK  KK *");         
        System.out.println("*  VVV    VVV   RR  RR     AAAA           JJ    *   BB  B      AAAA      NN NN    NN  KK KK  *");      
        System.out.println("*   VVV  VVV    RR  RR    AA  AA          JJ    *   BBBBB     AA  AA     NN  NN   NN  KKKK   *"); 
        System.out.println("*    VVVVVV     RRRRR    AAAAAAAA         JJ    *   BB  BB   AAAAAAAA    NN   NN  NN  KKKK   *");
        System.out.println("*     VVVV      RR RR   AA      AA   JJ   JJ    *   BB  BB  AA      AA   NN    NN NN  KK KK  *");
        System.out.println("*      VV       RR  RR AA        AA   JJJJJ     *   BBBBB  AA        AA  NN     NNNN  KK  KK *");
        System.out.println("**********************************************************************************************");
        System.out.println();
        System.out.println("W-E-L-C-O-M-E");
        System.out.println();

    }

    public static int setBal(int i){
        bal=i;
        return bal;
    }

    public void input()
    {
        System.out.println("==================================================================");
        System.out.print("Enter Your Account Number Provided To You (only 1,2,3,4,5,6,7,8,9,10) ");
        b= a.nextInt();
        System.out.println("==================================================================");

    }

    public static void setBalance ()
    {
        switch (b)
        {  case 1:
            {setBal(140000);
                break;}
            case 2:
            {setBal(15000);
                break;}
            case 3:
            setBal(145000);
            break;
            case 4:
            setBal(130000);
            break;
            case 5:
            bal=950000;
            break;
            case 6:
            bal=750000;
            break;
            case 7:
            bal=650000;
            break;
            case 8:
            bal=450000;
            break;
            case 9:
            bal=350000;
            break;
            case 10:
            bal=15000;
            break;

        }
        System.out.println("Your Balance is:Rs."+bal);

    }

    public static void menu()
    {   
        System.out.println("==============================================================="); 
        System.out.println("                           M E N U");
        System.out.println("===============================================================");
        System.out.println("1)Deposit");
        System.out.println("2)Withdrawal");
        System.out.println("3)Balance Reciept");
        System.out.println("4)Exit");
        System.out.println("===============================================================");
        System.out.println("Your Choice");
        int c=a.nextInt();
        if (c==1)
            deposit();
        if (c==2)
            withdraw();
        if (c==3)
            reciept();
        if (c==4)
            exit();
    }

    public static void deposit()
    {
        System.out.println();
        System.out.println("===========================================================");
        System.out.println();
        System.out.println("Enter The Amount To Be Deposited");
        int d=a.nextInt();
        bal=bal+d;
        System.out.println("Your Balance is Rs"+bal);
        System.out.println();
        System.out.println("===========================================================");

        System.out.println("Do You Wish To Continue:1)Yes,2)No");
        int h=a.nextInt();   
        if (h==1)
            menu();
        else 
            reciept()   ;           

    }

    public static void withdraw()
    {
        System.out.println();
        System.out.println("===========================================================");
        System.out.println("From");
        System.out.println("1.Credited Account");
        System.out.println("2.Savings Account");
        System.out.println("3. Exit");
        System.out.println("Your Choice");
        int e=a.nextInt();
        if(e==1)
        {
            cawithdraw();
        }
        else if(e==2)
        {
            sawithdraw();
        }
        else if(e==3)
        {
            menu();
        }
        else
        if(e==4)
        {
            exit();
        }
        else
        {
            System.out.println("Error. Please Re-enter");
            withdraw();
        }

        System.out.println("Do You Wish To Continue:1)Yes,2)No");
        int h=a.nextInt();   
        if (h==1)
            menu();
        else 
            exit();
    }

    public static void sawithdraw()
    {

        System.out.println("Enter The Amount To Be Withdrawn");
        g=a.nextInt();
        if(bal<g)
        {
            System.out.println("Amount Exceeded");
            sawithdraw();
        }
        bal=bal-g;                
        System.out.println("Your Balance is Rs."+bal);

        System.out.println("===========================================================");
        
        recieptw();

    }

    public static void cawithdraw()
    {
        System.out.println("Your Credited Limit is Rs."+ca);
        System.out.println("Enter The Amount To Be Withdrawn");
        int f=a.nextInt();

        if (f>ca)
        {
            System.out.println("Credit exceeded");
            cawithdraw();
        }
        else
        {
            ca=ca-f;
            System.out.println("Your Credit Amount Left is Rs."+ca);

        }
        System.out.println("===========================================================");

        System.out.println("Do You Wish To Continue:1)Yes,2)No");
        int h=a.nextInt();   
        if (h==1)
            withdraw();
        else
            exit();         

    }

    public static void reciept()
    {
        System.out.println("****************************************************************************"); 
        System.out.println("Sir/Madam,Your reciept");
        System.out.println("|=======================================|"); 
        System.out.println("|ATM CUSTOMER ADVICE                    |");
        System.out.println("|=__====================================|");
        System.out.println("|<VB> VRAJ'S BANK OF INDIA      24/7    |");
        System.out.println("|=======================================|");
        System.out.println("|Day    Date           Time             |");
        System.out.println("|"+ft.format(dNow)+"      |");
        System.out.println("|Account/Card No. :"+b+"                 |") ;
        System.out.println("|Transaction Type : Reciept             |");
        System.out.println("| Your Balance is Rs."+bal+"               |");
        System.out.println("========================================|");
        System.out.println("|ANY INCONVENIENCE IS REGRETTED.KINDLY  |"); 
        System.out.println("|CONTACT YOUR BBRANCH OR CALL 24X7      |");
        System.out.println("|HELPLINE AT 1800112211 OR 08026599990  |");
        System.out.println("|=======================================|");
        try {
            
            fr(bal);
            
        } catch (Exception e) {

        }
        System.out.println("Do You Wish To Continue:1)Yes,2)No");
        int h=a.nextInt();   
        if (h==1)
            menu();
        else
            exit();

    }

    public static void recieptw()
    {
        System.out.println("****************************************************************************"); 
        System.out.println("Sir/Madam,Your reciept");
        System.out.println("|=======================================|"); 
        System.out.println("|ATM CUSTOMER ADVICE                    |");
        System.out.println("|=__====================================|");
        System.out.println("|<VB> VRAJ'S BANK OF INDIA      24/7    |");
        System.out.println("|=======================================|");
        System.out.println("|Day    Date           Time             |");
        System.out.println("|"+ft.format(dNow)+"      |");
        System.out.println("|Account/Card No. :"+b+"                   |") ;
        System.out.println("|Transaction Type : Withdrawal          |");
        System.out.println("|  Withdrawn Rs."+g+"                    |");
        System.out.println("| Your Balance is Rs."+bal+"              |");
        System.out.println("========================================|");
        System.out.println("|ANY INCONVENIENCE IS REGRETTED.KINDLY  |"); 
        System.out.println("|CONTACT YOUR BBRANCH OR CALL 24X7      |");
        System.out.println("|HELPLINE AT 1800112211 OR 08026599990  |");
        System.out.println("|=======================================|");
        try {
            
            fr(bal);
            
        } catch (Exception e) {

        }
        System.out.println("Do You Wish To Continue:1)Yes or 2)No     (Only 1 or 2 accepted)   ");
        int h=a.nextInt();   
        if (h==1)
            menu();
        else 
        { 
            exit();

        }  

    }    

    public static void exit()
    {
        System.out.println("Please restart the program");
        System.exit (0);
    }

}