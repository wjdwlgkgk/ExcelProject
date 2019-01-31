package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectDB {
    int Size = 1000;
//    String connectionUrl = "jdbc:sqlserver://192.168.152.104:1433;" + "databaseName = SecuMS;";
    String connectionUrl = "jdbc:postgresql://192.168.122.198:5432/csp";
    String title[] = {"cve_id", "sumary", "score", "wfn_parts", "wfn_vendor", "wfn_product", "window_10", "window_7", "window_8", "window_8.1", "windows_server_2008", "windows_server_2012", "centos", "ubuntu_linux_18.04", "ubuntu_linux_16.04", "cve_id"};
    Connection con =null;
    Statement stmt = null;
    ResultSet rs = null;
    String a[][] = new String[Size][title.length];

    public String[][] getA() {
        return a;
    }

    public void init(){

        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "post","post");
            stmt = con.createStatement();

            String sql;
            sql ="select\n" +
                    "  mngt.cve_id\n" +
                    "     ,   sumary\n" +
                    "     ,   cvss.score\n" +
                    "     ,   aff.wfn_parts\n" +
                    "     ,   aff.wfn_vendor\n" +
                    "     ,   aff.wfn_product\n" +
                    "     ,   case when aff.wfn_parts::text not like '%a%' and aff.wfn_product::text like '%windows_10%'\n" +
                    "                then 'O'\n" +
                    "  end as window_10\n" +
                    "\n" +
                    "     ,   case when aff.wfn_parts::text not like '%a%' and aff.wfn_product::text like '%windows_7%'\n" +
                    "                then 'O'\n" +
                    "  end as window_7\n" +
                    "     ,   case when aff.wfn_parts::text not like '%a%' and aff.wfn_product::text like '%windows_8%'\n" +
                    "                then 'O'\n" +
                    "  end as window_8\n" +
                    "\n" +
                    "     ,   case when aff.wfn_parts::text not like '%a%' and aff.wfn_product::text like '%windows_8.1%'\n" +
                    "                then 'O'\n" +
                    "  end as \"window_8.1\"\n" +
                    "\n" +
                    "     ,   case when aff.wfn_parts::text not like '%a%' and aff.wfn_product::text like '%windows_server_2008%'\n" +
                    "                then 'O'\n" +
                    "  end as windows_server_2008\n" +
                    "\n" +
                    "       ,   case when aff.wfn_parts::text not like '%a%' and aff.wfn_product::text like '%windows_server_2012%'\n" +
                    "                  then 'O'\n" +
                    "    end as windows_server_2012\n" +
                    "       ,   case when aff.wfn_parts::text not like '%a%' and aff.wfn_product::text like '%windows_server_2016%'\n" +
                    "                  then 'O'\n" +
                    "    end as windows_server_2016\n" +
                    "\n" +
                    "  ,   case when aff.wfn_parts::text not like '%a%' and aff.wfn_product::text like '%centos%'\n" +
                    "            then 'O'\n" +
                    "      end as centos\n" +
                    "     ,   case when aff.wfn_parts::text not like '%a%'\n" +
                    "                      and aff.wfn_product::text like '%ubuntu_linux%'\n" +
                    "                      and aff.wfn_version::text like '%18.04%'\n" +
                    "                then 'O'\n" +
                    "  end as \"ubuntu_linux_18.04\"\n" +
                    "     ,   case when aff.wfn_parts::text not like '%a%'\n" +
                    "\n" +
                    "  and aff.wfn_product::text like '%ubuntu_linux%'\n" +
                    "  and aff.wfn_version::text like '%16.04%'\n" +
                    "                then 'O'\n" +
                    "  end as \"ubuntu_linux_16.04\"\n" +
                    "\n" +
                    "     ,   case when aff.wfn_parts::text not like '%a%'\n" +
                    "  and aff.wfn_product::text like '%ubuntu_linux%'\n" +
                    "  and aff.wfn_version::text like '%14.04%'\n" +
                    "                then 'O'\n" +
                    "  end as \"ubuntu_linux_14.04\"\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "       ,   oval.*\n" +
                    "from nvd_cve_list_mngt mngt\n" +
                    "       inner join nvd_cvss cvss\n" +
                    "                  on mngt.cve_id = cvss.cve_id\n" +
                    "       left outer join (\n" +
                    "  select\n" +
                    "    cve_id\n" +
                    "       ,array_agg(wfn_part) as wfn_parts\n" +
                    "       ,array_agg(wfn_vendor) as wfn_vendor\n" +
                    "       ,array_agg(wfn_product) as wfn_product\n" +
                    "       ,array_agg(wfn_version) as wfn_version\n" +
                    "\n" +
                    "  from nvd_vuln_affed\n" +
                    "  group by cve_id\n" +
                    ") aff\n" +
                    "                       on aff.cve_id = mngt.cve_id\n" +
                    "       left outer join (\n" +
                    "  select\n" +
                    "    o_ref.ref_id as cve_id\n" +
                    "  from oval_def def\n" +
                    "         inner join oval_ref o_ref\n" +
                    "                    on def.oval_id = o_ref.oval_id\n" +
                    "  where o_ref.source = 'CVE'\n" +
                    "  group by o_ref.ref_id\n" +
                    ") oval\n" +
                    "                       on mngt.cve_id = oval.cve_id\n" +
                    "order by mngt.cve_id  desc";

            rs = stmt.executeQuery(sql);
            int num = 0;
            while(rs.next()){
                for(int i=0; i<title.length; i++)
                a[num][i] = rs.getString(title[i]);
                num++;
            }
            rs.close();
            stmt.close();
            con.close();
        }catch(Exception e){ e.printStackTrace(); }

    }


}
