/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tampilan;

/**
 *
 * @author erica aghestin
 */
public class UserID {
    private static String kd;
    //private static String lavel;
    public static void setUserIDLogin(String kode){
        kd  = kode;
    }
    
    public static String getUserLogin(){
        return kd;
    }
}
