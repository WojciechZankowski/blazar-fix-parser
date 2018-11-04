package pl.zankowski.fixparser.web.bean.help;

import pl.zankowski.fixparser.messages.api.FixMessageTO;
import pl.zankowski.fixparser.web.util.FixUtilities;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("fixBean")
@ApplicationScoped
public class FixBean {

    public String getSender(FixMessageTO message) {
        return FixUtilities.getSender(message);
    }

    public String getReceiver(FixMessageTO message) {
        return FixUtilities.getReceiver(message);
    }

    public String getSendingTime(FixMessageTO message) {
        return FixUtilities.getSendingTime(message);
    }

    public String getOrdStatusDescription(FixMessageTO message) {
        return FixUtilities.getOrdStatusDescription(message);
    }

}
