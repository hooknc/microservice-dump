package name.hooknc.ncdump;

import org.springframework.context.annotation.Configuration;
import ucar.nc2.NCdumpW;
import ucar.nc2.NetcdfFile;
import ucar.unidata.io.InMemoryRandomAccessFile;

import java.io.StringWriter;

@Configuration
public class SimpleNcdumpWriter implements Ncdump {

    @Override
    public String dumpHeader(byte[] bytes) {

        String dump = null;

        NetcdfFile netcdfFile = null;

        try {
            InMemoryRandomAccessFile randomAccessFile = new InMemoryRandomAccessFile("test file", bytes);
            netcdfFile = NetcdfFile.open(randomAccessFile, "ignored", null, null);

            StringWriter writer = new StringWriter();
            NCdumpW.print(netcdfFile, writer, false, false, false, false, null, null);
            dump = writer.toString();

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
