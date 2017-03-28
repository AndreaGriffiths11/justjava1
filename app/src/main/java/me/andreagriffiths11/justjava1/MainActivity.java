package me.andreagriffiths11.justjava1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

import me.andreagriffiths11.justjava1.R;

/**

 This app displays an order form to order coffee. Remember the global variable int quantity
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
    /***
     This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }
    /**
     * Calculates the price of the order.
     * returning the total price.
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
      orderSummaryTextView.setText(message);
    }

    /**
     * This method creates order summary.
     * @param price of the order
     * @return text summary
     */
    private String createOrderSummary(int price) {
        String priceMessage = "Name: Kaptain Kunal";
        priceMessage = priceMessage +"\nQuantity: " + quantity;
        priceMessage = priceMessage +"\nTotal: $" + price;
        priceMessage = priceMessage +"\nThank you!";
        return priceMessage;


    }

    }



