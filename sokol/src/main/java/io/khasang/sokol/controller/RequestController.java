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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@PropertySource(value = {"classpath:hibernate.properties"})
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
    DepartmentDao departmentDao;
    @Autowired
    private Environment environment;

    private ArrayList<Integer> totalOfPages(int lastPageNumber) { //общее количество страниц для paging
        ArrayList<Integer> totalOfPages = new ArrayList<>();
        for (int i = 0; i < lastPageNumber; i++) {
            totalOfPages.add(i + 1);
        }
        return totalOfPages;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String requestListPage(Model requestPageModel, @RequestParam(value = "pagenumber", required = false) String pagenumber,
                                  @RequestParam(value = "sortBy", required = false) String sortBy,
                                  @RequestParam(value = "sortOrder", required = false) String sortOrder) {

        pagenumber = (pagenumber == null || sortBy.equals("")) ? "1" : pagenumber;
        sortOrder = (sortOrder == null || sortOrder.equals("")) ? "" : sortOrder;
        Integer countLineOfTable = requestDao.getCountLineOfTable(); // кол-во записей в таблице
        Integer pageRows = Integer.parseInt(environment.getRequiredProperty("page.size")); // кол-во записей на странице
        Integer lastPageNumber = ((countLineOfTable / pageRows) + 1);
        ArrayList<Integer> pageNumbers = totalOfPages(lastPageNumber);
        List<Request> requestAll;
        sortBy = (sortBy == null || sortBy.equals("")) ? "id" : sortBy;
        String imgBy = "";
        String sortOrderHeader = "";
        requestAll = requestDao.sortingBy((Integer.parseInt(pagenumber) - 1) * pageRows, pageRows, sortBy, sortOrder);
        if (sortOrder.equals("ASC")) {
            imgBy = "/img/sortUP15.png";
            sortOrderHeader = "DESC";
        } else if (sortOrder.equals("DESC")) {
            imgBy = "/img/sortDown15.png";
            sortOrderHeader = "ASC";
        } else {
            sortOrderHeader = "ASC";
            sortOrder = "ASC";
        }

        requestPageModel.addAttribute("requestAll", requestAll);
        requestPageModel.addAttribute("pageTotal", pageNumbers);
        requestPageModel.addAttribute("sortBy", sortBy);
        requestPageModel.addAttribute("imgBy", imgBy);
        requestPageModel.addAttribute("sortOrder", sortOrder);
        requestPageModel.addAttribute("sortOrderHeader", sortOrderHeader);
        requestPageModel.addAttribute("pagenumber", pagenumber);
        return "requestList";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delRequestPage(Model delRequest, @RequestParam("idRequest") String idRequest) {
        Request request = requestDao.getByRequestId(Integer.parseInt(idRequest));
        requestDao.delete(request);
        delRequest.addAttribute("request", request);
        return "redirect:/requestList/list?pagenumber=1&sortBy=id&sortOrder=";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String requesttest() {
        return "test";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test2(@RequestParam("file") MultipartFile file) {
      //  @RequestParam("file") MultipartFile file
        ModelAndView model = new ModelAndView();
        try {
            if (file !=null) {
                byte[] photoBytes = file.getBytes();

                       String photoFilePathToSave = "d:/Temp/test2.txt";
                saveBytesToFile(photoFilePathToSave, photoBytes);
            model.setViewName("test2");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return "test";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String requestAddPage(Model requestAddModel,
                                 @RequestParam("pagenumber") String pagenumber,
                                 @RequestParam("sortBy") String sortBy,
                                 @RequestParam("sortOrder") String sortOrder,
                                 @RequestParam("sortOrderHeader") String sortOrderHeader) {
        List<RequestType> requestTypeAll = requestTypeDao.getAll();
        requestAddModel.addAttribute("requestTypeAll", requestTypeAll);
        List<Department> departmentAll = departmentDao.getAll();
        requestAddModel.addAttribute("departmentAll", departmentAll);
        requestAddModel.addAttribute("pagenumber", pagenumber);
        requestAddModel.addAttribute("sortBy", sortBy);
        requestAddModel.addAttribute("sortOrder", sortOrder);
        requestAddModel.addAttribute("sortOrderHeader", sortOrderHeader);
        return "requestAdd";
    }

/*    private static byte[] readBytesFromFile(String filePath) throws IOException {
        File inputFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] fileBytes = new byte[(int) inputFile.length()];
        inputStream.read(fileBytes);
        inputStream.close();
        return fileBytes;
    }*/

/*    private static byte[] readBytesFromFile(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        byte[] fileBytes = new byte[(int) file.length()];
        inputStream.read(fileBytes);
        inputStream.close();
        return fileBytes;
    }*/

    private static void saveBytesToFile(String filePath, byte[] fileBytes) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filePath);
        outputStream.write(fileBytes);
        outputStream.close();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String requestAdd(@RequestParam("title") String name,
                             @RequestParam("description") String description,
                             @RequestParam("idrequesttype") String idrequesttype,
                             @RequestParam("iddepartment") String iddepartment,
                             @RequestParam("pagenumber") String pagenumber,
                             @RequestParam("sortBy") String sortBy,
                             @RequestParam("sortOrder") String sortOrder,
                             @RequestParam("sortOrderHeader") String sortOrderHeader,
                             @RequestParam("file") MultipartFile file) {
        ModelAndView model = new ModelAndView();
        Request request = new Request();
        request.setTitle(name);
        request.setDescription(description);
        RequestStatus status = requestStatusDao.getById(1);
        request.setStatus(status);
        request.setVersion(1);
        request.setCreatedDate(new Date());
        RequestType requestType = requestTypeDao.getById(Integer.parseInt(idrequesttype));
        request.setRequestType(requestType);
        Department department = departmentDao.getById(Integer.parseInt(iddepartment));
        request.setDepartment(department);
        try {
            // byte[] photoBytes = readBytesFromFile(photoFilePathToRead);
            // byte[] photoBytes = inputString.getBytes();
            //   byte[] photoBytes = readBytesFromFile(fileScreenShot);
            request.setScreenShot(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        SecurityContext context = SecurityContextHolder.getContext();
        request.setCreatedBy(context.getAuthentication().getName());
        request.setUpdatedBy(context.getAuthentication().getName());

        // String photoFilePathToRead = "d:/Temp/test.txt";
        //   String photoFilePathToRead = fileScreenShot;
        //  String inputString = "prologistic.com.ua";
        // byte[] photoBytes = inputString.getBytes();
        //   request.setScreenShot(photoBytes);
        // преобразуем нашу строку в массив байт


        requestDao.save(request);
        model.setViewName("requestAdd");
        return "redirect:/requestList/list?pagenumber=" + pagenumber + "&sortBy=" + sortBy + "&sortOrder=" + sortOrder + "&sortOrderHeader=" + sortOrderHeader;
    }

    // добавление запроса на редактирование
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String requestEditPage(Model requestEditModel, @RequestParam("idRequest") String idRequest,
                                  @RequestParam("pagenumber") String pagenumber,
                                  @RequestParam("sortBy") String sortBy,
                                  @RequestParam("sortOrder") String sortOrder,
                                  @RequestParam("sortOrderHeader") String sortOrderHeader) {


        Request request = requestDao.getByRequestId(Integer.parseInt(idRequest));
        requestEditModel.addAttribute("request", request);
        List<RequestStatus> requestStatusAll = requestStatusDao.getAll();

        List<RequestType> requestTypeAll = requestTypeDao.getAll();
        requestEditModel.addAttribute("requestTypeAll", requestTypeAll);
        List<Department> departmentAll = departmentDao.getAll();
        requestEditModel.addAttribute("departmentAll", departmentAll);
        requestEditModel.addAttribute("requestStatusAll", requestStatusAll);
        requestEditModel.addAttribute("pagenumber", pagenumber);
        requestEditModel.addAttribute("sortBy", sortBy);
        requestEditModel.addAttribute("sortOrder", sortOrder);
        requestEditModel.addAttribute("sortOrderHeader", sortOrderHeader);

/*        String photoFilePathToSave = "d:/Temp/test2.txt";
        byte[] photoBytes = request.getScreenShot();
        try {
            saveBytesToFile(photoFilePathToSave, photoBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return "requestEdit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String addRequestPerformer(@RequestParam("idrequest") String idrequest,
                                      @RequestParam("title") String name,
                                      @RequestParam("description") String description,
                                      @RequestParam("idrequesttypes") String idrequesttypes,
                                      @RequestParam("iddepartment") String iddepartment,
                                      @RequestParam("pagenumber") String pagenumber,
                                      @RequestParam("sortBy") String sortBy,
                                      @RequestParam("sortOrder") String sortOrder,
                                      @RequestParam("sortOrderHeader") String sortOrderHeader,
                                      @RequestParam("idrequeststatus") String idrequeststatus,
                                      @RequestParam("fileScreenShot") String fileScreenShot) {
        ModelAndView model = new ModelAndView();
        Request request = requestDao.getByRequestId(Integer.parseInt(idrequest));
        request.setTitle(name);
        request.setDescription(description);
        RequestStatus status = requestStatusDao.getByRequestStatusId(Integer.parseInt(idrequeststatus));
        request.setStatus(status);
        request.setUpdatedDate(new Date());
        RequestType requestType = requestTypeDao.getById(Integer.parseInt(idrequesttypes));
        request.setRequestType(requestType);
        Department department = departmentDao.getById(Integer.parseInt(iddepartment));
        request.setDepartment(department);
        SecurityContext context = SecurityContextHolder.getContext();
        request.setUpdatedBy(context.getAuthentication().getName());
        requestDao.update(request);
        model.setViewName("requestEdit");
        return "redirect:/requestList/list?pagenumber=" + pagenumber + "&sortBy=" + sortBy + "&sortOrder=" + sortOrder + "&sortOrderHeader=" + sortOrderHeader;
    }
}
