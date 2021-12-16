package com.esra.kgm;

import org.linkki.framework.ui.application.ApplicationHeader;
import org.linkki.framework.ui.application.ApplicationInfo;
import org.linkki.framework.ui.application.menu.ApplicationMenuItemDefinition;
import org.linkki.framework.ui.dialogs.ApplicationInfoDialog;
import org.linkki.framework.ui.nls.NlsText;
import org.linkki.framework.ui.pmo.ApplicationInfoPmo;
import org.linkki.util.Sequence;

import com.vaadin.flow.component.contextmenu.MenuItem;

public class KgmApplicationHeader extends ApplicationHeader {

    public KgmApplicationHeader(ApplicationInfo applicationInfo,
                                Sequence<ApplicationMenuItemDefinition> menuItemDefinitions) {
        super(applicationInfo, menuItemDefinitions);
    }

    @Override
    protected void addApplicationInfoMenuItem(MenuItem helpMenu) {
        helpMenu.getSubMenu()
                .addItem(NlsText.getString("ApplicationHeader.Info"),
                         (i) -> (new ApplicationInfoDialog(this.createApplicationInfoPmo())).open());
    }

    @Override
    protected ApplicationInfoPmo createApplicationInfoPmo() {
        return new KgmApplicationInfoPmo(this.getApplicationInfo());
    }
}
