package com.Drishti.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.Drishti.myapplication.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(
            resources.getString(
                R.string.app_name
            ), MODE_PRIVATE
        )
        editor = sharedPreferences.edit()
        if (sharedPreferences.getString("language", "").isNullOrEmpty() == false) {
            val locale = Locale(sharedPreferences.getString("language", ""))
            val config = this.resources.configuration
            config.setLocale(locale)
            createConfigurationContext(config)
            resources.updateConfiguration(config, resources.displayMetrics)
            if (sharedPreferences.getBoolean("dark",false)){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        binding.btnChange1.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle(resources.getString(R.string.change_language))
                setMessage(resources.getString(R.string.change_language_message))
                setPositiveButton(resources.getString(R.string.Punjabi)) { _, _ ->
                    val locale = Locale("pa")
                    Locale.setDefault(locale)
                    val config = context.resources.configuration
                    config.setLocale(locale)
                    context.createConfigurationContext(config)
                    context.resources.updateConfiguration(config, context.resources.displayMetrics)
                    editor.putString("language", "pa")
                    editor.commit()
                    editor.apply()
                    startActivity(Intent(this@MainActivity, MainActivity::class.java))
                    this@MainActivity.finish()
                }
                setNegativeButton(resources.getString(R.string.English)) { _, _ ->
                    val locale = Locale("en")
                    Locale.setDefault(locale)
                    val config = context.resources.configuration
                    config.setLocale(locale)
                    context.createConfigurationContext(config)
                    context.resources.updateConfiguration(config, context.resources.displayMetrics)
                    editor.putString("language", "en")
                    editor.commit()
                    editor.apply()
                    startActivity(Intent(this@MainActivity, MainActivity::class.java))
                    this@MainActivity.finish()
                }
                setNeutralButton(resources.getString(R.string.Hindi)) { _, _ ->
                    val locale = Locale("hi")
                    Locale.setDefault(locale)
                    val config = context.resources.configuration
                    config.setLocale(locale)
                    context.createConfigurationContext(config)
                    context.resources.updateConfiguration(config, context.resources.displayMetrics)
                    editor.putString("language", "hi")
                    editor.commit()
                    editor.apply()
                    startActivity(Intent(this@MainActivity, MainActivity::class.java))
                    this@MainActivity.finish()

                }
            }
        }
        binding.btnChangetheme2.setOnClickListener {
            AlertDialog.Builder(this@MainActivity).apply {
                setTitle(resources.getString(R.string.change_color_theme))
                setPositiveButton(resources.getString(R.string.dark_theme)) { _, _ ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    editor.putBoolean("dark", true)
                    editor.commit()
                    editor.apply()
                }
                setNegativeButton(resources.getString(R.string.Light_theme)){_,_->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    editor.putBoolean("light",false)
                    editor.apply()
                    editor.commit()
            }
                show()
        }

//        val ivDot = findViewById<ImageView>(R.id.ivDot)
//        ivDot.setOnClickListener {
//            showAlertDialog()
//        }
//    }
//
//    private fun showAlertDialog() {
//        val alertDialogBuilder = AlertDialog.Builder(this)
//        alertDialogBuilder.setTitle("Alert")
//        alertDialogBuilder.setMessage("This is an alert dialog!")
//        // Set positive button
//        alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->
//            Toast.makeText(this, "OK clicked", Toast.LENGTH_SHORT).show()
//            dialog.dismiss()
//        }
//        // Set negative button
//        alertDialogBuilder.setNegativeButton("Cancel") { dialog, _ ->
//            Toast.makeText(this, "Cancel clicked", Toast.LENGTH_SHORT).show()
//            dialog.dismiss()
//        }
//        //Set natural button
//        alertDialogBuilder.setNeutralButton("Cancel") { dialog, _ ->
//            Toast.makeText(this, "Cancel clicked", Toast.LENGTH_SHORT).show()
//            dialog.dismiss()
//        }
//            // Create and show the dialog
//        val alertDialog = alertDialogBuilder.create()
//        alertDialog.show()
//    }
        }
    }
}