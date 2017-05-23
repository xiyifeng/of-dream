/**
 * 
 */
package com.dreamof.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * @description
 * @author xiyf
 * @date 2017年5月11日
 */
public class DataClassLoader extends ClassLoader {

    private String path;


    /**
     * @param path
     */
    public DataClassLoader(String path) {
        super();
        this.path = path;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.ClassLoader#findClass(java.lang.String)
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("==" + name);
        String className = name.replace('.', File.separatorChar);
        System.out.println("==" + className);
        File file = new File(path + File.separator + className + ".class");
        FileInputStream fis = null;
        ByteArrayOutputStream sb = null;
        try {
            fis = new FileInputStream(file);
            int cod;
            sb = new ByteArrayOutputStream();
            while ((cod = fis.read()) != -1) {
                sb.write(cod);
            }

            byte[] bt = sb.toByteArray();

            return defineClass(name, bt, 0, bt.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }
            if (sb != null) {
                try {
                    sb.close();
                } catch (IOException e) {
                }
            }
        }

        return super.findClass(name);
    }
}
