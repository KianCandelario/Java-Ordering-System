package OrderingSystem;

/**
 * Contains all the vouchers that the user can use in order to get a free shipping.
 * 
 * @author Kian Candelario
 */
class Vouchers {
    // Variable
    public boolean verified = false;
    
    // List of vouchers
    public String[] voucherCodes = {
        "FREESHIP",
        "NOPAYSHIPPING",
        "0SHIPPING",
        "ZEROCOSTSHIPPING",
        "NOCOSTSHIP"
    };
    
    /**
     * Checks if the entered voucher code by the user exists
     * <p>
     *      This method will register the voucher code that the user entered and verify it if it matches the 
     *      existing vouchers by iterating the <code>String[] voucherCodes</code> using a <code>for loop</code>.
     *      If the entered voucher exists, this method will set the <code>verified</code> variable to 
     *      <code>true</code>. Otherwise, the value of <code>verified</code> variable will remain <code>false</code>.
     * </p>
     * 
     * @param voucher the voucher code that the user entered.
     * 
     * @return the verified variable.
     */
    // A function that verify if the voucher is correct
    public boolean voucherVerifier(String voucher) {
        for (int i = 0; i < voucherCodes.length; i++) {
            if (voucherCodes[i].equals(voucher)) { 
                verified = true;
                break;
            }   
        }
        return verified;
    }
}
