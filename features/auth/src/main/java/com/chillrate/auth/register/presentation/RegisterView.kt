package com.chillrate.auth.register.presentation

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import app.whatrushik.what_shadcn_ui.core.react.useState
import com.chillrate.auth.register.domain.models.RegisterEvent
import com.chillrate.auth.register.domain.models.RegisterState
import com.chillrate.foundation.core.Listener
import com.chillrate.navigation.core.rememberNavigator
import com.chillrate.ui.components.button.Button
import com.chillrate.ui.components.spacer.Space
import com.chillrate.ui.components.topbar.TopAppBar
import com.chillrate.ui.components.widget.BaseTextField
import com.chillrate.ui.components.widget.CategoryFieldsBox
import com.chillrate.ui.icons.ArrowLeftRight
import com.chillrate.ui.theme.SHUIIcons
import com.chillrate.ui.theme.SHUITheme.spacing
import com.chillrate.ui.utils.OnKeyboardHiddenListener

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun RegisterView(
    state: RegisterState,
    listener: Listener<RegisterEvent>
) {
    val navigator = rememberNavigator()
    val focusManager = LocalFocusManager.current

    val (name, setName) = useState(state.name)
    val (surname, setSurname) = useState(state.surname)
    val (patronymic, setPatronymic) = useState(state.patronymic)
    val (login, setLogin) = useState(state.surname)
    val (password, setPassword) = useState(state.patronymic)
    val (repeatPassword, setRepeatPassword) = useState(state.patronymic)

    val updateAll = {
        listener(
            RegisterEvent.OnFocusTakenOff(
                name, surname, patronymic,
                login, password, repeatPassword
            )
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
            TopAppBar(
                title = "Регистрация",
                onBackPress = navigator.c::navigateUp
            )

            Space(spacing.sm)

            CategoryFieldsBox(
                icon = SHUIIcons.ArrowLeftRight,
                title = "Заоплните информацию о себе",
            ) {
                BaseTextField(
                    value = name,
                    onValueChange = setName,
                    placeholder = "Имя",
                    actions = KeyboardActions {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )

                BaseTextField(
                    value = surname,
                    onValueChange = setSurname,
                    placeholder = "Фамилия",
                    actions = KeyboardActions {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )

                BaseTextField(
                    value = patronymic,
                    onValueChange = setPatronymic,
                    placeholder = "Отчество",
                    actions = KeyboardActions {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            }

            Space(spacing.sm)

            CategoryFieldsBox(
                icon = SHUIIcons.ArrowLeftRight,
                title = "Придумайте логин и пароль",
            ) {
                BaseTextField(
                    value = login,
                    onValueChange = setLogin,
                    placeholder = "Логин",
                    actions = KeyboardActions {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )

                BaseTextField(
                    value = password,
                    onValueChange = setPassword,
                    placeholder = "Пароль",
                    actions = KeyboardActions {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )

                BaseTextField(
                    value = repeatPassword,
                    onValueChange = setRepeatPassword,
                    placeholder = "Повторите пароль",
                    actions = KeyboardActions {
                        focusManager.clearFocus()
                    }
                )
            }

            Space(spacing.sm)
        }

        Button(
            fill = true,
            label = "Зарегистрироваться"
        ) { listener(RegisterEvent.OnRegisterClicked) }
    }
}