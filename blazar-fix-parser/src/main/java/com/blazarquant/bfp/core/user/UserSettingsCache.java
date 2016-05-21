package com.blazarquant.bfp.core.user;

import com.blazarquant.bfp.data.user.UserID;
import com.blazarquant.bfp.data.user.UserSetting;
import com.blazarquant.bfp.data.user.UserSettingHolder;
import com.blazarquant.bfp.database.dao.UserDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wojciech Zankowski
 */
public class UserSettingsCache {

    private final UserDAO userDAO;

    private final Map<UserID, Map<UserSetting, Object>> defaultSettings = new HashMap<>();
    private final UserSettingTranslator userSettingTranslator = new UserSettingTranslator();

    public UserSettingsCache(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void loadParameters(UserID userID) {
        List<UserSettingHolder> userSettingHolders = userDAO.findParameters(userID);
        Map<UserSetting, Object> userSettingsActual = defaultSettings.get(userID);
        if (userSettingsActual == null) {
            userSettingsActual = new HashMap<>();
        }
        for (UserSettingHolder holder : userSettingHolders) {
            userSettingsActual.put(
                    holder.getUserSetting(),
                    userSettingTranslator.resolveSetting(holder.getUserSetting(), holder.getSettingValue())
            );
        }
        defaultSettings.put(userID, userSettingsActual);
    }

    public void setParameter(UserID userID, UserSetting userSetting, Object value) {
        String settingValue = userSettingTranslator.translateSetting(userSetting, value);
        Map<UserSetting, Object> userSettings = defaultSettings.get(userID);
        if (userSettings == null) {
            userSettings = new HashMap<>();
        }
        userSettings.put(userSetting, value);
        defaultSettings.put(userID, userSettings);
        userDAO.saveParameter(userID, userSetting, settingValue);
    }

    public String getParameter(UserID userID, UserSetting userSetting) {
        return (String) getObject(userID, userSetting);
    }

    public Object getObject(UserID userID, UserSetting userSetting) {
        Map<UserSetting, Object> userSettings = defaultSettings.get(userID);
        if (userSettings == null) {
            return null;
        }
        return userSettings.get(userSetting);
    }

    public Boolean getBoolean(UserID userID, UserSetting userSetting) {
        return (Boolean) getObject(userID, userSetting);
    }

}
