public class CoffeeProduct 
{
	public String code;
	public String description;
	public double price;
	
	//构造方法↓
	public CoffeeProduct(String code,String description,double price)
	{
		this.code=code;
		this.description=description;
		this.price=price;
	}
	//三个获取属性的方法↓
	public String getCode()
	{
		return code;
	}
	public String getDescription()
	{
		return description;
	}
	public double getPrice()
	{
		return price;
	}
	//联合属性的方法↓
	public String toString()
	{
		return code+"---"+description+"---"+price;
	}
	
}
