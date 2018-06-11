package cs401_Project;

import java.util.Comparator;

public class Coupon implements Comparable<Coupon>  {

	private String coupon_provider;
	private String product_name;
	private double price;
	private double final_price;
	private int discount;
	private int expiration_date;
	private String status_coupon;



	/**
	 * PUBLIC CONSTRUCTOR
	 */
	public Coupon() {
		coupon_provider = "";
		product_name = "";
		price = 0;
		final_price=0;
		discount = 0;
		expiration_date = 0;
		status_coupon = "";

	}


	/**
	 * PARAMETERIZED CONSTRUCTOR
	 * @param coupon_provider
	 * @param product_name
	 * @param price
	 * @param discount
	 * @param final_price
	 * @param expiration_date
	 * @param status_coupon
	 */
	public Coupon(String coupon_provider, String product_name, double price,
			int discount,double final_price, int expiration_date, String status_coupon) {

		this.coupon_provider = coupon_provider;
		this.product_name = product_name;
		this.price = price;
		this.discount = discount;
		this.final_price = final_price;
		this.expiration_date = expiration_date;
		this.status_coupon = status_coupon;
	}


	/**
	 * @return the coupon_provider
	 */
	public String getCoupon_provider() {
		return coupon_provider;
	}


	/**
	 * @param coupon_provider the coupon_provider to set
	 * @throws Exception 
	 */
	public void setCoupon_provider(String coupon_provider) throws Exception {

		if(coupon_provider.length() <= 20)
			this.coupon_provider = coupon_provider;
		else
			throw new Exception ("The Coupon Provider name should be less than 20 bytes");
	}


	/**
	 * @return the final_price
	 */
	public double getFinal_price() {
		return final_price;
	}


	/**
	 * @param final_price the final_price to set
	 */
	public void setFinal_price(double final_price) {
		this.final_price = final_price;
	}


	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}


	/**
	 * @param product_name the product_name to set
	 * @throws Exception 
	 */
	public void setProduct_name(String product_name) throws Exception {

		if(product_name.length() <= 20)
			this.product_name = product_name;
		else
			throw new Exception ("The Product name should be less than 20 character");
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}


	/**
	 * @return the discount
	 */
	public int  getDiscount() {
		return discount;
	}


	/**
	 * @param discount the discount to set
	 * @throws Exception 
	 */
	public void setDiscount(int discount) throws Exception {
		if(discount < 80 && discount > 5)
			this.discount = discount;
		else
			throw new Exception ("The discount percent should range between 5 to 80%");
	}


	/**
	 * @return the expiration_date
	 */
	public int getExpiration_date() {
		return expiration_date;
	}


	/**
	 * @param expiration_date the expiration_date to set
	 * @throws Exception 
	 */
	public void setExpiration_date(int expiration_date) throws Exception {
		if(expiration_date < 365 && expiration_date > 0)
			this.expiration_date = expiration_date;
		else
			throw new Exception ("The expiration date should range from 0 to 365 days");
	}


	/**
	 * @return the status_coupon
	 */
	public String getStatus_coupon() {
		return status_coupon;
	}


	/**
	 * @param status_coupon the status_coupon to set
	 * @throws Exception 
	 */
	public void setStatus_coupon(String status_coupon) throws Exception {
		if(status_coupon.equalsIgnoreCase("UNUSED") || status_coupon.equalsIgnoreCase("REDEEMED"))
			this.status_coupon = status_coupon;
		else
			throw new Exception ("The Product name should be less than 20 character");
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coupon [ coupon_provider = " + coupon_provider + ", product_name = "
				+ product_name + ", price = " + price + ", final_price = "
				+ final_price + ", discount = " + discount + ", expiration_date = "
				+ expiration_date + ", status_coupon = " + status_coupon + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coupon_provider == null) ? 0 : coupon_provider.hashCode());
		result = prime * result + discount;
		result = prime * result + expiration_date;
		long temp;
		temp = Double.doubleToLongBits(final_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((product_name == null) ? 0 : product_name.hashCode());
		result = prime * result
				+ ((status_coupon == null) ? 0 : status_coupon.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coupon other = (Coupon) obj;
		if (coupon_provider == null) {
			if (other.coupon_provider != null)
				return false;
		} else if (!coupon_provider.equals(other.coupon_provider))
			return false;
		if (discount != other.discount)
			return false;
		if (expiration_date != other.expiration_date)
			return false;
		if (Double.doubleToLongBits(final_price) != Double
				.doubleToLongBits(other.final_price))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (status_coupon == null) {
			if (other.status_coupon != null)
				return false;
		} else if (!status_coupon.equals(other.status_coupon))
			return false;
		return true;
	}


	@Override
	public int compareTo(Coupon coupon) {

		if (discount < coupon.discount)
			return -1;
		else if (discount > coupon.discount )
			return 1;
		else 
			return 0;

	}

	public static Comparator<Coupon> Coupon_Provider_Comparator() 

	{
		return new Comparator<Coupon>()
				{
			public int compare(Coupon coupon1, Coupon coupon2)
			{
				return (coupon1.coupon_provider.compareTo(coupon2.coupon_provider));
			}
				};
	} 

	public static Comparator<Coupon> Coupon_Product_Comparator() 

	{
		return new Comparator<Coupon>()
				{
			public int compare(Coupon coupon1, Coupon coupon2)
			{
				return (coupon1.product_name.compareTo(coupon2.product_name));
			}
				};
	} 

	public static Comparator<Coupon> Coupon_Price_Comparator() 

	{
		return new Comparator<Coupon>()
				{
			public int compare(Coupon coupon1, Coupon coupon2)
			{
				return (int) (coupon1.price - coupon2.price);
			}
				};
	} 

	public static Comparator<Coupon> Coupon_Discount_Comparator() 

	{
		return new Comparator<Coupon>()
				{
			public int compare(Coupon coupon1, Coupon coupon2)
			{
				return (int) (coupon1.discount - coupon2.discount);
			}
				};
	} 


	public static Comparator<Coupon> Coupon_Expiration_Comparator() 

	{
		return new Comparator<Coupon>()
				{
			public int compare(Coupon coupon1, Coupon coupon2)
			{
				return (int) (coupon1.expiration_date - coupon2.expiration_date);
			}
				};
	} 

	public static Comparator<Coupon> Coupon_Status_Comparator() 

	{
		return new Comparator<Coupon>()
				{
			public int compare(Coupon coupon1, Coupon coupon2)
			{
				return (int) (coupon1.status_coupon.compareTo(coupon2.status_coupon));
			}
				};
	} 

	public static Comparator<Coupon> Coupon_Final_Price_Comparator() 

	{
		return new Comparator<Coupon>()
				{
			public int compare(Coupon coupon1, Coupon coupon2)
			{
				return (int) (coupon1.final_price - coupon2.final_price);
			}
				};
	} 
}
