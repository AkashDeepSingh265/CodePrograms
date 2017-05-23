package MoneyCurrency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
//we use big decimal class to remove rounding errors . total amount in case of double is wrong . it is increased by 
// penny should be 90.04 but it is 90.05 . 
// BigDecimal is immutable class . so when ever we change we have to store it in reference
// Like other Number subclasses in the Java platform, BigDecimal is immutable, so if you call setScale(), you must "save" the return value: 
public class MoneyHandlingClass {

	public static void testBigDecimal(){
		BigDecimal amount = new BigDecimal("100.05");
		BigDecimal discountPercent = new BigDecimal("0.10");
		BigDecimal discountAmount = discountPercent.multiply(amount);
		discountAmount=discountAmount.setScale(2,RoundingMode.HALF_UP);
		BigDecimal total = amount.subtract(discountAmount);
		total = total.setScale(2,RoundingMode.HALF_UP);
		BigDecimal taxPercent = new BigDecimal("0.05");
		BigDecimal taxAmount = taxPercent.multiply(total);
		taxAmount = taxAmount.setScale(2,RoundingMode.HALF_UP);
		BigDecimal taxTotal = taxAmount.add(total);
		taxTotal=taxTotal.setScale(2,RoundingMode.HALF_UP);
		NumberFormat money = NumberFormat.getCurrencyInstance(); 
		System.out.println("Subtotal : "+ money.format(amount)); 
	    System.out.println("Discount : " + money.format(discountAmount)); 
	    System.out.println("Total : " + money.format(total)); 
	    System.out.println("Tax : " + money.format(taxAmount)); 
	    System.out.println("Tax+Total: " + money.format(taxTotal));
	}
	public static void main(String[] args){
		System.out.println("Using BigDecimal");
		System.out.println("--------------------------------------------------------------");
		MoneyHandlingClass.testBigDecimal();
		System.out.println("==============================================================");
		//in case of double output is wrong
		double d = 0.1 + 0.2 -0.3 ;
		System.out.println(d);
		System.out.println("==============================================================");
		System.out.println("Using Double");
		System.out.println("--------------------------------------------------------------");
		double amount = 100.05; 
	    double discount = amount * 0.10; 
	    double total = amount - discount; 
	    double tax = total * 0.05; 
	    double taxedTotal = tax + total; 
	    NumberFormat money = NumberFormat.getCurrencyInstance(); 
	    System.out.println("Subtotal : "+ money.format(amount)); 
	    System.out.println("Discount : " + money.format(discount)); 
	    System.out.println("Total : " + money.format(total)); 
	    System.out.println("Tax : " + money.format(tax)); 
	    System.out.println("Tax+Total: " + money.format(taxedTotal));
	}
}
