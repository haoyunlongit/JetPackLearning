package com.example.jetpack

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.io.StringWriter
import java.lang.Exception
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    @BindView(R.id.clickView) @JvmField var clickView: TextView? = null
    val PATH: String = "myFile"
    var threadPoolExecutor: ThreadPoolExecutor = ThreadPoolExecutor(
        3, 3, 20, TimeUnit.SECONDS, ArrayBlockingQueue(
            10
        )
    )
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        clickView?.setBackgroundColor(Color.RED)
        clickView?.setOnClickListener {
            threadPoolExecutor.run {
                execute {
//
                    val documents = getExternalFilesDirs(Environment.DIRECTORY_DOCUMENTS)
                    var file = File(
                        documents[0],
                        "TestFile.txt"
                    )
                    writeTxtToFile("我的哈哈哈哈哈", file);
//                    try {
//                        var content = readTxtFromFile(file)
//                        Log.i("hyl", "~~~~~$content")
//                    } catch (ex: java.lang.Exception) {
//
//                    }

                }
            }

//            threadPoolExecutor.run {
//                execute {
//                    Thread.sleep(100)
//                    val documents = getExternalFilesDirs(Environment.DIRECTORY_DOCUMENTS)
//                    var file = File(
//                        documents[0] ,
//                        "TestFile.txt"
//                    )
//                    var result = file.delete()
//                    Log.i("hyl", "delete $result")
//                }
//            }
        }
    }

    fun readTxtFromFile(file: File): String {
        val sb = StringBuilder("")
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            //打开文件输入流
            val inputStream = FileInputStream(file)
            val buffer = ByteArray(1024)
            var len: Int = inputStream.read(buffer)
            //读取文件内容
            while (len > 0) {
                sb.append(String(buffer, 0, len))

                //继续将数据放到buffer中
                len = inputStream.read(buffer)
            }
            //关闭输入流
            inputStream.close()
        }
        return sb.toString()
    }

    fun writeTxtToFile(strcontent: String, file: File) {
        // 每次写入时，都换行写
        val strContent = """
               $strcontent
               
               """.trimIndent()
       try {
           val inputStream: InputStream = FileInputStream(file)
           val writer = StringWriter()
           writer.write(strcontent)
       } catch (e : Exception) {
           Log.i("hyl", "write error")
       }

        var result = file.delete()
        Log.i("hyl", "delete $result")
    }


}
