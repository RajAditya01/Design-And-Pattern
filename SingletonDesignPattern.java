// Double Checked Locking based Java implementation of
// singleton design pattern
class SingletonDesignPattern
{
	private static volatile SingletonDesignPattern obj = null;

	private SingletonDesignPattern() {}

	public static SingletonDesignPattern getInstance()
	{
		if (obj == null)
		{
			// To make thread safe
			synchronized (SingletonDesignPattern.class)
			{
				// check again as multiple threads
				// can reach above step
				if (obj==null)
					obj = new SingletonDesignPattern();
			}
		}
		return obj;
	}
}

