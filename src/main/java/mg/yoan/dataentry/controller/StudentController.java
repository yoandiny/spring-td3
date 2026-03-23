package mg.yoan.dataentry.controller;

import mg.yoan.dataentry.dto.StudentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<StudentRequest> StudentList = new ArrayList<>();

    @PostMapping
    public String students(@RequestBody StudentRequest studentRequest) {
        StudentList.add(studentRequest);
        return "First name :" + studentRequest.getFirstName() + " Last name :" + studentRequest.getLastName();

    }

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestHeader("Accept") String accept) {
        if(!accept.equalsIgnoreCase("text/plain")) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Format non supporté");

        }
            String result = StudentList.stream().map(StudentRequest::getLastName).collect(Collectors.joining(","));
        return ResponseEntity.ok(result);
    }
}
