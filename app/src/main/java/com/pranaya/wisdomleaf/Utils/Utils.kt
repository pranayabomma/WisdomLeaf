package com.pranaya.wisdomleaf.Utils

import android.app.Dialog
import android.content.Context
import android.net.NetworkInfo

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

import androidx.core.content.ContextCompat.getSystemService
import com.pranaya.wisdomleaf.R


class Utils {

    companion object {
        fun isOnline(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val capabilities =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                } else {
                    return false
                }
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    return true
                }
            }
            return false
        }


         fun showDialog(title: String,context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Message")
            builder.setMessage(title)
            builder.setNeutralButton("OK") { dialog, which ->
               dialog.dismiss()
            }
            builder.show()

        }

    }
}