package pl.zankowski.fixparser.web.bean.parser;

import org.primefaces.event.FileUploadEvent;
import pl.zankowski.fixparser.core.exception.FixParserBusinessException;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.nio.charset.Charset;

@Named("fileParserBean")
@ViewScoped
public class FileParserBean extends ParserBean {

    private static final long serialVersionUID = -8245466999349097099L;

    public void handleFileUpload(final FileUploadEvent event) throws FixParserBusinessException {
        doParse(new String(
                event.getFile().getContents(),
                Charset.defaultCharset()));
    }

}
