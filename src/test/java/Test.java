import Excel.CreateExcel;
import Json.JsonTest;
import Thread.ThreadInterrupt;
import com.account.Account;
import dto.Enum;
import logger.Foo;
import logger.Foo1;
import logger.logTest;
import org.junit.Before;
import testbed.openapi;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Test {

    @org.junit.Test
    public void jihaTest(){
        CreateExcel excel = new CreateExcel();
        excel.makeExcelFile();

    }


    @org.junit.Test
    public void specialcharTest(){

       String[] a = new String[500000];
       for(int i = 0 ; i < a.length; i++)
           a[i] = "a";
        for(int i = 0 ; i < a.length; i++)
            System.out.println(a[i]);

    }

    @org.junit.Test
    public void jsonTest(){
        JsonTest jt = new JsonTest();
        try {
            jt.dataFromOpenApi();
        }catch (Exception e){ e.printStackTrace();}
    }


    @org.junit.Test
    public void Thread5Test(){
        ThreadInterrupt th = new ThreadInterrupt("뉴 스레드");
        th.start();

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){}
        th.interrupt();
    }


    @org.junit.Test
    public void openapiTest(){
        openapi op = new openapi();
        try {
            op.init();
        }catch (Exception e ) { e.printStackTrace();}


    }


    @org.junit.Test
    public void asldkfn(){
        System.out.println(Enum.jiha + "" + Enum.fight + "" + Enum.people);
        System.out.println("1234");
    }

    @org.junit.Test
    public void alksdnvlaks(){
        HashMap<String, Integer> map = new HashMap();

        map.put("asdf", 1234);
        map.put("a", 12345);
        map.put("b", 12346);
        map.put("c", 12347);
        map.put("d", 12348);

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        ArrayList<String> keys = new ArrayList<String>();
        String[] key1;

        while(iterator.hasNext())
            keys.add((String)iterator.next());

        key1 = (String[])keys.toArray(new String[keys.size()]);
        System.out.println(1234);

    }


    @org.junit.Test
    public void 테스트(){
//        Foo1.test();
        Foo.test();
    }




    @org.junit.Test
    public void ERERERER(){


        HashMap map = new HashMap();

        for(int i = 0 ; i < 5; i++) {
            map.put("count", i);
            if (map.get("count") == (Integer) 0) {


                System.out.println("OK");
            }
        }

    }

    @org.junit.Test
    public void ASDFASDFASDF() {
        String str = "12w3asdvsvs" +
                "asdf \n" +
                "asdf \n" +
                "asdf" +
                "dfffd" +
                "12";

        StringBuilder sb = new StringBuilder();

        sb.append(str);

//        sb = sb.substring(0, 12);

        System.out.println(sb.toString());

    }


    @org.junit.Test
    public void FileTestFromgetEx(){
        try {
            DataOutputStream os = new DataOutputStream(new FileOutputStream("F:\\a.txt"));
            String str = "간단한 file 입출력 테스트";
            byte[] bs = str.getBytes();
            os.write(bs);
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    @org.junit.Test
    public void laknsddv(){
        DataInputStream dis = null;

        InputStream is = null;
        try {
            is = new FileInputStream("F:\\a.txt");
            while (true) {
                int i = is.read();
                System.out.println("데이터 : " + i);
                if (i == -1) break;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try{
                if(is != null) is.close();
            }catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }

        OutputStream os = null;
        try{
            os = new FileOutputStream("F:\\a.txt");
                String str = "봄봄봄 봄이 왔어요. 하늘에서 봄이왔어요.";
                byte[] bs = str.getBytes();
                os.write(bs);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (os != null) os.close();
            }catch (Exception e){
                System.out.println("gd");
            }
        }



    }


    @org.junit.Test
    public void mainasdfasdfdasf(){

        String str= "Content_Type:text/xml\n" +
                "From:agent\n" +
                "IPAddress:192.168.122.102\n" +
                "Identifier:N2VmYzIyZTYtZmU0Ny0xMWU4LTgxODctMDAwYzI5MmYyM2M0U0RMQzA1MDBfT1MxOTIuMTY4LjEyMi4xMDJsaW51eENlbnRPUzUuNg==\n" +
                "Message_Type:response\n" +
                "/r/n/r/n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<body>\n" +
                "\t<description>Request Complete</description>\n" +
                "\t<success>NO</success>\n" +
                "\t<hostname>SDLC0500</hostname>\n" +
                "\t<msg>Manager is not approved</msg>\n" +
                "</body>\n";

        System.out.println(str.length() + "\n\n\n\n");
        System.out.println(str.substring(0,297) + "\n\n\n\n");
        System.out.println(str.substring(297,str.length()-1));

    }



    @org.junit.Test
    public void mansmansmdnamsnduiqiwuejsnasd(){

        File dirpath = new File(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.dir"));
        File[] files = dirpath.listFiles();

        for(int i = 0 ; i < files.length; i++)
        {
            if(files[i].isDirectory())
                System.out.println(files[i].getName() + "\t\t\t\t\t <== 폴더 ");
            else if(files[i].isFile())
                System.out.println(files[i].getName() + "\t\t\t\t\t <== 파일 ");
        }
    }



    @org.junit.Test
    public void 파일이름캐치(){

        File file = new File("C:\\tomcat8.5");
        File[] chk_folder = file.listFiles();
        ArrayList list = new ArrayList();
        if(chk_folder != null)
        {
            for(int i = 0 ; i < chk_folder.length; i++)
            {
                if(chk_folder[i].isDirectory()){
                    if(chk_folder[i].getName().contains("csp")) {
                        list.add(chk_folder[i].getName().split("-")[1].replaceAll("r",""));
                    }
                }
            }
        }
        String max_revision = String.valueOf(getIndexOfMax(list));
        System.out.println("max : "  + max_revision);
        System.out.println("r" + max_revision);
    }

    private int getIndexOfMax(ArrayList<Integer> max_list){
        int MaxVal = Integer.parseInt(String.valueOf(max_list.get(0)));
        int indexOfMax = -1;
        for (int i = 0; i < max_list.size(); i++) {
            if(Integer.parseInt(String.valueOf(max_list.get(i))) > MaxVal ){
                MaxVal = Integer.parseInt(String.valueOf(max_list.get(i)));
                indexOfMax = i;
            }
        }
        return MaxVal;
    }


    @org.junit.Test
    public void alkndv(){

        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        System.out.println(str.length());
    }


    @org.junit.Test
    public void zipTest() throws IOException {
            File temp = new File("F:/package.zip");
            String fileZip = temp.getName();

            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(temp));
            ZipEntry zipEntry = zis.getNextEntry();
            File newFile = null;
            while(zipEntry != null){
                String fileName = zipEntry.getName();

                newFile = new File("F:/unzipTest/" + fileName);

                if(!newFile.exists())
                {
                    newFile.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        }

    @org.junit.Test
    public void testetsetsetest(){
        try{
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream("F:/package.zip"));
        ZipEntry zipEntry = zis.getNextEntry();
        while(zipEntry != null){
            String fileName = zipEntry.getName();
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(fileName);
            FileOutputStream fos = new FileOutputStream(fileName);
            if (fileName.charAt(fileName.length()-1) == '/'){ file.mkdir();}
            else {
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
            }
            fos.close();
            fis.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }catch(IOException e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void ziptestetst() throws IOException {
        String filePath = "F:/package.zip";
        String unzipPath = "F:/zip";
        String zipFilePath = filePath;
        File zipFile = new File(zipFilePath);
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry ze = zis.getNextEntry();

        while (ze != null) {
            String entryName = ze.getName();
            String[] name = entryName.split("/");
            entryName = name[name.length-1];
            File f = new File(unzipPath + File.separator + entryName);
            if(name.length >= 1) {
                f.mkdirs();
                ze = zis.getNextEntry();
                continue;
            }
            FileOutputStream fos = new FileOutputStream(f);
            int len;
            byte buffer[] = new byte[1024];
            while((len = zis.read(buffer)) > 0 ) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            ze = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }

    @org.junit.Test
    public void zipte123123stetst() throws IOException {
        String filePath = "F:/package.zip";
        String unzipPath = "F:/zip";
        String zipFilePath = filePath;
        File zipFile = new File(zipFilePath);
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry ze = zis.getNextEntry();

        while (ze != null) {
            String entryName = ze.getName();
            String[] name = entryName.split("/");
            entryName = name[name.length-1];
            ZipInputStream zis2 = new ZipInputStream(new FileInputStream(entryName));
            ZipEntry ze2 = zis2.getNextEntry();
            while (ze2 != null) {
                File f = new File(unzipPath + File.separator + entryName);
                if(name.length >= 1)
                    f.mkdir();
                FileOutputStream fos = new FileOutputStream(f);
                int len;
                byte buffer[] = new byte[1024];
                while((len = zis.read(buffer)) > 0 ) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                ze2 = zis2.getNextEntry();
            }
            ze = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }


    @org.junit.Test
    public void madnvkasldv(){
        File file = new File("F:/");
        if(!file.exists())
        {
            file.mkdirs();
        }
    }


    @org.junit.Test
    public void deletefile() throws IOException{
        File file = new File("F:\\1234.zip");

        if(file.exists())
        {
            file.delete();
        }

    }

    @org.junit.Test
    public void directoryTestt(){
        System.out.println(System.getProperty("user.home") + "\\Downloads");

    }


    @org.junit.Test
    public void mlakndvlkcontain(){

        ArrayList<Integer> ar = new ArrayList<Integer>();

        ar.add(3);
        ar.add(4);
        ar.add(5);
        ar.add(6);
        ar.add(7);

        ar.contains(Integer.parseInt("3"));

        System.out.println(ar.contains(Integer.parseInt("3")));



    }


    @org.junit.Test
    public void 스트링테스트() throws Exception {
        String encryptionKey = "happyprogrammer!";

        // 암호화할 문자열
        String target = "Java 마스터!";


        // AES로 암호화 =================================================

        // AES Cipher 객체 생성
        Cipher cipher = Cipher.getInstance("AES");

        // 암호화 Chipher 초기화
        SecretKeySpec secretKeySpec = new SecretKeySpec(encryptionKey.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        // 암호화 완료
        byte[] encryptBytes = cipher.doFinal(target.getBytes("UTF-8"));
        System.out.println(new String(encryptBytes)); // => 똑같은 암호화키로 복호화


        // AES로 복호화 =================================================

        // 복호화 Chipher 초기화, 똑같은 암호화키로 복호화
        cipher.init(cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        System.out.println(new String(decryptBytes, "UTF-8"));
    }

    @org.junit.Test
    public void 테스트비와(){

        String str = "file:E:/Program Files (x86)/kisa/csp/web/conf/crosscert.jks";
        System.out.println(str.indexOf(15));
    }

    @org.junit.Test
    public void asdf(){
        String str = "12344321";
        str.replace(str.charAt(3),'-');
        System.out.println(str);
    }


    @org.junit.Test
    public void laksndlaksndaslkd(){
        HashMap map = new HashMap();
        map.put("hi",123);
        map.put("hi1",123);
        map.put("hi12",123);
        map.put("hi123",123);


        String asdrt = "forin";



    }

    @org.junit.Test
    public void lkansdvlkansldkvnaslk() throws IOException{
        File f = new File("E:\\workspace\\intellij\\getexceldata\\src\\test\\java\\A2.cfg");
        System.out.println(f.length());

        StringBuilder sb = new StringBuilder();

        FileReader fileReader = new FileReader(f);
        BufferedReader br = new BufferedReader(fileReader);
        String line;

        while(( line = br.readLine()) != null)
            sb.append(line);


        System.out.println(sb.toString().trim().length());


    }


    @org.junit.Test
    public void mASTOBIPSITE(){

    }


}