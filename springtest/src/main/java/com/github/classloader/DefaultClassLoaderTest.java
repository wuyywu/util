package com.github.classloader;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * TODO
 *
 * @author wuyun
 * @date 2018/11/3 12:39
 */
public class DefaultClassLoaderTest {

    private File appDirectory;
    private AppClassLoader appClassLoader;
    private MetadataReaderFactory metadataReaderFactory;
    //

    private void initialize(File appDirectory, AppClassLoader appClassLoader) throws IOException {
        this.appDirectory = appDirectory;
        this.appClassLoader = appClassLoader;
        this.metadataReaderFactory = new SimpleMetadataReaderFactory(appClassLoader);

        //
        List<String> classNames = appClassLoader.getClasses();
        for(String className : classNames) {
            try {
                MetadataReader metadataReader = this.metadataReaderFactory.getMetadataReader(className);
                ClassMetadata classMetaData = metadataReader.getClassMetadata();
                AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        File file = new File("E:\\ETS4.0\\ECP\\ECG\\trunk\\eccg\\eccg-dist\\eccg-distribution\\target\\comm-eccg-server-4.2.5.0-SNAPSHOT\\comm-server\\apps\\reapal-app");
        System.out.println(file.listFiles());
        DefaultClassLoaderTest test = new DefaultClassLoaderTest();
        try {
            test.loadAppFromDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadAppFromDirectory(File appFile) throws IOException {
        File[] fileJars = appFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println(name);
                return name.endsWith(".jar");
            }
        });
        if (fileJars == null){
            return;
        }
        //
        URL[] jarUrls = new URL[fileJars.length];
        for(int i=0; i<jarUrls.length; i++) {
            jarUrls[i] = fileJars[i].toURI().toURL();
        }
        //
        AppClassLoader appClassLoader = new AppClassLoader(jarUrls);
        initialize(appFile, appClassLoader);
    }


    private void loadAppFromZipFile(File appFile) throws IOException {
        //
        File appsDirectory = appFile.getParentFile();
        //
        ZipFile zipFile = new ZipFile(appFile);
        for(Enumeration<? extends ZipEntry> e = zipFile.entries(); e.hasMoreElements();) {
            ZipEntry zipEntry = e.nextElement();
            // skip directory copy
            if(zipEntry.isDirectory()) {
                continue;
            }
            // create copy target file
            File target = new File(appsDirectory, zipEntry.getName());
            if(target.exists()==false) {
                if (!target.getParentFile().exists() && !target.getParentFile().mkdirs()){
                    throw new IOException(String.format("创建目录[%s]失败", target.getParent()));
                }
                if (!target.createNewFile()){
                    throw new IOException(String.format("创建文件[%s]失败", target.getAbsolutePath()));
                }
            }
            // copy from input stream to output stream
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            OutputStream outputStream = new FileOutputStream(target);
            FileCopyUtils.copy(inputStream, outputStream);
        }
        zipFile.close();
        //
        File appDirectory = new File(zipFile.getName().substring(0, zipFile.getName().indexOf(".zip")));
        //

        loadAppFromDirectory(appDirectory);
        return;
    }
}
