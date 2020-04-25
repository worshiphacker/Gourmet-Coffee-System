public class CoffeeBrewer extends CoffeeProduct
{
	private String modelOfTheBrewer;
	private String typeOfTheWaterSupply;
	private int capacity;
	
	//构造方法↓
	public CoffeeBrewer(String code,String description,double price,
			String modelOfTheBrewer,String typeOfTheWaterSupply,int capacity)
	{
		super(code,description,price);
		this.modelOfTheBrewer=modelOfTheBrewer;
		this.typeOfTheWaterSupply=typeOfTheWaterSupply;
		this.capacity=capacity;
	}
	//获取属性的方法↓
	public String getModelOfTheBrewer()
	{
		return modelOfTheBrewer;
	}
	public String getTypeOfTheWaterSupply()
	{
		return typeOfTheWaterSupply;
	}
	public int getCapacity()
	{
		return capacity;
	}
	//联合属性的方法↓
	public String toString()
	{
		return super.toString()+"---"+modelOfTheBrewer+"---"+typeOfTheWaterSupply+"---"+capacity;
	}
	//仅获取重要属性（code，description，price）的方法↓
	public String superToString()
	{
		return super.toString();
	}
}
