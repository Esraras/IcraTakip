package com.esra.kgm.ui;

import java.util.List;
import java.util.function.Consumer;

import com.esra.kgm.entity.Entry;
import org.linkki.core.defaults.columnbased.pmo.SimpleTablePmo;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;

import com.esra.kgm.entity.Employee;

/**
 *
 */
@UISection
public class EntryTablePmo extends SimpleTablePmo<Entry, EntryRowPmo> {

    private final Consumer<Entry> deleteConsumer;

    public EntryTablePmo(List<Entry> entries,
                         Consumer<Entry> deleteConsumer) {
        super(entries);
        this.deleteConsumer = deleteConsumer;
    }

    @Override
    protected EntryRowPmo createRow(Entry entry) {
        return new EntryRowPmo(entry, deleteConsumer);
    }
}
