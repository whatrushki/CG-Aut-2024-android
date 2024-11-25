package com.chillrate.main.children.profile.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import app.whatrushik.what_shadcn_ui.core.react.useState
import com.chillrate.foundation.core.Listener
import com.chillrate.main.children.profile.domain.models.ProfileEvent
import com.chillrate.main.children.profile.domain.models.ProfileState
import com.chillrate.ui.components.button.Button
import com.chillrate.ui.components.spacer.Space
import com.chillrate.ui.components.widget.BaseTextField
import com.chillrate.ui.theme.SHUITheme.spacing
import com.chillrate.ui.utils.OnKeyboardHiddenListener

@Composable
fun LoginForm(
    state: ProfileState,
    listener: Listener<ProfileEvent>,
) {
    val focusManager = LocalFocusManager.current

    val (name, setName) = useState(state.username)
    val (password, setPassword) = useState(state.password)

    val updateAll = {
        listener(ProfileEvent.OnFocusTakenOffOnLogin(name, password))
    }

    OnKeyboardHiddenListener(updateAll)

    Column(
        modifier = Modifier
            .padding(horizontal = spacing.md.dp)
            .padding(bottom = spacing.md.dp)
            .onFocusChanged {
                if (!it.hasFocus) updateAll()
            }
    ) {
        Space(spacing.sm)

        BaseTextField(
            value = name,
            onValueChange = setName,
            placeholder = "Имя пользователя",
            actions = KeyboardActions {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )

        Space(spacing.sm)

        BaseTextField(
            value = password,
            onValueChange = setPassword,
            placeholder = "Пароль",
            actions = KeyboardActions {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )

        Space(spacing.sm)

        Button(
            fill = true,
            label = "Войти"
        ) { listener(ProfileEvent.OnSubmitLoginClicked) }
    }
}