package OrderingSystem;

import java.util.ArrayList;

/**
 * Accommodate the important variables that will be used throughout the program; the <code>Arrays</code> that 
 * contains all of the product's names, prices, stock, and number of sold items; the <code>ArrayList</code> that will 
 * serve as the Cart; and the methods that prints the list of purchasable products—including 
 * their price, current number of stock, and current number of sold items.
 * 
 * @author Kian Candelario
 */
class Products {
    // Constants
    public final char NEWLINE = '\n';

    // Variable
    public int gameType;
    public int selectedPeripheral;

    // ArrayList to represent a Cart 
    ArrayList<String> item = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>(); 
    ArrayList<Integer> finalPrice = new ArrayList<>();
    
    // Video Game Products
    public String[] playStationGames = {
        "Grand Theft Auto V", 
        "Call of Duty: Vanguard", 
        "LEGO Star Wars: The Skywalker Saga",
        "Hogwarts Legacy",
        "Gotham Knights Deluxe Edition"
    };
    public int[] playStationGamePrices = {
        2000, 2500, 3200, 3500, 4700
    };
    public int[] playStationGameStock = {
        50, 50, 50, 50, 50
    };
    public int[] playStationGameSold = {
        0, 0, 0, 0, 0
    };

    public String[] xBoxGames = {
        "Cyberpunk 2077",
        "Resident Evil 2",
        "Red Dead Redemption 2",
        "NBA 2K22",
        "Dying Light 2 Deluxe Edition"
    };
    public int[] xBoxGamePrices = {
        1000, 1050, 1300, 3150, 4080
    };
    public int[] xBoxGameStock = {
        50, 50, 50, 50, 50
    };
    public int[] xBoxGameSold = {
        0, 0, 0, 0, 0
    };

    public String[] pcGames = {
        "Dragon Age II",
        "Pirate 101",
        "Net Dragon",
        "Batman: Arkham Knight",
        "Gotham Knights"
    };
    public int[] pcGamePrices = {
        550, 1050, 1300, 2100, 3670
    };
    public int[] pcGameStock = {
        50, 50, 50, 50, 50
    };
    public int[] pcGameSold = {
        0, 0, 0, 0, 0
    };

    // Console Products
    public String[] consoles = {
        "Xbox One S",
        "Xbox Series X|S",
        "PlayStation 4",
        "PlayStation 5"
    };
    public int[] consolePrices = {
        15190, 19995, 24690, 27990
    };
    public int[] consoleStock = {
        25, 25, 25, 25
    };
    public int[] consoleSold = {
        0, 0, 0, 0
    };

