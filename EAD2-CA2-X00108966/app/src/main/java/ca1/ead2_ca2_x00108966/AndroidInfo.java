package ca1.ead2_ca2_x00108966;

/**
 * Created by garet on 06/04/2017.
 */

public class AndroidInfo {

    String CodeName;
    String PlatformVersion;
    int ApiLevel;
    int Year;

    public AndroidInfo(String codeName, String platformVersion, int apiLevel, int year) {
        CodeName = codeName;
        PlatformVersion = platformVersion;
        ApiLevel = apiLevel;
        Year = year;
    }


    public String getCodeName() {
        return CodeName;
    }

    public void setCodeName(String codeName) {
        CodeName = codeName;
    }

    public String getPlatformVersion() {
        return PlatformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        PlatformVersion = platformVersion;
    }

    public int getApiLevel() {
        return ApiLevel;
    }

    public void setApiLevel(int apiLevel) {
        ApiLevel = apiLevel;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }
}
