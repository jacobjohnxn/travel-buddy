import javax.naming.Context;

import android.content.Context;
import android.widget.Toast;

public class BookingUtil {
    public static void bookHotel(String hotelName, String checkInDate, String checkOutDate) {
        // HotelBookingUtil.java

public class HotelBookingUtil {
    public static void bookHotel(Context context, String hotelName, String checkInDate, String checkOutDate) {
        //API call to a hotel booking service
        boolean bookingSuccessful = makeHotelBookingAPIRequest(hotelName, checkInDate, checkOutDate);

        if (bookingSuccessful) {
            showToast(context, "Hotel booking successful!");
        } else {
            showToast(context, "Hotel booking failed. Please try again.");
        }
    }

    private static boolean makeHotelBookingAPIRequest(String hotelName, String checkInDate, String checkOutDate) {
        // Simulate a successful booking
        return true;
    }

    private static void showToast(Context context, String message) {
        // Display a toast message
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

    }

    public static void bookTaxi(String pickupLocation, String destination) {
        // TaxiBookingUtil.java

import android.content.Context;
import android.widget.Toast;

public class TaxiBookingUtil {
    public static void bookTaxi(Context context, String pickupLocation, String destination) {
        //API call to a taxi booking service
        boolean bookingSuccessful = makeTaxiBookingAPIRequest(pickupLocation, destination);

        if (bookingSuccessful) {
            showToast(context, "Taxi booking successful!");
        } else {
            showToast(context, "Taxi booking failed. Please try again.");
        }
    }

    private static boolean makeTaxiBookingAPIRequest(String pickupLocation, String destination) {
        // Simulate a successful booking
        return true;
    }

    private static void showToast(Context context, String message) {
        // Display a toast message
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

    }
}
