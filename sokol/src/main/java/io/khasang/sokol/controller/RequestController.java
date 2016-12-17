package io.khasang.sokol.controller;

        import io.khasang.sokol.dao.*;
        import io.khasang.sokol.entity.*;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.PropertySource;
        import org.springframework.core.env.Environment;
        import org.springframework.security.core.context.SecurityContext;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.servlet.ModelAndView;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

@PropertySource(value = {"classpath:hibernate.properties"})

/**
 * Created by Andrey on 02.10.2016.
 */
@Controller
@RequestMapping(value = "/requestList")
public class RequestController {
    @Autowired
    RequestDao requestDao;
    @Autowired
    RequestTypeDao requestTypeDao;
    @Autowired
    RequestStatusDao requestStatusDao;
    @Autowired
    UserDao userDao;
    @Autowired
    TempDao tempDao;
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    private Environment environment;

    private boolean sortingRequestByTitle = false;
    private boolean sortingRequestByDescription = false;


    private ArrayList<Integer> totalOfPages(int lastPageNumber){ //общее количество страниц для paging
        ArrayList<Integer> totalOfPages = new ArrayList<>();
        for (int i = 0; i < lastPageNumber; i++) {
            totalOfPages.add(i+1);
        }
        return totalOfPages;
    }



    // расчет количества записей в таблице и количества страниц
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String requestListPage(Model requestPageModel, @RequestParam("pagenumber") String pagenumber){
        Integer countLineOfTable = requestDao.getCountLineOfTable(); // кол-во записей в таблице
        Integer countLineOfPage = Integer.parseInt(environment.getRequiredProperty("page.size")); // кол-во записей на странице
        Integer lastPageNumber = ((countLineOfTable  / countLineOfPage) + 1);
        ArrayList<Integer> pageTotal = totalOfPages(lastPageNumber);
        List<Request> requestAll;
        if (sortingRequestByTitle  == true) {
            requestAll =  requestDao.sortingRequestByTitle((Integer.parseInt(pagenumber)-1)*countLineOfPage, countLineOfPage);
         } else if (sortingRequestByDescription  == true) {
            requestAll =  requestDao.sortingRequestByDescription((Integer.parseInt(pagenumber)-1)*countLineOfPage, countLineOfPage);
            }
             else {requestAll =  requestDao.sortingRequestByID((Integer.parseInt(pagenumber)-1)*countLineOfPage, countLineOfPage);
        }
        requestPageModel.addAttribute("requestAll", requestAll);
        requestPageModel.addAttribute("pageTotal", pageTotal);
        return "requestList";

    }

    @RequestMapping(value = "/sortingByTitle", method = RequestMethod.GET)
    public String requestListPage2(Model requestPageModel2){
        sortingRequestByTitle = true;
        sortingRequestByDescription = false;
        Integer countLineOfTable2 = requestDao.getCountLineOfTable(); // кол-во записей в таблице
        Integer countLineOfPage2 = Integer.parseInt(environment.getRequiredProperty("page.size")); // кол-во записей на странице
        Integer lastPageNumber2 = ((countLineOfTable2  / countLineOfPage2) + 1);
        ArrayList<Integer> pageTotal2 = totalOfPages(lastPageNumber2);
        List<Request> requestAll =  requestDao.sortingRequestByTitle(0, countLineOfPage2);
        requestPageModel2.addAttribute("requestAll", requestAll);
        requestPageModel2.addAttribute("pageTotal", pageTotal2);
        return "requestList";
    }

