package pl.zankowski.fixparser.payment.paypal;

import com.paypal.api.payments.Agreement;
import pl.zankowski.fixparser.payment.api.SubscriptionPlan;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PayPalAgreementManager {

    public static final String AGREEMENT_REL = "approval_url";

    private final Map<String, Agreement> agreementMap = new ConcurrentHashMap<>();
    private final Map<String, SubscriptionPlan> agreementTypeMap = new ConcurrentHashMap<>();

    public void saveAgreement(Agreement agreement, SubscriptionPlan subscriptionPlan) {
        agreementMap.put(agreement.getToken(), agreement);
        agreementTypeMap.put(agreement.getToken(), subscriptionPlan);
    }

    public SubscriptionPlan getSubscriptionTypeForToken(String token) {
        return agreementTypeMap.get(token);
    }

    public Agreement getAgreement(String token) {
        return agreementMap.get(token);
    }

    public void removeAgreement(Agreement agreement) {
        String token = agreement.getToken();
        if (token != null) {
            agreementMap.remove(token);
            agreementTypeMap.remove(token);
        }
    }

}
