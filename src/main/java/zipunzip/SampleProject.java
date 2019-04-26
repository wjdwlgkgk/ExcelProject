package zipunzip;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SampleProject {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Administrator\\Desktop\\test";
        File file = new File(path);
        String files[] = null;

        //파일이 디렉토리 일경우 리스트를 읽어오고
        //파일이 디렉토리가 아니면 첫번째 배열에 파일이름을 넣는다.
        if (file.isDirectory()) {
            files = file.list();
        } else {
            files = new String[1];
            files[0] = file.getName();
            System.out.println(file.getName().getBytes());
        }


        //buffer size
        int size = 1024;
        byte[] buf = new byte[size];
        String outZipNm = "C:\\Users\\Administrator\\Desktop\\test.zip";
        File zipfile = new File(outZipNm);
        if(!zipfile.exists()) {
            file.createNewFile();
        }


        FileInputStream fis = null;
        ZipOutputStream zos = null;
        BufferedInputStream bis = null;

        try {
            // Zip 파일생성
            zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outZipNm)));
            for (int i = 0; i < files.length; i++) {

                //buffer에 해당파일의 stream을 입력한다.
                fis = new FileInputStream(path + "/" + files[i]);
                bis = new BufferedInputStream(fis, size);

                //zip에 넣을 다음 entry 를 가져온다.
                zos.putNextEntry(new ZipEntry(files[i]));

                //압출레벨을 설정한다.
                //기본값은 8이라고 한다. 최대는 9이다.
                final int COMPRESSION_LEVEL = 8;
                zos.setLevel(COMPRESSION_LEVEL);

                //준비된 버퍼에서 집출력스트림으로 write 한다.
                int len;
                while ((len = bis.read(buf, 0, size)) != -1) {
                    zos.write(buf, 0, len);
                }
                zos.closeEntry();
                bis.close();
                fis.close();

            }
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}