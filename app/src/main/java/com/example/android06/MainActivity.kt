package com.example.android06

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.android06.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var  binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val secenttfragmint = SecFragment()
        val profileFragment = ProfileFragment()

        binding.bottomAppBar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> { restart() }
                R.id.fav -> setUpFragmint(secenttfragmint)
                R.id.profile -> setUpFragmint(profileFragment)
            }
            true
        }

        binding.toolbar.title="navigation drower app"

        val toggel = ActionBarDrawerToggle(this,
            binding.drowerLayout,
            binding.toolbar,
            R.string.open,
            R.string.close)

        toggel.syncState()
        binding.navigationDrower.setNavigationItemSelectedListener (object :NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.home -> { restart() }

                R.id.shear -> {
                    val send = Intent()
                    send.action = Intent.ACTION_SEND
                    send.putExtra(
                        Intent.EXTRA_TEXT,
                        "https://play.google.com/store/apps/details?id=com.seif.ZamalkawyAna"
                    )
                    send.type = "text/plain"
                    startActivity(Intent.createChooser(send,"choose app to shear with"))

                }

                R.id.rate ->{
                    val i = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.seif.ZamalkawyAna")
                    )
                    startActivity(i)
                }

                R.id.riveo -> {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(
                                "mailto:" + "hekar1987@gmail.com" + "?subject=" + "massage from hekar"
                            )
                        )
                    )
                }

                R.id.ourapp -> {
                    val i = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/developer?id=Software+Inversion")
                    )
                    startActivity(i)
                }


            }

                return true
            }

        })

    }

    private fun restart() {
        startActivity(Intent(this,MainActivity::class.java))
    }

    private fun setUpFragmint(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.freamelaiout,fragment).commit()
        }



    }
}