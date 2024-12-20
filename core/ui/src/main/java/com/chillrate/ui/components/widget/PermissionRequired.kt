package com.chillrate.ui.components.widget

import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.chillrate.ui.theme.SHUITheme.palettes

@Composable
fun PermissionRequired(
    permission: String,
    permissionName: String,
    content: @Composable () -> Unit
) {
    var hasPermission by remember { mutableStateOf(false) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { hasPermission = it }
    )

    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) content()
    else { //Check for Android 12+
        hasPermission = ContextCompat.checkSelfPermission(
            LocalContext.current, permission
        ) == PackageManager.PERMISSION_GRANTED

        if (hasPermission) content()
        else Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = palettes.primary,
                contentColor = palettes.primaryForeground,
                disabledContentColor = palettes.mutedForeground,
                disabledContainerColor = palettes.muted
            ),
            onClick = { launcher.launch(permission) }
        ) { Text("Требуется разрешение $permissionName") }
    }
}