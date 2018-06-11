package cs401_Project;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Coupon_Inventory_System {

	private static LinkedListArray<Coupon> coupon_list = new LinkedListArray<Coupon>();
	private static Sorted_LinkedList_Array<Coupon> sorted_coupon_list;
	static int search_count,flag;
	public static void main(String[] args) throws Exception{

		String readLine;
		String[] readLineSplited;
		Scanner scan = new Scanner(System.in);
		for(;;)
		{
			System.out.println("---------------------------------------------");
			System.out.println("WELCOME TO CS 401 COUPON INVENTORY SYSTEM");
			System.out.println("THIS IS THE MENU ");
			System.out.println("---------------------------------------------");
			System.out.println("1. Purchase Coupons");
			System.out.println("2. Search Coupons ");
			System.out.println("3. List of all the Coupons");
			System.out.println("4. Exit");
			System.out.println("---------------------------------------------");


			int menu_entry = scan.nextInt();

			if(menu_entry == 1)
			{
				System.out.println("\nThis is the section to input the data both manually or through a file\n");
				System.out.println("---------------------------------------------------------------------------");

				for(;;)
				{
					System.out.println("Enter the mode of input[FILE, MANUAL or EXIT]");

					String input_entry = scan.next();

					if(input_entry.equalsIgnoreCase("FILE"))
					{
						System.out.println("ENTER THE PATH OF INPUT FILE");
						System.out.println("---------------------------------------------");
						String file_name = scan.next();
						File input_file = new File(file_name);
						int i = 0;
						Scanner scan_file = new Scanner(input_file);

						while(scan_file.hasNextLine()){	
							readLine = scan_file.nextLine();
							readLineSplited= readLine.split(" ");
							double final_price = Double.parseDouble(readLineSplited[2]) - (Double.parseDouble(readLineSplited[2]) * Integer.parseInt(readLineSplited[3]) / 100);
							Coupon new_coupon = new Coupon(readLineSplited[0],readLineSplited[1], Double.parseDouble(readLineSplited[2]), Integer.parseInt(readLineSplited[3]),final_price ,Integer.parseInt(readLineSplited[4]), readLineSplited[5]); 
							coupon_list.add(new_coupon);
							i++;
						}
						System.out.println("Coupons from the input file has been updated successfully");
						System.out.println("----------------------------------------------------------");
					}
					else if(input_entry.equalsIgnoreCase("MANUAL"))
					{
						for(;;){

							System.out.println("Enter NEXT for adding new coupon and EXIT to stop adding manually ");
							String next_coupon=scan.next();

							if(next_coupon.equalsIgnoreCase("exit"))
							{
								break;
							}
							else if(next_coupon.equalsIgnoreCase("next"))
							{
								System.out.println("---------------------------------------------");
								System.out.println("Enter the values of the coupons");
								System.out.println("Enter the input for Coupon provider ");
								String provider_name =scan.next();
								System.out.println("Enter the input for the product name");
								String prod_name = scan.next();
								System.out.println("Enter the input for price ");
								double prod_price = scan.nextDouble();
								System.out.println("Enter the input for discount");
								int prod_discount = scan.nextInt();
								System.out.println("Enter the input for expiration days");
								int exp_days = scan.nextInt();
								System.out.println("Enter the status of the coupon");
								String status = scan.next();

								double final_price = prod_price - (prod_price*prod_discount/100);

								Coupon new_coupon = new Coupon(provider_name, prod_name, prod_price, prod_discount,final_price, exp_days, status); 
								coupon_list.add(new_coupon);
								System.out.println("The new coupon has been added successfully");
								System.out.println("---------------------------------------------");
							}
						}
					}
					else if(input_entry.equalsIgnoreCase("EXIT"))
					{
						break;
					}
					else
						System.out.println("INVALID USER INPUT - TYPE FILE OR MANUAL OR EXIT BASED ON YOUR CHOICE");
				}
			}
			else if(menu_entry == 2)
			{
				System.out.println("This is the section to search for the coupon(s)");
				System.out.println("---------------------------------------------");
				search_count=0;
				flag=0;
				int count_linear=0;
				int count_BST=0;
				int count_not_linear=0;
				Scanner scan_search = new Scanner(System.in);
				System.out.println("ENTER THE DETAIL OF THE COUPON [COUPON PROVIDER NAME OR COUPON PRODUCT NAME]");
				String coupon_prod = scan_search.next();


				linear_search(coupon_prod);
				Coupon cou =new Coupon();
				Coupon cou1 =new Coupon();
				cou.setProduct_name(coupon_prod);
				Sorted_LinkedList_Array<Coupon> coupon_list_sort2 = new Sorted_LinkedList_Array<Coupon>(cou1.Coupon_Product_Comparator());
				for(int p=0;p< coupon_list.size();p++)
				{
					coupon_list_sort2.add(coupon_list.get(p));
				}


				int binary_count = binarysearch(coupon_list_sort2,coupon_prod,0,coupon_list.size());
				if(flag != 1)
				{
					System.out.println("NO COUPON COUNT");
					System.out.println("The SEARCH COUNT IN BINARY SEARCH IS :  "+search_count);
				}

			}

			else if(menu_entry == 3)
			{
				System.out.println("This is the section to list all the coupons based on user's choice");
				System.out.println("---------------------------------------------");

				Coupon obj = new Coupon();
				Scanner scan4 = new Scanner(System.in);
				System.out.println("ENTER THE PARAMETER OF COUPON AND IT WILL LISTED ACCORDINGLY [provider, price, final_ price, discount, expiration, product or status]");
				String coupon_parameter = scan4.next();
				if(coupon_parameter.equalsIgnoreCase("provider"))
				{
					Sorted_LinkedList_Array<Coupon> coupon_list_sort1 = new Sorted_LinkedList_Array<Coupon>(obj.Coupon_Provider_Comparator());
					adding_sorted_array(coupon_list_sort1);
				}
				else if(coupon_parameter.equalsIgnoreCase("product"))	
				{
					Sorted_LinkedList_Array<Coupon> coupon_list_sort2 = new Sorted_LinkedList_Array<Coupon>(obj.Coupon_Product_Comparator());
					adding_sorted_array(coupon_list_sort2);
				}
				else if(coupon_parameter.equalsIgnoreCase("price"))
				{
					Sorted_LinkedList_Array<Coupon> coupon_list_sort3 = new Sorted_LinkedList_Array<Coupon>(obj.Coupon_Price_Comparator());
					adding_sorted_array(coupon_list_sort3);
				}
				else if(coupon_parameter.equalsIgnoreCase("discount"))
				{
					Sorted_LinkedList_Array<Coupon> coupon_list_sort4 = new Sorted_LinkedList_Array<Coupon>(obj.Coupon_Discount_Comparator());
					adding_sorted_array(coupon_list_sort4);
				}
				else if(coupon_parameter.equalsIgnoreCase("expiration"))	
				{
					Sorted_LinkedList_Array<Coupon> coupon_list_sort5 = new Sorted_LinkedList_Array<Coupon>(obj.Coupon_Expiration_Comparator());
					adding_sorted_array(coupon_list_sort5);
				}
				else if(coupon_parameter.equalsIgnoreCase("status"))
				{
					Sorted_LinkedList_Array<Coupon> coupon_list_sort6 = new Sorted_LinkedList_Array<Coupon>(obj.Coupon_Status_Comparator());
					adding_sorted_array(coupon_list_sort6);
				}

				else if(coupon_parameter.equalsIgnoreCase("final_Price"))
				{
					Sorted_LinkedList_Array<Coupon> coupon_list_sort7 = new Sorted_LinkedList_Array<Coupon>(obj.Coupon_Final_Price_Comparator());
					adding_sorted_array(coupon_list_sort7);
				} 
				else 
				{
					System.out.println("INVALID PARAMETER");
				}
			}

			else if(menu_entry == 4)
			{
				System.out.println("THANK YOU. EXITING THE PROGRAM");
				System.out.println("---------------------------------------------");
				break;

			}			

		}
	}

	public static void linear_search(String coupon_entry)
	{

		LinkedList n = new LinkedList();
		int count_not_linear=0;
		for(int m=0; m< coupon_list.size();m++){

			if(coupon_list.get(m).getProduct_name().equalsIgnoreCase(coupon_entry) 
					|| coupon_list.get(m).getCoupon_provider().equalsIgnoreCase(coupon_entry)
					|| coupon_list.get(m).getStatus_coupon().equalsIgnoreCase(coupon_entry) )
			{
				n.add(coupon_list.get(m));
				n.add(m);
			}
			else
			{
				count_not_linear=m;
			}
		}
		if(n.size() == 0)
		{
			System.out.println("NO COUPON FOUND");
			System.out.println("THE SEARCH COUNT BY LINEAR SEARCH ALGORITHM IS : " + count_not_linear);
		}
		else
		{
			System.out.println("COUPON IS FOUND");


			for (int a =0; a<n.size();a+=2){
				System.out.println("SEARCH COUNT FOR LINEAR SEARCH IS " + n.get(a+1));
				System.out.println(" And the coupon is :"+n.get(a));

			}
		}
	}

	public static void adding_sorted_array(Sorted_LinkedList_Array<Coupon> coupon_list_sort){

		for(int p=0;p< coupon_list.size();p++)
		{
			coupon_list_sort.add(coupon_list.get(p));
		}

		for(int p=0;p< coupon_list_sort.size();p++)
		{
			System.out.println((p+1)+". "+ coupon_list_sort.get(p));
		}
	}

	public static int binarysearch(Sorted_LinkedList_Array<Coupon> sorted_list,String target,int first,int last)
	{

		int midpoint=(first+last)/2;
		if(first>last)
			return -1;
		else if(target.equalsIgnoreCase(sorted_list.get(midpoint).getProduct_name()))
		{    
			search_count++;
			flag=1;
			System.out.println("The SEARCH COUNT IN BINARY SEARCH IS : "+search_count);
			return search_count;
		}
		else if(target.compareToIgnoreCase(sorted_list.get(midpoint).getProduct_name())  > 0)
		{		
			search_count++;
			binarysearch(sorted_list,target,midpoint+1,last); 
			return search_count;
		}
		else
		{
			search_count++;
			binarysearch(sorted_list,target,first,midpoint-1);	
			return search_count;

		}

	}
}
