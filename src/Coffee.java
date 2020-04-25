public class Coffee extends CoffeeProduct
{
	private String countryOfOrigin;
	private String typeOfRoast;
	private String flavor;
	private String aroma;
	private String acidity;
	private String body;
	
	//构造方法↓
	public Coffee(String code,String description,double price,String countryOfOrigin,
			String typeOfRoast,String flavor,String aroma,String acidity,String body)
	{
		super(code,description,price);
		this.countryOfOrigin=countryOfOrigin;
		this.typeOfRoast=typeOfRoast;
		this.flavor=flavor;
		this.aroma=aroma;
		this.acidity=acidity;
		this.body=body;
	}
	//获取各自属性的方法↓
	public String getCountryOfOrigin()
	{
		return countryOfOrigin;
	}
	public String getTypeOfRoast()
	{
		return typeOfRoast;
	}
	public String getFlavor()
	{
		return flavor;
	}
	public String getAroma()
	{
		return aroma;
	}
	public String getAcidity()
	{
		return acidity;
	}
	public String getBody()
	{
		return body;
	}
	//联合属性的方法↓
	public String toString()
	{
		return super.toString()+"---"+countryOfOrigin+"---"+typeOfRoast+"---"
				+flavor+"---"+aroma+"---"+acidity+"---"+body;
	}
	//仅获取重要属性（code，description，price）的方法↓
	public String superToString()
	{
		return super.toString();
	}
}
