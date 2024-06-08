package com.lucassimao.cabojosiasinforma.project_list.data.source.remote

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.lucassimao.cabojosiasinforma.core.firebase.ReferencesDatabase
import com.lucassimao.cabojosiasinforma.project_list.data.model.ActionDataModel
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectDataModel
import com.lucassimao.cabojosiasinforma.project_list.data.model.ProjectListDataModel
import com.lucassimao.cabojosiasinforma.project_list.data.source.ProjectListDataSource
import com.lucassimao.cabojosiasinforma.project_list.data.source.remote.callback.ProjectCallback
import com.lucassimao.cabojosiasinforma.project_list.data.source.remote.callback.ProjectListCallback
import javax.inject.Inject

class ProjectListRealtimeDatabase @Inject constructor(
    private val databaseReference: DatabaseReference
) : ProjectListDataSource {

    override fun fetchProjectList(callback: ProjectListCallback) {
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val projectLists = snapshot.child(ReferencesDatabase.PROJECT_LIST)
                        .children
                        .mapNotNull { it.getValue(ProjectListDataModel::class.java) }
                    callback.onSuccess(projectLists)

                } else {
                    callback.onSuccess(emptyList())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback.onError(error)
            }

        })
    }

    override fun getProjectDetails(id: Int, callback: ProjectCallback) {
        val projectsRef = databaseReference.child(ReferencesDatabase.PROJECT)
        val query = projectsRef.orderByChild(ReferencesDatabase.ID).equalTo(id.toDouble())

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (projectSnapshot in dataSnapshot.children) {
                        val title = projectSnapshot.child(ReferencesDatabase.TITLE)
                            .getValue(String::class.java) ?: ""

                        val description = projectSnapshot.child(ReferencesDatabase.DESCRIPTION)
                            .getValue(String::class.java) ?: ""

                        val objectivesSnapshot = projectSnapshot.child(ReferencesDatabase.OBJECTIVES)

                        val objectives = objectivesSnapshot.children.map {
                            it.getValue(String::class.java) ?: ""
                        }

                        val actionsSnapshot = projectSnapshot.child(ReferencesDatabase.ACTIONS)

                        val actions = actionsSnapshot.children.map { actionSnapshot ->
                            val actionTitle = actionSnapshot.child(ReferencesDatabase.TITLE)
                                .getValue(String::class.java) ?: ""

                            val actionDescription = actionSnapshot.child(ReferencesDatabase.DESCRIPTION)
                                .getValue(String::class.java) ?: ""

                            ActionDataModel(actionTitle, actionDescription)
                        }

                        val createdAt = projectSnapshot.child(ReferencesDatabase.CREATED_AT)
                            .getValue(String::class.java) ?: ""

                        val updatedAt = projectSnapshot.child(ReferencesDatabase.UPDATED_AT)
                            .getValue(String::class.java) ?: ""

                        val project = ProjectDataModel(
                            id,
                            title,
                            description,
                            objectives,
                            actions,
                            createdAt,
                            updatedAt
                        )

                        callback.onSuccess(project)
                    }
                } else {
                    callback.onSuccess(ProjectDataModel())
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                callback.onError(databaseError)
            }
        })
    }
}