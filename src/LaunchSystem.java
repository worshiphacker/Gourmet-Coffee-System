import java.util.Scanner;
public class LaunchSystem 
{
	public static void main(String[] args)
	{
		//初始化定义↓
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		Catalog catalog=new Catalog();
		Order currentOrder =  new Order();
		//Coffee商品信息集成在代码内（信息来自PPT），并加入catalog目录、点单初始化↓
		CoffeeProduct[] c=new CoffeeProduct[4];
		c[0]=new Coffee("C001","Columbia,Whole,1 lb",17.99,"Columbia","Medium","Rich and hearty","Rich","Medium","Full");
		c[1]=new Coffee("C002","Columbia,Ground,1 lb",18.75,"Columbia","Medium","Rich and hearty","Rich","Medium","Full");
		c[2]=new Coffee("C007","Guatemala,Whole,1 lb",17.99,"Guatemala","Medium","Rich and complex","Spicy","Medium to high","Medium to full");
		c[3]=new Coffee("C008","Guatemala,Ground,1 lb",18.75,"Guatemala","Medium","Rich and complex","Spicy","Medium to high","Medium to full");
		for(int l=0;l<c.length;l++)
		{
			catalog.addCoffeeProduct(c[l]);
			currentOrder.init_CoffeeProductOrder(c[l]);
		}
		//CoffeeBrewer商品信息集成在代码中（信息来自PPT），并加入catalog目录、点单初始化↓
		CoffeeProduct[] cb=new CoffeeProduct[5];
		cb[0]=new CoffeeBrewer("B001","Home Coffee Brewer",150.00,"Brewer 100","Pourover",6);
		cb[1]=new CoffeeBrewer("B002","Coffee Brewer,2 Warmers",200.00,"Brewer 200","Pourover",12);
		cb[2]=new CoffeeBrewer("B003","Coffee Brewer,3 Warmers",200.00,"Brewer 210","Pourover",12);
		cb[3]=new CoffeeBrewer("B004","Commercial Brewer,20 cups",380.00,"Quick Coffee 100","Automatic",20);
		cb[4]=new CoffeeBrewer("B005","Commercial Brewer,40 cups",480.00,"Quick Coffee 200","Automatic",40);
		for(int l=0;l<cb.length;l++)
		{
			catalog.addCoffeeProduct(cb[l]);
			currentOrder.init_CoffeeProductOrder(cb[l]);
		}
		//CoffeeAccessory商品信息集成在代码中（信息来自PPT），并加入catalog目录、点单初始化↓
		CoffeeProduct[] ca=new CoffeeProduct[5];
		ca[0]=new CoffeeAccessory("A001","Almond Flavored Syrup",9.00);
		ca[1]=new CoffeeAccessory("A002","Irish Creme Flavored Syrup",9.00);
		ca[2]=new CoffeeAccessory("A005","Gourmet Coffee Cookies",12.00);
		ca[3]=new CoffeeAccessory("A007","Gourmet Coffee Ceramic Mug",8.00);
		ca[4]=new CoffeeAccessory("A009","Gourmet Coffee 36 Cup Filters",45.00);
		for(int l=0;l<ca.length;l++)
		{
			catalog.addCoffeeProduct(ca[l]);
			currentOrder.init_CoffeeProductOrder(ca[l]);
		}
		//根据以上三类内容，即可创建总类GourmetCoffeeSystem↓
		GourmetCoffeeSystem gcs=new GourmetCoffeeSystem(catalog,currentOrder);
		int choice;
		System.out.println("[0] Quit");
		System.out.println("[1] Display catalog");
		System.out.println("[2] Display product");
		System.out.println("[3] Display current order");
		System.out.println("[4] Add modify product to current order");
		System.out.println("[5] Remove product from current order");
		System.out.println("[6] Register sale of current order");
		System.out.println("[7] Display sales");
		System.out.println("[8] Display number of orders with a specific product");
		System.out.println("[9] Display the total quantity sold for each prooduct");
		Order[] sales = new Order[20];
		sales[0] = new Order();
		sales[1] = new Order();
		sales[2] = new Order();
		int j=0;
		int i;
		do {
			System.out.print("choice>");
			choice = in.nextInt();
			switch(choice) {
				case 0:
					break;
				case 1:
					//展示目录↓,无需输入
					gcs.displayCatalog();
					break;
				case 2:
					//展示某一商品详情↓，输入code即可，如B001
					String code1=in.next();
					gcs.displayCoffeeProduct(code1);
					break;
				case 3:
					//当前购买前的点单↓，无需输入
					System.out.println("\nCurrent Order:");
					gcs.displayCurrentOrder();
					break;
				case 4:
					//购买↓，输入code-数量，如B001-10，代表购买BOO1商品10个
					String string1=in.next();
					String[] p1=string1.split("-");
					int q1=Integer.parseInt(p1[1]);
					while(!p1[0].equals("0"))
					{
						gcs.purchase(p1[0], q1);
						string1=in.next();
						System.arraycopy(string1.split("-"), 0, p1, 0, string1.split("-").length);
						q1=Integer.parseInt(p1[1]);
					}
					break;
				case 5:
					//取消某一商品的购买，输入code-数量，如B001-10，代表减少购买B001商品10件
					//下面两行代码无用
					//Coffee coffee=new Coffee("2sed","3e32f",23.33,"33r","crejv","467734","nvnbt","9ju7","47648");
					//gcs.addProduct(coffee);
					String string3=in.next();
					String[] p3=string3.split("-");
					int q3=Integer.parseInt(p3[1]);
					while(!p3[0].equals("0"))
					{
						gcs.cancel(p3[0], q3);
						string3=in.next();
						System.arraycopy(string3.split("-"), 0, p3, 0, string3.split("-").length);
						q1=Integer.parseInt(p3[1]);
					}
					break;
				case 6:
					//把order添加到sale
					sales[j].co.putAll(currentOrder.co);
					//清空currentOrder
					currentOrder.clear();
					//Order currentOrder=new Order();
					for(int l=0;l<c.length;l++)
					{
						currentOrder.init_CoffeeProductOrder(c[l]);
					}
					for(int l=0;l<cb.length;l++)
					{
						currentOrder.init_CoffeeProductOrder(cb[l]);
					}
					for(int l=0;l<ca.length;l++)
					{
						currentOrder.init_CoffeeProductOrder(ca[l]);
					}
					j++;
					break;
				case 7:
					//展示每个订单
					double total=0;
					for(i=0;i<j;i++){
						System.out.printf("Order：%d\n",i+1);
						for (CoffeeProduct key : sales[i].co.keySet()) {
							if(sales[i].co.get(key)!=0){
							System.out.println("产品："+ key + "	数量：" + sales[i].co.get(key));//打印订单产品数量和信息
							total = total + sales[i].co.get(key) * key.price;//计算订单产品的总价
						}
					}
						System.out.printf("Total: %.1f\n",total);
				}
					break;
				case 8:
					//显示特定产品的订单数量
					String string4 = in.next();
					int count1 = 0;
					for(i=0;i<j;i++){
						for (CoffeeProduct key : sales[i].co.keySet()) {
							if(key.code.equals(string4) && sales[i].co.get(key)!=0){
								count1 = count1+1;
							}
						}
					}
					System.out.printf("The order of " + string4 + " is %d\n",count1);
					break;
				case 9:
					//显示每个产品的总销售量
					String string5 = in.next();
					int count2 = 0;
					for(i=0;i<j;i++){
						for (CoffeeProduct key : sales[i].co.keySet()) {
							if(key.code.equals(string5)){
								count2 = count2 + sales[i].co.get(key);
							}
						}
					}
					System.out.printf("The order of " + string5 + " is %d\n",count2);
					break;
			}
		}while(choice!=0);
	}
	//hashmap clear方法后currentorder内存就被回收了，因此需要封装一个生成并初始化currentOreder的函数
	/*public Order generate_Currentorder(CoffeeProduct c[],CoffeeProduct cb[], CoffeeProduct ca[])
	{
		Order currentOrder=new Order();
		for(int l=0;i<c.length;l++)
		{
			currentOrder.init_CoffeeProductOrder(c[l]);
		}
		for(int l=0;i<cb.length;l++)
		{
			currentOrder.init_CoffeeProductOrder(cb[l]);
		}
		for(int l=0;l<ca.length;l++)
		{
			currentOrder.init_CoffeeProductOrder(ca[l]);
		}
		return currentOrder;
	}
	*/

}

