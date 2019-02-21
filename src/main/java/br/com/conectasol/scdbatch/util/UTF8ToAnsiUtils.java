package br.com.conectasol.scdbatch.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.log4j.Logger;

public class UTF8ToAnsiUtils {

	private UTF8ToAnsiUtils() {
	}

	public static final String UTF8_BOM = "\uFEFF";

	public static void convert(String... filepath) {
		try (
				BufferedInputStream in = new BufferedInputStream(new URL(filepath[0]).openStream());
				BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
				FileOutputStream fos = new FileOutputStream(filepath[1]);
				Writer w = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8));) {
			boolean firstLine = true;
			String s = "";
			while ((s = r.readLine()) != null) {
				if (firstLine) {
					s = UTF8ToAnsiUtils.removeUTF8BOM(s);
					firstLine = false;
				}
				w.write(s + System.getProperty("line.separator"));
				w.flush();
			}

		} catch (Exception e) {
			Logger.getRootLogger().error(e.getMessage(), e);
		}
	}

	private static String removeUTF8BOM(String s) {
		if (s.startsWith(UTF8_BOM)) {
			s = s.substring(1);
		}
		return s;
	}
}
