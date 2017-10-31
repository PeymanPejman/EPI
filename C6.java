import java.util.*;

public class C6{
    
    public static boolean isPalindromic (String s){
        for (int i=0, j = s.length(); i<j; i++, j--){
            if (s.charAt(i) != s.charAt(j))
                return false;
        }

        return true;
    }
    
    public static int stringToInt (String s){
        int result=0;         
        for (int i= s.charAt(0) == '-' ? 1:0; i<s.length(); i++){
            result = result * 10 + (int)(s.charAt(i) - '0');
       } 
       return result;
    }

    public static String convertBase (String num, int b1, int b2){
        boolean isNegative = num.startsWith('-');       
        
        int base10 = 0;

        for (int i = (isnegative ? 1:0); i<num.length(); i++){
            base10 *= 10;
            base10 = base10 * b1 + (Character.isDigit(num.charAt(i)) ?
                    (int) (num.charAt(i) - '0') : (int)(num.charAt(i) - 'A')); 
        }

        return (isnegative ? '-':" ") + (base10 == 0 ? '0': constructFromBase (base10, b2));
    }

    public static String constructFromBase(int base10, int b2){
        return base10 == 0 ? " " : constructFromBase(base10/b2, b2)
            + (char)(base10 % b2 >= 10 ? 'A' + base10 % b2 - 10
                    : '0' + base10 % b2);
    }
   

    public static void reverseWords (String s){
        reverse(s, 0, s.length);
        
        int start = 0, end; 
        while ( (end = s.find (' ', start)) != -1){
            reverse(s, start, end);
        }
    }
        
    public static void reverse(char[] s, int start, int end){
        if (start >= end) 
            return; 
        end = end -1;
        for(int i=start; i<(int)(strat + (end-start)/2); i++){
            char temp = s[end - i];
            s[end-i] = s[start];
            s[start]  = temp;
        }
    }

    public static int find (char[] s , int start){
        for(int i = start; i< s.size; i++){
            if(s[i] == ' ')
                return i;
        }
        return -1;
    }

    public static String lookAndSay(int n){
        String s="1";

        for (int i=0; i<n; i++){
            s=nextNum(s);    
        }
        return s;
    }

    public static String nextNum(String S){
        StringBuilder res = new StringBuilder();
        int counter = 0;

        for (int i=0; i<s.length; i++){
            if ( i+1 == s.length)
                break;
            if (res.charAt(i) == res.charAt(i+1)){
                counter ++;
            }
            else{
                counter++;
                res.append(counter);
                res.append(res.charAt(i));
                counter = 0;
            }
        }
        return result.toString();

    }


    public static int romanToInt(String s){
        Map <Character, Integer> dic = new HashMap<Character, Integer>(){
            {
                put('I',1);
                put('V',5);
                put('X',10);
                put('C',50);
                put('L',100);
                put('D',500);
                put('M',1000);
            }
        }; 
        if (s.length() <2) return dic.get(s.charAt(0));
        int sum = dic.get(s.charAt(s.length()-1));
        for (int i=s.length()-2; i>=0; i--){
            if(dic.get(s.charAt(i)) < dic.get(s.charAt(i+1))){
                res -= dic.get(s.charAt(i));
            }
            else{
                res += dic.get(s.charAt(i));
            }
            
        } 
               
    }

    public static List<String> getValidIP (String s){
        
        for(int i=1; i < 4 && i<s.length(); i++){
            final String first = s.subString(0,i);
            if (isValid(first)){
                for (int j=1; i+j<s.length() && j <4; j++){
                    final String second = s.subString(i, i+j);
                    if (isValid(second)){
                        for (int k=1; i+j+k<s.length() && k<4; k++){
                            final String third = s.subString(i+j, i+j+k);
                            final String fourth = s.subString(i+j+k);
                            if(isValid(third) && isvalid(fourth))
                                result.add(first + "." + second + "." + third + "." + fourth); 
                        }
                    }
                }
            }
        }
    }

    public static boolean isValid(String s){
        return true;
    }

    public static String decoding (String s){

        int numberChar = 0;
        StringBuilder result = new StringBuilder();

        for (int i =0; i<s.length(); s++){
            if(s.charAt(i).isDigit){
                numberChar *= 10;
                numberChar += s.charAt(i) - '0';
            }
            else{
                for (int j =0; j<numChar; j++)
                    result.append(charAt(i));
                numberChar = 0;
            }
        }
        return result.toString();
    }

    public static String encoding (String s){
        StringBuilder result = new StringBuilder();
        int charCount = 1;
        char currentChar = s.charAt(0);

        for (int i = 1; i<s.length(); i++){
            if(s.charAt(i) == currentChar){
                charCount++;
            }else{
                result.append(Integer.toString(charCount));
                result.append(currentChar);
                currentChar = s.charAt(i);
                charCount = 0;
            }
        }
        result.append (Integer.toString(charCount));
        result.append(currentChar);
        return result.toString();
    }
    
    public static int rabinKarp(String t, String S){
        if(s.length() > t.length)
            return -1; 

        int base = 26;
        int power = 1;
        
        int tHash = 0;
        int sHash = 0;

        for (int i=0; i<s.length(); i++){
            base = i==0 ? base = base: 1;

            tHash = tHash * base + t.charAt(i);  
            sHash = sHash * base + s.charAt(i);
            
            power++;
        }
    }   


    public static void main (String[] args){
        //System.out.println(stringToInt ("123"));
        System.out.println(decoding("12f4r"));
    }
}
