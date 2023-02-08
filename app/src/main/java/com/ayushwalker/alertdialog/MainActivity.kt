package com.ayushwalker.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to Add Mr. Walker Number to your Contact List?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes"){ _, _ ->
                Toast.makeText(this,"You added Mr. Walker to your Contact List", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){ _, _ ->
                Toast.makeText(this,"You didn't add Mr. Walker to your Contact List", Toast.LENGTH_SHORT).show()
            }.create()
        // set icon color as Black as Alert Dialog box has white Background
        val btnDialog1 = findViewById<Button>(R.id.btnDialog1)
        btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        // for single choice multiple options
        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options,0){ dialogInterface, i ->
                Toast.makeText(this,"You checked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }.setPositiveButton("Accept"){ _, _ ->
                Toast.makeText(this,"You Accepted Single Choice Dialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){ _, _ ->
                Toast.makeText(this,"You Declined Single Choice Dialog", Toast.LENGTH_SHORT).show()
            }.create()

        val btnDialog2 = findViewById<Button>(R.id.btnDialog2)
        btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }


        // for multi Choice Dialog box options
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)){ _, i, isChecked ->
                if(isChecked){
                    Toast.makeText(this,"You checked on ${options[i]}", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"You Unchecked on ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }.setPositiveButton("Accept"){ _, _ ->
                Toast.makeText(this,"You Accepted Multi Choice Dialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){ _, _ ->
                Toast.makeText(this,"You Declined Multi Choice Dialog", Toast.LENGTH_SHORT).show()
            }.create()

        val btnDialog3 = findViewById<Button>(R.id.btnDialog3)
        btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}