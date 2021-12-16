package com.esra.kgm;

import java.time.Year;

import org.linkki.framework.ui.application.ApplicationInfo;

public class KgmApplicationInfo implements ApplicationInfo {

    public static final String APPLICATION_NAME = "KGM İcra Takip";

    @Override
    public String getApplicationName() {
        return APPLICATION_NAME;
    }

    @Override
    public String getApplicationVersion() {
        return "1.0";
    }

    @Override
    public String getApplicationDescription() {
        return "KGM İcra Takip Uygulaması";
    }

    @Override
    public String getCopyright() {
        return "© KGM / E.Aras " + Year.now();
    }
}
