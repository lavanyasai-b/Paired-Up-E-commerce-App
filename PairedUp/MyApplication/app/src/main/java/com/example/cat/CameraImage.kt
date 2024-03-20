package com.example.cat
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class CamActivity : AppCompatActivity() {
    private lateinit var clickImageId: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_image)
        val cameraOpenId: Button = findViewById(R.id.thisbutton)
        clickImageId = findViewById(R.id.click_image)



        cameraOpenId.setOnClickListener(View.OnClickListener { v: View? ->
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, pic_id)
        })
    }

    // This method will help to retrieve the image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val backB : Button  =findViewById(R.id.button4)
        super.onActivityResult(requestCode, resultCode, data)
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            val photo = data!!.extras!!["data"] as Bitmap?
            // Set the image in imageview for display
            clickImageId.setImageBitmap(photo)

        }

        backB.setOnClickListener{
            onBackClicked()
        }
    }

    companion object {
        // Define the pic id
        private const val pic_id = 123
    }

    private fun onBackClicked(){
        val intent = Intent(this, CartActivity::class.java)
        startActivity(intent)
    }
}
