package OrderingSystem;

/**
 * Contains all of the methods that has something to do with the Cart feature.
 * <p>The parent class of this class is the <code>Computations class</code>.</p>
 * 
 * @author Kian Candelario
 */
class Cart extends Computations {
	
	/**
     * Empties the Cart
     * <p>
     *      This method removes all of the elements inside the <code>ArrayLists item</code>, 
     *      <code>ArrayLists quantity</code>, and <code>ArrayLists finalPrice</code>.
     * </p>
     */
    // Clear Cart 
    public void clearCart() {
        if (item.size() != 0 && quantity.size() != 0 && finalPrice.size() != 0) {
            item.clear();
            quantity.clear();
            finalPrice.clear();
        }
    } 

    /**
     * Removes the most recent added item to the Cart.
     * <p>
     *      This method removes the latest appended element to the <code>ArrayLists item</code>, 
     *      <code>ArrayLists quantity</code>, and <code>ArrayLists finalPrice</code>; then displays 
     *      <strong>Order Canceled!</strong>.
     * </p>
     */
    // Cancel Cart
    public void cancelOrders() {
        item.remove(item.size()-1);
        quantity.remove(quantity.size()-1);
        finalPrice.remove(finalPrice.size()-1);

        System.out.print(NEWLINE);
        System.out.println("Order Canceled!");
        System.out.print(NEWLINE);
    }

    /**
     * 		Displays the items inside the Cart or print <strong>EMPTY</strong> in case the Cart is empty.
     *      This method iterates and gets the elements inside the <code>ArrayLists item</code>, 
     *      <code>ArrayLists quantity</code>, and <code>ArrayLists finalPrice</code> using a <code>for loop</code>. 
     * <p>
     *      This method also checks if the cart is empty by getting the size of the <code>ArrayList item</code> using 
     *      the <code>size</code> method. If the size of <code>ArrayList item</code> is equal to zero, that means 
     *      the Cart is empty and this method will display <strong>EMPTY</strong>.
     * </p>
     */
    // Show Cart
    public void showCart() {
        System.out.println("-------- Your Cart --------");
        for (int i = 0; i < item.size(); i++) {
            System.out.println("Product: " + "'" + item.get(i) + "'");
            System.out.println("Quantity: " + quantity.get(i));
            System.out.println("Price: " + finalPrice.get(i) + " PHP");
            System.out.print(NEWLINE);
        }
        if (item.size() == 0) {
            System.out.print(NEWLINE);
            System.out.println("\t   EMPTY");
            System.out.print(NEWLINE);
        }
        System.out.println("---------------------------");
    }

