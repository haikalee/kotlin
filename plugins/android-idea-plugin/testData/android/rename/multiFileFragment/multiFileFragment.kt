package com.myapp

import android.app.Fragment
import kotlinx.android.synthetic.layout.*

class MyFragment: Fragment() {
    val button = this.login<caret>
    val button1 = this.loginButton
}

