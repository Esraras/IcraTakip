package com.esra.kgm.ui;

import com.esra.kgm.entity.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.esra.kgm.KgmApplicationInfo;
import com.esra.kgm.KgmApplicationLayout;
import com.esra.kgm.entity.EmployeeRepository;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle(KgmApplicationInfo.APPLICATION_NAME)
@Route(value = EmployeeView.ROUTE, layout = KgmApplicationLayout.class)
public class EmployeeView extends VerticalLayout {

    public static final String ROUTE = "";

    private static final long serialVersionUID = 1L;

    @Autowired
    public EmployeeView(EmployeeRepository employeeRepository, EntryRepository entryRepository) {
        setSizeFull();
        EmployeePage employeePage = new EmployeePage(employeeRepository, entryRepository);
        employeePage.init();
        add(employeePage);
    }

}