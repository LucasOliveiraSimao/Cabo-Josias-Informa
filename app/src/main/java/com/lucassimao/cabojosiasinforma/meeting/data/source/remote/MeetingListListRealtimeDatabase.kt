package com.lucassimao.cabojosiasinforma.meeting.data.source.remote

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.lucassimao.cabojosiasinforma.core.firebase.ReferencesDatabase
import com.lucassimao.cabojosiasinforma.meeting.data.model.MeetingDataModel
import com.lucassimao.cabojosiasinforma.meeting.data.source.MeetingListDataSource
import javax.inject.Inject

class MeetingListListRealtimeDatabase @Inject constructor(
    private val databaseReference: DatabaseReference
) : MeetingListDataSource {
    override fun fetchMeetings(callback: MeetingListCallback) {
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val meetings = snapshot.child(ReferencesDatabase.MEETING)
                        .children
                        .mapNotNull {
                            it.getValue(MeetingDataModel::class.java)?.apply {
                                id = it.key?.toIntOrNull() ?: 0
                            }
                        }
                        .sortedByDescending { it.id }
                    callback.onSuccess(meetings)
                } else {
                    callback.onSuccess(emptyList())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback.onError(error)
            }
        })
    }
}