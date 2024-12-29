package javadt07dec;
class Sender
{
	public void send(String msg)
	{
		
		System.out.println("Sending "+msg);
		
		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(msg+" Sent");
		
	}
}

class ThreadSend extends Thread
{
	Sender sender;//refrence variable
	String msg;//variable
	private Sender sender2;
	
	public ThreadSend(Sender sender,String msg) 
	{
	
		this.sender=sender;
		this.msg=msg;
	}
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		//super.run();
		
		asynchronized (sender) ;
		{
			sender.send(msg);
		}
		
	}

	private void asynchronized(Sender sender2) {
		// TODO Auto-generated method stub
		this.sender2 = sender;
	}
}
public class syncEX {
	public static void main(String[] args) 
	{
		Sender sender = new Sender();
		
		ThreadSend t1 = new ThreadSend(sender,"Hii");
		ThreadSend t2 = new ThreadSend(sender, "Byee");
		
		t1.start();
		t2.start();
		
	}

}
