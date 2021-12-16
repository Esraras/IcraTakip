package com.esra.kgm.ui;

import java.util.function.Consumer;

import com.esra.kgm.entity.Entry;
import org.linkki.core.defaults.ui.aspects.types.CaptionType;
import org.linkki.core.pmo.ModelObject;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UIDateField;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.table.column.annotation.UITableColumn;

import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;

/**
 * Row to display a employee.
 */
public class EntryRowPmo {

    private final Entry entry;
    private final Consumer<Entry> deleteConsumer;

    public EntryRowPmo(Entry entry,
                       Consumer<Entry> deleteConsumer) {
        this.entry = entry;
        this.deleteConsumer = deleteConsumer;
    }

    @ModelObject
    public Entry getEntry() {
        return entry;
    }

    @UITableColumn(width = 200)
    @UITextField(position = 1, label = "Evrak Kayit", modelAttribute = "evrakKayit")
    public void evrakKayit() {
    }

    @UITableColumn(width = 200)
    @UITextField(position = 2, label = "İcra Türü", modelAttribute = "icraTuru", width = "20em")
    public void icraTuru() {
    }

    @UITableColumn(width = 200)
    @UITextField(position = 3, label = "Dosya No", modelAttribute = "dosyaNo")
    public void dosyaNo() {
    }

    @UITableColumn(width = 200)
    @UITextField(position = 4, label = "Açıklama", modelAttribute = "aciklama")
    public void aciklama() {
    }

    @UITableColumn(width = 200)
    @UITextField(position = 5, label = "İcra Müdürlüğü", modelAttribute = "icraMudur")
    public void icraMudur() {
    }

    @UITableColumn(width = 200)
    @UITextField(position = 6, label = "Alacaklı", modelAttribute = "alacakli")
    public void alacakli() {
    }

    @UITableColumn(width = 200)
    @UIDateField(position = 7, label = "Kuruma Giris Tarihi", modelAttribute = "kurumaGirisTarihi")
    public void kurumaGiris() {
    }

    @UITableColumn(width = 200)
    @UIDateField(position = 8, label = "İcra Tarihi", modelAttribute = "icraTarihi")
    public void icraTarihi() {
    }

    @UITableColumn(width = 200)
    @UITextField(position = 9, label = "Borç Tutarı", modelAttribute = "borcTutari")
    public void borcTutari() {
    }

    @UITableColumn(width = 200)
    @UITextField(position = 10, label = "Ödenen Borç", modelAttribute = "odenenBorc")
    public void odenenBorc() {
    }

    @UITableColumn(width = 200)
    @UITextField(position = 11, label = "Maaş", modelAttribute = "maas")
    public void maas() {
    }

    @UITableColumn(width = 200)
    @UITextField(position = 12, label = "İkramiye", modelAttribute = "ikramiye")
    public void ikramiye() {
    }

    @UITableColumn(width = 200)
    @UIDateField(position = 13, label = "Bitiş Tarihi", modelAttribute = "bitisTarihi")
    public void bitisTarihi() {
    }



    @UITableColumn(width = 200)
    @UIButton(position = 100, icon = VaadinIcon.TRASH, variants = ButtonVariant.LUMO_ERROR, showIcon = true, captionType = CaptionType.NONE)
    public void delete() {
        deleteConsumer.accept(getEntry());
    }


}
