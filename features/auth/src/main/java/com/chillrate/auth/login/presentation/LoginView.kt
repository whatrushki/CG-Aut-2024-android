package com.chillrate.auth.login.presentation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import app.whatrushik.what_shadcn_ui.core.react.useState
import com.chillrate.auth.login.domain.models.LoginEvent
import com.chillrate.auth.login.domain.models.LoginState
import com.chillrate.foundation.core.Listener
import com.chillrate.ui.components.button.Button
import com.chillrate.ui.components.button.ButtonMode
import com.chillrate.ui.components.spacer.Space
import com.chillrate.ui.components.topbar.TopAppBar
import com.chillrate.ui.components.widget.BaseTextField
import com.chillrate.ui.theme.SHUITheme.palettes
import com.chillrate.ui.theme.SHUITheme.spacing
import com.chillrate.ui.theme.SHUITheme.typography
import com.chillrate.ui.utils.OnKeyboardHiddenListener

@Composable
internal fun LoginView(
    state: LoginState,
    listener: Listener<LoginEvent>
) {
    val focusManager = LocalFocusManager.current

    val (login, setLogin) = useState(state.login)
    val (password, setPassword) = useState(state.password)

    val updateAll = {
        listener(
            LoginEvent.OnFocusTakenOff(login, password)
        )
    }

    OnKeyboardHiddenListener {
        updateAll()
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = spacing.md.dp)
            .padding(top = spacing.lg.dp)
            .padding(bottom = spacing.md.dp)
            .padding(
                WindowInsets.systemBars
                    .only(WindowInsetsSides.Vertical)
                    .asPaddingValues()
            )
            .onFocusChanged {
                if (!it.hasFocus) updateAll()
            }
    ) {
        Column {
            TopAppBar(title = "Авторизация")

            Space(spacing.sm)

            Text(
                text = "Для входа в приложение введите логин и пароль. Если забыли пароль, воспользуйтесь опцией его восстановления:",
                style = typography.subtleMedium,
                color = palettes.foreground
            )

            Space(spacing.md)

            BaseTextField(
                value = login,
                onValueChange = setLogin,
                placeholder = "Логин",
                actions = KeyboardActions {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )

            Space(spacing.md)

            BaseTextField(
                value = password,
                onValueChange = setPassword,
                placeholder = "Пароль",
                actions = KeyboardActions {
                    focusManager.clearFocus()
                }
            )

            Space(spacing.md)

            Column {
                Button(
                    fill = true,
                    label = "Войти"
                ) { listener(LoginEvent.OnLoginClicked) }

                Space(spacing.md)

                Button(
                    fill = true,
                    label = "Зарегистрироваться",
                    mode = ButtonMode.Secondary
                ) { listener(LoginEvent.OnRegisterClicked) }
            }
        }
    }
}