/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrodatamii.metrodatamii.controller;

import javax.validation.Valid;
import metrodatamii.metrodatamii.entities.Employee;
import metrodatamii.metrodatamii.entities.Job;
import metrodatamii.metrodatamii.entities.OvertimeRequest;
import metrodatamii.metrodatamii.entities.OvertimeType;
import metrodatamii.metrodatamii.entities.Status;
import metrodatamii.metrodatamii.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import metrodatamii.metrodatamii.repository.EmployeeRepository;
import metrodatamii.metrodatamii.repository.JobRepository;
import metrodatamii.metrodatamii.repository.OvertimeRequestRepository;
import metrodatamii.metrodatamii.repository.OvertimeRequestStatusRepository;
import metrodatamii.metrodatamii.repository.OvertimeTypeRepository;
import metrodatamii.metrodatamii.repository.TimeSheetRepository;
import metrodatamii.metrodatamii.service.AccountService;
import metrodatamii.metrodatamii.service.EmployeeJobService;
import metrodatamii.metrodatamii.service.EmployeeRoleService;
import metrodatamii.metrodatamii.service.JobService;
import metrodatamii.metrodatamii.service.OvertimeTypeService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author WIN7
 */
@Controller
public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private JobService jobService;

    @Autowired
    private EmployeeJobService employeeJobService;

    @Autowired
    private EmployeeRoleService employeeRoleService;

    @Autowired
    private OvertimeTypeService overtimeTypeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private OvertimeTypeRepository overtimeTypeRepository;

    @Autowired
    private OvertimeRequestRepository overtimeRequestRepository;

    @Autowired
    private OvertimeRequestStatusRepository overtimeRequestStatusRepository;

    @Autowired
    private TimeSheetRepository timeSheetRepository;

    @GetMapping("/")
    public String index(Model model) {
        return "login";
    }

    @GetMapping("/emp_dash")
    public String indexEmp(Model model) {
        return "emp_dash";
    }

    @GetMapping("/adm_dash")
    public String indexAdm(Model model) {
        return "adm_dash";
    }

    @GetMapping("/mgr_dash")
    public String indexMgr(Model model) {
        return "mgr_dash";
    }

    @GetMapping("/data_employee_job")
    public String geAllEmployeeJobRole(Model model) {
        model.addAttribute("dataEmployee", employeeRepository.findAll());
        return "data_employee_job";
    }

    @GetMapping("/data_account")
    public String getAllAccount(Model model) {
        model.addAttribute("dataAccount", accountService.findAllAccount());
        model.addAttribute("dataEmployee", employeeRepository.findAll());
        return "data_account";
    }

    @GetMapping("/data_employee")
    public String geAllEmployee(Model model) {
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        model.addAttribute("employeeSave", new Employee());
        return "data_employee";
    }

    @PostMapping("/employee_save")
    public String addDataEmployee(Employee employee) {
        employee.setId("0");
        employeeRepository.save(employee);
        return "redirect:/data_employee";
    }

    @PostMapping("employee_edit/{id}")
    public String updateEmployee(@PathVariable("id") String id, @Valid Employee employee) {
        employee.setIsDelete(false);
        employeeRepository.save(employee);
        return "redirect:/data_employee";
    }

    @PostMapping("employee_delete/{id}")
    public String deleteEmployee(@PathVariable("id") String id, @Valid Employee employee) {
        employee.setIsDelete(true);
        employeeRepository.save(employee);
        return "redirect:/data_employee";
    }

    @GetMapping("/data_job")
    public String getAllJob(Model model) {
        model.addAttribute("dataJob", jobRepository.getAll());
        model.addAttribute("jobSave", new Job());
        return "data_job";
    }

    @PostMapping("/job_save")
    public String addDataJob(Job job) {
        job.setId("0");
        jobRepository.save(job);
        return "redirect:/data_job";
    }

    @PostMapping("job_edit/{id}")
    public String updateJob(@PathVariable("id") String id, @Valid Job job) {
        job.setIsDelete(false);
        jobRepository.save(job);
        return "redirect:/data_job";
    }

    @PostMapping("job_delete/{id}")
    public String jobDelete(@PathVariable("id") String id, @Valid Job job) {
        job.setIsDelete(true);
        jobRepository.save(job);
        return "redirect:/data_job";
    }

    @GetMapping("/data_overtime_type")
    public String getAllOvertimeType(Model model) {
        model.addAttribute("dataOvertimeType", overtimeTypeRepository.getAll());
        model.addAttribute("overtimeTypeSave", new OvertimeType());
        return "data_overtime_type";
    }

    @PostMapping("/overtime_type_save")
    public String addDataOvertimeType(OvertimeType overtimeType) {
        overtimeType.setId("0");
        overtimeTypeRepository.save(overtimeType);
        return "redirect:/data_overtime_type";
    }

    @PostMapping("overtime_type_edit/{id}")
    public String updateType(@PathVariable("id") String id, @Valid OvertimeType overtimeType) {
        overtimeType.setIsDelete(false);
        overtimeTypeRepository.save(overtimeType);
        return "redirect:/data_overtime_type";
    }

    @PostMapping("overtime_type_delete/{id}")
    public String deleteType(@PathVariable("id") String id, @Valid OvertimeType overtimeType) {
        overtimeType.setIsDelete(true);
        overtimeTypeRepository.save(overtimeType);
        return "redirect:/data_overtime_type";
    }

    @GetMapping("/data_employee_role")
    public String getAllEmployeeRole(Model model) {
        String id = "2";
        model.addAttribute("dataEmployeeRole", employeeRoleService.findAllEmployeeRole());
        return "data_employee_role";
    }

