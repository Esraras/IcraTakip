package com.esra.kgm.ui;

import com.esra.kgm.entity.Entry;
import org.linkki.core.defaults.ui.aspects.types.RequiredType;
import org.linkki.core.pmo.ModelObject;
import org.linkki.core.ui.element.annotation.UIDateField;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UIFormSection;

/**
 * Dialog to create a new Entry.
 */
@UIFormSection
public class EntryCreationDialog {


    private final Entry entry;

    public EntryCreationDialog(Entry entry) {
        this.entry = entry;
    }

    @ModelObject
    public Entry getEntry() {
        return entry;
    }

    @UITextField(position = 10, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "evrakKayit")
    public void evrakKayit() { }
    @UITextField(position = 11, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "icraTuru")
    public void icraTuru() { }
    @UITextField(position = 12, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "dosyaNo")
    public void dosyaNo() { }
    @UITextField(position = 13, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "aciklama")
    public void aciklama() { }
    @UITextField(position = 14, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "icraMudur")
    public void icraMudur() { }
    @UITextField(position = 15, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "alacakli")
    public void alacakli() { }
    @UIDateField(position = 16, required = RequiredType.REQUIRED, modelAttribute = "kurumaGirisTarihi")
    public void kurumaGirisTarihi(){}
    @UIDateField(position = 17,  required = RequiredType.REQUIRED, modelAttribute = "icraTarihi")
    public void icraTarihi() {}
    @UITextField(position = 18, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "borcTutari")
    public void borcTutari() { }
    @UITextField(position = 19, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "odenenBorc")
    public void odenenBorc() { }
    @UITextField(position = 20, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "maas")
    public void maas() { }
    @UITextField(position = 21, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "ikramiye")
    public void ikramiye() { }
    @UIDateField(position = 22, required = RequiredType.REQUIRED, modelAttribute = "bitisTarihi")
    public void bitisTarihi() { }

}