    /**
     * Adds the selected item to Cart
     *<p>
     *      This method uses <code>conditional statements</code> to determine the category which is important because the 
     *      Video Games and PC Peripheral have their own subcategories. The <code>conditional statements</code> contains 
     *      <code>switch statements</code> which will be used to determine the right <code>Arrays</code> that will be indexed.
     *</p>
     *<p>
     *      The <code>switch statements</code> uses the value of <code>gameType</code> and <code>selectedPeripheral</code> 
     *      variables which values originated from the <code>Main class</code> and has been passed to the <code>Product class</code>.
     *</p> 
     *<p>
     *      This method can access the <code>gameType</code> and <code>selectedPeripheral</code> variables without
     *      instantiating an object because <code>Cart class</code> inherits the <code>Computation class</code> which is 
     *      the child class of the <code>Product class</code>.
     *</p>
     *<p>
     *      This method subtracts the quantity of items ordered by the user to the product's stock. Conversely, it adds the
     *      quantity of items ordered by the user to the number of sold products. If the user tries to add to cart a product
     *      that has zero stock, this method will display <strong>Out of Stock!</strong>. Otherwise, this method will add the 
     *      product's name to <code>ArrayList item</code>; add the quantity of the ordered item to the <code>ArrayLists quantity</code>;
     *      and add the final price, which was got using the <code>totalPrice</code> method, to the <code>ArrayLists finalPrice</code>.
     * </p>
     * 
     * @param selectedCategory the category number that was selected by the user.
     * @param addedItem the product number that was selected by the user.
     * @param numOfItems the entered amount of product the user wants to buy.
     */
    // Add to Cart
    public void addtoCart(int selectedCategory, int addedItem, int numOfItems) {
        // Video Games Category
        if (selectedCategory == 1) {
            switch (gameType) {
                case 1:
                    playStationGameStock[addedItem-1] -= numOfItems;
                    playStationGameSold[addedItem-1] += numOfItems; 
                    if (playStationGameStock[addedItem-1] >= 0) {
                        item.add(playStationGames[addedItem-1]); 
                        quantity.add(numOfItems);
                        finalPrice.add(totalPrice(selectedCategory,addedItem-1, numOfItems));
                    
                        showCart();
                    }
                    else {
                        System.out.println("Out of Stock!");
                        System.out.print(NEWLINE);
                    }
                    break;
                case 2:
                    xBoxGameStock[addedItem-1] -= numOfItems;
                    xBoxGameSold[addedItem-1] += numOfItems;
                    if (xBoxGameStock[addedItem-1] >= 0) {
                        item.add(xBoxGames[addedItem-1]);
                        quantity.add(numOfItems);
                        finalPrice.add(totalPrice(selectedCategory,addedItem-1, numOfItems));

                        showCart();
                    }
                    else {
                        System.out.println("Out of Stock!");
                        System.out.print(NEWLINE);
                    }
                    break;
                case 3:
                    pcGameStock[addedItem-1] -= numOfItems;
                    pcGameSold[addedItem-1] += numOfItems;
                    if (pcGameStock[addedItem-1] >= 0) {
                        item.add(pcGames[addedItem-1]);
                        quantity.add(numOfItems);
                        finalPrice.add(totalPrice(selectedCategory,addedItem-1, numOfItems));
        
                        showCart();
                    }
                    else {
                        System.out.println("Out of Stock!");
                        System.out.print(NEWLINE);
                    }
                    break;
            };
        }
        
        // Console Category
        else if (selectedCategory == 2) {
            consoleStock[addedItem-1] -= numOfItems;
            consoleSold[addedItem-1] += numOfItems;
            if (consoleStock[addedItem-1] >= 0) {
                item.add(consoles[addedItem-1]);
                quantity.add(numOfItems);
                finalPrice.add(totalPrice(selectedCategory,addedItem-1, numOfItems));
    
                showCart();
            }
            else {
                System.out.println("Out of Stock!");
                System.out.print(NEWLINE);
            }
        }

        // PC Peripherals Category
        else if (selectedCategory == 3) {
            switch (selectedPeripheral) {
                case 1:
                    keyboardStock[addedItem-1] -= numOfItems;
                    keyboardSold[addedItem-1] += numOfItems;
                    if (keyboardStock[addedItem-1] >= 0) {
                        item.add(keyboards[addedItem-1]);
                        quantity.add(numOfItems);
                        finalPrice.add(totalPrice(selectedCategory,addedItem-1, numOfItems));
    
                        showCart();
                    }
                    else {
                        System.out.println("Out of Stock!");
                        System.out.print(NEWLINE);
                    }
                    break;
                case 2:
                    mouseStock[addedItem-1] -= numOfItems;
                    mouseSold[addedItem-1] += numOfItems;
                    if (mouseStock[addedItem-1] >= 0) {
                        item.add(mouse[addedItem-1]);
                        quantity.add(numOfItems);
                        finalPrice.add(totalPrice(selectedCategory,addedItem-1, numOfItems));
    
                        showCart();
                    }
                    else {
                        System.out.println("Out of Stock!");
                        System.out.print(NEWLINE);
                    }
                    break;
                case 3:
                    headsetStock[addedItem-1] -= numOfItems;
                    headsetSold[addedItem-1] += numOfItems;
                    if (headsetStock[addedItem-1] >= 0) {
                        item.add(headset[addedItem-1]);
                        quantity.add(numOfItems);
                        finalPrice.add(totalPrice(selectedCategory,addedItem-1, numOfItems));
                    
                        showCart();
                    }
                    else {
                        System.out.println("Out of Stock!");
                        System.out.print(NEWLINE);
                    }
                    break;
                case 4:
                    monitorStock[addedItem-1] -= numOfItems;
                    monitorSold[addedItem-1] += numOfItems;
                    if (monitorStock[addedItem-1] >= 0) {
                        item.add(monitor[addedItem-1]);
                        quantity.add(numOfItems);
                        finalPrice.add(totalPrice(selectedCategory,addedItem-1, numOfItems));

                        showCart();
                    }
                    else {
                        System.out.println("Out of Stock!");
                        System.out.print(NEWLINE);
                    }
                    break;
                case 5:
                    speakerStock[addedItem-1] -= numOfItems;
                    speakerSold[addedItem-1] += numOfItems;
                    if (speakerStock[addedItem-1] >= 0) {
                        item.add(speaker[addedItem-1]);
                        quantity.add(numOfItems);
                        finalPrice.add(totalPrice(selectedCategory,addedItem-1, numOfItems));
    
                        showCart();
                    }
                    else {
                        System.out.println("Out of Stock!");
                        System.out.print(NEWLINE);
                    }
                    break;
            }
        }
    }
}
