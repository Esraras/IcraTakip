package com.esra.kgm.ui;

import java.util.Optional;

import com.esra.kgm.entity.Entry;
import com.esra.kgm.entity.EntryRepository;
import com.vaadin.flow.component.notification.NotificationVariant;
import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.binding.validation.ValidationService;
import org.linkki.core.vaadin.component.ComponentFactory;
import org.linkki.core.vaadin.component.page.AbstractPage;

import com.esra.kgm.KgmStyles;
import com.esra.kgm.entity.Employee;
import com.esra.kgm.entity.EmployeeRepository;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;

public class EmployeePage extends AbstractPage {

    private static final long serialVersionUID = 1L;

    private final BindingManager bindingManager = new DefaultBindingManager(ValidationService.NOP_VALIDATION_SERVICE);
    private EmployeeRepository employeeRepository;
    private final EntryRepository entryRepository;

    private SearchSectionPmo searchSectionPmo;

    public EmployeePage(EmployeeRepository employeeRepository, EntryRepository entryRepository) {
        this.employeeRepository = employeeRepository;
        this.entryRepository = entryRepository;
    }

    @Override
    public void createContent() {
        setMargin(true);

        Label heading = new Label("İcra Takip Sayfası");
        heading.setSizeFull();
        heading.addClassName(KgmStyles.HEADING);
        add(heading);
        searchSectionPmo = new SearchSectionPmo(this::saveEmployee, this::search);
        add(getPmoBasedSectionFactory().createSection(searchSectionPmo, getBindingManager().getContext("Context 1")));
    }



    private void search(Employee search) {
        //Notification.show("Arıyor…​", 1000, Notification.Position.MIDDLE);

        Optional<Employee> searchResult = employeeRepository.findByRegistration(search.getRegistration());

        removeAll();
        createContent();
        add(ComponentFactory.newHorizontalLine());

        if(searchResult.isPresent()){
            addSearchResultSection(searchResult.get());
        } else  {
            showNotFoundMessage();
        }
    }

    private void showNotFoundMessage() {
        String notificationText = "Aranan sicile kayit bulunamadi";
        Notification.show(notificationText, 5000, Notification.Position.MIDDLE)
                .addThemeVariants(NotificationVariant.LUMO_CONTRAST);
    }

    private void delete(Entry entry){
        entryRepository.delete(entry);
    }

    private Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    private Entry saveEntry(Entry entry) {
        Entry saved = entryRepository.save(entry);
        removeAll();
        createContent();
        add(ComponentFactory.newHorizontalLine());
        entry.getEmployee().getEntries().add(entry);
        addSearchResultSection(entry.getEmployee());
        return saved;
    }

    private void addSearchResultSection(Employee employee) {
        addSection(new EmployeeInfoSectionPmo(employee, this::saveEntry));
        addSection(new EntryTablePmo(employee.getEntries(), this::delete));
    }


    @Override
    protected BindingManager getBindingManager() {
        return bindingManager;
    }

}
