package Cantina;

import java.util.Scanner;

public class Menu {

    public static String lerString() {
        String res;
        Scanner in = new Scanner(System.in);
        res = in.nextLine();
        return res;
    }
    public static String lerStringMsg(String msg) {
        System.out.println(msg);
        return lerString();
    }
    public static int lerInt() {
        String saux;
        int ires=0;
        boolean valid=false;
        do {
            Scanner in = new Scanner(System.in);
            saux = in.nextLine();
            try {
                Integer iRes = Integer.parseInt(saux);
                valid = true;
                ires = iRes;
            } catch (NumberFormatException e) {
                System.out.print("Inválido, tente de novo: ");
            }
        } while(!valid);
        return ires;
    }
    public static int lerIntMsg(String msg) {
        System.out.println(msg);
        return lerInt();
    }
    public static double lerDouble() {
        String saux;
        double dres=0;
        boolean valid=false;
        do {
            Scanner in = new Scanner(System.in);
            saux = in.nextLine();
            try {
                Double dRes = Double.parseDouble(saux);
                valid = true;
                dres = dRes;
            } catch (NumberFormatException e) {
                System.out.print("Inválido, tente de novo: ");
            }
        } while(!valid);
        return dres;
    }
    public static double lerDoubleMsg(String msg) {
        System.out.println(msg);
        return lerDouble();
    }
}
