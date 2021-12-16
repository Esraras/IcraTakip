package com.esra.kgm;

import org.linkki.core.nls.NlsService;
import org.linkki.framework.ui.application.ApplicationInfo;

import org.linkki.framework.ui.pmo.ApplicationInfoPmo;

import com.esra.kgm.util.NlsText;

public class KgmApplicationInfoPmo extends ApplicationInfoPmo {

    public KgmApplicationInfoPmo(ApplicationInfo applicationInfo) {
        super(applicationInfo);
    }

    @Override
    public String getDialogCaption() {
        //String var10000 = NlsText.getString("KgmApplicationInfoPmo.About");
        return this.getApplicationInfo().getApplicationName();
    }

}
