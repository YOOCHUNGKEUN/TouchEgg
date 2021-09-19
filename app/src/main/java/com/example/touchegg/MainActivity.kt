package com.example.touchegg

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.LoginFilter
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.example.touchegg.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var mainBinding:ActivityMainBinding
    val mTARGET_TOUCH_NUM = 30
    var mSTART_TOUCH_NUM = 1
    var mImageResourceNum = 0
    var mResult = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        var shake = AnimationUtils.loadAnimation(this,R.anim.shake)
        var mImageResource = arrayOf(resources.getDrawable(R.drawable.egg_1),resources.getDrawable(R.drawable.egg_2),resources.getDrawable(R.drawable.egg_3)
            ,resources.getDrawable(R.drawable.egg_4),resources.getDrawable(R.drawable.egg_5))

        //이미지 변환 5단계
        mResult = mTARGET_TOUCH_NUM/5
        mainBinding.constlMainBody.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {

                if(mSTART_TOUCH_NUM==mTARGET_TOUCH_NUM){
                    shake.cancel()
                    mainBinding.ivMainEgg.background = resources.getDrawable(R.drawable.egg_6)
                    mainBinding.ivFinishEgg.visibility = View.VISIBLE
                    return
                }
                ++mSTART_TOUCH_NUM
                mainBinding.ivMainEgg.startAnimation(shake)

                Log.d("loglog","mResult : ${mResult}")
                Log.d("loglog","mTARGET_TOUCH_NUM : ${mTARGET_TOUCH_NUM}")
                Log.d("loglog","mTouchNum : ${mSTART_TOUCH_NUM}")
                Log.d("loglog","mImageResourceNum : ${mImageResourceNum}")

                //각 단계별로 이미지 변경
                if(mSTART_TOUCH_NUM%mResult==0){
                    mainBinding.ivMainEgg.background = mImageResource[mImageResourceNum]
                    mImageResourceNum++
                }
            }
        })

    }

}//class end