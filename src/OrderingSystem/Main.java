package OrderingSystem;

import java.util.Scanner;

/**
 * The most crucial in the execution of the program because this is where the main method is located.
 * 
 * @author Kian Candelario ; Mel Zedric Faustino ; Vincent Antanoy
 */
public class Main {
	/**
     * A special method that serves as the starting point from where the compiler starts 
     * program execution.
     * <p>
     *      This method contains error handlings, instantiation of the objects, and a bunch of <code>conditional statements</code>
     *      and <code>do-while loops</code> that will control the whole flow of the program. 
     * </p>
     * 
     * @param args the default parameter of the Java main method
     */
    public static void main(String[] args) {
        // Instantiating Objects 
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        Vouchers voucher = new Vouchers();

        // Constants
        final char NEWLINE = '\n';
        final int SHIPPING_FEE = 50;
        
        do {
            System.out.println("WELCOME TO GameShop <3!");
            System.out.print("""

                Shop by Category
                (1) Video Games
                (2) Consoles
                (3) PC Peripherals

                """);
            System.out.print("Select Category: ");
            int selectedCategory = sc.nextInt();

            if (selectedCategory == 1) {
                System.out.print("""

                        Category > Video Games
                        [1] PlayStation
                        [2] Xbox
                        [3] PC

                    """);
                System.out.print("Select type of game: ");
                int typeOfGame = sc.nextInt();
                System.out.print(NEWLINE);
                cart.gameType = typeOfGame; // Pass the value to Products which is the Parent Class of Cart

                cart.videoGameItems(typeOfGame); // Shows the Item list of Video Games

                System.out.print("Add to Cart: ");
                int addedItem = sc.nextInt();
                System.out.print("Quantity: ");
                int numOfItems = sc.nextInt();
                System.out.print(NEWLINE);

                cart.addtoCart(selectedCategory, addedItem, numOfItems); // Add items to cart
            }

            else if (selectedCategory == 2) {
                cart.consoleItems(); // Shows the Item list of Consoles

                System.out.print("Add to Cart: ");
                int addedItem = sc.nextInt();
                System.out.print("Quantity: ");
                int numOfItems = sc.nextInt();
                System.out.print(NEWLINE);

                cart.addtoCart(selectedCategory, addedItem, numOfItems); // Add items to cart
            }

            else if (selectedCategory == 3) {
                System.out.print("""

                        Category > PC Peripherals
                        [1] Keyboard
                        [2] Mouse
                        [3] Headset
                        [4] Monitor
                        [5] Speaker

                    """);
                System.out.print("Select Peripherals: ");
                int chosenPeripheral = sc.nextInt();
                cart.selectedPeripheral = chosenPeripheral; // Pass the value to Products which is the Parent Class of Cart
                System.out.print(NEWLINE);
                
                cart.pcPeripheralItems(chosenPeripheral); // Shows the Item list of PC Peripherals

                System.out.print("Add to Cart: ");
                int addedItem = sc.nextInt();
                System.out.print("Quantity: ");
                int numOfItems = sc.nextInt();
                System.out.print(NEWLINE);

                cart.addtoCart(selectedCategory, addedItem, numOfItems); // Add items to cart
            }

            else {
                System.out.println("Invalid Input");
                System.out.print(NEWLINE);
                continue;
            }

            System.out.print("Press [1] to cancel the order | Press [2] to check out the items | Press [3] to buy more: ");
            int decision = sc.nextInt();
            
            if (decision == 1) {
                cart.cancelOrders();
                cart.showCart();
                // Space for order cancelation
                System.out.print("""

                Press [1] if you still want to buy  
                Press [2] to check out the items  
                Press [3] to cancel the order  
                Press [4] to cancel all the orders and exit 

                    """);
                System.out.print("Your Answer: ");
                int buyAgain = sc.nextInt();

                if (buyAgain == 1) {
                    System.out.print(NEWLINE);
                    continue;
                }
                else if (buyAgain == 2) {
                    int payment = 0;
                    System.out.print(NEWLINE);
                    System.out.print("Do you have Free Shipping Voucher? Press [1] for YES | Press [2] for NO: ");
                    int freeShipping = sc.nextInt();
                    if (freeShipping == 1) {
                        do {
                            System.out.print("Enter the code: ");
                            sc.nextLine();
                            String code = sc.nextLine();
                            boolean verifiedVoucher = voucher.voucherVerifier(code);
                            
                            if (verifiedVoucher == true) {
                                do {
                                    System.out.print(NEWLINE);
                                    cart.showCart(); 
                                    int totalCost = cart.totalCost(); 
                                    System.out.println("Total shipping fee cost: FREE");
                                    System.out.println("Cost of All the Items: " + totalCost + " PHP");
                                    System.out.println("Total Bill: " + totalCost+ " PHP");
                                    System.out.print("Enter your payment: ");
                                    payment = sc.nextInt();
                                    
                                    if (payment < totalCost) {
                                        System.out.println("Insufficient Money!");
                                        System.out.print(NEWLINE);
                                        System.out.print("Press [1] to pay again | Press any number to exit: ");
                                        int payAgain = sc.nextInt();
                                        if (payAgain == 1) {
                                            continue;
                                        }
                                        else {
                                            System.out.print("Unsuccessful Purchase!");
                                            break;
                                        }
                                    }
                                    System.out.print(NEWLINE);
                                    System.out.println("Purchased Successfuly!");
                                    System.out.println("Your Change: " + cart.changeComputation(payment) + " PHP");
                                    System.out.print(NEWLINE);
                                    break;
                                } while(true);
                            }
                            else {
                                System.out.println("You entered a wrong voucher code!");
                                System.out.print("Press [1] to try again | Press [2] to cancel: ");
                                int cancelation = sc.nextInt();
                                if (cancelation == 1) {
                                    System.out.print(NEWLINE);
                                    continue;
                                }
                                else if (cancelation == 2) {
                                    do {
                                        System.out.print(NEWLINE);
                                        cart.showCart();
                                        System.out.println("Total Shipping Fee Cost (50 PHP every item): " + cart.totalShipping(SHIPPING_FEE) + " PHP");
                                        System.out.println("Cost of All the Items: " + cart.totalCost() + " PHP");
                                        System.out.println("Total Bill: " + cart.totalCost(cart.totalShipping(SHIPPING_FEE)) + " PHP");
                                        System.out.print("Enter your payment: ");
                                        payment = sc.nextInt();
    
                                        if (payment < cart.totalCost(cart.totalShipping(SHIPPING_FEE))) {
                                            System.out.println("Insufficient Money!");
                                            System.out.print(NEWLINE);
                                            System.out.print("Press [1] to pay again | Press any number to exit: ");
                                            int payAgain = sc.nextInt();
                                            if (payAgain == 1) {
                                                continue;
                                            }
                                            else {
                                                System.out.print("Unsuccessful Purchase!");
                                                break;
                                            }
                                        }
                                        System.out.print(NEWLINE);
                                        System.out.println("Purchased Successfuly!");
                                        System.out.println("Your Change: " + cart.changeComputation(payment, cart.totalShipping(SHIPPING_FEE)) + " PHP");
                                        System.out.print(NEWLINE);
                                        break;
                                    } while (true);
    
    
                                    System.out.print("Press [1] if you want to shop again | Press [2] to exit: ");
                                    int shopAgain = sc.nextInt();
                                    if (shopAgain == 1) {
                                        cart.clearCart();
                                        continue;
                                    }
                                    else if (shopAgain == 2) {
                                        cart.clearCart();
                                        break;
                                    }
                                    break;
                                }
                            }
                        } while (true);
                        break;
                    }
                    else if (freeShipping == 2) {
                        do {
                            System.out.print(NEWLINE);
                            cart.showCart();
                            System.out.println("Total Shipping Fee Cost (50 PHP every item): " + cart.totalShipping(SHIPPING_FEE) + " PHP");
                            System.out.println("Cost of All the Items: " + cart.totalCost() + " PHP");
                            System.out.println("Total Bill: " + cart.totalCost(cart.totalShipping(SHIPPING_FEE)) + " PHP");
                            System.out.print("Enter your payment: ");
                            payment = sc.nextInt();

                            if (payment < cart.totalCost(cart.totalShipping(SHIPPING_FEE))) {
                                System.out.println("Insufficient Money!");
                                System.out.print(NEWLINE);
                                System.out.print("Press [1] to pay again | Press any number to exit: ");
                                int payAgain = sc.nextInt();
                                if (payAgain == 1) {
                                    continue;
                                }
                                else {
                                    System.out.print("Unsuccessful Purchase!");
                                    break;
                                }
                            }
                            System.out.print(NEWLINE);
                            System.out.println("Purchased Successfuly!");
                            System.out.println("Your Change: " + cart.changeComputation(payment, cart.totalShipping(SHIPPING_FEE)) + " PHP");
                            System.out.print(NEWLINE);
                            break;
                        } while (true);

    
                        System.out.print("Press [1] if you want to shop again | Press [2] to exit: ");
                        int shopAgain = sc.nextInt();
                        if (shopAgain == 1) {
                            cart.clearCart();
                            continue;
                        }
                        else if (shopAgain == 2) {
                            cart.clearCart();
                            break;
                        }
                    }
                }
                else if (buyAgain == 3) {
                    System.out.print(NEWLINE);
                    cart.cancelOrders();
                    cart.showCart();
                    System.out.print("Press [1] if you still want to buy | Press [2] to exit: ");
                    int secondBuyAgain = sc.nextInt();
                    if (secondBuyAgain == 1) {
                        System.out.print(NEWLINE);
                        continue;
                    }
                    else if (secondBuyAgain == 2) {
                        System.out.print(NEWLINE);
                        break;
                    }
                }
                else if (buyAgain == 4) {
                    break;
                }
            }
            else if (decision == 2) {
                int payment = 0;
                System.out.print(NEWLINE);
                System.out.print("Do you have Free Shipping Voucher? Press [1] for YES | Press [2] for NO: ");
                int freeShipping = sc.nextInt();
                if (freeShipping == 1) {
                    do {
                        System.out.print("Enter the code: ");
                        sc.nextLine();
                        String code = sc.nextLine();
                        boolean verifiedVoucher = voucher.voucherVerifier(code);
                        
                        if (verifiedVoucher == true) {
                            do {
                                System.out.print(NEWLINE);
                                cart.showCart(); 
                                int totalCost = cart.totalCost(); 
                                System.out.println("Total shipping fee cost: FREE");
                                System.out.println("Cost of All the Items: " + totalCost + " PHP");
                                System.out.println("Total Bill: " + totalCost+ " PHP");
                                System.out.print("Enter your payment: ");
                                payment = sc.nextInt();
                                
                                if (payment < totalCost) {
                                    System.out.println("Insufficient Money!");
                                    System.out.print(NEWLINE);
                                    System.out.print("Press [1] to pay again | Press any number to exit: ");
                                    int payAgain = sc.nextInt();
                                    if (payAgain == 1) {
                                        continue;
                                    }
                                    else {
                                        System.out.print("Unsuccessful Purchase!");
                                        break;
                                    }
                                }
                                System.out.print(NEWLINE);
                                System.out.println("Purchased Successfuly!");
                                System.out.println("Your Change: " + cart.changeComputation(payment) + " PHP");
                                System.out.print(NEWLINE);
                                break;
                            } while(true);
                        }
                        else {
                            System.out.println("You entered a wrong voucher code!");
                            System.out.print("Press [1] to try again | Press [2] to cancel: ");
                            int cancelation = sc.nextInt();
                            if (cancelation == 1) {
                                continue;
                            }
                            else if (cancelation == 2) {
                                do {
                                    System.out.print(NEWLINE);
                                    cart.showCart();
                                    System.out.println("Total Shipping Fee Cost (50 PHP every item): " + cart.totalShipping(SHIPPING_FEE) + " PHP");
                                    System.out.println("Cost of All the Items: " + cart.totalCost() + " PHP");
                                    System.out.println("Total Bill: " + cart.totalCost(cart.totalShipping(SHIPPING_FEE)) + " PHP");
                                    System.out.print("Enter your payment: ");
                                    payment = sc.nextInt();

                                    if (payment < cart.totalCost(cart.totalShipping(SHIPPING_FEE))) {
                                        System.out.println("Insufficient Money!");
                                        System.out.print(NEWLINE);
                                        System.out.print("Press [1] to pay again | Press any number to exit: ");
                                        int payAgain = sc.nextInt();
                                        if (payAgain == 1) {
                                            continue;
                                        }
                                        else {
                                            System.out.print("Unsuccessful Purchase!");
                                            break;
                                        }
                                    }
                                    System.out.print(NEWLINE);
                                    System.out.println("Purchased Successfuly!");
                                    System.out.println("Your Change: " + cart.changeComputation(payment, cart.totalShipping(SHIPPING_FEE)) + " PHP");
                                    System.out.print(NEWLINE);
                                    break;
                                } while (true);

                                System.out.print("Press [1] if you want to shop again | Press [2] to exit: ");
                                int shopAgain = sc.nextInt();
                                if (shopAgain == 1) {
                                    cart.clearCart();
                                    continue;
                                }
                                else if (shopAgain == 2) {
                                    cart.clearCart();
                                    break;
                                }
                                break;
                            }
                        }
                        break;
                    } while (true);
                    break;
                }
                else if (freeShipping == 2) {
                    do {
                        System.out.print(NEWLINE);
                        cart.showCart();
                        System.out.println("Total Shipping Fee Cost (50 PHP every item): " + cart.totalShipping(SHIPPING_FEE) + " PHP");
                        System.out.println("Cost of All the Items: " + cart.totalCost() + " PHP");
                        System.out.println("Total Bill: " + cart.totalCost(cart.totalShipping(SHIPPING_FEE)) + " PHP");
                        System.out.print("Enter your payment: ");
                        payment = sc.nextInt();

                        if (payment < cart.totalCost(cart.totalShipping(SHIPPING_FEE))) {
                            System.out.println("Insufficient Money!");
                            System.out.print(NEWLINE);
                            System.out.print("Press [1] to pay again | Press any number to exit: ");
                            int payAgain = sc.nextInt();
                            if (payAgain == 1) {
                                continue;
                            }
                            else {
                                System.out.print("Unsuccessful Purchase!");
                                break;
                            }
                        }
                        System.out.print(NEWLINE);
                        System.out.println("Purchased Successfuly!");
                        System.out.println("Your Change: " + cart.changeComputation(payment, cart.totalShipping(SHIPPING_FEE)) + " PHP");
                        System.out.print(NEWLINE);
                        break;
                    } while (true);

                    System.out.print("Press [1] if you want to shop again | Press [2] to exit: ");
                    int shopAgain = sc.nextInt();
                    if (shopAgain == 1) {
                        cart.clearCart();
                        continue;
                    }
                    else if (shopAgain == 2) {
                        cart.clearCart();
                        break;
                    }
                }
            }
            else if (decision == 3) {
                System.out.print(NEWLINE);
                continue;
            }
            else {
                System.out.println("Invalid Input");
            }
        } while(true);
        cart.clearCart();
        System.out.print(NEWLINE);
        System.out.println("Thank you for stopping by!");
        System.out.print(NEWLINE);
    } 
}
