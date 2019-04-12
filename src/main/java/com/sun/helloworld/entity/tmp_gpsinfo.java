package com.sun.helloworld.entity;

public class tmp_gpsinfo {
    private String applicationnumber;

    private String positioningstate;

    public String getApplicationnumber() {
        return applicationnumber;
    }

    public void setApplicationnumber(String applicationnumber) {
        this.applicationnumber = applicationnumber == null ? null : applicationnumber.trim();
    }

    public String getPositioningstate() {
        return positioningstate;
    }

    public void setPositioningstate(String positioningstate) {
        this.positioningstate = positioningstate == null ? null : positioningstate.trim();
    }
}
