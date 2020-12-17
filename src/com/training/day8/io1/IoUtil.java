package com.training.day8.io1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IoUtil implements StreamType{
	//private static final OutputStream FileOutputStream(path) = null;
	public static InputStream createInputStream(
			int streamType,
			String path)
	throws FileNotFoundException {
		switch (streamType) {
		case StreamType.FileInputStream:
			return new FileInputStream(path);	
		}
		return null;
	}

	public static OutputStream createOutputStream(
			int streamType,
			boolean appand,
			String path)throws FileNotFoundException {
		switch (streamType) {
		case StreamType.FileOutputStream:
			return new FileOutputStream(path,appand);	
		}
		return null;
	}

	public static void close(InputStream is) {
		if (null != is) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(OutputStream os) {
		if (null != os) {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Reader r) {
		if (null != r) {
			try {
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Writer w) {
		if (null != w) {
			try {
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
}
