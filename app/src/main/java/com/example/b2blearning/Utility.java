package com.example.b2blearning;

import android.content.Context;
import android.widget.Toast;

public class Utility {
    public static boolean loginCheck(String email, String password, Context context) {
        boolean check = false;
        if (email.equals("")) {
            Toast.makeText(context, "Please submit an email", Toast.LENGTH_LONG).show();
        }
        else if (!email.contains("@") && !email.contains(".com")){
            Toast.makeText(context, "Use a valid e-mail such as:\n example@email.com", Toast.LENGTH_LONG).show();
        }
        else if (password.equals("")) {
            Toast.makeText(context, "Please submit a password", Toast.LENGTH_LONG).show();
        }
        else
        {
            check = true;
        }

        return check;
    }
}
