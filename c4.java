import java.lang.Math;

public class c4 {

    public static short countBits(int x){
        short counter = 0;

        while (x != 0){
            counter += 1;
            x &= (x-1);    
        }
        return counter; 
    }

    public static short parity (long x){
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 0x1);
    }   

    public static long swapBits (long x, long i, long j){

        if (((x >>> i)&1) != ((x >>> j) &1)){
            long BIT_MASK = (1L << i) | (1L << j);
            x ^= BIT_MASK;
        }
        return x;
    } 

    public static long reverseBits(long x){
        
        for (int i=0; i<64; i++){
            x = swapBits(x, i, 63-i);
        }
        return x;
    }

    public static long reverseBitsLarge (long x){
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xffff;
        /*pcp((int)(x & BIT_MASK) <<  (3*WORD_SIZE))|
        pcp((int)((x>>> WORD_SIZE) & BIT_MASK) <<  (2*WORD_SIZE))|
        pcp((int)((x>>> (2*WORD_SIZE)) & BIT_MASK) <<  WORD_SIZE)|
        pcp((int)((x>>> (3*WORD_SIZE)) & BIT_MASK) );*/
        return 123;

    }

    public static long closestInt(long x){
        long i=0;
        if ((x & 0x1) == 0){
            i = x & ~ (x-1);
            i = (long)(Math.log(i)/Math.log(2));
            return swapBits (x, i, i-1);
        }
        else{
            i = (~x) & ~ ((~x)-1);
            i = (long)(Math.log(i)/Math.log(2));
            return swapBits (x, i, i-1);
        }
    }


    public static long add (long a, long b){
    /*
        long sum =0, carryin = 0, k = 1 , tempA = a, tempB = b;

        while ((tempA != 0) || (tempB ! = 0)){
            long ak = a & k, bk = b & k;
            long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);  
            sum |= (ak^bk^carryin);
            carryin = carryout << 1;
            k <<=1;
            tempA >>>= 1;
            tempB >>>= 1;    
        }
        return sum | carryin;
        */return 0;
    }

    public static long multiply (long a, long b){
        long sum = 0;
     
        while (a != 0){
            if ((a&0x1) !=0){
                sum = add(sum,b);
            }
            a>>=1;
            b<<=1;
        }    
        return sum;
    }

    public static long division (long a, long b){
        long result = 0;
        int power = 32;
        long ypower = b<<power;
        while (a >= b){
            while(ypower > a ){
                ypower >>= 1;
                power --;            
            }
            a -= ypower;
            result |= 1L << power;        
        }        
        return result;
    }

    /*public static long xtothey (long x, long y){
        long power = y;
        double result= 1.0;
        
        if (y<0){
            x = 1.0/x;
            power = -power;
        } 

        while (power != 0){

            if ((power & 1) ! =0){
                result *= x;
            }

            x *= x
            power >>>= 1;
        }
        return result;
        }
    }*/
    
    public static int reverseDigits (int x){
        int rev = 0;
        if (x<10){
            return x;
        }
        while (x > 9){
            rev += (x-(x/10)*10);
            rev *= 10;
            x /= 10;
        }
        return rev + x; 
    }

    public static boolean isPalindrome(int x){
        if (x<10) return true;
        while (x > 9){
        int digits = (int)(Math.log(x)/Math.log(10));
            if (((int)(x/(Math.pow(10, digits))) != x%10)){
                return false; 
            }
            x = x - (int) ( ((int)(x/Math.pow(10, digits))) *Math.pow(10,digits) );
            x /= 10;
        }
        return true;
    }

    public static uniformRand ( int lb, int ub){
        int num = ub - lb + 1, result; 

        do{
            for (int i=0; (1 << i) < num; ++i){
                //result = (result << 1) | zeroOneRandom();
            }

        }while (result >= num);
        return result + nbum;
    }

    public class Rectangle{
        int x, y, width, height;

        public Rectangle(){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;           
        }

        public Rectangle intersectRect ( Rectangle R1, Rectangle R2){
            if (!isIntersect(R1, R2))
                return new Rectangle (0, 0 , 0 , 0);
            else{
                return new Rectangle ( 
                        Math.max(R1.x, R2.X), Math.max(R1.y, R2.y),
                        Math.min(R1.x+R1.width, R2.x+R2.width)-Math.max(R1.x, R2.x),
                        Math.min(R1.y+R1.height, R2.y+R2.height)-Math.max(R1.y, R2.y));
            }
        }

        public boolean isIntersect(R1, R2){
            return R1.x <= R2.x + R2.width && R1.x + R1.width >= R2.x
                   && R1.y <= R2.y +R2.height && R1.y + r1.height >= R2.y;
        }

    }
    public static void main (String[] args){
        //System.out.println (countBits(Integer.parseInt(args[0])));
        //System.out.println(parity(Integer.parseInt(args[0])));
        //System.out.println(swapBits(Integer.parseInt(args[0]), 2, 4));
        //System.out.println(reverseBits(123123));
        //System.out.println(closestInt(6));
        //System.out.println(reverseDigits(1234567));
        System.out.println(isPalindrome(Integer.parseInt(args[0])));
    }
}
