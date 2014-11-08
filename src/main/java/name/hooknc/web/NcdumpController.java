package name.hooknc.web;

import name.hooknc.file.FileTransfer;
import name.hooknc.ncdump.Ncdump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NcdumpController {

    @Autowired
    private FileTransfer fileTransfer;

    @Autowired
    private Ncdump ncdump;

    @RequestMapping(value = "/api/v1.0.0/ncdump", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
    public String ncdump(@RequestParam("url") String url) {

        byte[] bytes = this.fileTransfer.transfer(url);

        String dump = this.ncdump.dumpHeader(bytes);

        if (dump == null) {
            dump = "no data available";
        }
        return dump;
    }
}
