package com.process;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

class StreamGobbler extends Thread {
    InputStream is;
    PrintStream os;
   
    StreamGobbler(InputStream is, PrintStream os) {
      this.is = is;
      this.os = os;
    }
   
    public void run() {
      try {
        int c;
        while ((c = is.read()) != -1)
            os.print((char) c);
      } catch (IOException x) {
        // Handle error
      }
    }
  }