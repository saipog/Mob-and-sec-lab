import java.math.BigInteger;
import java.util.*;
/**
*
* @author student
*/
public class sha512 {
 /**
 * @param args the command line arguments
 */
 public static void main(String[] args) {
 // TODO code application logic here
 String w = "6162638000000000";
 String k = "428a2f98d728ae22";
 String a = "6a09e667f3bcc908", e = "510e527fade682d1", b = 
"bb67ae8584caa73b", f = "9b05688c2b3e6c1f", c = "3c6ef372fe94f82b", g = 
"1f83d9abfb41bd6b", d = 
"a54ff53a5f1d36f1", h = "5be0cd19137e2179";
 String ba = hexToBin(a);
 String bb = hexToBin(b);
 String bc = hexToBin(c);
 String bd = hexToBin(d);
 String be = hexToBin(e);
 String bf = hexToBin(f);
 String bg = hexToBin(g);
 String bh = hexToBin(h);
 BigInteger a1 = new BigInteger(be, 2);
 BigInteger a2 = new BigInteger(bf, 2);
 BigInteger a3 = new BigInteger(bg, 2);
 String ch = (a1.and(a2)).xor((a1.not()).and(a3)).toString(2);
 String p = "";
 int x = ch.length();
 // System.out.println(x);
 if (x < 64) {
 x = 64 - x;
 //System.out.println(x);
 for (int i = 0; i < x; i++) {
 p = p + "0";
 }
 //System.out.println(p);
 ch = p + ch;
 //System.out.println(ch);
 }
 BigInteger a4 = new BigInteger(ba, 2);
 BigInteger a5 = new BigInteger(bb, 2);
 BigInteger a6 = new BigInteger(bc, 2);
 String maj = ((a4.and(a5)).xor((a4.and(a6)).xor(a5.and(a6)))).toString(2);
 x = maj.length();
 //System.out.println(x);
 if (x < 64) {
 x = 64 - x;
 //System.out.println(x);
 p = "";
 for (int i = 0; i < x; i++) {
 p = p + "0";
 }
 //System.out.println(p);
 maj = p + maj;
 //System.out.println(maj);
 }
 System.out.println(ch + " " + ch.length());
 System.out.println(maj + " " + maj.length());
 String r28 = Rotate(ba, 28);
 String r34 = Rotate(ba, 34);
 String r39 = Rotate(ba, 39);
 BigInteger sa1 = new BigInteger(r28, 2);
 BigInteger sa2 = new BigInteger(r34, 2);
 BigInteger sa3 = new BigInteger(r39, 2);
 String sa = ((sa1.xor(sa2)).xor(sa3)).toString();
 String r14 = Rotate(be, 14);
 String r18 = Rotate(be, 18);
 String r41 = Rotate(be, 41);
 BigInteger se1 = new BigInteger(r14, 2);
 BigInteger se2 = new BigInteger(r18, 2);
 BigInteger se3 = new BigInteger(r41, 2);
 String se = ((se1.xor(se2)).xor(se3)).toString();
 System.out.println("sumation of a : " + sa);
 System.out.println("sumation of e : " + se);
 BigInteger ta = new BigInteger(sa);
 BigInteger te = new BigInteger(se);
 BigInteger h1 = new BigInteger(h, 16);
 BigInteger ch1 = new BigInteger(ch, 2);
 BigInteger w1 = new BigInteger(w, 16);
 BigInteger k1 = new BigInteger(k, 16);
 BigInteger maj1 = new BigInteger(maj, 2);
 BigInteger T1 = h1.add(ch1);
 T1 = T1.add(te);
 // System.out.println(T1);
 T1 = T1.add(w1);
 //System.out.println(T1);
 T1 = T1.add(k1);
 System.out.println("Value of t1(int) " + T1);
 BigInteger T2 = ta.add(maj1);
 System.out.println("value of t2(int) " + T2);
 String t1 = T1.toString(16);
 String t2 = T2.toString(16);
 System.out.println("T1 hex " + t1);
 System.out.println("T2 hex " + t2);
 h = g;
 g = f;
 f = e;
 BigInteger D = new BigInteger(d, 16);
 e = (D.add(T1)).toString(16);
 d = c;
 c = b;
 b = a;
 a = (T1.add(T2)).toString(16);
 System.out.println("a : " + a + " " + a.length());
 System.out.println("b : " + b + " " + b.length());
 System.out.println("c : " + c + " " + c.length());
 System.out.println("d : " + d + " " + d.length());
 System.out.println("e : " + e + " " + e.length());
 System.out.println("f : " + f + " " + f.length());
 System.out.println("g : " + g + " " + g.length());
 System.out.println("h : " + h + " " + h.length());
 String Final = a + b + c + d + e + f + g + h;
 System.out.println("hash value = " + Final + " " + Final.length());
 }
 static String Rotate(String s, int n) {
 s += s;
 String r;
 r = s.substring(n, n + 64);
 return r;
 }
 static String hexToBin(String s) {
 String p = new BigInteger(s, 16).toString(2);
 String a = "";
 int x = p.length();
 if (x < 64) {
 x = 64 - x;
 for (int i = 0; i < x; i++) {
 a = a + "0";
 }
 a = a + p;
 } else {
 a = p;
 }
 return a;
 }
}