public class StringClasses {
 public void main(String[] args) {
     String s = "Hello, World!";
     System.out.println("Original string: " + s);
     System.out.println("Length: " + s.length());
     System.out.println("Uppercase: " + s.toUpperCase());
     System.out.println("Lowercase: " + s.toLowerCase());
     System.out.println("Index of: " + s.indexOf('c'));   // non posso usare s[index] come in C
 }
}
