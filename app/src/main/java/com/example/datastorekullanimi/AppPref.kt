package com.example.datastorekullanimi

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(var context: Context) {
    val Context.ds : DataStore<Preferences> by preferencesDataStore("bilgiler")

    companion object {
        val AD_KEY = stringPreferencesKey("AD")
        val YAS_KEY = intPreferencesKey("YAS")
        val BOY_KEY = doublePreferencesKey("BOY")
        val BEKAR_KEY = booleanPreferencesKey("BEKAR")
        val ARKADAS_LİSTE_KEY = stringSetPreferencesKey("ARKADAS_LISTE")
    }

    suspend fun kayitAd(ad: String) { // Suspend olması işlem zaman alacak bekle demek.
        context.ds.edit {
            it[AD_KEY] = ad
        }
    }

    suspend fun okuAd(): String {
        val p = context.ds.data.first()
        return p[AD_KEY] ?: "isim yok"
    }

    suspend fun silAd() {
        context.ds.edit {
            it.remove(AD_KEY)
        }
    }
    suspend fun kayitYas(yas: Int) { // Suspend olması işlem zaman alacak bekle demek.
        context.ds.edit {
            it[YAS_KEY] = yas
        }
    }

    suspend fun okuYas(): Int {
        val p = context.ds.data.first()
        return p[YAS_KEY] ?: 0
    }
    suspend fun kayitBoy(boy: Double) { // Suspend olması işlem zaman alacak bekle demek.
        context.ds.edit {
            it[BOY_KEY] = boy
        }
    }

    suspend fun okuBoy(): Double {
        val p = context.ds.data.first()
        return p[BOY_KEY] ?: 0.0
    }
}