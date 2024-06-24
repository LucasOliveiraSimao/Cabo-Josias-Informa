package com.lucassimao.cabojosiasinforma.biography.data.source.remote

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.lucassimao.cabojosiasinforma.biography.data.model.BiographyDataModel
import com.lucassimao.cabojosiasinforma.biography.data.source.BiographyDataSource
import com.lucassimao.cabojosiasinforma.core.firebase.ReferencesDatabase
import javax.inject.Inject

class BiographyRealtimeDatabase @Inject constructor(
    private val databaseReference: DatabaseReference
) : BiographyDataSource {

    override fun fetchBiography(callback: BiographyCallback) {
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val biographySnapshot = snapshot.child(ReferencesDatabase.BIOGRAPHY)
                    val biography = biographySnapshot.getValue(BiographyDataModel::class.java)

                    if (biography != null) {
                        Log.i("myTag", "Biography: $biography")
                        callback.onSuccess(biography)
                    } else {
                        Log.e("myTag", "Biography data is malformed or null")
                        callback.onError(DatabaseError.fromException(Exception("Biography data is malformed or null")))
                    }
                } else {
                    Log.e("myTag", "No biography data found")
                    callback.onError(DatabaseError.fromException(Exception("No biography data found")))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                    Log.e("myTag", "Database error: ${error.message}")
                    callback.onError(error)
                }
            })
    }


}