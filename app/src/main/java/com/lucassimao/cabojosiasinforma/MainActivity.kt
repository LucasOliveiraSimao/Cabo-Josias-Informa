package com.lucassimao.cabojosiasinforma

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.lucassimao.cabojosiasinforma.notification.NotificationHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToFragmentIfNeeded(intent)
        askNotificationPermissionIfNeeded()
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        handlePermissionResult(isGranted)
    }

    private fun handlePermissionResult(isGranted: Boolean) {
        if (!isGranted) {
            showToast(
                getString(R.string.warning_notifications_permission_denied),
                Toast.LENGTH_LONG
            )
        }
    }


    private fun askNotificationPermissionIfNeeded() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                isPermissionGranted(android.Manifest.permission.POST_NOTIFICATIONS) -> { }

                shouldShowRequestPermissionRationale(android.Manifest.permission.POST_NOTIFICATIONS) -> {
                    showPermissionRationale()
                }

                else -> {
                    requestNotificationPermission()
                }
            }
        }
    }

    private fun isPermissionGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun showPermissionRationale() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.warning_notification_permission_needed))
            .setMessage(getString(R.string.warning_this_app_needs_notification_permission))
            .setPositiveButton(getString(R.string.ok)) { dialog, _ ->
                requestNotificationPermission()
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.no_thanks)) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    private fun requestNotificationPermission() {
        requestPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
    }

    private fun showToast(message: String, duration: Int) {
        Toast.makeText(this, message, duration).show()
    }

    private fun navigateToFragmentIfNeeded(intent: Intent?) {
        if (intent?.action == NotificationHelper.ACTION_NOTIFICATION) {
            navigateToMeetingFragment()
        }
    }

    private fun navigateToMeetingFragment() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.findNavController().navigate(R.id.action_global_Fragment)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToFragmentIfNeeded(intent)
    }
}