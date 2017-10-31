import java.util.*;

public class  Mock1{

    public static int checkOdd (int[] array) {
        if (array == null || array.length == 0) return SENTINAL;
        
        Map<Integer, Integer> occurences = new HashMap<Integer, Integer>();

        for (int i=0; i<array.length; i++){
            if (occurences.get(array[i]) == null){
                occurences.put(array[i]], 1);
            } else{
                occurences.put(array[i], occurences.get(array[i])++);
            }
        }

        for (Integer key : occurences.keySet()){
            if ((occurences.get(key) % 2) == 1){
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args){        
    }
}
