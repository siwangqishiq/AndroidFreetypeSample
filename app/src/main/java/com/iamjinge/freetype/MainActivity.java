package com.iamjinge.freetype;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = new File(getCacheDir() , "font.ttf");
        if(!file.exists()){
            System.out.println(file.getAbsoluteFile() + "文件不存在的");
            copyFiles(this , "font.ttf" , file);
        }else{
            System.out.println(file.getAbsoluteFile() + "文件OK");
        }
    }

    public static void copyFiles(Context context, String fileName, File desFile) {
        try(InputStream in = context.getApplicationContext().getAssets().open(fileName);
            OutputStream out = new FileOutputStream(desFile.getAbsolutePath());){
            byte[] bytes = new byte[1024];
            int i;
            while ((i = in.read(bytes)) != -1)
                out.write(bytes, 0 , i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
