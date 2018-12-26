package com.github.classloader;

import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 应用类加载器
 *
 * @author gavin
 * @create 13-7-31
 * @since 1.0.0
 */
public class AppClassLoader extends URLClassLoader {
//    private static final Log log =LogFactory.getLog(AppClassLoader.class);

    private ClassLoader parent;

    public AppClassLoader(URL[] classPaths, ClassLoader parent) {
        super(classPaths);
        //
        this.parent = parent;
    }

    public AppClassLoader(URL[] classPaths) {
        super(classPaths);
        //
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            return super.findClass(name);
        } catch (ClassNotFoundException e) {
            return parent.loadClass(name);
        }
    }

    @Override
    public URL findResource(String name) {
        URL url = super.findResource(name);
        if(url==null) {
            return parent.getResource(name);
        }
        return url;
    }

    @Override
    public Enumeration<URL> findResources(String name) throws IOException {
        Enumeration<URL> e = super.findResources(name);
//不会为空
//        if(e==null) {
//            return parent.getResources(name);
//        }
        return e;
    }

    public void addClassPath(URL classPath) {
        super.addURL(classPath);
    }

    public List<String> getClasses() throws IOException {
        //
        List<String> classList = new ArrayList<String>();
        //
        for(URL url : getURLs()) {
            if(ResourceUtils.isFileURL(url) || ResourceUtils.isJarURL(url)) {
                JarFile classPath = new JarFile(url.getFile());
                classList.addAll(scanClassPath(classPath));
                classPath.close();
            } else {
                throw new UnsupportedOperationException(String.format("不支持的 URLConnection ：[%s]", url.getClass().getName()));
            }
        }
        //
        return classList;
    }

    private List<String> scanClassPath(JarFile classPath) throws IOException {
        List<String> classList = new ArrayList<String>();
        //
        for(Enumeration<JarEntry> e=classPath.entries();e.hasMoreElements();) {
            //
            JarEntry jarEntry = e.nextElement();
            if(jarEntry.getName().endsWith(".class")
                    && jarEntry.getName().contains("$")==false) {
                //
                classList.add(getClassName(jarEntry.getName()));
            }
        }
        //
        return classList;
    }

    private String getClassName(String classResourceName) {
        //
        if(classResourceName.endsWith(".class")){
            classResourceName = classResourceName.substring(0, classResourceName.indexOf(".class"));
        }
        return ClassUtils.convertResourcePathToClassName(classResourceName);
    }



}