    @RequestMapping(value = "/sortingByDescription", method = RequestMethod.GET)
    public String requestListPage3(Model requestPageModel3){
        sortingRequestByTitle = false;
        sortingRequestByDescription = true;
        Integer countLineOfTable2 = requestDao.getCountLineOfTable(); // кол-во записей в таблице
        Integer countLineOfPage2 = Integer.parseInt(environment.getRequiredProperty("page.size")); // кол-во записей на странице
        Integer lastPageNumber2 = ((countLineOfTable2  / countLineOfPage2) + 1);
        ArrayList<Integer> pageTotal2 = totalOfPages(lastPageNumber2);
        List<Request> requestAll =  requestDao.sortingRequestByDescription(0, countLineOfPage2);
        requestPageModel3.addAttribute("requestAll", requestAll);
        requestPageModel3.addAttribute("pageTotal", pageTotal2);
        return "requestList";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delRequestPage(Model delRequest, @RequestParam("idRequest") String idRequest){
        Request request =  requestDao.getByRequestId(Integer.parseInt(idRequest));
        requestDao.delete(request);
        delRequest.addAttribute("request", request);
        return "redirect:/requestList/list?pagenumber=1";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String requestAddPage(Model requestAddModel){
        List<RequestType> requestTypeAll =  requestTypeDao.getAll();
        requestAddModel.addAttribute("requestTypeAll", requestTypeAll);
        List<Department> departmentAll = departmentDao.getAll();
        requestAddModel.addAttribute("departmentAll", departmentAll);
        return "requestAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String requestAdd(@RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("idrequest") String idrequest,
                             @RequestParam("iddepartment") String iddepartment){
        ModelAndView model = new ModelAndView();
        Request request = new Request();
        request.setTitle(name);
        request.setDescription(description);
        RequestStatus status =  requestStatusDao.getById(1);
        request.setStatus(status);
        request.setVersion(1);
        request.setCreatedDate(new Date());
        RequestType requestType =  requestTypeDao.getById(Integer.parseInt(idrequest));
        request.setRequestType(requestType);
        Department department = departmentDao.getById(Integer.parseInt(iddepartment));
        request.setDepartment(department);
        SecurityContext context = SecurityContextHolder.getContext();
        request.setCreatedBy(context.getAuthentication().getName());
        request.setUpdatedBy(context.getAuthentication().getName());
        requestDao.save(request);
        model.setViewName("requestAdd");
        return "redirect:/requestList/list?pagenumber=1";
    }

    // добавление запроса на редактирование
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String requestEditPage(Model requestEditModel, @RequestParam("idRequest") String idRequest){
        Request request =  requestDao.getByRequestId(Integer.parseInt(idRequest));
        requestEditModel.addAttribute("request", request);
        List<RequestType> requestTypeAll =  requestTypeDao.getAll();
        requestEditModel.addAttribute("requestTypeAll", requestTypeAll);
        List<Department> departmentAll = departmentDao.getAll();
        requestEditModel.addAttribute("departmentAll", departmentAll);
        return "requestEdit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String  addRequestPerformer(@RequestParam("idrequest") String idrequest,
                                       @RequestParam("name") String name,
                                       @RequestParam("description") String description,
                                       @RequestParam("dateCreator") String dateCreator,
                                       @RequestParam("creator") String creator,
                                       @RequestParam("idrequesttypes") String idrequesttypes,
                                       @RequestParam("iddepartment") String iddepartment){
        ModelAndView model = new ModelAndView();
        Request request = requestDao.getByRequestId(Integer.parseInt(idrequest));
        request.setTitle(name);
        request.setDescription(description);
        RequestStatus status = requestStatusDao.getById(2);
        request.setStatus(status);
        // request.setVersion(1);
        request.setUpdatedDate(new Date());
        RequestType requestType =  requestTypeDao.getById(Integer.parseInt(idrequesttypes));
        request.setRequestType(requestType);
        request.setCreatedBy(creator);
        Department department = departmentDao.getById(Integer.parseInt(iddepartment));
        request.setDepartment(department);
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            Date date= format.parse(dateCreator);
            request.setCreatedDate(date);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        SecurityContext context = SecurityContextHolder.getContext();
        request.setUpdatedBy(context.getAuthentication().getName());
        requestDao.update(request);
        model.setViewName("requestEdit");
        return "redirect:/requestList/list?pagenumber=1";
    }
}
