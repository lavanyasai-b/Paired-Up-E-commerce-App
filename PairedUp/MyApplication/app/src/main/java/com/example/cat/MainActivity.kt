package com.example.cat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso

class CartActivity : AppCompatActivity() {

    private lateinit var item1NameTxt: TextView
    private lateinit var item1QuantityTxt: TextView
    private lateinit var item1PriceTxt: TextView
    private lateinit var item1Iv: ImageView
    private lateinit var item1AddIb: ImageButton
    private lateinit var item1RemoveIb: ImageButton
    private lateinit var item1DeleteIb: ImageButton
    private lateinit var item1Layout: LinearLayout
    private lateinit var item1CancelIb: ImageButton

    private lateinit var item2NameTxt: TextView
    private lateinit var item2QuantityTxt: TextView
    private lateinit var item2PriceTxt: TextView
    private lateinit var item2Iv: ImageView
    private lateinit var item2AddIb: ImageButton
    private lateinit var item2RemoveIb: ImageButton
    private lateinit var item2DeleteIb: ImageButton
    private lateinit var item2Layout: LinearLayout
    private lateinit var item2CancelIb: ImageButton


    private lateinit var totalPriceTxt: TextView
    private lateinit var checkoutBtn: TextView
    private lateinit var buttonb: TextView
    private lateinit var customb: Button

    private val item1UnitPrice = 7.2
    private val item2UnitPrice = 3.2
    private lateinit var textView7Txt :TextView
    private lateinit var dateTxt :TextView
    private lateinit var textViewTxt : TextView
    private lateinit var textView2Txt :TextView
    //private lateinit var textView5Txt :TextView
    //private lateinit var textView3Txt :TextView
    private lateinit var editText: EditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initItem1Components()
        setupItem1Listeners()

        initItem2Components()
        setupItem2Listeners()

        initFooterComponents()
        setupFooterListeners()

