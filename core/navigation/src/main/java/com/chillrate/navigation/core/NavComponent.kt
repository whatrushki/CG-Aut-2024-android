package com.chillrate.navigation.core

import app.whatrsuhik.core.foundation.core.UIComponent

interface NavComponent<P : NavProvider> : UIComponent {
    val data: P
}