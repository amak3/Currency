package Currency;

public class AmountUninterpretable extends RuntimeException
{
	public AmountUninterpretable()
	{
		super("kwota nierozpoznana");
	}

}