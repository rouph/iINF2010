import java.util.ArrayList;
import java.util.Random;

public class QuadraticSpacePerfectHashing<AnyType> 
{
	static int p = 46337;

	int a, b;
	AnyType[] items;

	QuadraticSpacePerfectHashing()
	{
		a = b = 0; items = null;
	}

	QuadraticSpacePerfectHashing(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public int Size()
	{
		if( items == null ) return 0;

		return items.length;
	}

	public boolean containsKey(int key)
	{
		return !(items[key] == null);
	}

	public boolean containsValue(AnyType x )
	{
		if(Size() == 0)
		{
			return false;
		}
		return x.equals(items[getKey(x)])  ? true : false;
	}

	public void remove (AnyType x)
	{
		if(containsValue(x))
		{
			items[getKey(x)] = null;
		}
	}

	public int getKey (AnyType x)
	{
		int temp = ((( a * x.hashCode() + b ) % p ) % items.length);
		return temp;
	}

	@SuppressWarnings("unchecked")
	private void AllocateMemory(ArrayList<AnyType> array)
	{
		Random generator = new Random( System.nanoTime() );
		if(array == null || array.size() == 0)
		{
			items = null;
			return;
		}
		if(array.size() == 1)
		{
			a = b = 0;
			items = (AnyType[]) new Object[1];
			items[0] = array.get(0);
			return;
		}
		boolean collision = false;
		do{
			collision = false;
			a = generator.nextInt(p - 1) + 1;
			b = generator.nextInt(p);
			items = (AnyType[]) new Object[ array.size() * array.size() ];
			for (AnyType element : array) {
				if (!containsKey(getKey(element))) {
					items[getKey(element)] = element;
				} else {
					collision = true;
				}
			}
		}while(collision);
		/* Si une collision a ete detecte on regenere
		 les a et b et on recommence le processus de dispersement*/
		return;
	}

	public String toString () {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null)
				result.append( "( "  + getKey(items[i]) + ", " + items[i] + "), ");
		}
		result.setCharAt(result.length()- 2, '.'); /* pour remplace la derniere virgule par un point*/
		return result.toString();
	}

	public void makeEmpty () {
		for(int i = 0; i < Size() ; i++)
		{
			remove(items[i]);
		}
   	}
}
