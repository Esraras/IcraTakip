package com.esra.kgm.ui;

import java.util.ArrayList;
import java.util.List;

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
    private final EmployeeRepository employeeRepository;

    private SearchSectionPmo searchSectionPmo;

    public EmployeePage(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createContent() {
        setMargin(true);

        Label heading = new Label("İcra Takip Sayfası");
        heading.setSizeFull();
        heading.addClassName(KgmStyles.HEADING);
        add(heading);
        searchSectionPmo = new SearchSectionPmo(this::search);
        add(getPmoBasedSectionFactory().createSection(searchSectionPmo, getBindingManager().getContext("Context 1")));
    }

    private void search() {
        Notification.show("Arıyor…​", 1000, Notification.Position.MIDDLE);

        Iterable<Employee> searchResult = employeeRepository.findAll();

        removeAll();
        createContent();
        add(ComponentFactory.newHorizontalLine());

        List<Employee> result = new ArrayList<Employee>();
        searchResult.forEach(result::add);
        addSearchResultSection(result);
    }

    private void delete(Employee employee){
        employeeRepository.delete(employee);
        search();
    }

    private void addSearchResultSection(List<Employee> employees) {
        addSection(new EmployeesPmo(employees, this::delete));
    }


    @Override
    protected BindingManager getBindingManager() {
        return bindingManager;
    }

}
