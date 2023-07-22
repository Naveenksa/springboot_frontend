package com.naveen.springboot_frontend.controller;

import com.naveen.springboot_frontend.StudentSorting.SortStudentByFirstName;
import com.naveen.springboot_frontend.StudentSorting.SortStudentByFirstNameAge;
import com.naveen.springboot_frontend.entity.Student;
import com.naveen.springboot_frontend.expectionstudent.WorngLoginPasswordException;
import com.naveen.springboot_frontend.studentservice.StudentService;
import com.naveen.springboot_frontend.userservice.UserService;
import com.naveen.springboot_frontend.UserRepo.UserRepo;
import com.naveen.springboot_frontend.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@Controller
public class UserController {

    private static final Logger llogger = LoggerFactory.getLogger(UserController.class);
    //-------------------------------------------------------------------------------------------------------------------------------------------
    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    StudentService studentService;

    //--------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/")
    public String index() {
        return "redirect:/index.html";
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/login")
    public String loginPage() {
        return "login.html";
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/newuser")
    public String signUp() {
        return "register.html";
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/signup")
    public String registreUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/loginuser")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {

        User userList = userRepo.findByUsernameAndPassword(username, password);

        // Compare the data
        if (userList == null) {
            model.addAttribute("message", "Data not found");
            return "login";
        } else {
            model.addAttribute("message", "User Login Success");
            return "home";
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------

    @PostMapping("/addstudent")
    public String addStudent(@ModelAttribute("stu") Student student) {


        studentService.saveStudent(student);
        return "redirect:/all";
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/AddnewStudent")
    public String addnew() {
        return "AddStudent";
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/all")
    public String getAllStu(Model model) {
        List<Student> allstd = studentService.getAllStudent();
        model.addAttribute("studs", allstd);
        return "alls";
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping("/updateById/{id}")
    public String updateById(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

        Student toup = studentService.getStudentbyId(id);

        toup.setId(student.getId());
        toup.setFirstName(student.getFirstName());
        toup.setLastName(student.getLastName());
        toup.setGender(student.getGender());
        toup.setDob(student.getDob());
        toup.setAge(student.getAge());

        studentService.updatestudent(toup);

        return "redirect:/all";
    }

    @GetMapping("/student/update/{id}")
    public String getSById(@PathVariable Long id, Model model) {

        model.addAttribute("student", studentService.getStudentbyId(id));
        return "updateStudent";
    }
   @GetMapping("/deleteById/{id}")
    public String deleteStudentById(@PathVariable Long id){
        studentService.deleteStuden(id);
        return "redirect:/all";
    }

 @GetMapping("/getstudentbyname")
    public String getByFirstName(@RequestParam("firstName") String firstname,Model model){
        List<Student> studs=studentService.getByFirstName(firstname);
        model.addAttribute("studs" ,studs);
        return "alls";
    }

    @GetMapping("/sortbyfirrstname")
    public String sortByFirstname(Model model){
        List<Student> studs= studentService.getAllStudent();
        Collections.sort(studs,new SortStudentByFirstName());
        model.addAttribute("studs",studs);
        return "alls";
    }

    @GetMapping("/sortbyage")
    public String sortByAge(Model model){
        List<Student> studs= studentService.getAllStudent();
        Collections.sort(studs,new SortStudentByFirstNameAge());
        model.addAttribute("studs",studs);
        return "alls";
    }

    @GetMapping("/password")
    public String pass(){
        throw new WorngLoginPasswordException("Enter password");
    }

    @GetMapping("/jq")
    public @ResponseBody List<Student> jQury(){
llogger.info("student get api called.............oijoinoinbiobbb");
llogger.debug("debugg jq");
llogger.warn("czxc");
        return studentService.getAllStudent();
    }


}
