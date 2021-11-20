package com.example.android06

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android06.databinding.FragmentSecBinding
import com.google.android.material.snackbar.Snackbar


class SecFragment : Fragment() {

    lateinit var binding: FragmentSecBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSecBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAlert.setOnClickListener{
            val dialogBuilder = AlertDialog.Builder(context)

            dialogBuilder.setMessage("Do you want to close this application ?")

            val alert = dialogBuilder.create()

            alert.setTitle("Alert Dialog")

            alert.show()
        }

        binding.btnSnak.setOnClickListener{
            val snack = Snackbar.make(it,"This is a simple Snackbar", Snackbar.LENGTH_LONG)
            snack.show()
        }

        }



    }