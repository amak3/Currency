package Currency;

import java.util.Arrays;

public class Runner 
{
    public static void main(String[] args)
    {
    	CurrencyWordsPL obiekt = new CurrencyWordsPL();
    	for(int i=0; i<args.length; i++)
    	{    		

			try
			{
				try
				{
					double argument = Double.parseDouble(args[i]);
					System.out.println(Arrays.toString(obiekt.convert(argument))); 
				} catch (NumberFormatException e)
				{
					throw new AmountUninterpretable();
				}
			} catch (AmountUninterpretable e)
			{
				e.printStackTrace();
			}
			catch (ArrayOutOfBound e)
			{
				e.printStackTrace();
			}
    	}
    }
}


