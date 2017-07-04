package Currency;

public class CurrencyWordsPL extends CurrencyWords
{
	private final String[] jednostki = { "", "jeden", "dwa", "trzy", "cztery", "piec", "szesc", "siedem", "osiem",
			"dziewiec" };
	private final String[] dziesiatki = { "", "dziesiec", "dwadziescia", "trzydziesci", "czterdziesci", "piecdziesiat",
			"szescdziesiat", "siedemdziesiat", "osiemdziesiat", "dziewiecdziesiat" };
	private final String[] setki = { "", "sto", "dwiescie", "trzysta", "czterysta", "piecset", "szescset", "siedemset",
			"osiemset", "dziewiecset" };
	private final String[] specjalne = { "", "jedenascie", "dwanascie", "trzynascie", "czternascie", "pietnascie",
			"szesnascie", "siedemnascie", "osiemnascie", "dziewietnascie" };

	@Override
	public Object[] convert(double a)
	{

		Object[] tabliczka = new Object[2];
		int[] table =  CurrencyWords.toArrayOfIntegers(a);
		
		if(table[0] >= 1000000)
		{
			throw new ArrayOutOfBound();
		}
		if (table[0] == 0)
		{
			tabliczka[0] = "zero";
		}
		else if (table[0] > 0 &&  table[0] < 1000)
		{
			tabliczka[0] = convertOnes(table[0]);
		}
		else
		{
			tabliczka[0] = convertThousands(table[0]);
		}
		
		tabliczka[1] = table[1];
		
		return tabliczka;
	}
	
	/**
	 * convert number < 1000 to words
	 */
	public String convertOnes(int liczba)
	{
		String liczbaSlownie = null;
		int cyfraJednosci = liczba % 10;
		int cyfraDziesiatek = (liczba / 10) % 10;
		int cyfraSetek = (liczba / 100) % 10;

		if (liczba < 10)
		{
			liczbaSlownie = this.jednostki[liczba];
		}
		if (liczba > 10 && liczba < 20)
		{
			liczbaSlownie = this.specjalne[cyfraJednosci];
		}
		if (liczba == 10 || liczba >= 20 && liczba < 100)
		{
			liczbaSlownie = this.dziesiatki[cyfraDziesiatek] + " " + this.jednostki[cyfraJednosci];
		}
		if (liczba > 110 && liczba < 120)
		{
			liczbaSlownie = this.setki[cyfraSetek] + " " + this.specjalne[cyfraJednosci];
		}
		if (liczba >= 100 && liczba < 111 || liczba >119 && liczba < 1000)
		{
			liczbaSlownie = this.setki[cyfraSetek] + " " + this.dziesiatki[cyfraDziesiatek] + " "
					+ this.jednostki[cyfraJednosci];
		}
		return liczbaSlownie;	
	}
	
	/**
	 * convert number > 1000 to words
	 */
	public String convertThousands(int liczba)
	{
		String liczbaSlownie;
		int grupaTysiecy = liczba/1000;
		
		if (grupaTysiecy >= 1 && grupaTysiecy < 2)
		{
			liczbaSlownie = "tysiac " + convertOnes(liczba%1000);
		}
		else if ((grupaTysiecy >= 2 && grupaTysiecy < 5) || (grupaTysiecy%100 > 20 &&  grupaTysiecy%10 >= 2 && grupaTysiecy%10 < 5))
		{
			liczbaSlownie = convertOnes(liczba/1000) + " " + "tysiace " + convertOnes(liczba%1000);
		}
		else
		{
			liczbaSlownie = convertOnes(liczba/1000) + " " + "tysiecy " + convertOnes(liczba%1000);
		}	
		return liczbaSlownie;
	}
}