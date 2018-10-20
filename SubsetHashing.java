import java.util.HashSet;

public class SubsetHashing {
	
    /* Return true si Tab2 [] est un sous-ensemble de Tab1 [] */
	static boolean isSubset(int Tab1[], int Tab2[], int m, int n)
    {
        // compléter
        HashSet<Integer> table1 = new HashSet<Integer>(m);

        // Adding elements into HashSet usind add()
       for (int i = 0; i < m; i++)
        {
            table1.add(Tab1[i]);
        }

        for (int j = 0; j < n; j++)
        {
            if (!table1.contains(Tab2[j]))      //add a counter pour pa mettre !...
               return false;
        }
        return true;
    } 
 
    public static void main(String[] args) 
    { 
        int T1[] = {5, 11, 12, 1, 10, 3, 7};
        int T2[] = {11, 1, 10};
        int m = T1.length;
        int n = T2.length;
     
        if(isSubset(T1, T2, m, n))
            System.out.print("Tab2 [] est un sous-ensemble de Tab1 [] ");
        else
            System.out.print("Tab2 [] n'est pas un sous-ensemble de Tab1 []"); 
    }
}


