package com.process;

import java.io.IOException;

public class Exec {
    public static void main(String[] args)
      throws IOException, InterruptedException {
   
      Runtime rt = Runtime.getRuntime();
      Process proc = rt.exec("ffmpeg -i D:\\test\\video\\movToMp4\\asd.mov -vcodec copy -acodec copy D:\\test\\video\\movToMp4\\asd.mp4");
   
      // Any error message?
      StreamGobbler errorGobbler =
          new StreamGobbler(proc.getErrorStream(), System.err);
   
      // Any output?
      StreamGobbler outputGobbler =
          new StreamGobbler(proc.getInputStream(), System.out);
   
      errorGobbler.start();
      outputGobbler.start();
   
      // Any error?
      int exitVal = proc.waitFor();
      errorGobbler.join();   // Handle condition where the
      outputGobbler.join();  // process ends before the threads finish
      
    }
    
    
   
  }