//    EMPLOYEE PART START
    @GetMapping("/emp_overtime_request")
    public String getAllOvertimeRequest(Model model) {
        model.addAttribute("dataOvertimeRequest", overtimeRequestRepository.findAll());
        model.addAttribute("dataOvertimeType", overtimeTypeService.findAllOvertimeType());
        model.addAttribute("dataTimeSheet", timeSheetRepository.findAll());
        model.addAttribute("overtimeRequestSave", new OvertimeRequest());
        return "emp_overtime_request";
    }

    @PostMapping("/emp_overtime_request_save")
    public String addDataOvertimeRequest(OvertimeRequest overtimeRequest) {
        overtimeRequest.setId("0");
        overtimeRequestRepository.save(overtimeRequest);
        return "redirect:/emp_overtime_request";
    }
    
    @PostMapping("cancel/{id}")
    public String updateCancel(@PathVariable("id") String id, @Valid OvertimeRequest overtimeRequest) {
        Status status = new Status();
        status.setId("S-0004");
        overtimeRequest.setStatus(status);
        overtimeRequestRepository.save(overtimeRequest);
        return "redirect:/emp_overtime_request";
    }

    @GetMapping("/emp_request_history")
    public String getAllOvertimeRequestStatus(Model model) {
        model.addAttribute("dataHistoryRequest", overtimeRequestRepository.findAll());
        model.addAttribute("dataEmployee", employeeRepository.getAll());
        return "emp_request_history";
    }
//    EMPLOYEE PART END

//    HRD PART START
    @GetMapping("/mgr_approval_history")
    public String getAllHistoryApproval(Model model) {
        model.addAttribute("dataHistoryApproval", overtimeRequestRepository.findAll());
//        model.addAttribute("dataEmployee", employeeRepository.getAll());
        return "mgr_approval_history";
    }

    @GetMapping("/mgr_approval")
    public String getAllApproval(Model model) {
        model.addAttribute("dataOvertimeRequest", overtimeRequestRepository.findAll());
        model.addAttribute("dataOvertimeType", overtimeTypeRepository.findAll());
        model.addAttribute("dataTimeSheet", timeSheetRepository.findAll());
        return "mgr_approval";
    }

    @PostMapping("approve/{id}")
    public String updateApproval(@PathVariable("id") String id, @Valid OvertimeRequest overtimeRequest) {
        Status status = new Status();
        status.setId("S-0002");
        overtimeRequest.setStatus(status);
        overtimeRequestRepository.save(overtimeRequest);
        return "redirect:/mgr_approval";
    }
    
    @PostMapping("reject/{id}")
    public String updateReject(@PathVariable("id") String id, @Valid OvertimeRequest overtimeRequest) {
        Status status = new Status();
        status.setId("S-0003");
        overtimeRequest.setStatus(status);
        overtimeRequestRepository.save(overtimeRequest);
        return "redirect:/mgr_approval";
    }
}   
//    HRD PART END

//    @RequestMapping(value = "/employee_save", method = RequestMethod.POST)
//    public String save (@ModelAttribute("employeeSave") Employee employee){
//        employeeService.save(employee);
//        return "redirect:/data_employee";
//    }


//    @PostMapping("/job_edit")
//    public String EditJob(Job job) {
//        job.setIsDelete(false);
//        jobRepository.save(job);
//        return "redirect:/data_job";
//    }
//    @GetMapping("/find_job")
//    @ResponseBody
//    public Job findJob(String id) {
//        Job j = new Job(jobRepository.getJobById(id).get(0).getId(),
//                jobRepository.getJobById(id).get(0).getName()
//        );
//        return j;
//    }
//    @GetMapping("/data_job/{id}")
//    public String showUpdateForm(@PathVariable("id") String id, Model model) {
//        model.addAttribute("dataJob", jobService.findById(id));
//        return "data_job";
//    }
//    @PostMapping("/job_edit/{id}")
//    public String updateJob(@PathVariable("id") String id, @Valid Job job) {
//        jobRepository.save(job);
//        
//        return "redirect:/data_job";
//    }
//    @GetMapping("/data_employee_job")
//    public String getAllEmployeeJob(Model model) {
//        String id = "2";
//        model.addAttribute("dataEmployeeJob", employeeJobService.findAllEmployeeJob());
//        return "data_employee_job";
//    }
