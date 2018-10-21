import java.util.HashSet;

public class SubsetHashing {
	
    /* Return true si Tab2 [] est un sous-ensemble de Tab1 [] */
	static boolean isSubset(int Tab1[], int Tab2[], int m, int n)
    {
        if (m == 0 || n == 0 || n > m)
            return false;
        HashSet<Integer> table1 = new HashSet<>(m);

        // Adding elements into HashSet usind add()
       for (int i : Tab1)
        {
            table1.add(i);
        }

        for (int j : Tab2 )
        {
            if (!table1.contains(j))
               return false;
        }
        return true;
    } 
 
    public static void main(String[] args) 
    { 
        int T1[] = {5, 11, 12, 1, 10, 3, 7};
        int T2[] = {11, 1, 3};
        int m = T1.length;
        int n = T2.length;
     
        if(isSubset(T1, T2, m, n))
            System.out.print("Tab2 [] est un sous-ensemble de Tab1 [] ");
        else
            System.out.print("Tab2 [] n'est pas un sous-ensemble de Tab1 []"); 
    }
}


