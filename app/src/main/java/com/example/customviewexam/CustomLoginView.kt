package com.example.customviewexam

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

class CustomLoginView(context: Context, attrs: AttributeSet?) : RelativeLayout(context, attrs) {

    init {
        val view =
            LayoutInflater.from(context).inflate(R.layout.custom_view_login_button, this, true)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.CustomLoginView)
            val customTitle = typedArray.getString(R.styleable.CustomLoginView_loginTitle)
            val customBgColor = typedArray.getColor(R.styleable.CustomLoginView_loginBgColor, Color.WHITE)
            val customTextColor = typedArray.getColor(R.styleable.CustomLoginView_loginTextColor, Color.BLACK)
            typedArray.recycle()

            val imageView = view.findViewById<ImageView>(R.id.customLoginImage)
            val textView = view.findViewById<TextView>(R.id.customLoginTitle)
            val layout = view.findViewById<RelativeLayout>(R.id.customLoginLayout)

            textView.apply {
                text = customTitle
                setTextColor(customTextColor)
            }

            layout.backgroundTintList = ColorStateList.valueOf(customBgColor)

            imageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    when (customTitle) {
                        "구글 로그인" -> {
                            R.drawable.login_google
                        }
                        "카카오 로그인" -> {
                            R.drawable.login_kakao
                        }
                        "네이버 로그인" -> {
                            R.drawable.login_naver
                        }
                        else -> {
                            R.mipmap.ic_launcher_round
                        }
                    },
                    null
                )
            )
        }
    }
}