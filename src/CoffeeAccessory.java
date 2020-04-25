public class CoffeeAccessory extends CoffeeProduct
{
	//构造方法↓
	public CoffeeAccessory(String code,String description,double price)
	{
		super(code,description,price);
	}
	public String superToString()
	{
		return super.toString();
	}
}