    // Peripheral Products
    // Keyboard
    public String[] keyboards = {
        "Logitech G813 LIGHTSYNC RGB Mechanical Gaming Keyboard",
        "Logitech Pop Keys Daydream Mint Lilac Wireless Receiver Mechanical Keyboard",
        "RAZER Huntsman Mini Purple Opto Mechanical Switch 60% Size Keyboard",
        "Logitech G413 Carbon Backlit Mechanical Gaming Keyboard",
        "ASUS TUF Gaming K1 spill-resistantant RGB Gaming Keyboard"
    };
    public int[] keyboardPrices = {
        7300, 5400, 3995, 3900, 2000
    };
    public int[] keyboardStock = {
        25, 25, 25, 25, 25
    };
    public int[] keyboardSold = {
        0, 0, 0, 0, 0
    };
    // Mouse
    public String[] mouse = {
        "LOGITECH G502 LIGHTSPEED WIRELESS MOUSE",
        "KINGSTON HYPERX PULSEFIRE DART WIRELESS GAMING MOUSE",
        "ASUS ROG STRIX IMPACT II RGB WIRELESS MOUSE (BLACK)",
        "ASUS TUF GAMING M3 RGB GAMING MOUSE",
        "LOGITECH M331 Silent Plus Wireless Mouse (Black)"
    };
    public int[] mousePrices = {
        6700, 3950, 2900, 900, 800
    };
    public int[] mouseStock = {
        25, 25, 25, 50, 50
    };
    public int[] mouseSold = {
        0, 0, 0, 0, 0
    };
    // Headset 
    public String[] headset = {
        "JBL Tune 750BTNC Bluetooth Headset (Black)",
        "LOGITECH G733 Lightspeed RGB Wireless Gaming Headset (Lilac)",
        "JBL T600BT Noise-Cancelling Bluetooth Headset (Black)",
        "LOGITECH G331 Gaming Headset (Black)",
        "JBL Tune 500 Headset (Black)"
    };
    public int[] headsetPrices = {
        6000, 6000, 4400, 1900, 1600
    };
    public int[] headsetStock = {
        25, 25, 25, 25, 25
    };
    public int[] headsetSold = {
        0, 0, 0, 0, 0
    };
    // Monitor 
    public String[] monitor = {
        "LG 27'' 27UL550-W.APH Ultrafine 60HZ IPS Monitor",
        "LG 29'' 29WP500-B.APH Ultrawide 75HZ IPS Monitor",
        "Viewplus 27'' MS-27CH 165HZ Curved Gaming Monitor",
        "Viewsonic 21.5'' VA2256-H IPS 75HZ Monitor",
        "ViewPlus MH-24 23.8'' Full HD 75Hz IPS Monitor"
    };
    public int[] monitorPrices = {
        18000, 13600, 10150, 6700, 6500
    };
    public int[] monitorStock = {
        25, 25, 25, 25, 25
    };
    public int[] monitorSold = {
        0, 0, 0, 0, 0
    };
    // Speaker
    public String[] speaker = {
        "JBL BAR 2.1 DEEP BASS 300W BT",
        "JBL Pulse 4 Portable Bluetooth Speaker (Black)",
        "JBL BAR 2.0 AIO 2X40W/BT/OPTICAL/HDMI OUT",
        "LOGITECH Z313 2.1 Speaker And Subwoofer (Black)",
        "LOGITECH Z120 USB Speaker (White/Black)"
    };
    public int[] speakerPrices = {
        14100, 8650, 6200, 1700, 575
    };
    public int[] speakerStock = {
        25, 25, 25, 25, 50
    };
    public int[] speakerSold = {
        0, 0, 0, 0, 0
    };

    /**
     * Displays the list of the purchasable Video Game products including their prices, 
     * current number of stock, and current number of sold items. Contains a <code>switch statement</code>
     * that will print the list of product in accordance to the type of game which is inputted by the user.
     * 
     * @param gameType the number that corresponds to the type of game that the user wants 
     *                 to purchase (1 = PlayStation, 2 = XBox, 3 = PC Games).
     */
    public void videoGameItems(int gameType) {
        System.out.println("------- Product List -------");
        switch (gameType) {
            case 1:
                System.out.println("Category > Video Games > PlayStation");
                for (int i = 0; i < playStationGames.length; i++) {
                    int itemNum = i;
                    itemNum += 1;
                    System.out.println("{"+ itemNum + "} " + "Product: " + "'"+playStationGames[i]+"'");
                    System.out.println("    Price: " + playStationGamePrices[i] + " PHP");
                    System.out.println("    Stock: " + playStationGameStock[i]);
                    System.out.println("    Sold: " + playStationGameSold[i]);
                    System.out.print(NEWLINE);
                }
                break;
            case 2:
                System.out.println("Category > Video Games > XBox");
                for (int i = 0; i < xBoxGames.length; i++) {
                    int itemNum = i;
                    itemNum+=1;
                    System.out.println("{"+ itemNum + "} " + "Product: " + "'"+xBoxGames[i]+"'");
                    System.out.println("    Price: " + xBoxGamePrices[i] + " PHP");
                    System.out.println("    Stock: " + xBoxGameStock[i]);
                    System.out.println("    Sold: " + xBoxGameSold[i]);
                    System.out.print(NEWLINE);
                }
                break;
            case 3:
                System.out.println("Category > Video Games > PC");
                for (int i = 0; i < pcGames.length; i++) {
                    int itemNum = i;
                    itemNum+=1;
                    System.out.println("{"+ itemNum + "} " + "Product: " + "'"+pcGames[i]+"'");
                    System.out.println("    Price: " + pcGamePrices[i] + " PHP");
                    System.out.println("    Stock: " + pcGameStock[i]);
                    System.out.println("    Sold: " + pcGameSold[i]);
                    System.out.print(NEWLINE);
                }
                break;
            default:
                System.out.println("Invalid Input");
        }
        System.out.println("----------------------------");
    }

