package com.lucassimao.cabojosiasinforma.problem_notifications.presentation.ui

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lucassimao.cabojosiasinforma.R
import com.lucassimao.cabojosiasinforma.databinding.ProblemNotificationsFragmentBinding
import com.lucassimao.cabojosiasinforma.problem_notifications.presentation.model.ProblemNotificationUiModel
import com.lucassimao.cabojosiasinforma.problem_notifications.presentation.view_model.ProblemNotificationViewModel
import com.lucassimao.cabojosiasinforma.problem_notifications.util.ConstantsForPermissions.CAMERA_REQUEST_CODE
import com.lucassimao.cabojosiasinforma.problem_notifications.util.ConstantsForPermissions.STORAGE_REQUEST_CODE
import com.lucassimao.cabojosiasinforma.problem_notifications.util.CropImageContract
import com.lucassimao.cabojosiasinforma.problem_notifications.util.ImagePickerDialog
import com.lucassimao.cabojosiasinforma.problem_notifications.util.PermissionUtils
import com.theartofdev.edmodo.cropper.CropImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProblemNotificationFragment : Fragment() {
    private lateinit var binding: ProblemNotificationsFragmentBinding

    private val cameraPermission = arrayOf(Manifest.permission.CAMERA)
    private val storagePermission = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)

    private val cropImageLauncher = registerForActivityResult(CropImageContract()) { result ->
        handleCropResult(result)
    }

    private var image1: String = ""
    private var image2: String = ""
    private var image3: String = ""

    private val problemViewModel: ProblemNotificationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProblemNotificationsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.problemImageButton1.setOnClickListener {
            showImagePickerDialog()
        }
        binding.problemImageButton2.setOnClickListener {
            showImagePickerDialog()
        }
        binding.problemImageButton3.setOnClickListener {
            showImagePickerDialog()
        }

        binding.problemSendButton.setOnClickListener {
            handleProblemSubmission()
        }
    }

    private fun handleProblemSubmission() {
        val location = getLocationInput()
        val description = getDescriptionInput()

        val problem = createProblemNotificationModel(location, description)

        val result = problemViewModel.sendProblemNotifications(problem)

        clearInputFields()

        Log.i("Problem", result)
    }

    private fun getLocationInput(): String {
        return binding.problemLocationEditText.text.toString()
    }

    private fun getDescriptionInput(): String {
        return binding.problemDescriptionEditText.text.toString()
    }

    private fun createProblemNotificationModel(
        location: String,
        description: String
    ): ProblemNotificationUiModel {
        return ProblemNotificationUiModel(
            location = location,
            description = description,
            image1 = image1,
            image2 = image2,
            image3 = image3
        )
    }

    private fun clearInputFields() {
        binding.problemLocationEditText.setText("")
        binding.problemDescriptionEditText.setText("")
    }

    private fun showImagePickerDialog() {
        val dialog = ImagePickerDialog(requireContext(),
            onCameraSelected = {
                if (!PermissionUtils.checkPermission(
                        requireContext(),
                        Manifest.permission.CAMERA
                    )
                ) {
                    PermissionUtils.requestPermission(
                        requireActivity(),
                        cameraPermission,
                        CAMERA_REQUEST_CODE
                    )
                } else {
                    startImageCropActivity()
                }
            },
            onGallerySelected = {
                if (!PermissionUtils.checkPermission(
                        requireContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                ) {
                    PermissionUtils.requestPermission(
                        requireActivity(),
                        storagePermission,
                        STORAGE_REQUEST_CODE
                    )
                } else {
                    startImageCropActivity()
                }
            }
        )
        dialog.show()
    }

    private fun startImageCropActivity() {
        cropImageLauncher.launch(null)
    }

    private fun handleCropResult(result: CropImage.ActivityResult) {
        if (result.isSuccessful) {
            val resultUri: Uri = result.uri
            image1 = resultUri.toString()
            image2 = resultUri.toString()
            image3 = resultUri.toString()

//            Picasso.get().load(resultUri).into(binding.)
        } else {
            Log.e("CropError", result.error?.message.toString())
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        PermissionUtils.handlePermissionResult(
            requestCode, permissions, grantResults,
            CAMERA_REQUEST_CODE,
            onPermissionGranted = { startImageCropActivity() },
            onPermissionDenied = { showToast(requireContext().getString(R.string.camera_permission_denied)) }
        )

        PermissionUtils.handlePermissionResult(
            requestCode, permissions, grantResults,
            STORAGE_REQUEST_CODE,
            onPermissionGranted = { startImageCropActivity() },
            onPermissionDenied = { showToast(requireContext().getString(R.string.storage_permission_denied)) }
        )
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}