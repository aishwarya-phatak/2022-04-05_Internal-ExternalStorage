package com.example.externalinternalstorage

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /*  var extStorageState = Environment.getExternalStorageState()
        if(extStorageState.equals(Environment.MEDIA_MOUNTED))
        {
            mt("This is Media Mounted Storage with Read & Write Access")
        }

        if(extStorageState.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
        {
            mt("This is Media Mounted Read Only Storage")
        }


        var rootDir : File = Environment.getExternalStorageDirectory()
        mt("The root directory is : ${rootDir.absolutePath}")
        Log.e("tag","${rootDir.absolutePath}")

        var extRootDir : File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
        mt("The external Root Directory for Movies is : ${extRootDir.absolutePath} ")
        Log.e("tag","${extRootDir.absolutePath}")

        var extMusicRootDir : File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
        mt("The Music Directory is : ${extMusicRootDir.absolutePath}")
        Log.e("tag","${extMusicRootDir.absolutePath}")

        var extAppRootDir = Environment.getExternalStorageDirectory()
        mt("The APP root dir is : ${extAppRootDir.absolutePath}")
        Log.e("tag","${extAppRootDir.absolutePath}")

        var extAppMoviesDir = getExternalFilesDir(Environment.DIRECTORY_MOVIES)
        mt("The App Movies Dir is : ${extAppMoviesDir?.absolutePath}")
        Log.e("tag","${extAppMoviesDir?.absolutePath}")

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            var storageDir = Environment.getStorageDirectory()
            mt("${storageDir.absolutePath}")
        }

       */
        //internal Storage
        var fileOutputStream : FileOutputStream = openFileOutput("my_textFile1",Activity.MODE_PRIVATE)
        fileOutputStream.write("Android Class".toByteArray())
        fileOutputStream.write("Learning Android".toByteArray())
        fileOutputStream.close()

        var fileInputStream : FileInputStream = openFileInput("my_textFile1")
        var count = 0
        var data = ByteArray(1024 * 2)
        count = fileInputStream.read(data)
        while(count!=-1){
            Log.e("tag",String(data,0,count))
            count = fileInputStream.read(data)
        }
        fileInputStream.close()
    }

    private fun mt(text : String){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }
}