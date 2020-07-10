package com.example.finalproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @Suppress("PrivatePropertyName")
    private val REQUEST_CODE: Int = 777
    private lateinit var providers: List<AuthUI.IdpConfig>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // spinner code

        val countryNames = arrayOf("US","GB","DE","RU")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,countryNames)
        // attack adapter to spinner
        country_spinner.adapter = arrayAdapter

        country_spinner.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // To change body of created
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selected_country_text_view.text = countryNames[position]
            }

        }



        //init firebase auth
        providers = listOf(
            AuthUI.IdpConfig.EmailBuilder().build(), // email login
            AuthUI.IdpConfig.GoogleBuilder().build() // google login

        )
        showSignInOptions()
        // Event
        sign_out_button.setOnClickListener{
            //SignOut
            AuthUI.getInstance().signOut(this@MainActivity)
                .addOnCompleteListener{
                    sign_out_button.isEnabled=false
                    showSignInOptions()
                }
                .addOnFailureListener{
                    e->Toast.makeText(this@MainActivity,e.message, Toast.LENGTH_SHORT).show()
                }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==REQUEST_CODE){
            val response = IdpResponse.fromResultIntent(data)
            if(resultCode== Activity.RESULT_OK){
                val user = FirebaseAuth.getInstance().currentUser // get current user
                Toast.makeText(this,""+user!!.email,Toast.LENGTH_SHORT).show()

                sign_out_button.isEnabled = true
            }
            else{
                Toast.makeText(this,""+response!!.error!!.message,Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun showSignInOptions(){
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().
        setAvailableProviders(providers).setTheme(R.style.LoginTheme).build(),REQUEST_CODE)
    }

    private fun getNews(newsTopic:String,newsCategory:String){

    }
}