    /**
     * Displays the list of the purchasable Console products including their prices, 
     * current number of stock, and current number of sold items.
     */
    public void consoleItems() {
        System.out.print(NEWLINE);
        System.out.println("------- Product List -------");
        System.out.println("Category > Consoles");
        for (int i = 0; i < consoles.length; i++) {
            int itemNum = i;
            itemNum+=1;
            System.out.println("{"+ itemNum + "} " + "Product: " + "'"+consoles[i]+"'");
            System.out.println("    Price: " + consolePrices[i] + " PHP");
            System.out.println("    Stock: " + consoleStock[i]);
            System.out.println("    Sold: " + consoleSold[i]);
            System.out.print(NEWLINE);
        }
        System.out.println("----------------------------");
    }

    /** 
     * Displays the list of the purchasable PC Peripheral products including their prices, 
     * current number of stock, and current number of sold items. Contains a <code>switch statement</code>
     * that will print the list of product in accordance to the type of peripheral selected by the user.
     * 
     * @param selectedPeripheral the number that corresponds to the type of peripheral that the user wants 
     *                           to purchase (1 = Keyboard, 2 = Mouse, 3 = Headset, 4 = Monitor, 5 = Speaker).
     */
    public void pcPeripheralItems(int selectedPeripheral) {
        System.out.println("------- Product List -------");
        switch (selectedPeripheral) {
            case 1:
                System.out.println("Category > PC Peripherals > Keyboard");
                for (int i = 0; i < keyboards.length; i++) {
                    int itemNum = i;
                    itemNum+=1;
                    System.out.println("{"+ itemNum + "} " + "Product: " + "'"+keyboards[i]+"'");
                    System.out.println("    Price: " + keyboardPrices[i] + " PHP");
                    System.out.println("    Stock: " + keyboardStock[i]);
                    System.out.println("    Sold: " + keyboardSold[i]);
                    System.out.print(NEWLINE);
                }
                break;
            case 2:
                System.out.println("Category > PC Peripherals > Mouse");
                for (int i = 0; i < mouse.length; i++) {
                    int itemNum = i;
                    itemNum+=1;
                    System.out.println("{"+ itemNum + "} " + "Product: " + "'"+ mouse[i]+"'");
                    System.out.println("    Price: " + mousePrices[i] + " PHP");
                    System.out.println("    Stock: " + mouseStock[i]);
                    System.out.println("    Sold: " + mouseSold[i]);
                    System.out.print(NEWLINE);
                }
                break;
            case 3:
                System.out.println("Category > PC Peripherals > Headset");
                for (int i = 0; i < mouse.length; i++) {
                    int itemNum = i;
                    itemNum+=1;
                    System.out.println("{"+ itemNum + "} " + "Product: " + "'"+ headset[i]+"'");
                    System.out.println("    Price: " + headsetPrices[i] + " PHP");
                    System.out.println("    Stock: " + headsetStock[i]);
                    System.out.println("    Sold: " + headsetSold[i]);
                    System.out.print(NEWLINE);
                }
                break;
            case 4: 
                System.out.println("Category > PC Peripherals > Monitor");
                for (int i = 0; i < mouse.length; i++) {
                    int itemNum = i;
                    itemNum+=1;
                    System.out.println("{"+ itemNum + "} " + "Product: " + "'"+ monitor[i]+"'");
                    System.out.println("    Price: " + monitorPrices[i] + " PHP");
                    System.out.println("    Stock: " + monitorStock[i]);
                    System.out.println("    Sold: " + monitorSold[i]);
                    System.out.print(NEWLINE);
                }
                break;
            case 5:
                System.out.println("Category > PC Peripherals > Speaker");
                for (int i = 0; i < mouse.length; i++) {
                    int itemNum = i;
                    itemNum+=1;
                    System.out.println("{"+ itemNum + "} " + "Product: " + "'"+ speaker[i]+"'");
                    System.out.println("    Price: " + speakerPrices[i] + " PHP");
                    System.out.println("    Stock: " + speakerStock[i]);
                    System.out.println("    Sold: " + speakerSold[i]);
                    System.out.print(NEWLINE);
                }
                break;
            default:
                System.out.println("Invalid Input");
        }
        System.out.println("----------------------------");
    }
}
