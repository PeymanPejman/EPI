import java.lang.Math;
import java.util.*;

public class C5{
    
    public static void evenOdd (int[] A){
        int pEven = 0, pOdd = A.length -1;
        while (pEven < pOdd){
           if (A[pEven] % 2 == 0){
                pEven++;                
           }
           else{
                int temp = A[pOdd];
                A[pOdd] = A[pEven];
                A[pEven] = temp;
                pOdd--;                
           }
        }
    }

    public enum Color {RED, WHITE, BLUE}
    
    public static void dutchFlag (List<Color> A, int p){
        Color colorP = A.get(p);
        int wallS = 0;

        for (int i=0; i < A.size(); i++){
                if (A.get(i).ordinal() < colorP.ordinal()){
                    Collections.swap(A, i, wallS++);
                }
        }

        int wallL = A.size() -1;

        for (int i = A.size(); i>=wallS; i--){
                if (A.get(i).ordinal > colorP.ordinal()){
                    Collections.swap(A, i, wallL--);
                }
        }
    }

    public static List<Integer> plusOne (List<Integer> A){
    
        int cIn = 0, cOut = 0;

        for (int i=A.size(); i >=0 ; i--){
            cOut = (int)((A.get(i) + 1 + cIn)/10);
            A.set(i, (A.get(i) + 1 + cIn)%10);
            cIn = cOut;
        }
        int temp = A.get(0);
        if (temp > 9){
            
            A.set(0, temp%10);
            A.add(0, (int)(temp/10));
        }
        return A;
    }

    public static List<Integer> multiply (List<Integer> A, List<Integer> B){
    
        int cIn = 0, cOut = 0;

        int s = Math.min (A.size(), B.size());
        int b = Math.max (A.size(), B.size());

        int sign = A.get(0)<0 ^ B.get(0)<0 ? -1:1;
        
        List<Integer> res = Collections.nCopies(s+b, 0);
        int loc = 0;
        for (int i= s; i >=0 ; i--){
            for (int j = b; j >=0; j--){            
                
                res.set(i + j + 1, res.get(i+j+1)+ A.get(i)* B.get(j));
                res.set(i+j, res.get(i+j+1)/10 +res.get(i+j));
                res.set(i+j+1, res.get(i+j+1)%10);
        
            }
        }
        
        int nonzero = 0;
        while (res.get(nonzero) == 0 && nonzero < res.size()){
            nonzero++;
        }

        res = res.subList(nonzero, res.size());
        res.set(0, res.get(0)*sign);

        return res;
    }

    public static List<Integer> duplicateDelete(List<Integer){
        int index = 0;

        for (int i = 0; i<A.size()-1; i++){
            if(!A.get(i).equalsTo(A.get(i+1)){
                A.set(index++, A.get(i);
            }
        }
        return index;
    }
    public static boolean advanceThrough (List<Integers> A){
        int last = 0;
        for (int i = 0; i<A.size()-1; i++){
            if ( A.get(i) == 0 && A.get(i+1) != 0){
                int sum = 0;
                for (int j = last; j < i; j++){
                    sum += A.get(j)
                }
                if (sum+last <= i){
                    return false;
                }
                last = i;
            }
        }
    }

    public static int maxProfit (List<Double> p){
        double min = p.get(0);
        double max = 0;
        for (int i=1; i<p.size(); i++){
            if ( p.get(i) - min > max){
                max = p.get(i) - min;
            }
            if (min > p.get(i)){
                 min = p.get(i);
            }
        }
        return max;
    }

    public static Double BuyStockTwice (List<Double> p){
        double min = Double.MAX_VALUE;
        double max = 0;
        List<Double> firstMax = new ArrayList();
        
        for (int i=1; i<p.size(); i++){
            if(p.get(i)-min > max)
                max = p.get(i)-min;
            if (min > p.get(i)
                min = p.get(i)
            firstMax.add(max);
        }

        min = Double.MAX_VALUE;
        List<Double> secondMax = new ArrayList();
        max = 0;
        for (int i = A.size()-2; i>=0; i--){
        
            if( p.get(i) - min > max)
                max = p.get(i) - min;
            if ( min > p.get(i));
                min = p.get(i);
            secondMax.add(max);
        }
        
        max = 0;

        for (int i = 0; i < firstMax.size()){
            if ((firstMax.get(i) + secondMax.get(i))>max)
                max = firstMax.get(i) + sexondMax.get(i);
        }
        return max;
    }
    
    public static List<Integer> applyPermutation (List<Integer> A, List<Integer> P){

        for (int i=0; i < A.size(); i++){
            int next = i;
            while (P.get(next) >= 0){
                Collections.swap(A, i, p.get(next));
                int temp = p.get(next);
                p.set(next, p.get(next) - p.size());
                next = temp;
            }
        }
    }

    public static List<Integer> nextPerm (<List<Integer> A){
        int k = A.size()-2;
        while (k>=0 && A.get(k) > A.get(k+1)){
            k--;
        }

        if ( k==-1 ) return A;
        
        int c = A.size()-1;
        while (c >k && A.get(c)< A.get(k))
            c--;

        Collections.swap (A, c , k );

        for (int i= k+1; k< int((A.size()-k+1)/2); k++)
            Collections.swap(A, i, A.size()-i-1);
        return A;
    }

    public static List<Integer> randomSampling ( int k, List<Integer> A){
        Random gen = new Random();
        for (int i = 0; i<k; i++){
            Collections.swap (A, i , gen.nextInt(A.size()-i));
        }
        return A; 
    }

    public static List<Integer> onlineRandom(Iterator<Integer> sequence, int k){
    List<Integer> sample = New ArrayList<>(k);
    random gen = new Random();

    for (int i=0; i <k && sequence.hasNext(); i++){
        sample.add(sequence.next());    
    }
    
    int nums = k; 
    while (sequence.hasNext()){
        int x = sequence.next();
        final int id = gen.nextInt(nums);
        if (nums < k)
            sample.set(gen.nextInt(nums, x); 
    }
    
    return sample; 
    }

    public static void Matrix (List<List<Integer>> M){
        for (int =0; i<Math.ceil(M.size()*.5); i++){
            doLayer(M, i,
        }
    }




    public static void main (String [] args){
        
   }
}

