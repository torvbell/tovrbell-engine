package com.torvbell.game_engine.utils;

/*
 * Creates on 2020/5/14.
 */

import com.torvbell.game_engine.log;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author kevin
 */
public class auto_close
{

  public static void close(Closeable... closeables) {
    try {
      if (closeables == null) return;
      for (Closeable closeable : closeables) {
        if (closeable == null) continue;
        closeable.close();
      }
    }catch (IOException e){
      log.error("close failure.", e);
    }
  }

}