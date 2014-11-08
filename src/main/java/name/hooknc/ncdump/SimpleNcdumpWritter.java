package name.hooknc.ncdump;

import org.springframework.context.annotation.Configuration;
import ucar.nc2.NCdumpW;
import ucar.nc2.NetcdfFile;
import ucar.unidata.io.InMemoryRandomAccessFile;

import java.io.StringWriter;

@Configuration
public class SimpleNcdumpWritter implements Ncdump {

    @Override
    public String dumpHeader(byte[] bytes) {

        String dump = null;

        NetcdfFile netcdfFile = null;

        try {
            InMemoryRandomAccessFile randomAccessFile = new InMemoryRandomAccessFile("test file", bytes);
            netcdfFile = NetcdfFile.open(randomAccessFile, "ignored", null, null);
            //netcdfFile = NetcdfFile.openInMemory(URI.create("https://www.earthsystemgrid.org/download/fileDownload.htm?logicalFileId=ef50e81c-1648-11e3-864b-00c0f03d5b7c"));
            //netcdfFile = NetcdfFile.openInMemory(URI.create("http://tds.ucar.edu/thredds/fileServer/datazone/narccap/DATA/HRM3/gfdl-current/table1/sic_HRM3_gfdl_1968010106.nc"));

            StringWriter writer = new StringWriter();
            NCdumpW.print(netcdfFile, writer, false, false, false, false, null, null);
            dump = writer.toString();

            //NCdumpW.printHeader("", null);
            writer.flush();
            writer.close();

        } catch (Exception e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        } finally {

            if (netcdfFile != null) {
                try {
                    netcdfFile.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                    e.printStackTrace();
                }
            }
        }

        return dump;
    }
}
