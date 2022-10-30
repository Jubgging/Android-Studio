package com.example.Jupgging

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity //기본
import android.os.Bundle //기본
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butt.setOnClickListener {
            checkPermission()
        }
    }
}

    fun checkPermission() {
        //카메라 권한의 승인 상태 가져오기
        val cameraPermission =
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)

        if (cameraPermission == PackageManager.PERMISSION_GRANTED) {
            // 상태가 승인일 경우에는 코드 진행
            startProcess()
        } else {
            //승인되지 않았다면 권한 요청 프로세스 진행
            requestPermission()
        }
    }
            private fun requestPermission(){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),99)
            }
            private fun startProcess(){
                Toast.makeText(this, "카메라를 실행 합니다." , Toast.LENGTH_SHORT).show()
            }
            override fun onRequestPermissionsResult(Int, Array<out String>,
                                                    grantResults: IntArray){
                when(requestCode){
                    99 -> {
                        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                            startProcess()
                        }
                        else{
                            finish()
                        }
                    }
                }
            }
