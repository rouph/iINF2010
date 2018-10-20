import java.util.Random;
import java.util.ArrayList;

public class LinearSpacePerfectHashing<AnyType>
{
	static int p = 46337;

	QuadraticSpacePerfectHashing<AnyType>[] data;
	int a, b;

	LinearSpacePerfectHashing()
	{
		a = b = 0; data = null;
	}

	LinearSpacePerfectHashing(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	public void SetArray(ArrayList<AnyType> array)
	{
		AllocateMemory(array);
	}

	@SuppressWarnings("unchecked")
	private void AllocateMemory(ArrayList<AnyType> array)
	{
		Random generator = new Random( System.nanoTime() );

		if(array == null || array.size() == 0)
		{
			data = null;
			return;
		}
		if(array.size() == 1)
		{
			a = b = 0;
			data =  new QuadraticSpacePerfectHashing[array.size()];
			data[0] = new QuadraticSpacePerfectHashing(array);
			return;
		}
		a = generator.nextInt(p);
		b = generator.nextInt(p);
		data =  new QuadraticSpacePerfectHashing[array.size()];
		ArrayList<AnyType>[] temp = new ArrayList[array.size()];
		for(int i = 0; i < array.size(); i++)
		{
			AnyType element = array.get(i);
			if (temp[getKey(element)] == null)
				temp[getKey(element)] = new ArrayList<>();
			temp[getKey(array.get(i))].add(element);
		}
		for(int i = 0; i < array.size(); i++)
		{
			if (temp[i] != null) {
				data[i] = new QuadraticSpacePerfectHashing(temp[i]);
			}
		}
	}

	public int Size()
	{
		if( data == null ) return 0;

		int size = 0;
		for(int i=0; i<data.length; ++i)
		{
			size += (data[i] == null ? 1 : data[i].Size());
		}
		return size;
	}

	public boolean containsKey(int key)
	{
		return !(data[key] == null);

	}
	
	public int getKey (AnyType x) {
		return ((a * x.hashCode() + b) % p) % data.length ;
	}
	
	public boolean containsValue (AnyType x) {
		if(data == null)
		{
			return false;
		}
		if (data[getKey(x)] != null)
			return data[getKey(x)].containsValue(x);
		return false;
	}
	
	public void remove (AnyType x) {
		// A completer
		
	}

	public String toString () {
		String result = "";
		
	for(int i = 0 ; i < data.length; i++) {
		if(data[i] != null)
		result += i + " / " + data[i].toString() + "---";
	}
		return result;
	}

	public void makeEmpty () {
		for(int i = 0; i < data.length; i++)
		{
			data[i] =null;
		}
   	}
	
}
