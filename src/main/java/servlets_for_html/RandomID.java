package servlets_for_html;



public class RandomID 
{
	public long getId()
	{
		Random r=new Random();
		long id = 1000000000L + (long)(r.nextDouble() * 8999999999L);
	
		return id;
	}
}
