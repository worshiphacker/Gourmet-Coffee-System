import java.util.HashMap;
import java.util.ArrayList;

public class Order 
{	
	//单个订单的总金额↓
	public double total;
	//使用ArrayList集合维护商品菜单；尝试HashMap，用于存放假想的点单（某个商品及其对应数量）↓
	public HashMap<CoffeeProduct,Integer> co=new HashMap<CoffeeProduct,Integer>();
	public ArrayList<CoffeeProduct> menu=new ArrayList<CoffeeProduct>();
	
	//构造方法↓
	public Order()
	{
		total=0;
	}
	//初始化点单，装载商品项目，但数量为0↓
	public void init_CoffeeProductOrder(CoffeeProduct coffeeProduct)
	{
		co.put(coffeeProduct,0);
	}
	//获取点单(商品及其数量)↓
	public void addCoffeeProductOrder(CoffeeProduct coffeeProduct,int m)
	{
		int n=co.get(coffeeProduct);//读取HashMap中原有的coffeeProduct数量←
		co.replace(coffeeProduct,n,n+m);//向HashMap中增加m个coffeeProduct←
		total+=m*coffeeProduct.getPrice();
		if(n==0)//保证ArrayList中存有商品←
		{
			menu.add(coffeeProduct);
		}
	}
	//删除点单中的某一商品
	public void deleteCoffeeProductOrder(CoffeeProduct coffeeProduct,int m)
	{
		int n=co.get(coffeeProduct);//读取HashMap中原有的coffeeProduct数量←
		co.replace(coffeeProduct,n,n-m);//在HashMap中归零coffeeProduct←
		total-=m*coffeeProduct.getPrice();
		if(n==0)//保证ArrayList中存有商品←
		{
			menu.add(coffeeProduct);
		}
	}

	//获取点单数量（以索引方式取得）↓
	public int getNumberOfCoffeeProduct(CoffeeProduct index)
	{
		return co.get(index);
	}
	//获取总价格↓
	public double getTotal()
	{
		return total;
	}
	//清空集合（清除全部记录）↓
	public void clear()
	{
		total=0;
		co.clear();
		menu.clear();
	}
	//获取ArrayList中的所有项目（商品）↓
	public CoffeeProduct[] getMembers()
	{
		CoffeeProduct[] members=new CoffeeProduct[menu.size()];
		int i=0;
		for (CoffeeProduct coffeeProduct:menu)
		{
			members[i]=coffeeProduct;
			i++;
		}
		return members;
	}
	//展示订单明细、总金额↓
	public void display()
	{
		for(CoffeeProduct coffeeProduct:menu)
		{
			if(coffeeProduct instanceof Coffee)
			{
				System.out.println(co.get(coffeeProduct)+"---"+((Coffee)coffeeProduct).superToString());
			}
			else if(coffeeProduct instanceof CoffeeBrewer)
			{
				System.out.println(co.get(coffeeProduct)+"---"+((CoffeeBrewer)coffeeProduct).superToString());
			}
			else if(coffeeProduct instanceof CoffeeAccessory)
			{
				System.out.println(co.get(coffeeProduct)+"---"+((CoffeeAccessory)coffeeProduct).superToString());
			}
		}
		System.out.println("Total:"+total);
	}
}
