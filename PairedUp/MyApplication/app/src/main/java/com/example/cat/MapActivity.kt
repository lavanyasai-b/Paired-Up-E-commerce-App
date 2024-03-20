package com.example.cat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.example.cat.FirstActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity() {

    private lateinit var titleTxt: EditText
    private lateinit var latitudeTxt: EditText
    private lateinit var longitudeTxt: EditText
    private lateinit var pinIb: ImageButton
    private lateinit var zoomInIb: ImageButton
    private lateinit var zoomOutIb: ImageButton
    private lateinit var mapview: MapView
    private lateinit var logoutId: TextView
    private lateinit var googleMap: GoogleMap
    private lateinit var latLng: LatLng
    private lateinit var nextButton: Button
    private var currentZoomLevel = 15f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        initComponents()
        setupListeners()
        mapview.onCreate(savedInstanceState)
    }

    private fun initComponents() {
        titleTxt = findViewById(R.id.title_txt)
        latitudeTxt = findViewById(R.id.latitude_txt)
        longitudeTxt = findViewById(R.id.longitude_txt)
        pinIb = findViewById(R.id.pin_btn)
        zoomInIb = findViewById(R.id.zoom_in_btn)
        zoomOutIb = findViewById(R.id.zoom_out_btn)
        mapview = findViewById(R.id.map_view)
        nextButton = findViewById(R.id.button2)
    }

    private fun setupListeners() {
        pinIb.setOnClickListener { onPinClicked() }
        mapview.getMapAsync { googleMap ->
            this.googleMap = googleMap
        }
        zoomInIb.setOnClickListener {
            onZoomInClicked()
        }
        zoomOutIb.setOnClickListener {
            onZoomOutClicked()
        }
        nextButton.setOnClickListener{
            onClickedNext()
        }

    }

    private fun getEnteredTitle(): String {
        return titleTxt.text.toString()
    }

    private fun getEnteredLatitude(): Double {
        return latitudeTxt.text.toString().toDouble()
    }

    private fun getEnteredLongitude(): Double {
        return longitudeTxt.text.toString().toDouble()
    }

    private fun onPinClicked() {
        latLng = LatLng(getEnteredLatitude(), getEnteredLongitude())
        showMarker(latLng)
    }

    private fun showMarker(latLng: LatLng) {
        val markerOptions = MarkerOptions()
            .position(latLng).title(getEnteredTitle())
        googleMap.addMarker(markerOptions)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, currentZoomLevel))
        googleMap.isTrafficEnabled = false
        googleMap.isBuildingsEnabled = true
    }

    private fun onZoomInClicked() {
        currentZoomLevel++
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, currentZoomLevel))

    }

    private fun onZoomOutClicked() {
        currentZoomLevel--
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, currentZoomLevel))

    }

    override fun onResume() {
        super.onResume()
        mapview.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapview.onResume()
    }

    override fun onStop() {
        super.onStop()
        mapview.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapview.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapview.onLowMemory()
    }

    private fun onClickedNext() {

        val intent = Intent(this, LastActivity::class.java)
        startActivity(intent)
    }
}