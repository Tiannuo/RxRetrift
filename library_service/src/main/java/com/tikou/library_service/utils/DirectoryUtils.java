package com.tikou.library_service.utils;

/**
 * Created by Administrator on 2016/7/1.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 */
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

import id.zelory.compressor.Compressor;

public class DirectoryUtils {
    public final static String temp_url=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()+"ATemp";
    /**
     * 删除空目录
     * @param dir 将要删除的目录路径
     */
    private static void doDeleteEmptyDir(String dir) {
        boolean success = (new File(dir)).delete();
        if (success) {
            System.out.println("Successfully deleted empty directory: " + dir);
        } else {
            System.out.println("Failed to delete empty directory: " + dir);
        }
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
       //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
    /**
     *测试
     */
    public static void main(String[] args) {
        doDeleteEmptyDir("new_dir1");
        String newDir2 = "new_dir2";
        boolean success = deleteDir(new File(newDir2));
        if (success) {
            System.out.println("Successfully deleted populated directory: " + newDir2);
        } else {
            System.out.println("Failed to delete populated directory: " + newDir2);
        }
    }


    /**
     *
     * @param filepath
     * @throws IOException
     */
    public static boolean del(String filepath) throws IOException {
        File f = new File(filepath);// 定义文件路径
        boolean r=false;
        if (f.exists() ) {// 判断是文件还是目录
            r=f.delete();
        }else if(f.isDirectory()){
            if (f.listFiles().length == 0) {// 若目录下没有文件则直接删除
                r=f.delete();
            } else {// 若有则把文件放进数组，并判断是否有下级目录
                File delFile[] = f.listFiles();
                int i = f.listFiles().length;

                for (int j = 0; j < i; j++) {
                    if (delFile[j].isDirectory()) {
                        del(delFile[j].getAbsolutePath());// 递归调用del方法并取得子目录路径
                    }
                    r=delFile[j].delete();// 删除文件
                }

            }
        }
        return r;
    }

    public File compressImg(Activity activity,int maxWidth,int maxHeight,int quality,String actualPath){
            File file=new Compressor.Builder(activity)
                .setMaxHeight(maxHeight==-1?1280:maxHeight)
                .setMaxWidth(maxWidth==-1?720:maxWidth)
                .setQuality(quality)
                .setCompressFormat(Bitmap.CompressFormat.JPEG)
                .setDestinationDirectoryPath(temp_url)
                .build()
                .compressToFile(new File(actualPath));
            return file.getAbsoluteFile();
    }

    public static void deletTemp(Activity activity){
        DirectoryUtils.deleteDir(new File(temp_url));
        //MediaScannerConnection.scanFile(activity,new String[]{Environment.getExternalStorageDirectory().getAbsolutePath()},null,null);
        //MediaScannerConnection.scanFile(activity,new String[]{Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()+"ATemp"},null,null);
    }


}