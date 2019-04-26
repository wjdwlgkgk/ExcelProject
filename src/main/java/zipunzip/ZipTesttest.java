package zipunzip;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTesttest {

    public static void main(String args[]) {
        String path = System.getProperty("user.dir");
        String destFile = "filename.zip";
        File file = new File(path + "\\" + destFile);
        String[] files = new String[3];
        files[0] = "test1.txt";
        files[1] = "test2.txt";
        files[2] = "test3.txt";

//            ZipCompress(file.getAbsolutePath(), files);
//        zipzipzip();
        try {
//            zipzip3();
            ziphaha();
        }catch(Exception e){
            e.printStackTrace();
        }
       }


    public static void ZipCompress(String destFile, String[] files) {
        File destfile = new File(destFile);
        String destfolder = destfile.getParentFile().getPath();
        byte[] buf = new byte[1024];

        ZipOutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            outputStream = new ZipOutputStream(new FileOutputStream(destFile));

            for (String file : files) {
                fileInputStream = new FileInputStream(destfolder + "\\" + file);
                outputStream.putNextEntry(new ZipEntry(destfolder + "\\" + file));

                int length = 0;
                while (((length = fileInputStream.read()) > 0)) {
                    outputStream.write(buf, 0, length);
                }
                outputStream.closeEntry();
                fileInputStream.close();
            }
            outputStream.close();
        } catch (IOException e) {
            // Exception Handling
        } finally {
            try {
                outputStream.closeEntry();
                outputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                // Exception Handling
            }
        }
    }


    public static void zipzipzip(){
        // TODO Auto-generated method stub
        // 압축할 파일에 포함시킬 파일들
        String[] files = new String[]{"F:\\zipfile\\a.txt", "F:\\zipfile\\b.txt"};

        // 파일을 읽기위한 버퍼
        byte[] buf = new byte[1024];

        try {
            // 압축파일명
            String zipName = "F:\\zipfile\\ab.zip";
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipName));

            // 파일 압축
            for (int i=0; i<files.length; i++) {
                FileInputStream in = new FileInputStream(files[i]);

                // 압축 항목추가
                out.putNextEntry(new ZipEntry(files[i]));

                // 바이트 전송
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }

                out.closeEntry();
                in.close();
            }

            // 압축파일 작성
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String currPath = System.getProperty("user.dir");//프로젝트(현재) 경로

    public static void zipzip3() throws IOException {
        String path = currPath + File.separator+ "hello";
        File file = new File(path);
        String files[] = null;

        //파일이 디렉토리 일경우 리스트를 읽어오고
        //파일이 디렉토리가 아니면 첫번째 배열에 파일이름을 넣는다.
        if( file.isDirectory() ){
            files = file.list();
        }else{
            files = new String[1];
            files[0] = file.getName();
            System.out.println(file.getName().getBytes());
        }

        //buffer size
        int size = 1024;
        byte[] buf = new byte[size];
        String outZipNm = path+File.separator + "테스트.zip";

        FileInputStream fis = null;
        ZipArchiveOutputStream zos = null;
        BufferedInputStream bis = null;

        try {
            // Zip 파일생성
            zos = new ZipArchiveOutputStream(new BufferedOutputStream(new FileOutputStream(outZipNm)));
            for( int i=0; i < files.length; i++){
                //해당 폴더안에 다른 폴더가 있다면 지나간다.
                if( new File(path+"/"+files[i]).isDirectory() ){
                    continue;
                }
                //encoding 설정
                zos.setEncoding("UTF-8");

                //buffer에 해당파일의 stream을 입력한다.
                fis = new FileInputStream(path + "/" + files[i]);
                bis = new BufferedInputStream(fis,size);

                //zip에 넣을 다음 entry 를 가져온다.
                zos.putArchiveEntry(new ZipArchiveEntry(files[i]));


                //준비된 버퍼에서 집출력스트림으로 write 한다.
                int len;
                while((len = bis.read(buf,0,size)) != -1){
                    zos.write(buf,0,len);
                }

                bis.close();
                fis.close();
                zos.closeArchiveEntry();

            }
            zos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if( zos != null ){
                zos.close();
            }
            if( fis != null ){
                fis.close();
            }
            if( bis != null ){
                bis.close();
            }
        }
    }


    public static void ziphaha(){
        try{
            String zipFile = "F:\\example.zip";
            String sourceFile = "F:\\zipfile";

            byte[] buffer = new byte[1024];

            FileOutputStream fout = new FileOutputStream(zipFile);

            ZipOutputStream zout = new ZipOutputStream(fout);

            FileInputStream fin = new FileInputStream(sourceFile);

            zout.putNextEntry(new ZipEntry(sourceFile));

            int length;

            while((length = fin.read(buffer)) > 0 )
            {
                zout.write(buffer, 0 , length);
            }

            zout.closeEntry();

            fin.close();

            zout.close();


        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
