package com.example.datastorekullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.datastorekullanimi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)
        val ap = AppPref(this)
        val job = CoroutineScope(Dispatchers.Main).launch {
            var gelenSayac = ap.okuSayac()
            ap.kayitSayac(++gelenSayac)

            tasarim.textViewSayac.text = gelenSayac.toString()


            ap.kayitAd("Ahmet")
            ap.kayitYas(23)
            ap.kayitBoy(1.79)
            ap.kayitBekar(true)


            val liste = HashSet<String>()
            liste.add("Mehmet")
            liste.add("Zeynep")
            ap.kayitArkadasListe(liste)
            //ap.silAd()

            val gelenad = ap.okuAd()
            val gelenYas = ap.okuYas()
            val gelenBoy = ap.okuBoy()
            val gelenBekar = ap.okuBekar()
            val gelenArkadasListesi = ap.okuArkadasListe()
            Log.e("Gelen Ad", gelenad)
            Log.e("Gelen Boy", gelenBoy.toString())
            Log.e("Gelen Yas", gelenYas.toString())
            Log.e("Gelen Bekar", gelenBekar.toString())
            if (gelenArkadasListesi != null) {
                Log.e("Gelen Arkadas Listesi", gelenArkadasListesi.toString())

            } else {
                Log.e("Gelen Arkadas Listesi ","Boş")
            }
        }
    }
}