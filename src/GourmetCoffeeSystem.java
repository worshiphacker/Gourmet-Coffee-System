//总类，集成各种功能
public class GourmetCoffeeSystem
{
	private Catalog catalog;
	private Order currentOrder;
	
	//构造方法↓
	public GourmetCoffeeSystem(Catalog catalog,Order currentOrder)
	{
		this.catalog=catalog;
		this.currentOrder=currentOrder;
	}
	//展示菜单↓
	public void displayCatalog()
	{
		catalog.displayAll();
	}
	//根据code展示商品↓
	public void displayCoffeeProduct(String code)
	{
		catalog.displayOne(code);
	}
	//展示当前点单信息↓
	public void displayCurrentOrder()
	{
		currentOrder.display();
	}
	//增加新商品（同时添加到菜单和售卖交互Sale的初始化中）↓
	public void addProduct(CoffeeProduct newCoffeeProduct)
	{
		catalog.addCoffeeProduct(newCoffeeProduct);
	}
	//下架某商品（从菜单中移除）↓
	public void removeProduct(String code)
	{
		CoffeeProduct coffeeProduct=catalog.getCoffeeProduct(code);
		catalog.removeCoffeeProduct(coffeeProduct);
	}
	//将currentOrder的点单信息装载到sale里，自身清空（Order类强调临时性）↓

	//用于交互，提交到currentOrder中↓
	public void purchase(String code,int n)
	{
		CoffeeProduct c=catalog.getCoffeeProduct(code);
		currentOrder.addCoffeeProductOrder(c,n);
	}
	public void cancel(String code,int n)
	{
		CoffeeProduct c=catalog.getCoffeeProduct(code);
		currentOrder.deleteCoffeeProductOrder(c,n);
	}

}
