import java.util.*;
import java.net.*;
import java.io.*;
public class elgamal_c {
    public static int k_inverse(int k, int q){
        for(int i= 0; i<q; i++){
            if(k*i % q== 1) return i;
        }
        return -1;
    }
    public static int power(int a, int b, int q){
        int ans=1;
        for(int i=0;i<b;i++){
            ans=ans*a;
            ans%=q;
        }
        return ans;
    }
    public static void main(String[] args) throws Exception{
        Socket s=new Socket("localhost",9000);
        PrintWriter pr=new PrintWriter(s.getOutputStream(),true);
        BufferedReader bw=new BufferedReader(new InputStreamReader(s.getInputStream()));
        Scanner inp=new Scanner(System.in);
        System.out.println("Enter the alpha and q: ");
        int alpha=inp.nextInt();
        int q=inp.nextInt();
        System.out.println("Choose Xa between 1<Xa<q-1 : ");
        int xa= inp.nextInt();
        int ya= power(alpha, xa, q);
        pr.println(alpha);
        pr.println(q);
        pr.println(ya);
        int c1= Integer.parseInt(bw.readLine());
        int c2= Integer.parseInt(bw.readLine());
        System.out.println("c1:"+c1);
        int K= power(c1, xa, q);
        System.out.println("k:"+K);
        System.out.println("k inv "+k_inverse(K, q));
        int m= c2* k_inverse(K, q) % q;
        System.out.println("The decrypted message is: "+ m);
    }
}