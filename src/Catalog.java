import java.util.ArrayList;

public class Catalog
{
	//选择采用ArrayList集合，存放商品信息↓
	private ArrayList<CoffeeProduct> menu=new ArrayList<CoffeeProduct>();
	
	//将CoffeeProduct装载进menu里↓
	public void addCoffeeProduct(CoffeeProduct newCoffeeProduct)
	{
		menu.add(newCoffeeProduct);
	}
	//将CoffeeProduct从menu中移除↓
	public void removeCoffeeProduct(CoffeeProduct CoffeeProduct)
	{
		menu.remove(CoffeeProduct);
	}
	//根据CoffeeProduct的code检索，成功则返回相应信息↓
	public CoffeeProduct getCoffeeProduct(String code)
	{
		for (CoffeeProduct coffeeProduct:menu)
		{
			if (coffeeProduct.getCode().equals(code)) return coffeeProduct;
		}
		return null;
	}
	//取得menu中CoffeeProduct的数量，即size↓
	public int getNumberOfCoffeeProduct()
	{
		return menu.size();
	}
	//取得menu中Coffee的数量↓
	public int getNumberOfCoffee()
	{
		int counter=0;
		for (CoffeeProduct coffeeProduct:menu)
		{
			if(coffeeProduct instanceof Coffee) counter++;
		}
		return counter;
	}
	//取得menu中CoffeeBrewer的数量↓
	public int getNumberOfCoffeeBrewer()
	{
		int counter=0;
		for (CoffeeProduct coffeeProduct:menu)
		{
			if(coffeeProduct instanceof CoffeeBrewer) counter++;
		}
		return counter;
	}
	//取得menu中CoffeeAccessory的数量↓
	public int getNumberOfCoffeeAccessory()
	{
		int counter=0;
		for(CoffeeProduct coffeeProduct:menu)
		{
			if(coffeeProduct instanceof CoffeeAccessory) counter++;
		}
		return counter;
	}
	//根据code展示全部信息↓
	public void displayOne(String code)
	{
		boolean judge=false;
		for(CoffeeProduct coffeeProduct:menu)
		{
			if(coffeeProduct.getCode().equals(code))
			{
				judge=true;//防止错误输入←
				if(coffeeProduct instanceof Coffee)
				{
					System.out.println("Coffee:  "+((Coffee)coffeeProduct).toString());
				}
				else if(coffeeProduct instanceof CoffeeBrewer)
				{
					System.out.println("CoffeeBrewer:  "+((CoffeeBrewer)coffeeProduct).toString());
				}
				else if(coffeeProduct instanceof CoffeeAccessory)
				{
					System.out.println("CoffeeAccessory:  "+((CoffeeAccessory)coffeeProduct).toString());
				}
			}
		}
		if(judge==false) System.out.println("No such product!");
	}
	//展示所有项的重要信息（code，price，description）↓
	public void displayAll()
	{
		for(CoffeeProduct coffeeProduct:menu)
		{
			if(coffeeProduct instanceof Coffee)
			{
				System.out.println("Coffee:  "+((Coffee)coffeeProduct).superToString());
			}
			else if(coffeeProduct instanceof CoffeeBrewer)
			{
				System.out.println("CoffeeBrewer:  "+((CoffeeBrewer)coffeeProduct).superToString());
			}
			else if(coffeeProduct instanceof CoffeeAccessory)
			{
				System.out.println("CoffeeAccessory:  "+((CoffeeAccessory)coffeeProduct).superToString());
			}
		}
	}
}