        showItem1Data()
        showItem2Data()



    }

    private fun initItem1Components() {
        textView7Txt = findViewById(R.id.textView7)
        textViewTxt = findViewById(R.id.textView)
        item1NameTxt = findViewById(R.id.item1_name_txt)
        item1QuantityTxt = findViewById(R.id.item1_quantity_txt)
        item1PriceTxt = findViewById(R.id.item1_price_txt)
        item1Iv = findViewById(R.id.item1_iv)
        item1AddIb = findViewById(R.id.item1_add_ib)
        item1RemoveIb = findViewById(R.id.item1_remove_ib)
        item1DeleteIb = findViewById(R.id.item1_delete_ib)
        item1Layout = findViewById(R.id.item1_layout)
        item1CancelIb = findViewById(R.id.item1_cancel_ib)

        editText = findViewById(R.id.editTextText3)


    }

    private fun setupItem1Listeners() {
        item1AddIb.setOnClickListener { onItem1AddClicked() }
        item1RemoveIb.setOnClickListener { onItem1RemoveClicked() }
        item1DeleteIb.setOnClickListener { onItem1DeleteClicked() }
        item1CancelIb.setOnClickListener { onItem1CancelClicked() }
    }

    private fun showItem1Data() {
        textView7Txt.text="Catalog"
        textViewTxt.text="Earring"
        item1NameTxt.text = "12mm, 3g"
        Picasso.get()
            .load("https://i.pinimg.com/564x/ac/c3/f7/acc3f737684aba820cc12e8289229af1.jpg")
            .into(item1Iv)
        updateItem1Quantity(1)
    }

    private fun getItem1Quantity(): Int {
        return item1QuantityTxt.text.toString().toInt()
    }

    private fun getItem1Price(): Double {
        return item1PriceTxt.text.toString().toDouble()
    }

    private fun onItem1AddClicked() {
        val quantity = getItem1Quantity()
        updateItem1Quantity(quantity + 1)
    }

    private fun onItem1RemoveClicked() {
        val quantity = getItem1Quantity()
        updateItem1Quantity(quantity - 1)
    }

    private fun onItem1DeleteClicked() {
        updateItem1Quantity(0)
        item1Layout.visibility = View.GONE
    }

    private fun onItem1CancelClicked() {
        updateItem1Quantity(0)
        item1Layout.visibility = View.GONE
    }

    private fun updateItem1Quantity(quantity: Int) {
        val itemPrice = quantity * item1UnitPrice
        item1QuantityTxt.text = quantity.toString()
        item1PriceTxt.text = itemPrice.toString()
        if(quantity == 1) {
            showItem1Delete()
        } else {
            showItem1Remove()
        }
        updateTotal()
    }

    private fun showItem1Remove() {
        item1RemoveIb.visibility = View.VISIBLE
        item1DeleteIb.visibility = View.GONE
    }

    private fun showItem1Delete() {
        item1DeleteIb.visibility = View.VISIBLE
        item1RemoveIb.visibility = View.GONE
    }


    private fun initItem2Components() {
        textView2Txt = findViewById(R.id.textView2)
        item2NameTxt = findViewById(R.id.item2_name_txt)
        item2QuantityTxt = findViewById(R.id.item2_quantity_txt)
        item2PriceTxt = findViewById(R.id.item2_price_txt)
        item2Iv = findViewById(R.id.item2_iv)
        item2AddIb = findViewById(R.id.item2_add_ib)
        item2RemoveIb = findViewById(R.id.item2_remove_ib)
        item2DeleteIb = findViewById(R.id.item2_delete_ib)
        item2Layout = findViewById(R.id.item2_layout)
        item2CancelIb = findViewById(R.id.item2_cancel_ib)
    }

    private fun setupItem2Listeners() {
        item2AddIb.setOnClickListener { onItem2AddClicked() }
        item2RemoveIb.setOnClickListener { onItem2RemoveClicked() }
        item2DeleteIb.setOnClickListener { onItem2DeleteClicked() }
        item2CancelIb.setOnClickListener { onItem2CancelClicked() }
    }

    private fun showItem2Data() {
        textView2Txt.text = "Shoe"
        item2NameTxt.text = "Canvas,Black"
        Picasso.get()
            .load("https://i.pinimg.com/564x/87/4f/a6/874fa626377dedc4e04ed79c167ab90b.jpg")
            .into(item2Iv)
        updateItem2Quantity(1)
    }

    private fun getItem2Quantity(): Int {
        return item2QuantityTxt.text.toString().toInt()
    }

    private fun getItem2TotalPrice(): Double {
        return item2PriceTxt.text.toString().toDouble()
    }

    private fun onItem2AddClicked() {
        val quantity = getItem2Quantity()
        updateItem2Quantity(quantity + 1)
    }

    private fun onItem2RemoveClicked() {
        val quantity = getItem2Quantity()
        updateItem2Quantity(quantity - 1)
    }

    private fun onItem2DeleteClicked() {
        updateItem1Quantity(0)
        item2Layout.visibility = View.GONE
    }

    private fun onItem2CancelClicked() {
        updateItem2Quantity(0)
        item2Layout.visibility = View.GONE
    }

    private fun updateItem2Quantity(quantity: Int) {
        val itemPrice = quantity * item2UnitPrice
        item2QuantityTxt.text = quantity.toString()
        item2PriceTxt.text = itemPrice.toString()
        if(quantity == 1) {
            showItem2Delete()
        } else {
            showItem2Remove()
        }
        updateTotal()
    }

    private fun showItem2Remove() {
        item2RemoveIb.visibility = View.VISIBLE
        item2DeleteIb.visibility = View.GONE
    }

    private fun showItem2Delete() {
        item2DeleteIb.visibility = View.VISIBLE
        item2RemoveIb.visibility = View.GONE
    }

    private fun initFooterComponents() {

        totalPriceTxt = findViewById(R.id.total_price_txt)
        customb=findViewById(R.id.button3)
        checkoutBtn = findViewById(R.id.checkout_btn)
        buttonb=findViewById(R.id.button)
        dateTxt=findViewById(R.id.date_txt)
    }

    private fun setupFooterListeners() {
        buttonb.setOnClickListener {onAddDiscountClicked()}
        customb.setOnClickListener{onCustomClicked()}
        checkoutBtn.setOnClickListener { onCheckoutClicked() }
    }

    private fun updateTotal() {
        val totalPrice = getItem1Price() + getItem2TotalPrice()
        totalPriceTxt.text = totalPrice.toString()
    }

    private fun onAddDiscountClicked(){
        val discountedTotalPrice = 0.75 * (getItem1Price() + getItem2TotalPrice())
        dateTxt.text="You got 25% off your first order!"
        updateItem1Quantity(getItem1Quantity())
        updateItem2Quantity(getItem2Quantity())
        totalPriceTxt.text = discountedTotalPrice.toString()
        }

    private fun onCustomClicked(){
        val intent = Intent(this, CamActivity::class.java)
        startActivity(intent)
    }

    private fun onCheckoutClicked() {
        val intent = Intent(this, MapActivity::class.java)
        startActivity(intent)
    }
}