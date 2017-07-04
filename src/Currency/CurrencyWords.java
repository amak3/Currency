package Currency;

public abstract class CurrencyWords implements Converter
{
	public static int[] toArrayOfIntegers(double a)
	{
		int[] tablica = new int[2];
		tablica[0] = (int)a;
		tablica[1] = (int)(a*100)%100;
		return tablica;
	}

	public abstract Object[] convert(double a);
}
