package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {

        Student student1 = new Student("Jayesh", 20, new Address("1234"), Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student("Khyati", 20, new Address("1235"), Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student("Jason", 20, new Address("1236"), Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

        List<Student> students = Arrays.asList(student1, student2, student3);

//        Get student with exact match name "jayesh"
        System.out.println("Get student with exact match name jayesh");
        Optional<Student> s1 = students.stream().filter((s) -> s.getName().equals("Jayesh")).findAny();
        if (s1.isPresent()) System.out.println(s1.get().toString());
        else System.out.println("No student with name Jayesh");

//        Get student with matching address "1235"
        System.out.println("Get student with matching address 1235");
        Optional<Student> s2 = students.stream().filter(s -> s.getAddress().getZipcode().equals("1235")).findFirst();
        if (s2.isPresent()) System.out.println(s2.get().toString());
        else System.out.println("No student with address 1235");

//        Get all student having mobile numbers 3333.
        System.out.println("Get all student having mobile numbers 3333.");
        List<Student> s3 = students.stream().filter(s -> {
            for (MobileNumber mb : s.getMobileNumbers()) {
                if ("3333".equals(mb.getNumber())) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
        s3.forEach(System.out::println);
//        Get all student having mobile number 1233 and 1234
        System.out.println("Get all student having mobile number 1233 and 1234");
        List<Student> s4 = students.stream().filter( s-> s.getMobileNumbers().stream().anyMatch(mobileNumber -> mobileNumber.getNumber().equals("1233") || mobileNumber.getNumber().equals("1234"))).collect(Collectors.toList());
        s4.forEach(System.out :: println);

//        Create a List<Student> from the List<TempStudent>
        System.out.println("Create a List<Student> from the List<TempStudent>");
//
//               Convert List<Student> to List<String> of student name
//        Convert List<students> to String
//        Change the case of List<String>
//        Sort List<String>
//                Conditionally apply Filter condition, say if flag is enabled then.
    }
}