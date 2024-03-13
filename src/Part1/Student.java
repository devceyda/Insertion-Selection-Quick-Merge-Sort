package Part1;

// 
// Title: Student Class
// Author: Ceyda Kuşçuoğlu

// Description: This class holds the student information and compare them according to their id,semesterNo and name
//
public class Student implements Comparable<Student> {

    private String name; // Holds the name value for student object
    private long id;// Holds the id value for student object
    private int semesterNo;// Holds the semester no value for student object

    public Student(String name, long id, int semesterNo)
    //
    // Summary: Assigns a value to the variables
    // Precondition: Name is a string,id is long and semesterNo is int
    // Postcondition: The value of the variables is set.
    //
    {
        this.name = name;
        this.id = id;
        this.semesterNo = semesterNo;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public int getSemesterNo() {
        return semesterNo;
    }

    @Override
    public int compareTo(Student other)
    //
    // Summary: Overrides compareTo method for student objects
    // Precondition: Takes student object
    // Postcondition: Students have been compared
    //
    {
        // Compare by id
        if (this.id < other.id) {
            return -1;
        } else if (this.id > other.id) {
            return 1;
        }

        // Compare by semesterNo
        if (this.semesterNo < other.semesterNo) {
            return -1;
        } else if (this.semesterNo > other.semesterNo) {
            return 1;
        }

        // Compare by name
        return this.name.compareTo(other.name);
    }

}
