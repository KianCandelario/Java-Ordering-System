package OrderingSystem;

/**
 * Handles all of the computations that will happen throughout the program. 
 * <p>This class's parent class is <code>Product class</code>.</p>
 * 
 * @author Kian Candelario
 */
class Computations extends Products {
	// Variables
	int lastPrice = 0;
	
	/**
     * Computes the total price by multiplying the price of the product to the preferred quantity of the user.
     * <p>
     *      This method uses <code>conditional statements</code> to determine the category which is important because the 
     *      Video Games and PC Peripheral have their own subcategories. The <code>conditional statements</code> contains 
     *      <code>switch statements</code> which will be used to determine the right <code>Arrays</code> that will be indexed.
     * </p>
     * <p>
     *      The <code>switch statements</code> uses the value of <code>gameType</code> and <code>selectedPeripheral</code> 
     *      variables which values originated from the <code>Main class</code> and has been passed to the <code>Product class</code>.
     * </p>
     * <p>
     *      This method can access the <code>gameType</code> and <code>selectedPeripheral</code> variables without
     *      instantiating an object because <code>Computations class</code> inherits the <code>Product class</code>.
     * </p>
     * 
     * @param selectedCategory the category number that was selected by the user.
     * @param index the product number that was selected by the user subtracted by 1.
     * @param quantity the entered amount of product the user wants to buy.
     * 
     * @return the product of the item's price multiplied to the user's entered quantity
     */
	// Item's total price
	public int totalPrice(int selectedCategory, int index, int quantity) {
	    if (selectedCategory == 1) {
	        switch (gameType) {
	            case 1:
	                lastPrice = playStationGamePrices[index] * quantity;
	                break;
	            case 2:
	                lastPrice = xBoxGamePrices[index] * quantity;
	                break;
	            case 3:
	                lastPrice = pcGamePrices[index] * quantity;
	                break;
	        }
	    }
	
	    else if (selectedCategory == 2) {
	        lastPrice = consolePrices[index] * quantity;
	    }
	
	    else if (selectedCategory == 3) {
	        switch (selectedPeripheral) {
	            case 1:
	                lastPrice = keyboardPrices[index] * quantity; 
	                break;
	            case 2:
	                lastPrice = mousePrices[index] * quantity;
	                break;
	            case 3:
	                lastPrice = headsetPrices[index] * quantity;
	                break;
	            case 4:
	                lastPrice = monitorPrices[index] * quantity;
	                break;
	            case 5:
	                lastPrice = speakerPrices[index] * quantity;
	                break;
	        }     
	    }
	    return lastPrice;
	}
	
	 /**
     * Multiplies the cost of shipping fee to the number of elements inside the <code>ArrayList finalPrice</code>
     * 
     * @param shippingFee the cost of shipping fee
     * @return the product of the cost of shipping fee multiplied to the number of elements inside the 
     *         <code>ArrayList finalPrice</code>.
     */
    // Total cost of shipping fee
	public int totalShipping(int shippingFee) {
	    return shippingFee * finalPrice.size();
	} 
	
	 /**
     * Computes the total cost by getting the sum of all of the elements inside the <code>ArrayList finalPrice</code> 
     * by iterating the <code>ArrayList</code> and adding the elements one by one using a <code>for-each loop</code>.
     * 
     * @return the sum of all of the elements inside the <code>ArrayList</code>.
     */
    // Total cost without shipping fee 
	public int totalCost() {
	    int totalCost = 0;
	    for (int prices : finalPrice) {
	        totalCost += prices;
	    }
	    return totalCost;
	}
	
	/**
     * Computes the total cost by getting the sum of all of the elements inside the <code>ArrayList finalPrice</code> 
     * by iterating the <code>ArrayList</code> and adding the elements one by one using a <code>for-each loop</code>, 
     * then adding the result to the total cost of shipping fee. 
     * <p>
     *      This method is similar to the <code>totalCost</code> method showed earlier, except that this method has 
     *      a parameter. This is called <code>Method Overloading</code>.
     * </p>
     * 
     * @param shippingFee the total cost of shipping fee.
     * @return the sum of all of the elements inside the <code>ArrayList</code> added to the cost of shipping fee.
     */
    // Total cost with shipping fee (Method Overloading)
	public int totalCost(int shippingFee) {
	    int totalCost = 0;
	    for (int prices : finalPrice) {
	        totalCost += prices;
	    }
	    return totalCost + shippingFee;
	}
	
	/**
     * Computes the change by subtracting the user's payment to the total cost of the ordered items by the user.
     * 
     * @param payment the payment entered by the user.
     * @return the difference of payment subtracted to the total cost of ordered items.
     */
    // Payment without shipping fee
	public int changeComputation(int payment) {
	    int finalCost = 0;
	    for (int prices : finalPrice) {
	        finalCost += prices;
	    }
	    return payment - finalCost;
	}
	
	/**
     * Computes the change by subtracting the user's payment to the sum of the total cost of the ordered items and 
     * total cost of shipping fee.
     * <p>
     *      This method is similar to the <code>changeComputation</code> method showed earlier, except that this method has 
     *      two parameters instead of one. This is called <code>Method Overloading</code>.
     * </p>
     * 
     * @param payment the payment entered by the user.
     * @param shippingFee the total cost of shipping fee.
     * @return the difference of payment subtracted to the sum of total cost of ordered items and total cost of shipping fee.
     */
    // Payment with shipping fee (Method Overloading)
	public int changeComputation(int payment, int shippingFee) {
	    int finalCost = 0;
	    for (int prices : finalPrice) {
	        finalCost += prices;
	    }
	    return payment - (finalCost+shippingFee);
	}
}
