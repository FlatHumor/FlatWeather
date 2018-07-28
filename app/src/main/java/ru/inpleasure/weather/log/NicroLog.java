package ru.inpleasure.weather.log;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.*;

public class NicroLog
{
    public static final String LOG_DIR = "/fssp_log";
    public static final String LOG_HEAD = " ***** %s ***** ";
    public static final String LOG_FOOT = " ****************** ";
    public static String logTag;
    
    public static String print(String text)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = Calendar.getInstance().getTime();
        StringBuilder logBlock = new StringBuilder();
        logBlock.append("\n\n");
        logBlock.append(String.format(LOG_HEAD, sdf.format(date)));
        logBlock.append("\n");
        logBlock.append(text);
        logBlock.append("\n");
        logBlock.append(LOG_FOOT);
        String filename = "dusty_weather.log";
        /*
        if (!Environment.MEDIA_MOUNTED.equals(
                Environment.getExternalStorageState()))
            return;
        */
        File storage = Environment.getExternalStorageDirectory();
        File logPath = new File(storage + LOG_DIR);
        if (!logPath.exists())
            logPath.mkdirs();
        File logFile = new File(logPath, filename);
        FileWriter writer = null;
        try {
            if (logFile.exists())
                writer = new FileWriter(logFile, true);
            else
                writer = new FileWriter(logFile);
            writer.write(logBlock.toString());
            writer.flush();
            writer.close();
            return "OK";
        }
        catch (IOException e) {
            return e.getMessage();
        }
    }
}
