package com.example.inventorymanagement

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }

        val products = listOf(
            Product("iPod", "Marty", 2006, 260.59),
            Product("PC", "Marty", 2009, 12.34),
            Product("OnePlus 6t", "Marty", 2020, 4999.99),
            Product("Airplane", "Marty", 1999, 500.00),
            Product("Kotlin", "Marty", 1776, 0.0)
        )

        var totalCost = 0.0

        products.forEach {
            d("marty", "Product is: $it")
            productsTextView.append("${it.name} - ${it.owner} - ${it.yearPurchased} - $${it.cost} \n\n")
            totalCost += it.cost
        }

        d("marty", "Total cost is $totalCost")

        totalCostTextView.text = "Total Cost: $ $totalCost"
    }
}
