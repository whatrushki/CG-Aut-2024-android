package com.chillrate.ui.components.widget

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.chillrate.ui.theme.SHUITheme.palettes
import kotlinx.coroutines.launch


val LocalSheetProvider = staticCompositionLocalOf<SheetProvider> { error("непон") }

interface SheetProvider {
    val cancellable: Boolean
    val content: @Composable () -> Unit
    fun setContent(value: @Composable () -> Unit)
    fun setCancellable(value: Boolean)
    fun open()
    fun close()
    fun animateClose()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProvideGlobalSheet(
    start: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val state = rememberModalBottomSheetState()
    val (open, setOpen) = remember { mutableStateOf(false) }
    val provider = remember {
        object : SheetProvider {
            private val _content: MutableState<@Composable () -> Unit> = mutableStateOf(start)
            override val content get() = _content.value
            override fun setContent(value: @Composable () -> Unit) {
                _content.value = value
            }

            private val _cancellable: MutableState<Boolean> = mutableStateOf(true)
            override val cancellable: Boolean get() = _cancellable.value
            override fun setCancellable(value: Boolean) {
                _cancellable.value = value
            }

            override fun open() = setOpen(true)
            override fun close() = setOpen(false)
            override fun animateClose() {
                scope.launch { state.hide() }
                    .invokeOnCompletion { setOpen(false) }
            }
        }
    }

    CompositionLocalProvider(
        LocalSheetProvider provides (provider as SheetProvider)
    ) {
        content()

        if (open) ModalBottomSheet(
            onDismissRequest = { if (provider.cancellable) setOpen(false) },
            sheetState = state,
            containerColor = palettes.card,
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                AnimatedContent(
                    targetState = provider.content,
                    transitionSpec = {
                        fadeIn() togetherWith fadeOut()
                    }, label = "AnimatedSheetContent"
                ) { sheetContent -> sheetContent() }
            }
        }
    }
}