package genericUtility;

import java.util.Random;

/**
 * 
 * @author Shivakumar
 *
 */

public class JavaUtility 
{
	public int getRandomNumber()
	{
		Random ran = new Random();
		int value = ran.nextInt(1000);
		return value;
	}

}
