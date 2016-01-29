package oe.roma.photodoc.controllers;


import oe.roma.photodoc.domain.Customer;
import oe.roma.photodoc.domain.File;
import oe.roma.photodoc.services.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by us8610 on 19.06.14.
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    @Resource(name="reportService")
    private ReportService reportService;

    @RequestMapping(method = RequestMethod.GET)
    public String downloadExcelAll(@RequestParam Integer rem_id, @RequestParam Integer value_type_id, ModelMap model) {

        List<Customer> list = reportService.recordsList(rem_id);
        List<File> listFile = reportService.recordsListFile(value_type_id);

        model.addAttribute("list", list);
        model.addAttribute("list", listFile);
        System.out.println(value_type_id);
        return "report";
    }
}
