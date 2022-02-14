import java.util.Scanner;

// class for payment related operation
class Payment
{
	// method for calculate finalPrice
	   public float findFinalPrice(float priceOfProdcuts)
	   {
		      // Initialized the variable  store amount and discount
		      float totalPayableAmount = 0,discount = 0;
		      
		      if(priceOfProdcuts<=0)
		      {
		    	  System.out.println("Price of Product Cannot Negative");
		      }
		      // No Discount
		      else if(priceOfProdcuts<=5)
		      {
		         totalPayableAmount = priceOfProdcuts;
		      }
		      //  Discount 2$ if bought between 5$ to 30$
		      else if(priceOfProdcuts>5 && priceOfProdcuts<=30)  // 
		      {
		         discount = (priceOfProdcuts*2)/100;   
		         totalPayableAmount = priceOfProdcuts - discount;
		      }
		      // Discount 3% if bought from 30$ and less than 80$
		      else if(priceOfProdcuts>30 && priceOfProdcuts<=80)
		      {
		         discount = (priceOfProdcuts*3)/100;
		         totalPayableAmount = priceOfProdcuts - discount;
		      }
		      // Discount 7% if bought from 80$ and less than 150$
		      else if(priceOfProdcuts>80 && priceOfProdcuts<=150)
		      {
		         discount = (priceOfProdcuts*7)/100;
		         totalPayableAmount = priceOfProdcuts - discount;
		      }
		      // Discount 12% if bought from 150$ and less than 300$
		      else if(priceOfProdcuts>150 && priceOfProdcuts<=300)
		      {
		         discount = (priceOfProdcuts*12)/100;
		         totalPayableAmount = priceOfProdcuts - discount;
		      }
		      // Discount 25% if bought from 300$ and above
		      else 
		      {
		         discount = (priceOfProdcuts*25)/100;
		         totalPayableAmount = priceOfProdcuts - discount;
		      }
			return totalPayableAmount;
	   }
}
public class Main
{

   // Entry point method
   public static void main(String[] args)
   {
	  while(true)
	  {
		  Payment obj = new Payment();
       // Initialized the variable  store amount and discount	  
      float priceOfProdcuts, totalPayableAmount = 0, discount;
      
      // taking input from user
      Scanner input = new Scanner(System.in);
      System.out.print("\nEnter price of the product - ");
      priceOfProdcuts = input.nextFloat();
	  // printing the price of the product
      System.out.print("money a customer needed to pay after discount: " + obj.findFinalPrice(priceOfProdcuts));
	  }
   }
}
